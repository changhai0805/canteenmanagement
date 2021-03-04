package com.canteenManagement.controller;

import com.canteenManagement.service.WantedInfoService;
import com.canteenManagement.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/wantedinfo")
@CrossOrigin
public class WantedInfoController {
    @Autowired
    private WantedInfoService wantedInfoService;
    @RequestMapping("/list.do")
    public CommonResult list() {
        List list = wantedInfoService.list();
        return new CommonResult(200,"success",list);
    }
}
