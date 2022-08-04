package com.test.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//Spring REST > 전용 컨트롤러 제공 
@RestController
public class AddressController {

	@Autowired
	private AddressDAO dao;
	
	//테스트
	@GetMapping(value="/test")
	public void test() {
		
		System.out.println(dao.selectOne("test.count"));
	}
	
	
	//REST Client 전용 프로그램
	// - REST 서비스를 테스트하기 위한 환경을 제공하는 프로그램
	// - Postman, Insomnia, VSCode Extension
	
	
	//주소록 CRUD
	//요소 추가하기
	//1. http://localhost:8090/spring/address
	//2. POST
	//3. return int
	
	@RequestMapping(value="/address", method=RequestMethod.POST)
	public int add (@RequestBody AddressDTO dto) {
		
		return dao.insert("test.add", dto);
	}
	
	
	//목록 가져오기
	//1. http://localhost:8090/spring/address
	//2. GET
	//3. return JSON
	
	@GetMapping("/address")
	public List<AddressDTO> list() {
		
		return dao.selectList("test.list");
	}
	
	
	//요소 수정하기
	//1. http://localhost:8090/spring/address/1
	//2. PUT
	//3. return int
	
	//@RequestMapping(value="/address/{seq}", method=RequestMethod.PUT)
	@PutMapping("/address/{seq}")
	public int edit(@PathVariable("seq") String seq, @RequestBody AddressDTO dto) {
		
		dto.setSeq(seq);
		return dao.update("test.edit", dto);
	}
	
	
	//요소 삭제하기
	//1. http://localhost:8090/spring/address/1
	//2. DELETE
	//3. return int
	
	@DeleteMapping("/address/{seq}")
	public int del(@PathVariable("seq") String seq) {
		
		return dao.delete("test.del", seq);
	}
	
	
	//요소 1개 가져오기 (ex 게시판이면 view, 회원이면 회원 정보...)
	//1. http://localhost:8090/spring/address/1
	//2. GET
	//3. return JSON
	
	@GetMapping("/address/{seq}")
	@ResponseBody
	public AddressDTO get(@PathVariable("seq") String seq) {
		
		return (AddressDTO)dao.selectOne("test.get", seq);
	}
	
}
