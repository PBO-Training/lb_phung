package com.example.AssetManage.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AssetManage.dto.AssetTypeAfterMap;
import com.example.AssetManage.dto.AssetTypeDto;
import com.example.AssetManage.entity.AssetTypeEntity;
import com.example.AssetManage.repository.AssetTypeRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AssetTypeController {
	@Autowired
	AssetTypeRepository assetTypeRepository;

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
	 * API Get By Id AssetEntity
	 */
	@RequestMapping(value = "/assetType/{assetType_id}", method = RequestMethod.GET)
	public AssetTypeAfterMap findAssetEntity(@PathVariable("assetType_id") long assetTypeId) {
		AssetTypeEntity assetType = assetTypeRepository.getOne(assetTypeId);
		AssetTypeAfterMap assetTypeMap = new AssetTypeAfterMap(assetType);
		return assetTypeMap;
	}

	/*
	 * API Create AssetEntity
	 */
	@RequestMapping(value = "/assetType", method = RequestMethod.POST)
	public ResponseEntity<?> saveAsset(@RequestBody AssetTypeDto assetTypeDto) {
		AssetTypeEntity assetType = new AssetTypeEntity();
		/*
		 * if (asset == null) { return ResponseEntity.notFound().build(); }
		 */
		assetType.setAssetTypeCode(assetTypeDto.getAssetTypeCode());
		assetType.setAssetTypeName(assetTypeDto.getAssetTypeName());

		assetTypeRepository.save(assetType);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/assetType/{assetType_id}", method = RequestMethod.PUT)
	
	public ResponseEntity<AssetTypeEntity> updateAssetType(@PathVariable(value = "assetType_id") Long assetTypeId,
			@RequestBody AssetTypeEntity assetTypeEntity) {
		AssetTypeEntity assetType = assetTypeRepository.getOne(assetTypeId);

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
	 * API Delete By Id AssetEntity
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
