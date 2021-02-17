package com.example.AssetManage.dto;

import com.example.AssetManage.entity.AssetTypeEntity;

public class AssetTypeAfterMap {
	/**
	 * ID of Asset
	 */

	private Long assetTypeId;
	/**
	 * Code of AssetType
	 */

	private String assetTypeCode;

	/**
	 * Name of AssetType
	 */

	private String assetTypeName;

	public AssetTypeAfterMap(AssetTypeEntity assetTypeEntity) {

		this.assetTypeId = assetTypeEntity.getAssetTypeId();
		this.assetTypeCode = assetTypeEntity.getAssetTypeCode();
		this.assetTypeName = assetTypeEntity.getAssetTypeName();

	}

	public Long getAssetTypeId() {
		return assetTypeId;
	}

	public void setAssetTypeId(Long assetTypeId) {
		this.assetTypeId = assetTypeId;
	}

	public String getAssetTypeCode() {
		return assetTypeCode;
	}

	public void setAssetTypeCode(String assetTypeCode) {
		this.assetTypeCode = assetTypeCode;
	}

	public String getAssetTypeName() {
		return assetTypeName;
	}

	public void setAssetTypeName(String assetTypeName) {
		this.assetTypeName = assetTypeName;
	}
}
