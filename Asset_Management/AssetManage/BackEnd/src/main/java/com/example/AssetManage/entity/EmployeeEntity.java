package com.example.AssetManage.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
	/**
	 * ID of employee
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	/**
	 * Code of employee
	 */
	private String employeeCode;
	/**
	 * Name of employee
	 */
	private String employeeName;
	
	/**
     * List Asset Employee
     */
    @OneToMany(mappedBy = "employeeId", cascade = CascadeType.ALL)
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
	private Date createDate;

	/**
	 * Last Modified Date
	 */
	private Date updateDate;

	
	public List<AssetEmployeeEntity> getListAssetEmploy() {
		return listAssetEmploy;
	}

	public void setListAssetEmploy(List<AssetEmployeeEntity> listAssetEmploy) {
		this.listAssetEmploy = listAssetEmploy;
	}

	public EmployeeEntity() {

	}


	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
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
