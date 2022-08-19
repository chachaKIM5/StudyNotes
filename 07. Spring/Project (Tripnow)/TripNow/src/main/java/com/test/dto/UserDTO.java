package com.test.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDTO {
	
	private String rn;
	private String id;
	private String gseq;
	private String pw;
	private String name;
	private String tel;
	private String birth;
	private String gender;
	private String email;
	private String isedit;
	
	private List<UserDTO> userlist;
}
