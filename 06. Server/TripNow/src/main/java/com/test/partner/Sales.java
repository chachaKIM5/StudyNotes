package com.test.partner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/partner/sales.do")
public class Sales extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		//파트너 ID 가져오기
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("auth");
		
		//sales.do를 처음 방문한 경우 -> 기본값 s(elected)month, s(elected)cate 설정
		//조회 월은 이번달, 조회 카테고리는 전체
		
		//이미 sales.do를 방문해 조회월과 카테고리를 선택한 경우 -> req.getParameter로 받아오기 
		String smonth;
		String scate;
	
		Calendar now = Calendar.getInstance();

		if (req.getParameter("month") == null || req.getParameter("month") == "") {
			smonth = (now.get(Calendar.MONTH) + 1) + ""; 
		} else {			
			smonth = req.getParameter("month");
		}
		
		if (req.getParameter("cate") == null || req.getParameter("cate") == "") {
			scate = "all";
		} else {			
			scate = req.getParameter("cate");
		}
		
	
		//select box의 option에 들어갈 이번달 ~ 이번달 - 11개월을 String[] dates 배열에 넣기 
		String[] dates = new String[12];
		String year = "";
		String month = "";
		
		for (int i=0 ; i<12 ; i++) {

			year = now.get(Calendar.YEAR) + "년";
			month = (now.get(Calendar.MONTH) + 1) + "월";
			dates[i] = year + " " + month;
			now.add(Calendar.MONTH, -1);
		}
		
		
		//smonth, scate로 DB(dao) 다녀오기
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("smonth", smonth);
		map.put("scate", scate);
		
		PartnerDAO dao = new PartnerDAO();
		ArrayList<PartnerDTO> roomlist = new ArrayList<PartnerDTO>();
		ArrayList<PartnerDTO> carlist = new ArrayList<PartnerDTO>();
		ArrayList<PartnerDTO> actlist = new ArrayList<PartnerDTO>();
		
		roomlist = dao.getRoomList(map);
		carlist = dao.getCarList(map);
		actlist = dao.getActList(map);
		
		
		
		
		req.setAttribute("dates", dates);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/partner/sales.jsp");
		dispatcher.forward(req, resp);

	}


}
