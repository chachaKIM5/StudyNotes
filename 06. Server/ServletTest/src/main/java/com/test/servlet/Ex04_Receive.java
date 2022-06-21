package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex04_Receive extends HttpServlet {
	
	//서블릿
	//1. 해당 서블릿 > get 요청 > doGet() 호출
	//2. 해당 서블릿 > post 요청 > doPost() 호출
	//GET > doGET(), POST > doPOST() 짝을 맞춰야 함!
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//Ex04_Send.java의 <form> -> 현재 서블릿(Ex04_Receive)에게 데이터를 전송 -> name값을 통해 req.getParameter로 수신
		//<input type='text' name='name'>
		String name = req.getParameter("name");
		//<input type='text' name='age'>
		String age = req.getParameter("age");
		
		System.out.println(name);
		System.out.println(age);
		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<meta charset='UTF-8'>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>수신한 데이터</h1>");
		writer.println("<p>이름: " + name + "</p>");
		writer.println("<p>나이: " + age + "</p>");
		writer.println("</body>");
		writer.println("</html>");
		
		
		writer.close();
		
	
	
	}

}