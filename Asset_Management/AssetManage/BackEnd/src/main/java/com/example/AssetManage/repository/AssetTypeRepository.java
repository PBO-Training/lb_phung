package com.example.AssetManage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.AssetManage.entity.AssetTypeEntity;

@Repository
public interface AssetTypeRepository extends JpaRepository<AssetTypeEntity, Long> {
	/*
	 * SearchName Query
	 * */
	@Query(value = "select * from asset_type where asset_type_name like %:assetTypeName%", nativeQuery = true)
	List<AssetTypeEntity> searchByName(@Param("assetTypeName") String name);
	/*
	 * SearchCode Query
	 * */
	@Query(value = "select * from asset_type where asset_type_code = ':assetTypeCode'", nativeQuery = true)
	List<AssetTypeEntity> searchByCode(@Param("assetTypeCode") String code);
	/*
	 * find all assetType Query 
	 * find all where is_delete = 1
	 * */
	@Query(value = "SELECT * FROM asset_Type  WHERE is_delete = 0",  nativeQuery = true)
	List<AssetTypeEntity> getAll();	
	/*
	 * Delete assetType Query
	 * Update is_delete =1 
	 * */
	@Modifying
	@Transactional
	@Query(value="UPDATE asset_Type set is_delete = 1 where asset_type_id=:assetTypeId", nativeQuery =true)
	void delete(@Param("assetTypeId")long assetTypeId);
}
