package com.test.activity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/activity/activityreviewok.do")
public class ActivityReviewOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("UTF-8");
		
		String content = req.getParameter("content");
		String rseq = req.getParameter("rseq");
		String star = req.getParameter("star");
		String id = (String)session.getAttribute("auth");
		
		
		
		ActReviewDTO dto = new ActReviewDTO();
		ActivityDAO dao = new ActivityDAO();
		
		dto.setId(id);
		dto.setRseq(rseq);
		dto.setStar(star);
		dto.setContent(content);
			
		
		int result = dao.addReview(dto);
		
		if(result == 0) {
			System.out.println("리뷰작성 실패");
		}
		
		
		dto = dao.getReview(dto);
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		
			
		PrintWriter writer = resp.getWriter();
		
		writer.print("{");
		writer.printf("\"result\": %d,", 		result);
		writer.printf("\"seq\": \"%s\",", 		dto.getSeq());
		writer.printf("\"id\": \"%s\",", 		dto.getId());
		writer.printf("\"star\": \"%s\",", 		dto.getStar());
		writer.printf("\"regdate\": \"%s\"", 	dto.getRegdate());
		writer.print("}");
		
		writer.close();
		
		
		
	}

}

























