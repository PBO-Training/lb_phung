package com.example.AssetManage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AssetManage.entity.AssetTypeEntity;

@Repository
public interface AssetTypeRepository extends JpaRepository<AssetTypeEntity, Long> {

	

}
