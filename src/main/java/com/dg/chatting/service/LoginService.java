package com.dg.chatting.service;

import javax.servlet.http.HttpServletRequest;

import com.dg.chatting.dto.UserDto;

public interface LoginService {
    boolean validateUser(String userId, String userPass);
    UserDto storeSessionById(String userId, HttpServletRequest request);
}