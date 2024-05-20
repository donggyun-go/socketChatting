package com.dg.chatting.dto;

import java.sql.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendDto {
    private String userId;
    private String friendId;
    private String friendName;
    private Timestamp createdAt;
}
