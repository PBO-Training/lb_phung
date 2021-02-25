package com.example.AssetManage.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssetManage.dto.AssetEmployeeAfterMap;
import com.example.AssetManage.entity.AssetEmployeeEntity;
import com.example.AssetManage.repository.AssetEmployeeRepository;
import com.example.AssetManage.repository.AssetRepository;

/**
 * @author lb_phung
 *
 */
@RestController
@RequestMapping("/api/assetemployee")
@CrossOrigin(origins = "*")
public class AssetEmployeeController {
	
	@Autowired
	AssetRepository assetRepository;
	AssetEmployeeRepository assetEmployeeRepository;	

	/*
	 * API Get All AssetEmployeeEntity
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<List<AssetEmployeeAfterMap>> getAll() {
		List<AssetEmployeeEntity> listAssetEmployeeEntity = assetEmployeeRepository.getAll();
		List<AssetEmployeeAfterMap> listAssetEmployeeAfterMap = listAssetEmployeeEntity.stream().map(AssetEmployeeAfterMap::new)
				.collect(Collectors.toList());

		if (listAssetEmployeeAfterMap.isEmpty()) {
			return new ResponseEntity<List<AssetEmployeeAfterMap>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<AssetEmployeeAfterMap>>(listAssetEmployeeAfterMap, HttpStatus.OK);
	}
	

}// end
