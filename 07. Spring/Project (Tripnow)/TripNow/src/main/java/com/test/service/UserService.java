package com.test.service;

import java.util.List;

import com.test.dto.EventDTO;
import com.test.dto.PagingDTO;
import com.test.dto.UserDTO;

public interface UserService {

//	List<UserDTO> list();

	int edit(UserDTO udto);

	PagingDTO paging(String nowPage, PagingDTO pdto,String column ,String word);

	List<UserDTO> list(PagingDTO pdto, String column ,String word);

}
