package com.example.AssetManage.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "asset_employee")
public class AssetEmployeeEntity implements Serializable {

	/**
	 * 
	 */
	private static long serialVersionUID = 1L;
	/**
	 * ID of Asset
	 */
	@Id
	@ManyToOne
	@JoinColumn(name = "asset_id")
	private AssetEntity assetId;
	/**
	 * ID of employee
	 */
	@Id
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private EmployeeEntity employeeId;
	/**
	 * amount of assetEmployee
	 */
	private String assetEmployeeName;
	/**
	 * amount of assetEmployee
	 */
	private Date assetEmployeDateRange;
	/**
	 * delete by User
	 */
	private boolean isDelete;

	/**
	 * Create by User
	 */
	private int createBy;

	/**
	 * Last modified by User
	 */
	private int updateBy;

	/**
	 * Date create
	 */
	private LocalDate createDate;

	/**
	 * Last Modified Date
	 */
	private Date updateDate;

	public AssetEmployeeEntity() {
	}

	public AssetEntity getAssetId() {
		return assetId;
	}

	public void setAssetId(AssetEntity assetId) {
		this.assetId = assetId;
	}

	public EmployeeEntity getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(EmployeeEntity employeeId) {
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

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public int getCreateBy() {
		return createBy;
	}

	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}

	public int getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(int updateBy) {
		this.updateBy = updateBy;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
