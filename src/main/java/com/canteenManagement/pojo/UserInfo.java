package com.canteenManagement.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("userinfo")
public class UserInfo implements Serializable {
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String userId;

    private String password;

    private String realName;

    private String sex;

    private String telephone;

    private String idNumber;

    private String role;

    private int status;


}
