package com.dg.chatting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.dg.chatting.dto.FriendDto;
import com.dg.chatting.repository.FriendDao;
import com.dg.chatting.service.impl.FriendServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FriendTest {

    @Mock
    private FriendDao friendDao;

    @InjectMocks
    private FriendServiceImpl friendService;

    private String userId;
    private List<FriendDto> mockFriends;

    @BeforeEach
    void setUp() {
        userId = "user1";
        mockFriends = new ArrayList<>();
        mockFriends.add(new FriendDto(userId, "user2", new Timestamp(System.currentTimeMillis())));
        mockFriends.add(new FriendDto(userId, "user3", new Timestamp(System.currentTimeMillis())));
    }

    @Test
    void testGetFriendsByUserId() {
        // given
        when(friendDao.getFriendsByUserId(userId)).thenReturn(mockFriends);

        // when
        List<FriendDto> friends = friendService.getFriendsByUserId(userId);

        // then
        assertEquals(2, friends.size());
        assertEquals("user2", friends.get(0).getFriendId());
        assertEquals("user3", friends.get(1).getFriendId());
    }
}