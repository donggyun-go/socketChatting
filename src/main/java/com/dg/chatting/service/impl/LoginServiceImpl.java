package com.dg.chatting.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.chatting.dto.UserDto;
import com.dg.chatting.repository.LoginDao;
import com.dg.chatting.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    public boolean validateUser(String userId, String userPass) {
        UserDto user = loginDao.getUserById(userId);
        return user != null && user.getUserPass().equals(userPass);
    }

	@Override
	public UserDto storeSessionById(String userId, HttpServletRequest request) {
		UserDto user = loginDao.getUserById(userId);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userName", user.getUserName());
            session.setAttribute("userEmail", user.getUserEmail());
            session.setAttribute("userId", user.getUserId());
        }
		
		return user;
	}
}
