package com.dg.chatting.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserDto {
	private String userId;
	private String userPass;
	private String userEmail;
	private String userName;

}
