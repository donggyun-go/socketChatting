package com.dg.chatting.service;

import java.util.List;

import com.dg.chatting.dto.FriendDto;
import com.dg.chatting.dto.UserDto;

public interface FriendService {
	
	List<FriendDto> getFriendsByUserId(String userId);

	List<UserDto> searchFriend(String userId);

	void addFriend(FriendDto friendDto);
	
	FriendDto getFriendByUserId(String userId);
}
