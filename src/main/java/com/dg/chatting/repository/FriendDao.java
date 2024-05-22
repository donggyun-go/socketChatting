package com.dg.chatting.repository;

import java.util.List;

import com.dg.chatting.dto.FriendDto;
import com.dg.chatting.dto.UserDto;

public interface FriendDao {
	List<FriendDto> getFriendsByUserId(String userId);

	List<UserDto> searchFriend(String userId);

	void addFriend(FriendDto friendDto);

	FriendDto getFriendByUserId(String userId);
}
