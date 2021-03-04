package com.canteenManagement.controller;

import com.canteenManagement.pojo.OrderInfo;
import com.canteenManagement.service.OrderInfoService;
import com.canteenManagement.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;
    @RequestMapping("/insert.do")
    public CommonResult insert(OrderInfo orderInfo) {
        return orderInfoService.insertOrder(orderInfo);
    }
    @RequestMapping("/list.do")
    public CommonResult list(int pageNum,int pageSize) {
        int currentPage = pageNum;
        return orderInfoService.listOrders(currentPage,pageSize);
    }
    @RequestMapping("/delete.do")
    public CommonResult delete(int id) {
        boolean remove = orderInfoService.removeById(id);
        if(remove){
            return new CommonResult(200,"success",1);
        }else {
            return new CommonResult(500,"failed",0);
        }
    }

}
