package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.UserDAO;
import com.test.dto.EventDTO;
import com.test.dto.PagingDTO;
import com.test.dto.UserDTO;

@Repository
public class UserServiceImpl implements UserService {
	
	private UserDAO dao;
	
	@Autowired
	public UserServiceImpl(UserDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public PagingDTO paging(String nowPage, PagingDTO pdto,String column, String word) {
		int total = dao.countUser(column, word);
		
		if (nowPage == null) {
			nowPage = "1";
		}
		
		return pdto = new PagingDTO(total, Integer.parseInt(nowPage));
	}
	
	
	@Override
	public List<UserDTO> list(PagingDTO pdto ,String column ,String word) {
		
		return dao.userList(pdto, column, word);
	}
	
	
	
//	@Override
//	public List<UserDTO> list() {
//		
//		return dao.list();
//	}
	

	@Override
	public int edit(UserDTO userlist) {
		
		int result = 0;
		
		for(int i = 0; i < userlist.getUserlist().size(); i++) {
			if(userlist.getUserlist().get(i).getIsedit().equals("true")) {
				
				UserDTO udto = new UserDTO();
				
				udto.setId(userlist.getUserlist().get(i).getId());
				udto.setGseq(userlist.getUserlist().get(i).getGseq());
				udto.setName(userlist.getUserlist().get(i).getName());
				udto.setTel(userlist.getUserlist().get(i).getTel());
				udto.setBirth(userlist.getUserlist().get(i).getBirth());
				udto.setGender(userlist.getUserlist().get(i).getGender());
				udto.setEmail(userlist.getUserlist().get(i).getEmail());
				
				result = dao.edit(udto);
				if(result == 0) {
					break;
				}
			}
		}
		
		return result;
	}




}
