package com.example.AssetManage.repository;

import com.example.AssetManage.Base.BaseResponse;
import com.example.AssetManage.dto.AssetDto;

public interface AssetCreateService {
	BaseResponse assetCreate (AssetDto assetDto, int assetId );
}
