package com.canteenManagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.canteenManagement.pojo.GoodsInfo;
import com.canteenManagement.util.CommonResult;

public interface GoodsInfoService extends IService<GoodsInfo> {
    CommonResult selectAll(int currentPage,int pageSize);
    CommonResult findByGoodName(int currentPage,int pageSize,String goodName);
    CommonResult updateGoodsInfo(GoodsInfo goodsInfo);
    CommonResult updateStatus(int id,String status);
}
