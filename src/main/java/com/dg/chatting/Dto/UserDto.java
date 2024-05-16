package com.dg.chatting.Dto;

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
