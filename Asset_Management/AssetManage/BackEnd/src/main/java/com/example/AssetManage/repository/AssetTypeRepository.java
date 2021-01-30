package com.example.AssetManage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AssetManage.entity.AssetTypeEntity;

@Repository
public interface AssetTypeRepository extends JpaRepository<AssetTypeEntity, Long> {
@Query(value="select * from asset_type where asset_type_name like %:assetTypeName%", nativeQuery = true)	
	List<AssetTypeEntity> searchByName(@Param("assetTypeName") String name);

}
