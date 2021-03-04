package com.canteenManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.canteenManagement.dao.OrderInfoMapper;
import com.canteenManagement.pojo.OrderInfo;
import com.canteenManagement.service.OrderInfoService;
import com.canteenManagement.util.CommonResult;
import com.canteenManagement.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Override
    public CommonResult insertOrder(OrderInfo orderInfo) {
        if(orderInfo==null){
            return new CommonResult(500,"插入失败",0);
        }else {
            String orderTime = Utils.getDateTime();
            orderInfo.setOrderName(orderTime);
            if(orderInfoMapper.insert(orderInfo)==1){
                return new CommonResult(200,"插入成功",1);
            }else {
                return new CommonResult(500,"插入失败",0);
            }

        }

    }
}
