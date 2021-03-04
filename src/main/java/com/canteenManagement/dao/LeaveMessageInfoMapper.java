package com.canteenManagement.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.canteenManagement.pojo.LeaveMessageInfo;
import com.canteenManagement.util.PageBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface LeaveMessageInfoMapper extends BaseMapper<LeaveMessageInfo> {
    @Insert("insert into leavemessageinfo(name,telephone,message,creat_time) values(#{name},#{telephone},#{message},#{creatTime})")
    int insertLeaveMessage(LeaveMessageInfo leaveMessageInfo);
    @Select("select * from leavemessageinfo order by creat_time desc limit #{beginIndex},#{pageSize} ")
    List<LeaveMessageInfo> selectMessageInPage(PageBean<LeaveMessageInfo> pageBean);
    @Select("select count(id) from leavemessageinfo")
    int countMessage();
}
