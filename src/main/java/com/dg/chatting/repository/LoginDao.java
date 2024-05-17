package com.dg.chatting.repository;

import com.dg.chatting.dto.UserDto;

public interface LoginDao {

	UserDto getUserById(String userId);
}