package com.canteenManagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.canteenManagement.pojo.OrderInfo;
import com.canteenManagement.util.CommonResult;

public interface OrderInfoService extends IService<OrderInfo> {
    CommonResult insertOrder(OrderInfo orderInfo);
    CommonResult listOrders(int currentPage,int pageSize);
}
