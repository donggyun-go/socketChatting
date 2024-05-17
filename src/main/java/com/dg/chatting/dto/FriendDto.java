package com.dg.chatting.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FriendDto {
    private String userId;
    private String friendId;
    private Timestamp createdAt;
}