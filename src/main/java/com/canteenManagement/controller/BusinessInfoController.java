package com.canteenManagement.controller;

import com.canteenManagement.service.BusinessInfoService;
import com.canteenManagement.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/businessinfo")
@CrossOrigin
public class BusinessInfoController {
    @Autowired
    private BusinessInfoService businessInfoService;

    @RequestMapping("/list.do")
    public CommonResult list() {
        List list = businessInfoService.list();
        return new CommonResult(200,"success",list);
    }
}
