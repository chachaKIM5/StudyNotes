package com.test.activity;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/activity/activityview.do")
public class ActivityView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		
		req.setCharacterEncoding("UTF-8");
		
		// 액티비티 상품 번호와 메뉴바에 받을 인원, 날짜, 지역을 받음
	     String seq    = req.getParameter("seq");
		 String region = req.getParameter("region");
	     String date   = req.getParameter("date");
	     String count  = req.getParameter("count");
	     String id 	   = (String)session.getAttribute("auth");
			     
	     
	     ActivityDTO dto = new ActivityDTO();
	     ActivityDAO dao = new ActivityDAO();
	     
	     // dto에 상품 seq를 받아서 저장
	     dto.setSeq(seq);
	     dto.setCount(count);
	    
	     
	     ArrayList<ActivityDTO> imagedto = dao.getImages(dto);
	     
	     
	     // seq를 넘겨줘서 상품의 정보를 받아옴
	     dto = dao.view(dto);
 
	     
	     //////////////////////////////
	     //리뷰 쓰기권한 확인
	     ActReviewDTO rdto = new ActReviewDTO();
	     
	     
	     rdto.setId(id);
	     rdto.setAseq(seq);
	     
	     
	     rdto = dao.addReviewCheck(rdto);
	     
	     
	     
	 ////////////////////////////////////////////////////////////////////    
	     
	     //리뷰 리스트 출력
	     
	     ArrayList<ActReviewDTO> review = dao.review(seq);
	     
	     
	     
	     req.setAttribute("dto", dto);
	     req.setAttribute("imagedto", imagedto);
	     req.setAttribute("review", review);
	     req.setAttribute("region", region);
	     req.setAttribute("date", date);
	     req.setAttribute("count", count);
	     req.setAttribute("id", id);
	     req.setAttribute("seq", seq);
	     req.setAttribute("rdto", rdto);
	    
		
		
	     
	     
	     
	     

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/activity/activityview.jsp");

		dispatcher.forward(req, resp);	
		
		
		

		
	}

}





































