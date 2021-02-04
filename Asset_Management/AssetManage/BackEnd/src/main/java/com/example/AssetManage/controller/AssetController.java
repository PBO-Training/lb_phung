package com.example.AssetManage.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		List<AssetEntity> listAssetEntity = assetRepository.findAll();
		List<AssetAfterMap> listAssetAfterMap = listAssetEntity.stream().map(AssetAfterMap::new)
				.collect(Collectors.toList());

		if (listAssetAfterMap.isEmpty()) {
			return new ResponseEntity<List<AssetAfterMap>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<AssetAfterMap>>(listAssetAfterMap, HttpStatus.OK);
	}

	/*
	 * API Search BY Name AssetEntity
	 */
	@GetMapping("/searchname/{asset_name}")
	public ResponseEntity<?> searchByName(@PathVariable("asset_name") String assetName) {
		List<AssetEntity> asset = assetRepository.searchByName(assetName);
		List<AssetAfterMap> listassetMap = new ArrayList<AssetAfterMap>();
		for (int i = 0; i < asset.size(); i++) {
			AssetAfterMap assetMap = new AssetAfterMap(asset.get(i));
			listassetMap.add(assetMap);
		}
		return ResponseEntity.ok(listassetMap);
	}

	/*
	 * API Get By Id AssetEntity
	 */
	@RequestMapping(value = "/getid/{asset_id}", method = RequestMethod.GET)
	public AssetAfterMap getId(@PathVariable("asset_id") long assetId) {
		AssetEntity asset = assetRepository.getOne(assetId);
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

		AssetTypeEntity assetType = assetTypeRepository.getOne(assetDto.assetTypeId);
		asset.setAssetType(assetType);
		assetRepository.save(asset);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/*
	 * API Update AssetEntity
	 */
	@RequestMapping(value = "/update/{asset_id}", method = RequestMethod.PUT)
	public ResponseEntity<AssetEntity> updateAsset(@PathVariable(value = "asset_id") Long assetId,
			@RequestBody AssetEntity assetEntity) {
		AssetEntity asset = assetRepository.getOne(assetId);

		if (asset == null) {
			return ResponseEntity.notFound().build();
		}
		asset.setAssetId(assetEntity.getAssetId());
		asset.setAssetCode(assetEntity.getAssetCode());
		asset.setAssetName(assetEntity.getAssetName());
		asset.setAssetPrice(assetEntity.getAssetPrice());
		asset.setAssetDayExp(assetEntity.getAssetDayExp());
		asset.setAssetType(assetEntity.getAssetType());

		AssetEntity updateAsset = assetRepository.save(asset);
		return ResponseEntity.ok(updateAsset);
	}

	/*
	 * API Delete By Id AssetEntity
	 */
	@RequestMapping(value = "/delete/{asset_id}", method = RequestMethod.DELETE)
	public ResponseEntity<AssetEntity> deleteAsset(@PathVariable(value = "asset_id") Long id) {
		AssetEntity asset = assetRepository.getOne(id);
		if (asset == null) {
			return ResponseEntity.notFound().build();
		}

		assetRepository.delete(asset);
		return ResponseEntity.ok().build();
	}
}// end
