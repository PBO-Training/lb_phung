package com.example.AssetManage.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "asset")
public class AssetEntity {
	/**
	 * ID of Asset
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@ManyToOne
	@JoinColumn(name = "asset_type_id")
	private AssetTypeEntity assetType;

	/**
	 * List Asset Employee
	 */
	@OneToMany(mappedBy = "assetId", cascade = CascadeType.ALL)
	private List<AssetEmployeeEntity> listAssetEmploy;
	/**
	 * Flag delete
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

	public AssetEntity() {
	}

	public List<AssetEmployeeEntity> getListAssetEmploy() {
		return listAssetEmploy;
	}

	public void setListAssetEmploy(List<AssetEmployeeEntity> listAssetEmploy) {
		this.listAssetEmploy = listAssetEmploy;
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

	public AssetTypeEntity getAssetType() {
		return assetType;
	}

	public void setAssetType(AssetTypeEntity assetType) {
		this.assetType = assetType;
	}

}
