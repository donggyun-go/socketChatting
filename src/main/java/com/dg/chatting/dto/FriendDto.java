package com.dg.chatting.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FriendDto {
    private String userId;
    private String friendId;
    private Timestamp createdAt;
}
