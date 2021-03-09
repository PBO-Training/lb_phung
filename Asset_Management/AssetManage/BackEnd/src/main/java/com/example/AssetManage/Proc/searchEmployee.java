package com.example.AssetManage.Proc;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.AssetManage.dto.EmployeeDto;
import com.example.AssetManage.entity.EmployeeEntity;
import com.example.AssetManage.repository.SearchEmployeeRepo;

@Repository
public class searchEmployee implements SearchEmployeeRepo {
 
	 /**
     * Call entity manager to support creation a native query statement
     */
	@Autowired
	public EmployeeDto empDto;
	/**
     * Call query to save an instance native query statement
     */
	private Query query;
	
	 @Override
	 public void searchEmp(EmployeeDto empDto) {
		 StringBuffer selectStr = new StringBuffer("SELECT * ");
		 StringBuffer fromStr = new StringBuffer("from employee e");
		 StringBuffer whereStr = new StringBuffer("where e.employee_name like %:employeeName% and e.is_delete=0");
		 StringBuffer orderStr = new StringBuffer("order by employee_name asc");
		 StringBuffer queryStr = new StringBuffer();
		 
		 if (empDto.getEmployeeCode()!= null) {
	            whereStr.append("AND e.employee_code= :employeeCode");
	        }
		 queryStr.append(selectStr).append(fromStr).append(whereStr).append(orderStr);
	     fromStr.append(whereStr);

		
	}
}
