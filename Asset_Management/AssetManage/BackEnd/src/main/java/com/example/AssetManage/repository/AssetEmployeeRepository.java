package com.example.AssetManage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.AssetManage.entity.AssetEmployeeEntity;
import com.example.AssetManage.entity.AssetEntity;

@Repository
public interface AssetEmployeeRepository extends JpaRepository<AssetEntity, Long> {
	@Query(value = "select * from asset_employee" , nativeQuery=true)
	List<AssetEmployeeEntity> getAll();
	
}
	