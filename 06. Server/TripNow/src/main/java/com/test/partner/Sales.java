package com.test.partner;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/partner/sales.do")
public class Sales extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Calendar now = Calendar.getInstance();
	
		String[] dates = new String[12];
		String year = "";
		String month = "";
		
		for (int i=0 ; i<12 ; i++) {

			year = now.get(Calendar.YEAR) + "년";
			month = (now.get(Calendar.MONTH) + 1) + "월";
			dates[i] = year + " " + month;
			now.add(Calendar.MONTH, -1);
		}
		
		
		req.setAttribute("dates", dates);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/partner/sales.jsp");
		dispatcher.forward(req, resp);

	}


}
