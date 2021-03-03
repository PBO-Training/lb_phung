package com.example.AssetManage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssetManage.dto.AssetEmployeeAfterMap;
import com.example.AssetManage.dto.AssetEmployeeDto;
import com.example.AssetManage.entity.AssetEmployeeEntity;
import com.example.AssetManage.repository.AssetEmployeeRepository;

/**
 * @author lb_phung
 *
 */
@RestController
@RequestMapping("/api/assetemployee")
@CrossOrigin(origins = "*")
public class AssetEmployeeController {
	
	@Autowired
	
	AssetEmployeeRepository assetEmployeeRepository;		
	
	/*
	 * API Get All AssetEmployeeEntity
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		List<AssetEmployeeEntity> listAssetEmployeeEntity = assetEmployeeRepository.findAll();
		List<AssetEmployeeAfterMap> listAssetEmployeeAfterMap = listAssetEmployeeEntity.stream().map(AssetEmployeeAfterMap::new)
				.collect(Collectors.toList());

		if (listAssetEmployeeAfterMap.isEmpty()) {
			return new ResponseEntity<List<AssetEmployeeAfterMap>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<AssetEmployeeAfterMap>>(listAssetEmployeeAfterMap, HttpStatus.OK);
	}
	
	/**
	 * API get employee_id
	 * show employee_name, asset_name
	 * */
	@RequestMapping(value = "/employeeinfo", method = RequestMethod.POST)
	public ResponseEntity<List<AssetEmployeeAfterMap>> getemployeeinfo(@RequestBody AssetEmployeeDto dto) {
		List<AssetEmployeeEntity> employ = assetEmployeeRepository.getEmployee(dto.getEmployeeId());
		List<AssetEmployeeAfterMap> listempMap = new ArrayList<AssetEmployeeAfterMap>();
		for (int i = 0; i < employ.size(); i++) {
			System.out.println(employ.get(i));
			AssetEmployeeAfterMap employeeMap = new AssetEmployeeAfterMap(employ.get(i));
			listempMap.add(employeeMap);
		}
		;
		return new ResponseEntity<List<AssetEmployeeAfterMap>>(listempMap, HttpStatus.OK);
	}
	/**
	 * API get asset_id
	 * show  asset_name, employee_name,
	 * */
	@RequestMapping(value = "/assetinfo", method = RequestMethod.POST)
	public ResponseEntity<List<AssetEmployeeAfterMap>> getassetinfo(@RequestBody AssetEmployeeDto dto) {
		List<AssetEmployeeEntity> employ = assetEmployeeRepository.getAssetInfo(dto.getAssetId());
		List<AssetEmployeeAfterMap> listempMap = new ArrayList<AssetEmployeeAfterMap>();
		for (int i = 0; i < employ.size(); i++) {
			System.out.println(employ.get(i));
			AssetEmployeeAfterMap employeeMap = new AssetEmployeeAfterMap(employ.get(i));
			listempMap.add(employeeMap);
		}
		;
		return new ResponseEntity<List<AssetEmployeeAfterMap>>(listempMap, HttpStatus.OK);
	}

}// end
