package com.example.AssetManage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.AssetManage.dto.EmployeeDto;
import com.example.AssetManage.entity.EmployeeEntity;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
/*
 * SearchName Query
 * @param: employeeName
 * */
//	@Query(value="select * from employee where employee_name like %:employeeName% and is_delete=0", nativeQuery = true)
//	List<EmployeeEntity> searchByName(@Param("employeeName")String name);
	 /**
     * [Description]: Search a list Employee<br/>
     * [ Remarks ]:<br/>
     *
     * @param EmployeeDto
     * 
     * @return List Employee
     */
	//List<EmployeeEntity> searchEmp(EmployeeDto empDto);

	 
	 
	 
	 
	 
	/*
	 * find all employee Query 
	 * find all where is_delete = 1
	 * */
	@Query(value = "SELECT * FROM employee  WHERE is_delete = 0",  nativeQuery = true)
	List<EmployeeEntity> getAll();
	/*
	 * Delete employee Query
	 * Update is_delete =1 
	 * @param: employeeId
	 * */
	@Modifying
	@Transactional
	@Query(value="UPDATE employee set is_delete = 1 where employee_id=:employeeId", nativeQuery =true)
	void delete(@Param("employeeId")long employeeId);
	
	


}
