package com.test.toy.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/delcommentok.do")
public class DelCommentOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//DelCommentOk.java
		//1. 데이터 가져오기
		//2. DB 작업 > DAO 위임 > delete
		//3. 결과
		//4. 피드백
		
		
		//1.
		String seq = req.getParameter("seq");
		String pseq = req.getParameter("pseq");
		String isSearch = req.getParameter("isSearch");
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		
		
		//2 + 3
		BoardDAO dao = new BoardDAO();
		
		int result = dao.delcomment(seq);
		
		
		//4.
		 if (result == 1) {
		  
		 resp.sendRedirect(String.format(
		 "/toy/board/view.do?seq=%s&isSearch=%s&column=%s&word=%s", pseq, isSearch,
		 column, URLEncoder.encode(word, "UTF-8")));
		 
		 } else {
		 
		 resp.setCharacterEncoding("UTF-8"); PrintWriter writer = resp.getWriter();
		 
		 writer.print("<html>");
		 writer.print("<head>");
		 writer.print("<meta charset='UTF-8'>");
		 writer.print("</head>");
		 writer.print("<body>");
		 writer.print("<script>");
		 writer.print("alert('댓글 삭제에 실패했습니다.');");
		 writer.print("history.back();");
		 writer.print("</script>");
		 writer.print("</body>");
		 writer.print("</html>");
		 
		 writer.close();
		 
		 }
		 

		

	}

}