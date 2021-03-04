package com.canteenManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.canteenManagement.dao.MenuInfo2Mapper;
import com.canteenManagement.dao.MenuInfoMapper;
import com.canteenManagement.pojo.MenuInfo;
import com.canteenManagement.service.MenuInfoService;
import com.canteenManagement.util.CommonResult;
import com.canteenManagement.util.PageBean;
import com.canteenManagement.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoServiceImpl extends ServiceImpl<MenuInfoMapper, MenuInfo> implements MenuInfoService {
    @Autowired
    private MenuInfoMapper menuInfoMapper;
    @Autowired
    private MenuInfo2Mapper menuInfo2Mapper;
    @Override
    public CommonResult getStudentMenu(int window) {
        String creatTime = Utils.getDate();
        List<MenuInfo> list =  menuInfoMapper.selectTodayMenu(window,creatTime);
        if(list.size()>0){
            return new CommonResult(200,"查询成功",list);
        }else {
            return new CommonResult(500,"暂无数据,请检查今日是否更新菜单",0);
        }
    }

    @Override
    public CommonResult getTeacherMenu() {
        String creatTime = Utils.getDate();
        List<MenuInfo> list =  menuInfo2Mapper.selectTeacherMenu(creatTime);
        if(list.size()>0){
            return new CommonResult(200,"查询成功",list);
        }else {
            return new CommonResult(500,"暂无数据,请检查今日是否更新菜单",0);
        }
    }

    @Override
    public CommonResult listMenu(int currentPage, int pageSize) {
        PageBean<MenuInfo> pageBean = new PageBean<MenuInfo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        String keyword = Utils.getDate();
        pageBean.setKeyword(keyword);
        List<MenuInfo> list = menuInfoMapper.selectInPage(pageBean);
        int count = menuInfoMapper.countList();
        pageBean.setTotalCount(count);
        pageBean.setPageData(list);
        return new CommonResult(200,"success",pageBean);
    }

    @Override
    public CommonResult selectNoStayMenu(int currentPage, int pageSize) {
        PageBean<MenuInfo> pageBean = new PageBean<MenuInfo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        List<MenuInfo> list = menuInfoMapper.selectNoStayInPage(pageBean);
        int count = menuInfoMapper.countNoStay();
        pageBean.setTotalCount(count);
        pageBean.setPageData(list);
        return new CommonResult(200,"success",pageBean);
    }

    @Override
    public CommonResult selectStayMenu(int currentPage, int pageSize) {
        PageBean<MenuInfo> pageBean = new PageBean<MenuInfo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        List<MenuInfo> list = menuInfoMapper.selectStayInPage(pageBean);
        int count = menuInfoMapper.countStay();
        pageBean.setTotalCount(count);
        pageBean.setPageData(list);
        return new CommonResult(200,"success",pageBean);
    }

    @Override
    public CommonResult updateStatus(int id, String samplingUrl) {
         if(menuInfoMapper.updateStatus(id,samplingUrl)==1){
             return new CommonResult(200,"success",1);
         }else {
             return new CommonResult(500,"failed",0);
         }
    }

    @Override
    public CommonResult deleteStay(int id) {
        if(menuInfoMapper.deleteStay(id)==1){
            return new CommonResult(200,"success",1);
        }else {
            return new CommonResult(500,"failed",0);
        }
    }
}
