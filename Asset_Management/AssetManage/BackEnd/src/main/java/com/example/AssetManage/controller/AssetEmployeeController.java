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
	 * API Get All AssetEntity
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

//	/*
//	 * API Get By Name AssetEntity
//	 */
//	@PostMapping("/searchname")
//	public ResponseEntity<?> searchByName(@RequestBody AssetEntity assetEntity) {
//		List<AssetEntity> asset = assetRepository.searchByName(assetEntity.getAssetName());
//		List<AssetAfterMap> listAssetMap = new ArrayList<AssetAfterMap>();
//		for (int i = 0; i < asset.size(); i++) {
//			System.out.println(asset.get(i));
//			AssetAfterMap assetMap = new AssetAfterMap(asset.get(i));
//			listAssetMap.add(assetMap);
//		};
//		// return ResponseEntity.ok(listAssetMap);
//		return new ResponseEntity<List<AssetAfterMap>>(listAssetMap, HttpStatus.OK);
//	}
//
//	/*
//	 * API Get By Id AssetEntity
//	 */
//	@RequestMapping(value = "/getid", method = RequestMethod.POST)
//	public AssetAfterMap getId(@RequestBody AssetEntity assetEntity) {
//		AssetEntity asset = assetRepository.getOne(assetEntity.getAssetId());
//		AssetAfterMap assetMap = new AssetAfterMap(asset);
//		return assetMap;
//	}
//
//	/*
//	 * API Create AssetEntity
//	 */
//	@RequestMapping(value = "/create", method = RequestMethod.POST)
//	public ResponseEntity<?> createAsset(@RequestBody AssetDto assetDto) {
//		AssetEntity asset = new AssetEntity();
//		/*
//		 * if (asset == null) { return ResponseEntity.notFound().build(); }
//		 */
//		asset.setAssetCode(assetDto.getAssetCode());
//		asset.setAssetName(assetDto.getAssetName());
//		asset.setAssetPrice(assetDto.getAssetPrice());
//		asset.setAssetDayExp(assetDto.getAssetDayExp());
//		asset.setDoNotUse(assetDto.getDoNotUse());
//		asset.setUsed(assetDto.getUsed());
//		AssetTypeEntity assetType = assetTypeRepository.getOne(assetDto.assetTypeId);
//		asset.setAssetType(assetType);
//		assetRepository.save(asset);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}
//
//	/*
//	 * API Update AssetEntity
//	 */
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
//	public ResponseEntity<AssetEntity> updateAsset(@RequestBody AssetEntity assetEntity) {
//		AssetEntity asset = assetRepository.getOne(assetEntity.getAssetId());
//
//		if (asset == null) {
//			return ResponseEntity.notFound().build();
//		}
//		asset.setAssetId(assetEntity.getAssetId());
//		asset.setAssetCode(assetEntity.getAssetCode());
//		asset.setAssetName(assetEntity.getAssetName());
//		asset.setAssetPrice(assetEntity.getAssetPrice());
//		asset.setAssetDayExp(assetEntity.getAssetDayExp());
//		asset.setDoNotUse(assetEntity.getDoNotUse());
//		asset.setUsed(assetEntity.getUsed());
//		asset.setAssetType(assetEntity.getAssetType());
//
//		AssetEntity updateAsset = assetRepository.save(asset);
//		return ResponseEntity.ok(updateAsset);
//	}
//
//	/*
//	 * API Delete By Id AssetEntity
//	 */
//	@RequestMapping(value = "/delete", method = RequestMethod.POST)
//	public ResponseEntity<AssetEntity> deleteAsset(@RequestBody AssetEntity assetEntity) {
//		assetRepository.delete(assetEntity.getAssetId());
//		return ResponseEntity.ok().build();
//	}
}// end
