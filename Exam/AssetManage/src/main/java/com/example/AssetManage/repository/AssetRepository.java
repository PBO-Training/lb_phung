package com.example.AssetManage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.AssetManage.dto.AssetDto;
import com.example.AssetManage.entity.AssetEntity;

@Repository
public interface AssetRepository extends JpaRepository<AssetEntity, Long> {
	@Query
	AssetDto save(AssetDto assetDto);

}
