package com.dg.chatting.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.chatting.dto.FriendDto;
import com.dg.chatting.repository.FriendDao;
import com.dg.chatting.service.FriendService;

@Service
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendDao friendDao;
	
    @Override
    public List<FriendDto> getFriendsByUserId(String userId) {
        return friendDao.getFriendsByUserId(userId);
    }

}
