package com.test.dao;

import java.util.List;

import com.test.dto.EventDTO;
import com.test.dto.PagingDTO;
import com.test.dto.UserDTO;

public interface UserDAO {

//	List<UserDTO> list();

	int edit(UserDTO udto);

	int countUser(String column, String word);

	List<UserDTO> userList(PagingDTO pdto,String column ,String word);

}
