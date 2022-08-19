package com.test.event;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/event/calculateprice.do")
public class CalculatePrice extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");
		
		String id = (String)session.getAttribute("auth");
		String eseq = req.getParameter("eseq");
		String total = req.getParameter("total");
		
		CouponDTO dto = new CouponDTO();
		EventDAO dao = new EventDAO();
		
		//할인율 가져오기
		dto.setEseq(eseq);
		
		dto = dao.getEvent(dto);
		
		int totalPrice = Integer.parseInt(total);
		
		//쿠폰번호 가져오기
		
		dto.setId(id);
		dto = dao.getCouponSeq(dto);
		
		String cSeq = dto.getSeq();
		

		
		//할인 금액
		int discount = totalPrice * dto.getRate()/100;
		
		int finalPrice = totalPrice - discount;
		
		
		//피드백
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");	
		
		
		PrintWriter writer = resp.getWriter();
		
		writer.print("{");
		writer.printf("\"discount\":\"%d\",",discount);
		writer.printf("\"cSeq\":\"%s\",",cSeq);
		writer.printf("\"finalPrice\":\"%d\"",finalPrice);
		writer.print("}");
		
		
		writer.close();
		
		
	}

}