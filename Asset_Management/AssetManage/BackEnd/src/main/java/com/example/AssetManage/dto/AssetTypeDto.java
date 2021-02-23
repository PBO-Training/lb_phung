package com.example.AssetManage.dto;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import com.example.AssetManage.entity.AssetEntity;


public class AssetTypeDto {

	private Long assetTypeId;

	private String assetTypeCode;

	private String assetTypeName;

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

	public AssetTypeDto() {

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
