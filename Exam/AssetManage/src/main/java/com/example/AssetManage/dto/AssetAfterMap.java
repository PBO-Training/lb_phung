package com.example.AssetManage.dto;

import java.sql.Date;

import com.example.AssetManage.entity.AssetEntity;

/**
 * @author lb_phung
 *
 */
public class AssetAfterMap {

	/**
	 * ID of Asset
	 */

	private Long assetId;
	/**
	 * Code of Asset
	 */

	private String assetCode;

	/**
	 * Name of Asset
	 */

	private String assetName;
	/**
	 * Price of Asset
	 */

	private String assetPrice;
	/**
	 * DayExp of Asset
	 */

	private Date assetDayExp;
	/**
	 * id of AssetType
	 */

	private AssetTypeAfterMap assetTypeMap;

	public AssetAfterMap(AssetEntity assetEntity) {
		super();
		this.assetId = assetEntity.getAssetId();
		this.assetCode = assetEntity.getAssetCode();
		this.assetName = assetEntity.getAssetName();
		this.assetPrice = assetEntity.getAssetPrice();
		this.assetDayExp = assetEntity.getAssetDayExp();
		AssetTypeAfterMap assetType = new AssetTypeAfterMap(assetEntity.getAssetType());
		this.assetTypeMap = assetType;

	}

	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
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

	public String getAssetPrice() {
		return assetPrice;
	}

	public void setAssetPrice(String assetPrice) {
		this.assetPrice = assetPrice;
	}

	public Date getAssetDayExp() {
		return assetDayExp;
	}

	public void setAssetDayExp(Date assetDayExp) {
		this.assetDayExp = assetDayExp;
	}

	public AssetTypeAfterMap getAssetTypeMap() {
		return assetTypeMap;
	}

	public void setAssetTypeMap(AssetTypeAfterMap assetTypeMap) {
		this.assetTypeMap = assetTypeMap;
	}

}// end
