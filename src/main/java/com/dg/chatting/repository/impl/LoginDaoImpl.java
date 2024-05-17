package com.dg.chatting.repository.impl;

import com.dg.chatting.dto.UserDto;
import com.dg.chatting.repository.LoginDao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDaoImpl implements LoginDao {

    private static final String NAMESPACE = "com.dg.chatting.mapper.LoginMapper";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public UserDto getUserById(String userId) {
        return sqlSession.selectOne(NAMESPACE + ".selectUserById", userId);
    }
}
