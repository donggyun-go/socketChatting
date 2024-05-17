package com.dg.chatting.repository;

import java.util.List;

import com.dg.chatting.dto.FriendDto;

public interface FriendDao {
	List<FriendDto> getFriendsByUserId(String userId);
}
