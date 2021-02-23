package com.example.AssetManage.dto;

import java.sql.Date;

public class AssetDto {
	public String assetCode;
	public String assetName;
	public String assetPrice;
	public Date assetDayExp;
	public long assetTypeId;
	public int use;
	
	public int doNotUse;
	

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public Date getAssetDayExp() {
		return assetDayExp;
	}

	public void setAssetDayExp(Date assetDayExp) {
		this.assetDayExp = assetDayExp;
	}

	public String getAssetPrice() {
		return assetPrice;
	}

	public void setAssetPrice(String assetPrice) {
		this.assetPrice = assetPrice;
	}


	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public long getAssetTypeId() {
		return assetTypeId;
	}

	public void setAssetTypeId(long assetTypeId) {
		this.assetTypeId = assetTypeId;
	}
	public int getUse() {
		return use;
	}

	public void setUse(int use) {
		this.use = use;
	}

	public int getDoNotUse() {
		return doNotUse;
	}

	public void setDoNotUse(int doNotUse) {
		this.doNotUse = doNotUse;
}
}
