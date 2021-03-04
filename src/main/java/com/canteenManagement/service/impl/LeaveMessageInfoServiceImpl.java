package com.canteenManagement.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.canteenManagement.dao.LeaveMessageInfoMapper;
import com.canteenManagement.pojo.LeaveMessageInfo;
import com.canteenManagement.service.LeaveMessageInfoService;
import com.canteenManagement.util.PageBean;
import com.canteenManagement.util.Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class LeaveMessageInfoServiceImpl extends ServiceImpl<LeaveMessageInfoMapper, LeaveMessageInfo> implements LeaveMessageInfoService {
    @Resource
    LeaveMessageInfoMapper leaveMessageInfoMapper;

    @Override
    public int insertLeaveMessage(LeaveMessageInfo leaveMessageInfo) {
        leaveMessageInfo.setCreatTime(Utils.getDateTime());
        return leaveMessageInfoMapper.insertLeaveMessage(leaveMessageInfo);
    }

    @Override
    public PageBean<LeaveMessageInfo> selectMessageInPage(int currentPage, int pageSize) {
        PageBean<LeaveMessageInfo> pageBean = new PageBean<LeaveMessageInfo>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        List<LeaveMessageInfo> list = leaveMessageInfoMapper.selectMessageInPage(pageBean);
        int count = leaveMessageInfoMapper.countMessage();
        pageBean.setTotalCount(count);
        pageBean.setPageData(list);
        return pageBean;
    }
}
