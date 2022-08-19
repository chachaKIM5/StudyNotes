package com.test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dto.PagingDTO;
import com.test.dto.UserDTO;


@Repository
public class UserDAOImpl implements UserDAO {
	
	private SqlSessionTemplate template;
	
	@Autowired
	public UserDAOImpl(SqlSessionTemplate template) {
		this.template = template;
	}
	
	@Override
	public int countUser(String column, String word) {
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("column", column);
		map.put("word", word);

		return this.template.selectOne("user.countUser", map);
	}
	
	@Override
	public List<UserDTO> userList(PagingDTO pdto,String column ,String word) {
		
		pdto.setColumn(column);
		pdto.setWord(word);
		
		return this.template.selectList("user.userList",pdto);
	}

	
//	@Override
//	public List<UserDTO> list() {
//		
//		return this.template.selectList("user.list");
//	}

	@Override
	public int edit(UserDTO udto) {
		
		return this.template.update("user.edit", udto);
	}




	
	
}
