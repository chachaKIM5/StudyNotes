package com.test.admin.user;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.dto.PagingDTO;
import com.test.dto.UserDTO;
import com.test.service.UserService;

@Controller
@RequestMapping("/admin/user/")
public class UserController  {
	
	private UserService uService;
	
	@Autowired
	public UserController(UserService uService) {
		this.uService = uService;
	}
	
	
	// 유저정보
	@GetMapping("usermain")
	public String user(Model model, PagingDTO pdto
						, @RequestParam(value="nowPage", required=false )String nowPage
						, @RequestParam(value="column", required=false,defaultValue="id")String column
						, @RequestParam(value="word", required=false,defaultValue="")String word) {
		
		pdto = uService.paging(nowPage,pdto,column,word);
		
		List<UserDTO> list = uService.list(pdto,column,word);
		
		model.addAttribute("paging",pdto);
		System.out.println("화이팅");
		System.out.println(pdto);
		model.addAttribute("list",list);
		
		return "admin.user.usermain";
	}
	
	
	
	@PostMapping("editok")
	public void editinfo(Model model, UserDTO userlist ,HttpServletRequest req, HttpServletResponse resp) {
		
		int result = 0;
		
		result = uService.edit(userlist);
		
		
		try {
			if (result == 1) {
				resp.setContentType("text/html; charset=UTF-8");
				PrintWriter out = resp.getWriter();

				out.println("<script language='javascript'>");
				out.println("alert('수정완료!')");
				out.println("location.href=\"usermain\";");
				out.println("</script>");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}





































