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

import com.example.AssetManage.dto.AssetTypeAfterMap;
import com.example.AssetManage.entity.AssetTypeEntity;
import com.example.AssetManage.repository.AssetTypeRepository;

@RestController
@RequestMapping("/api/assettype")
@CrossOrigin(origins = "*")
public class AssetTypeController {
	@Autowired
	AssetTypeRepository assetTypeRepository;
	/*
	 * API Get AssetTypeEntity
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<List<AssetTypeAfterMap>> getAll() {
		List<AssetTypeEntity> listAssetEntity = assetTypeRepository.findAll();
		List<AssetTypeAfterMap> listAssetAfterMap = listAssetEntity.stream().map(AssetTypeAfterMap::new)
				.collect(Collectors.toList());
		if (listAssetAfterMap.isEmpty()) {
			return new ResponseEntity<List<AssetTypeAfterMap>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AssetTypeAfterMap>>(listAssetAfterMap, HttpStatus.OK);
	}

	/*
	 * API Get By Id AssetTypeEntity
	 */
	@RequestMapping(value = "/getid", method = RequestMethod.POST)
	public AssetTypeAfterMap getId(@RequestBody AssetTypeEntity assetTypeEntity) {
		AssetTypeEntity assetType = assetTypeRepository.getOne(assetTypeEntity.getAssetTypeId());
		AssetTypeAfterMap assetTypeMap = new AssetTypeAfterMap(assetType);
		return assetTypeMap;
	}

	/*
	 * API Get By Name AssetTypeEntity
	 */
	@PostMapping("/searchname")
	public ResponseEntity<?> searchByName(@RequestBody AssetTypeEntity assetTypeEntity) {
		List<AssetTypeEntity> assetType = assetTypeRepository.searchByName(assetTypeEntity.getAssetTypeName());
		List<AssetTypeAfterMap> listAssetTypeMap = new ArrayList<AssetTypeAfterMap>();
		for (int i = 0; i < assetType.size(); i++) {
			System.out.println(assetType.get(i));
			AssetTypeAfterMap assetTypeMap = new AssetTypeAfterMap(assetType.get(i));
			listAssetTypeMap.add(assetTypeMap);
		}
		;
		// return ResponseEntity.ok(listAssetTypeMap);
		return new ResponseEntity<List<AssetTypeAfterMap>>(listAssetTypeMap, HttpStatus.OK);
	}

	/*
	 * API Get By Code AssetTypeEntity
	 */
	@PostMapping("/searchcode")
	public ResponseEntity<?> searchByCode(@RequestBody AssetTypeEntity assetTypeEntity) {

		List<AssetTypeEntity> assetType = assetTypeRepository.searchByCode(assetTypeEntity.getAssetTypeCode());
		List<AssetTypeAfterMap> listAssetTypeMap = new ArrayList<AssetTypeAfterMap>();
		for (int i = 0; i < assetType.size(); i++) {
			System.out.println(assetType.get(i));
			AssetTypeAfterMap assetTypeMap = new AssetTypeAfterMap(assetType.get(i));
			listAssetTypeMap.add(assetTypeMap);
		}
		;
		// return ResponseEntity.ok(listAssetTypeMap);
		return new ResponseEntity<List<AssetTypeAfterMap>>(listAssetTypeMap, HttpStatus.OK);
	}

	/*
	 * API Create AssetTypeEntity
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public AssetTypeEntity create(@RequestBody AssetTypeEntity assetTypeEntity) {
		return assetTypeRepository.save(assetTypeEntity);
	}

	/*
	 * API Update AssetTypeEntity
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<AssetTypeEntity> update(@RequestBody AssetTypeEntity assetTypeEntity) {
		AssetTypeEntity assetType = assetTypeRepository.getOne(assetTypeEntity.getAssetTypeId());

		if (assetType == null) {
			return ResponseEntity.notFound().build();
		}
		assetType.setAssetTypeId(assetTypeEntity.getAssetTypeId());
		assetType.setAssetTypeCode(assetTypeEntity.getAssetTypeCode());
		assetType.setAssetTypeName(assetTypeEntity.getAssetTypeName());
		AssetTypeEntity updateAsset = assetTypeRepository.save(assetType);
		return ResponseEntity.ok(updateAsset);
	}

	/*
	 * API Delete By Id AssetTypeEntity
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<AssetTypeEntity> delete(@RequestBody AssetTypeEntity assetTypeEntity) {
		AssetTypeEntity assetType = assetTypeRepository.getOne(assetTypeEntity.getAssetTypeId());
		if (assetType == null) {
			return ResponseEntity.notFound().build();
		}
		assetTypeRepository.delete(assetType);
		return ResponseEntity.ok().build();
	}
}// end
