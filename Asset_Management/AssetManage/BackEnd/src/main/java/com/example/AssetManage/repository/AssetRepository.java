package com.example.AssetManage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AssetManage.dto.AssetDto;
import com.example.AssetManage.entity.AssetEntity;

@Repository
public interface AssetRepository extends JpaRepository<AssetEntity, Long> {
	/*
	 * SearchName Query
	 * */
	@Query(value="select * from asset where asset_name like %:assetName%", nativeQuery = true)
List<AssetEntity> searchByName(@Param("assetName")String name);
}
