package com.example.AssetManage.dto;

public class AssetDto {
	public long assetId;
	public String assetCode;
	public String assetName;
	public long assetType;

	public long getAssetId() {
		return assetId;
	}

	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public long getAssetType() {
		return assetType;
	}

	public void setAssetType(long assetTypeId) {
		this.assetType = assetTypeId;
	}
}
