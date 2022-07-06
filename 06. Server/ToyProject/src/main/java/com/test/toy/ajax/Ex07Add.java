package com.test.toy.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/ex07add.do")
public class Ex07Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String tel = req.getParameter("tel");
		String address = req.getParameter("address");
		
		AjaxDAO dao = new AjaxDAO();
	
		AddressDTO dto = new AddressDTO();
		dto.setName(name);
		dto.setAge(age);
		dto.setGender(gender);
		dto.setTel(tel);
		dto.setAddress(address);
		
		int result = dao.addAddress(dto);
		dto.setSeq(dao.getAddressMaxSeq());
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		
		String temp = "";
		
		temp += "{";
		temp += String.format("\"seq\": %s,", dto.getSeq());
		temp += String.format("\"name\": \"%s\",", dto.getName());
		temp += String.format("\"age\": \"%s\",", dto.getAge());
		temp += String.format("\"address\": \"%s\",", dto.getAddress());
		temp += String.format("\"gender\": \"%s\",", dto.getGender() == "m" ? "남자" : "여자");
		temp += String.format("\"tel\": \"%s\"", dto.getTel());
		temp += "}";

		writer.print(temp);
		writer.close();
	}

}