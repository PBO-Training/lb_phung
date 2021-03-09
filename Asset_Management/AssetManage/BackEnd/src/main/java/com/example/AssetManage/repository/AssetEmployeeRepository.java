package com.example.AssetManage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AssetManage.dto.AssetEmployeeDto;
import com.example.AssetManage.entity.AssetEmployeeEntity;
import com.example.AssetManage.entity.AssetEntity;
import com.example.AssetManage.entity.EmployeeEntity;
/*
 * get all;
 * */
@Repository
public interface AssetEmployeeRepository extends JpaRepository<AssetEmployeeEntity, Long> {
	/**
	 * search by is_delete = 0
	 * */
	@Query(value = "select * from asset_employee where is_delete= 0" , nativeQuery=true)
	List<AssetEmployeeEntity> getAll();
	
	/**
	 * Query
	 * Get info Employee
	 * show employee_name, asset_name
	 * @param: employeeId
	 * */	
	@Query(value = "SELECT \r\n" + 			
			"    ae.*" + 
			"FROM\r\n" + 
			"    asset_employee AS ae\r\n" + 
			"        INNER JOIN\r\n" + 
			"    asset AS a\r\n" + 
			"       INNER JOIN\r\n" + 
			"    employee as e ON ae.employee_id = e.employee_id\r\n" + 
			"        AND ae.asset_id = a.asset_id\r\n" + 
			"WHERE\r\n" + 
			"    e.employee_id = :employeeId", nativeQuery = true)

	List<AssetEmployeeEntity> getEmployee(@Param("employeeId")Long employeeId);

	/**
	 * Query
	 * Get info Asset
	 * show employee_name, asset_name
	 * @param: assetId
	 * */	
	@Query(value = "SELECT \r\n" + 			
			"    ae.*" + 
			"FROM\r\n" + 
			"    asset_employee AS ae\r\n" + 
			"        INNER JOIN\r\n" + 
			"    asset AS a\r\n" + 
			"       INNER JOIN\r\n" + 
			"    employee as e ON ae.employee_id = e.employee_id\r\n" + 
			"        AND ae.asset_id = a.asset_id\r\n" + 
			"WHERE\r\n" + 
			"    a.asset_id = :assetId", nativeQuery = true)
	List<AssetEmployeeEntity> getAssetInfo(@Param("assetId")Long assetId);
//	List<AssetEmployeeEntity> getAssetInfo(AssetEmployeeDto dto);	
//	 StringBuffer selectString = new StringBuffer("SELECT * ");
//	  StringBuffer fromString = new StringBuffer("FROM asset_employee ae ");
//	  StringBuffer joinString = new StringBuffer("Inner join asset a inner join employee e");
//	  StringBuffer onString = new  StringBuffer("ON ae.employee_id=e.employee_id and ae.asset_id = a.asset_id");
//	  StringBuffer whereString = new StringBuffer("WHERE  a.asset_id = :assetId AND ae.is_delete=0 ");
//	  StringBuffer orderByString = new StringBuffer("order by asset_name asc ");
//	  StringBuffer queryString = new StringBuffer();
	
}

	

	