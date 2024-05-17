package com.dg.chatting.service.impl;

import com.dg.chatting.dto.UserDto;
import com.dg.chatting.repository.LoginDao;
import com.dg.chatting.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public boolean validateUser(String userId, String userPass) {
        UserDto user = loginDao.getUserById(userId);
        return user != null && user.getUserPass().equals(userPass);
    }
}
