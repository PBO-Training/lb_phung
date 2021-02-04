package com.example.AssetManage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssetManage.dto.AssetAfterMap;
import com.example.AssetManage.dto.AssetTypeAfterMap;
import com.example.AssetManage.entity.AssetEntity;
import com.example.AssetManage.entity.AssetTypeEntity;
import com.example.AssetManage.repository.AssetTypeRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AssetTypeController {
	@Autowired
	AssetTypeRepository assetTypeRepository;

	/*
	 * API Get AssetTypeEntity
	 */
	@RequestMapping(value = "/assetType", method = RequestMethod.GET)
	public ResponseEntity<List<AssetTypeAfterMap>> fineAllAssetEntity() {
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
	@RequestMapping(value = "/assetType/{assetType_id}", method = RequestMethod.GET)
	public AssetTypeAfterMap findAssetType(@PathVariable("assetType_id") long assetTypeId) {
		AssetTypeEntity assetType = assetTypeRepository.getOne(assetTypeId);
		AssetTypeAfterMap assetTypeMap = new AssetTypeAfterMap(assetType);
		return assetTypeMap;
	}

	/*
	 * API Get By Name AssetTypeEntity
	 */
	@PostMapping("/searchAssetType")
	public ResponseEntity<?> searchByName(@RequestBody AssetTypeEntity assetTypeEntity) {

		List<AssetTypeEntity> assetType = assetTypeRepository.searchByName(assetTypeEntity.getAssetTypeName());
		List<AssetTypeAfterMap> listAssetTypeMap = new ArrayList<AssetTypeAfterMap>();
		for (int i = 0; i < assetType.size(); i++) {
			System.out.println(assetType.get(i));
			AssetTypeAfterMap assetTypeMap = new AssetTypeAfterMap(assetType.get(i));
			listAssetTypeMap.add(assetTypeMap);
		};
		// return ResponseEntity.ok(listAssetTypeMap);
		return new ResponseEntity<List<AssetTypeAfterMap>>(listAssetTypeMap, HttpStatus.OK);
	}

	/*
	 * API Create AssetTypeEntity
	 */
	@RequestMapping(value = "/assetType", method = RequestMethod.POST)
	public AssetTypeEntity saveAssetType(@RequestBody AssetTypeEntity assetTypeEntity) {
		return assetTypeRepository.save(assetTypeEntity);
	}

	/*
	 * API Update AssetTypeEntity
	 */
	@RequestMapping(value = "/updateAssetType", method = RequestMethod.POST)
	public ResponseEntity<AssetTypeEntity> updateAssetType(@RequestBody AssetTypeEntity assetTypeEntity) {
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
	@RequestMapping(value = "/assetType/{assetType_id}", method = RequestMethod.DELETE)
	public ResponseEntity<AssetTypeEntity> deleteAsset(@PathVariable(value = "assetType_id") Long assetType_id) {
		AssetTypeEntity assetType = assetTypeRepository.getOne(assetType_id);
		if (assetType == null) {
			return ResponseEntity.notFound().build();
		}
		assetTypeRepository.delete(assetType);
		return ResponseEntity.ok().build();
	}
}// end
