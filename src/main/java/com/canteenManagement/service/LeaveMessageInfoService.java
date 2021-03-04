package com.canteenManagement.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.canteenManagement.pojo.LeaveMessageInfo;
import com.canteenManagement.util.PageBean;

public interface LeaveMessageInfoService extends IService<LeaveMessageInfo> {
    int insertLeaveMessage(LeaveMessageInfo leaveMessageInfo);

    PageBean<LeaveMessageInfo> selectMessageInPage(int currentPage,int pageSize);
}
