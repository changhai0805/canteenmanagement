package com.canteenManagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.canteenManagement.pojo.BuyInfo;
import com.canteenManagement.util.CommonResult;

public interface BuyInfoService extends IService<BuyInfo> {
    CommonResult listInPage(int pageNum,int pageSize);
    CommonResult updateStatus(int id,String status);
}
