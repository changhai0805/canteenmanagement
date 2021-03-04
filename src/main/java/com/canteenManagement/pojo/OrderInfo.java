package com.canteenManagement.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("orderinfo")
public class OrderInfo {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private Integer window;

    private Integer orderNum;

    private String orderName;

    private String orderPhone;

    private String orderTime;

    private String getTime;
}
