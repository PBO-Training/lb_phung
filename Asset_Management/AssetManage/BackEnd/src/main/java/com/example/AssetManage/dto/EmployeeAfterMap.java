package com.example.AssetManage.dto;

import com.example.AssetManage.entity.EmployeeEntity;

public class EmployeeAfterMap {
	/**
	 * ID of employee
	 */

	private Long employeeId;
	/**
	 * Code of employee
	 */
	private String employeeCode;
	/**
	 * Name of employee
	 */
	private String employeeName;

	public EmployeeAfterMap(EmployeeEntity employeeEntity) {
		super();
		this.employeeId = employeeEntity.getEmployeeId();
		this.employeeCode = employeeEntity.getEmployeeCode();
		this.employeeName = employeeEntity.getEmployeeName();
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

}// end
