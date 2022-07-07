package com.test.toy.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/ex07search.do")
public class Ex07Search extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String choice = "";
		
		switch (req.getParameter("choice")) {
			case "남자":
				choice = "m";
			break;
			case "여자":
				choice = "f";
			break;
			case "전체":
				choice = "m,f";
			break;
		}
		
		System.out.println(choice);
		
		AjaxDAO dao = new AjaxDAO();
		ArrayList<AddressDTO> slist = dao.getSearchList(choice);
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
		PrintWriter writer = resp.getWriter();
		
		String temp = "[";
		
		for (AddressDTO dto : slist) {
			
			temp += "{";
			temp += String.format("\"seq\": %s,", dto.getSeq());
			temp += String.format("\"name\": \"%s\",", dto.getName());
			temp += String.format("\"age\": \"%s\",", dto.getAge());
			temp += String.format("\"address\": \"%s\",", dto.getAddress());
			temp += String.format("\"gender\": \"%s\",", dto.getGender().equals("m") ? "남자" : "여자");
			temp += String.format("\"tel\": \"%s\"", dto.getTel());
			temp += "},";
		}

		temp = temp.substring(0, temp.length() - 1);
		temp += "]";
		
		System.out.println(temp);
		
		writer.print(temp);
		writer.close();
		
		

	}

}