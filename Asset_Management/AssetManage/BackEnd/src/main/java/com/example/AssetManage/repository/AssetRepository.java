package com.example.AssetManage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.AssetManage.entity.AssetEntity;

@Repository
public interface AssetRepository extends JpaRepository<AssetEntity, Long> {
	/*
	 * SearchName Query
	 * */
	@Query(value="select * from asset where asset_name like %:assetName%", nativeQuery = true)
List<AssetEntity> searchByName(@Param("assetName")String name);	
	/*
	 * Delete asset Query 
	 * Update is_delete = 1
	 * */
	@Modifying
	@Transactional
	@Query(value="UPDATE asset set is_delete = 1 where asset_id=:assetId", nativeQuery =true)
	void delete(@Param("assetId")long assetId);
	/*
	 * find all asset Query 
	 * find all where is_delete = 1
	 * */
	@Query(value = "SELECT * FROM asset  WHERE is_delete = 0",  nativeQuery = true)
	List<AssetEntity> getAll();
}
	