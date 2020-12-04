package com.neusoft.springbootsell.dataobject;

import com.neusoft.springbootsell.enums.UserInfoEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
public class UserInfo {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String username;
    private String password;
    private Integer userStatus = UserInfoEnum.BUYER.getCode(); //默认是买家，卖家不开通账号注册
    private String Address; //常用地址
    private Date createTime; //用户创建时间
    private Date updateTime;
}

