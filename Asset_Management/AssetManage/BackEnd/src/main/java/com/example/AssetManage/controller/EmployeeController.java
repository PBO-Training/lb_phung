package com.example.AssetManage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssetManage.dto.EmployeeAfterMap;
import com.example.AssetManage.entity.EmployeeEntity;
import com.example.AssetManage.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepo;

	/*
	 * API find Employee
	 */
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeEntity>> listAllContact() {
		List<EmployeeEntity> listContact = employeeRepo.findAll();
		if (listContact.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmployeeEntity>>(listContact, HttpStatus.OK);
	}

	/*
	 * API find Employee by id
	 */
	@RequestMapping(value = "/employee/{employee_id}", method = RequestMethod.GET)
	public EmployeeAfterMap findAssetType(@PathVariable("employee_id") long employeeId) {
		EmployeeEntity assetType = employeeRepo.getOne(employeeId);
		EmployeeAfterMap assetTypeMap = new EmployeeAfterMap(assetType);
		return assetTypeMap;
	}

	/*
	 * API Create Employee
	 */
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return employeeRepo.save(employeeEntity);
	}

	/*
	 * API update EmployeeEntity
	 */
	@RequestMapping(value = "/employee/{employee_id}", method = RequestMethod.PUT)

	public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable(value = "employee_id") Long employeeId,
			@RequestBody EmployeeEntity employeeEntity) {
		EmployeeEntity employee = employeeRepo.getOne(employeeId);

		if (employee == null) {
			return ResponseEntity.notFound().build();
		}
		employee.setEmployeeId(employeeEntity.getEmployeeId());
		employee.setEmployeeCode(employeeEntity.getEmployeeCode());
		employee.setEmployeeName(employeeEntity.getEmployeeName());
		EmployeeEntity updateEmployee = employeeRepo.save(employee);
		return ResponseEntity.ok(updateEmployee);
	}

	/*
	 * API Delete By Id Employee
	 */
	@RequestMapping(value = "/employee/{employee_id}", method = RequestMethod.DELETE)
	public ResponseEntity<EmployeeEntity> deleteAsset(@PathVariable(value = "employee_id") Long employeeid) {
		EmployeeEntity employee = employeeRepo.getOne(employeeid);
		if (employee == null) {
			return ResponseEntity.notFound().build();
		}
		employeeRepo.delete(employee);
		return ResponseEntity.ok().build();
	}
}// end
