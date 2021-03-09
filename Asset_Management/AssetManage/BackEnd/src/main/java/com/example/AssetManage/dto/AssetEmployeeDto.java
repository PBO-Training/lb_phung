package com.example.AssetManage.dto;

import java.sql.Date;

public class AssetEmployeeDto {
	public long assetId;
	
	public long employeeId;
	
	public String assetEmployeeName;
	
	public Date assetEmployeDateRange;
	

	public long getAssetId() {
		return assetId;
	}

	public void setAssetId(long assetId) {
		this.assetId = assetId;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
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
	
	
}
