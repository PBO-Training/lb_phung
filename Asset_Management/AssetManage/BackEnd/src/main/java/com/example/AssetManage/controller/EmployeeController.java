package com.example.AssetManage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssetManage.dto.EmployeeAfterMap;
import com.example.AssetManage.entity.EmployeeEntity;
import com.example.AssetManage.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepo;

	/*
	 * API find Employee
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
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
	@RequestMapping(value = "/getid", method = RequestMethod.POST)
	public EmployeeAfterMap getid(@RequestBody EmployeeEntity employeeEntity) {
		EmployeeEntity employee = employeeRepo.getOne(employeeEntity.getEmployeeId());
		EmployeeAfterMap employeeMap = new EmployeeAfterMap(employee);
		return employeeMap;
	}

	/*
	 * API Get By Name Employee
	 */
	@PostMapping("/searchname")
	public ResponseEntity<?> searchByName(@RequestBody EmployeeEntity employeeEntity) {
		List<EmployeeEntity> employ = employeeRepo.searchByName(employeeEntity.getEmployeeName());
		List<EmployeeAfterMap> listempMap = new ArrayList<EmployeeAfterMap>();
		for (int i = 0; i < employ.size(); i++) {
			System.out.println(employ.get(i));
			EmployeeAfterMap employeeMap = new EmployeeAfterMap(employ.get(i));
			listempMap.add(employeeMap);
		}
		;

		return new ResponseEntity<List<EmployeeAfterMap>>(listempMap, HttpStatus.OK);
	}

	/*
	 * API Create Employee
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public EmployeeEntity create(@RequestBody EmployeeEntity employeeEntity) {
		return employeeRepo.save(employeeEntity);
	}

	/*
	 * API update EmployeeEntity
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)

	public ResponseEntity<EmployeeEntity> update(@RequestBody EmployeeEntity employeeEntity) {

		EmployeeEntity employee = employeeRepo.getOne(employeeEntity.getEmployeeId());

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
	 * API Delete By Id employee
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<EmployeeEntity> delete(@RequestBody EmployeeEntity employeeEntity) {
		EmployeeEntity employee = employeeRepo.getOne(employeeEntity.getEmployeeId());
		if (employee == null) {
			return ResponseEntity.notFound().build();
		}
		employeeRepo.delete(employee);
		return ResponseEntity.ok().build();
	}
}// end
