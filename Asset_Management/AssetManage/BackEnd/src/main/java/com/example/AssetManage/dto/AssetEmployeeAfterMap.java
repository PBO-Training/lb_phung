package com.example.AssetManage.dto;

import java.sql.Date;

import com.example.AssetManage.entity.AssetEmployeeEntity;

/**
 * @author lb_phung
 *
 */
public class AssetEmployeeAfterMap {


	private Long assetId;
	private Long employeeId;
	private String assetEmployeeName;
	private Date assetEmployeDateRange;
	
	private AssetAfterMap assetMap;


	public AssetEmployeeAfterMap(AssetEmployeeEntity assetEmployeeEntity) {
		super();
		this.assetEmployeDateRange = assetEmployeeEntity.getAssetEmployeDateRange();
		this.assetEmployeeName = assetEmployeeEntity.getAssetEmployeeName();
		
		AssetAfterMap assetType = new AssetAfterMap(assetEmployeeEntity.getAssetId());
		this.assetMap = assetType;
//		EmployeeAfterMap ap = new EmployeeAfterMap(EmployeeEntity.getEmployeeId());
		
	}	
	
	public Long getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(Long employeeId) {
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



	public AssetAfterMap getAssetMap() {
		return assetMap;
	}



	public void setAssetMap(AssetAfterMap assetMap) {
		this.assetMap = assetMap;
	}



	public Long getAssetId() {
		return assetId;
	}

	public void setAssetId(Long assetId) {
		this.assetId = assetId;
	}

	

	

}// end
