package com.example.AssetManage.repository;

import java.util.List;

import com.example.AssetManage.dto.AssetEmployeeDto;
import com.example.AssetManage.entity.AssetEmployeeEntity;

public interface SearchAllTableRepo {

	List<AssetEmployeeEntity> search(AssetEmployeeDto dto);
	  
}
