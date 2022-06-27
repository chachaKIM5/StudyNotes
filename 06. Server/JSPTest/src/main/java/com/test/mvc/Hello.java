package com.test.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

public class Hello extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//자바로 할 일 ~ > 비즈니스 코드
		
		
		//모두 같은 행동 (JSP는 Servlet이기 때문에)
		//Servlet이 Servlet을 호출
		//JSP가 JSP를 호출
		//Servlet이 JSP를 호출
		//JSP가 Servlet을 호출
		
		//JSP 호출하기
		//resp.sendRedirect("/jsp/mvc/hello.jsp");
		
		//사용중이던 request, response를 다음 페이지 전달 가능
		//PageContext.forward();
		
		
		
		//DB > "홍길동"
		String name = "홍길동";
		req.setAttribute("name", name);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/hello.jsp");
		dispatcher.forward(req, resp); //JSP 호출하기

	}
}
