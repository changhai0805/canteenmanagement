package com.canteenManagement.controller;

import com.canteenManagement.pojo.MenuInfo;
import com.canteenManagement.pojo.MenuInfo2;
import com.canteenManagement.service.MenuInfo2Service;
import com.canteenManagement.service.MenuInfoService;
import com.canteenManagement.util.CommonResult;
import com.canteenManagement.util.Utils;
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
    @Autowired
    private MenuInfo2Service menuInfo2Service;
    /**
     * 查看列表
     * @return
     */
    @RequestMapping("/listStudentMenu.do")
    @CrossOrigin
    public CommonResult getStudentMenu(int window){
        return menuInfoService.getStudentMenu(window);

    }
    @RequestMapping("/insertTeacherMenu.do")
    @CrossOrigin
    public CommonResult insertTeacherMenu(MenuInfo2 menuInfo2){
        boolean save = menuInfo2Service.save(menuInfo2);
        if(save){
            return new CommonResult(200,"操作成功",1);
        }else {
            return new CommonResult(500,"操作失败",0);
        }


    }
    @RequestMapping("/listTeacherMenu.do")
    @CrossOrigin
    public CommonResult getTeacherMenu(){
        return menuInfoService.getTeacherMenu();

    }
    @RequestMapping("/listMenu.do")
    @CrossOrigin
    public CommonResult listMenu(int pageNum,int pageSize){
        int currentPage=pageNum;
        return menuInfoService.listMenu(currentPage,pageSize);
    }
    @RequestMapping("/insert.do")
    @CrossOrigin
    public CommonResult insert(MenuInfo menuInfo){
        menuInfo.setCreatTime(Utils.getDate());
        boolean save = menuInfoService.save(menuInfo);;
        if(save){
            return new CommonResult(200,"success",1);
        }else {
            return new CommonResult(500,"failed",0);
        }
    }
    @RequestMapping("/update.do")
    @CrossOrigin
    public CommonResult update(MenuInfo menuInfo){
        boolean update=menuInfoService.updateById(menuInfo);
        if(update){
            return new CommonResult(200,"success",1);
        }else {
            return new CommonResult(500,"failed",0);
        }
    }
    @RequestMapping("/delete.do")
    @CrossOrigin
    public CommonResult delete(int id){
        boolean remove = menuInfoService.removeById(id);
        if(remove){
            return new CommonResult(200,"success",1);
        }else {
            return new CommonResult(500,"failed",0);
        }
    }
    @RequestMapping("/selectNoStayMenu.do")
    @CrossOrigin
    public CommonResult selectNoStayMenu(int pageNum,int pageSize){
        int currentPage=pageNum;
        return menuInfoService.selectNoStayMenu(currentPage,pageSize);
    }
    @RequestMapping("/selectStayMenu.do")
    @CrossOrigin
    public CommonResult selectStayMenu(int pageNum,int pageSize){
        int currentPage=pageNum;
        return menuInfoService.selectStayMenu(currentPage,pageSize);
    }
    @RequestMapping("/insertStay.do")
    @CrossOrigin
    public CommonResult insertStay(int id){

        return menuInfoService.updateStatus(id);
    }
    @RequestMapping("/deleteStay.do")
    @CrossOrigin
    public CommonResult deleteStay(int id){

        return menuInfoService.deleteStay(id);
    }
    @RequestMapping("/updateStay.do")
    @CrossOrigin
    public CommonResult updateStay(int id){

        return menuInfoService.updateStatus(id);
    }
}
