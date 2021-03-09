package com.example.AssetManage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import com.example.AssetManage.dto.EmployeeDto;
import com.example.AssetManage.entity.EmployeeEntity;
import com.example.AssetManage.repository.EmployeeRepository;
/**
 * [Description]: Search Controller for Employee Master Table<br>
 * @author lb_phung
 *
 */
import com.example.AssetManage.repository.SearchEmployeeRepo;
@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepo;
	SearchEmployeeRepo searchEmployeeRepo;
	/*
	 * API find all Employee
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeAfterMap>> getAll() {
		List<EmployeeEntity> listEmployeeEntity = employeeRepo.getAll();
		List<EmployeeAfterMap> listEmployeeAfterMap = listEmployeeEntity.stream().map(EmployeeAfterMap::new)
				.collect(Collectors.toList());

		if (listEmployeeAfterMap.isEmpty()) {
			return new ResponseEntity<List<EmployeeAfterMap>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<EmployeeAfterMap>>(listEmployeeAfterMap, HttpStatus.OK);
	}

	/*
	 * API find Employee by id
	 * 
	 * @param employeeEntity
	 */
	@RequestMapping(value = "/getid", method = RequestMethod.POST)
	public EmployeeAfterMap getid(@RequestBody EmployeeEntity employeeEntity) {
		EmployeeEntity employee = employeeRepo.getOne(employeeEntity.getEmployeeId());
		EmployeeAfterMap employeeMap = new EmployeeAfterMap(employee);
		return employeeMap;
	}

	/*
	 * API Get By Name Employee
	 * 
	 * @param employeeEntity
	 */
	@PostMapping("/searchname")
	public ResponseEntity<?> searchEmp(@RequestBody EmployeeDto employeeDto) {
		List<EmployeeEntity> employ = searchEmployeeRepo.searchEmp(employeeDto);
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
	 *
	 * @param employeeEntity
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public EmployeeEntity create(@RequestBody EmployeeEntity employeeEntity) {
		return employeeRepo.save(employeeEntity);
	}

	/*
	 * API update EmployeeEntity
	 * 
	 * @param employeeEntity
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
		return ResponseEntity.ok().build();
	}

	/*
	 * API Delete By Id employee
	 * 
	 * @param employeeEntity
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<EmployeeEntity> delete(@RequestBody EmployeeEntity employeeEntity) {
		employeeRepo.delete(employeeEntity.getEmployeeId());
			
		return ResponseEntity.ok().build();
	}
	
	
}// end
