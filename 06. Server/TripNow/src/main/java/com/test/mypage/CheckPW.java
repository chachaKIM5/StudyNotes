package com.test.mypage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.member.MemberDAO;
import com.test.member.MemberDTO;

@WebServlet("/mypage/checkpw.do")
public class CheckPW extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String id = req.getParameter("auth");
		String pw = req.getParameter("pw");
		
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		
		dto.setId(id);
		dto.setPw(pw);
		
		int result = dao.pwCheck(dto);
		
	}

}