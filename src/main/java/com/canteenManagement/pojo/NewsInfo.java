package com.canteenManagement.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("newsinfo")
public class NewsInfo {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String newsTitle;

    private String newsDescription;

    private Date creatTime;

}
