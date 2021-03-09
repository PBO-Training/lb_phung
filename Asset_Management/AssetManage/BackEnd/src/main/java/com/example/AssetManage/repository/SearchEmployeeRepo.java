package com.example.AssetManage.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.AssetManage.dto.EmployeeDto;
import com.example.AssetManage.entity.EmployeeEntity;

@Repository
public interface SearchEmployeeRepo {
	 /**
     * [Description]: Search a list Employee<br/>
     * [ Remarks ]:<br/>
     *
     * @param EmployeeDto
     *
     * @return List Employee
     */
	public void searchEmp(EmployeeDto empDto);


}
