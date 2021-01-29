package com.example.AssetManage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.AssetManage.dto.AssetTypeAfterMap;
import com.example.AssetManage.entity.AssetTypeEntity;
import com.example.AssetManage.repository.AssetTypeRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AssetTypeController {
	@Autowired
	AssetTypeRepository assetTypeRepository;
	/*
	 * API Get  AssetTypeEntity
	 */
	@RequestMapping(value = "/assetType", method = RequestMethod.GET)
	public ResponseEntity<List<AssetTypeEntity>> listAllContact() {
		List<AssetTypeEntity> listAssetType = assetTypeRepository.findAll();
		if (listAssetType.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AssetTypeEntity>>(listAssetType, HttpStatus.OK);
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
	@GetMapping("/searchAssetType/{assetType_name}")
	public ResponseEntity<?> getByName(@PathVariable("assetType_name") String assetTypeName) {		
		List<AssetTypeEntity> assetType = assetTypeRepository.searchByName(assetTypeName);
		
		List<AssetTypeAfterMap> listAssetTypeMap = new ArrayList<AssetTypeAfterMap>() ;	
		for (int i = 0; i < assetType.size(); i++) {			
			System.out.println(assetType.get(i));	
			AssetTypeAfterMap assetTypeMap = new AssetTypeAfterMap(assetType.get(i));
			listAssetTypeMap.add(assetTypeMap);
		};
		
		
//	AssetTypeAfterMap assetTypeMap = new arrayList< AssetTypeAfterMap>(assetType);
		return null;
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
