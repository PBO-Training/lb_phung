package com.example.AssetManage.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "asset_type")
public class AssetTypeEntity {
	/**
	 * ID of Asset
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assetTypeId;
	/**
	 * Code of AssetType
	 */
	private String assetTypeCode;

	/**
	 * Name of AssetType
	 */
	private String assetTypeName;
	/**
	 * AssetType
	 */
	@OneToMany(mappedBy = "assetType", cascade = CascadeType.ALL)
	private List<AssetEntity> assets;
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
	private Date createDate;

	/**
	 * Last Modified Date
	 */
	private Date updateDate;

	public AssetTypeEntity() {

	}

	public AssetTypeEntity(AssetTypeEntity assetType) {
		// TODO Auto-generated constructor stub
	}

	public Long getAssetTypeId() {
		return assetTypeId;
	}

	public void setAssetTypeId(Long assetTypeID) {
		this.assetTypeId = assetTypeID;
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

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public List<AssetEntity> getAssets() {
		return assets;
	}

	public void setAssets(List<AssetEntity> assets) {
		this.assets = assets;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
