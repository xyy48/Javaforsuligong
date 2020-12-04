package com.neusoft.springbootsell.services;

import com.neusoft.springbootsell.dataobject.UserInfo;

public interface UserInfoService {
    UserInfo findByUsernameAndPassword(String username, String password);
}