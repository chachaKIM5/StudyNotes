package com.test.toy.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/idcheckok2.do")
public class IdCheckOk2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//IdCheckOk2.java
		//1. 데이터 가져오기(id)
		//2. DB 작업 > DAO 위임 > select
		//3. 결과 + 피드백
		
		
		//1.
		String id = req.getParameter("id");
		
		//2.
		AjaxDAO dao = new AjaxDAO();
		
		int result = dao.checkid(id);
		
		//3.
		//resp.sendRedirect("/toy/ajax/idcheck.do?result=" + result + "&id=" + id);
		
		PrintWriter writer = resp.getWriter();
		
		//브라우저가 부른 게 아니라 ajax이기 때문에... <html>, <body> 등 적을 필요 없이 바로 result 찍기
		writer.print(result);
		
		writer.close();

	}

}