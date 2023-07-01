package com.videos.service;

import com.videos.bean.User;
import com.videos.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service  //  实例化对象   new UserService()
public class UserService {
    @Resource   // 自动注入    UserMapper mapper = new UserMapper ()
    private UserMapper mapper;
    public User login(String userName){
        return mapper.login(userName);

    }
}
