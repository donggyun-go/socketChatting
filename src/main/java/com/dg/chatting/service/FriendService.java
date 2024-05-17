package com.dg.chatting.service;

import java.util.List;

import com.dg.chatting.dto.FriendDto;

public interface FriendService {
	
	List<FriendDto> getFriendsByUserId(String userId);
}
