package com.example.AssetManage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AssetManage.entity.AssetEntity;
import com.example.AssetManage.entity.EmployeeEntity;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
/*
 * SearchName Query
 * */
	@Query(value="select * from employee where employee_name like %:employeeName%", nativeQuery = true)
List<EmployeeEntity> searchByName(@Param("employeeName")String name);

}
