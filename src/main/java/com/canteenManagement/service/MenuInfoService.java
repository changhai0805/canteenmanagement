package com.canteenManagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.canteenManagement.pojo.MenuInfo;
import com.canteenManagement.util.CommonResult;

public interface MenuInfoService extends IService<MenuInfo> {
    CommonResult getStudentMenu(int window);
    CommonResult getTeacherMenu();
}
