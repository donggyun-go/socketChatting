package com.dg.chatting.service;

public interface LoginService {
    boolean validateUser(String userId, String userPass);
}