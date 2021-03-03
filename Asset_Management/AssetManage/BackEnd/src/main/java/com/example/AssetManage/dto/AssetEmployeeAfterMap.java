package com.example.AssetManage.dto;

import java.sql.Date;

import com.example.AssetManage.entity.AssetEmployeeEntity;

/**
 * @author lb_phung
 *
 */
public class AssetEmployeeAfterMap {

	private String assetEmployeeName;
	private Date assetEmployeDateRange;
	private String assetName;
	private String employeeName;

	public AssetEmployeeAfterMap(AssetEmployeeEntity assetEmployeeEntity) {
		super();
		this.assetEmployeDateRange = assetEmployeeEntity.getAssetEmployeDateRange();
		this.assetEmployeeName = assetEmployeeEntity.getAssetEmployeeName();
		this.assetName = assetEmployeeEntity.getAssetId().getAssetName();
		this.employeeName = assetEmployeeEntity.getEmployeeId().getEmployeeName();
	}

	public String getAssetEmployeeName() {
		return assetEmployeeName;
	}

	public void setAssetEmployeeName(String assetEmployeeName) {
		this.assetEmployeeName = assetEmployeeName;
	}

	public Date getAssetEmployeDateRange() {
		return assetEmployeDateRange;
	}

	public void setAssetEmployeDateRange(Date assetEmployeDateRange) {
		this.assetEmployeDateRange = assetEmployeDateRange;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}// end
