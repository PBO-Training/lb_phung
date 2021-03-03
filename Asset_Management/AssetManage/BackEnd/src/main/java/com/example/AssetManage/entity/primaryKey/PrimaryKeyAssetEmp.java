package com.example.AssetManage.entity.primaryKey;

import java.io.Serializable;

/**
 * [Description]:Primary key of AssetEmployeeEntity<br>
 * [ Remarks ]:<br>
 * [Copyright]: Copyright (c) 2020<br>
 * 
 * @author Brycen VietNam Company
 * @version 1.0
 */
public class PrimaryKeyAssetEmp implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * EmployeeEntity
     */
    private Long employeeId;
    /**
     * AssetEntity
     */
    private Long assetId;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
        result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PrimaryKeyAssetEmp other = (PrimaryKeyAssetEmp) obj;
        if (employeeId == null) {
            if (other.employeeId != null)
                return false;
        } else if (!employeeId.equals(other.employeeId))
            return false;
        if (assetId == null) {
            if (other.assetId != null)
                return false;
        } else if (!assetId.equals(other.assetId))
            return false;
        return true;
    }

    public Long getEmployee() {
        return employeeId;
    }

    public void setEmployee(Long employeeId) {
        this.employeeId = employeeId;
    }



    public Long getAsset() {
		return assetId;
	}

	public void setAsset(Long assetId) {
		this.assetId = assetId;
	}

	public PrimaryKeyAssetEmp() {
    }

}
