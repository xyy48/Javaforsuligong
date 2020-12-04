package com.neusoft.springbootsell.services.impl;


import com.neusoft.springbootsell.dataobject.UserInfo;
import com.neusoft.springbootsell.repository.UserInfoRepository;
import com.neusoft.springbootsell.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoRepository repository;
    @Override
    public UserInfo findByUsernameAndPassword(String username, String password) {
        return repository.findByUsernameAndPassword(username,password);
    }
}