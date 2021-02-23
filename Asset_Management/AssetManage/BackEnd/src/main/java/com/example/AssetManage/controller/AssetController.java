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

import com.example.AssetManage.dto.AssetAfterMap;
import com.example.AssetManage.dto.AssetDto;
import com.example.AssetManage.entity.AssetEntity;
import com.example.AssetManage.entity.AssetTypeEntity;
import com.example.AssetManage.repository.AssetRepository;
import com.example.AssetManage.repository.AssetTypeRepository;

/**
 * @author lb_phung
 *
 */
@RestController
@RequestMapping("/api/asset")
@CrossOrigin(origins = "*")
public class AssetController {
	// public static Logger logger =
	// LoggerFactory.getLogger(AssetEntityController.class);
	@Autowired
	AssetRepository assetRepository;
	@Autowired
	AssetTypeRepository assetTypeRepository;

	/*
	 * API Get All AssetEntity
	 */
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<List<AssetAfterMap>> getAll() {
		List<AssetEntity> listAssetEntity = assetRepository.getAll();
		List<AssetAfterMap> listAssetAfterMap = listAssetEntity.stream().map(AssetAfterMap::new)
				.collect(Collectors.toList());

		if (listAssetAfterMap.isEmpty()) {
			return new ResponseEntity<List<AssetAfterMap>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<AssetAfterMap>>(listAssetAfterMap, HttpStatus.OK);
	}

	/*
	 * API Get By Name AssetEntity
	 */
	@PostMapping("/searchname")
	public ResponseEntity<?> searchByName(@RequestBody AssetEntity assetEntity) {
		List<AssetEntity> asset = assetRepository.searchByName(assetEntity.getAssetName());
		List<AssetAfterMap> listAssetMap = new ArrayList<AssetAfterMap>();
		for (int i = 0; i < asset.size(); i++) {
			System.out.println(asset.get(i));
			AssetAfterMap assetMap = new AssetAfterMap(asset.get(i));
			listAssetMap.add(assetMap);
		};
		// return ResponseEntity.ok(listAssetMap);
		return new ResponseEntity<List<AssetAfterMap>>(listAssetMap, HttpStatus.OK);
	}

	/*
	 * API Get By Id AssetEntity
	 */
	@RequestMapping(value = "/getid", method = RequestMethod.POST)
	public AssetAfterMap getId(@RequestBody AssetEntity assetEntity) {
		AssetEntity asset = assetRepository.getOne(assetEntity.getAssetId());
		AssetAfterMap assetMap = new AssetAfterMap(asset);
		return assetMap;
	}

	/*
	 * API Create AssetEntity
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createAsset(@RequestBody AssetDto assetDto) {
		AssetEntity asset = new AssetEntity();
		/*
		 * if (asset == null) { return ResponseEntity.notFound().build(); }
		 */
		asset.setAssetCode(assetDto.getAssetCode());
		asset.setAssetName(assetDto.getAssetName());
		asset.setAssetPrice(assetDto.getAssetPrice());
		asset.setAssetDayExp(assetDto.getAssetDayExp());
		asset.setDoNotUse(assetDto.getDoNotUse());
		asset.setUsed(assetDto.getUsed());
		AssetTypeEntity assetType = assetTypeRepository.getOne(assetDto.assetTypeId);
		asset.setAssetType(assetType);
		assetRepository.save(asset);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/*
	 * API Update AssetEntity
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<AssetEntity> updateAsset(@RequestBody AssetEntity assetEntity) {
		AssetEntity asset = assetRepository.getOne(assetEntity.getAssetId());

		if (asset == null) {
			return ResponseEntity.notFound().build();
		}
		asset.setAssetId(assetEntity.getAssetId());
		asset.setAssetCode(assetEntity.getAssetCode());
		asset.setAssetName(assetEntity.getAssetName());
		asset.setAssetPrice(assetEntity.getAssetPrice());
		asset.setAssetDayExp(assetEntity.getAssetDayExp());
		asset.setUsed(assetEntity.getUsed());
		asset.setDoNotUse(assetEntity.getDoNotUse());		
		asset.setAssetType(assetEntity.getAssetType());

		AssetEntity updateAsset = assetRepository.save(asset);
		return ResponseEntity.ok().build();
	}

	/*
	 * API Delete By Id AssetEntity
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity<AssetEntity> deleteAsset(@RequestBody AssetEntity assetEntity) {
		assetRepository.delete(assetEntity.getAssetId());
		return ResponseEntity.ok().build();
	}
}// end
