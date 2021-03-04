package com.canteenManagement.controller;

import com.canteenManagement.service.MenuInfoService;
import com.canteenManagement.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/menu")
@CrossOrigin
public class MenuInfoController {

    @Autowired
    private MenuInfoService menuInfoService;
    /**
     * 查看列表
     * @return
     */
    @RequestMapping("/listStudentMenu.do")
    @CrossOrigin
    public CommonResult getStudentMenu(int window){
        return menuInfoService.getStudentMenu(window);

    }
    @RequestMapping("/listTeacherMenu.do")
    @CrossOrigin
    public CommonResult getTeacherMenu(){
        return menuInfoService.getTeacherMenu();

    }
}
