package com.dg.chatting.repository.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dg.chatting.dto.FriendDto;
import com.dg.chatting.dto.UserDto;
import com.dg.chatting.repository.FriendDao;

@Repository
public class FriendDaoImpl implements FriendDao {
	
    private static final String NAMESPACE = "com.dg.chatting.mapper.FriendMapper";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<FriendDto> getFriendsByUserId(String userId) {
        return sqlSession.selectList(NAMESPACE + ".getFriendsByUserId", userId);
    }

	@Override
	public List<UserDto> searchFriend(String userId) {
		return sqlSession.selectList("com.dg.chatting.mapper.LoginMapper.selectUserById", userId);
	}

	@Override
	public void addFriend(FriendDto friendDto) {
		sqlSession.insert(NAMESPACE+ ".addFriend", friendDto);
		
	}

	@Override
	public FriendDto getFriendByUserId(String userId) {
		return sqlSession.selectOne(NAMESPACE + ".getFriendsByUserId", userId);
	}
	
}
