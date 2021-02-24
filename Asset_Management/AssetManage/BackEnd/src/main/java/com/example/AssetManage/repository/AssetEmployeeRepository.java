package com.example.AssetManage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.AssetManage.entity.AssetEmployeeEntity;
import com.example.AssetManage.entity.AssetEntity;
/*
 * get all;
 * */
@Repository
public interface AssetEmployeeRepository extends JpaRepository<AssetEntity, Long> {
	@Query(value = "select * from asset_employee" , nativeQuery=true)
	List<AssetEmployeeEntity> getAll();
	
	
	///*
	// * get detail employee with asset.
	// * What properties does an employee manage.
	// * */
//		@Query(value="select  ae.employee_id,e.employee_name, ae.asset_id, a.asset_name\r\n" + 
//				"FROM\r\n" + 
//				"    asset_employee as ae\r\n" + 
//				"        JOIN\r\n" + 
//				"    asset as a ON ae.asset_id = a.asset_id\r\n" + 
//				"    join employee as e on ae.employee_id= e.employee_id\r\n" + 
//				"WHERE\r\n" + 
//				"    e.employee_id =:employeeId", nativeQuery = true)
//		EmployeeEntity getDetail(@Param("employeeId")Long employeeId);
	//
}
	