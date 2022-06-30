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

@WebServlet("/board/editcommentok.do")
public class EditCommentOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//EditCommentOk.java
		//1. 인코딩
		//2. 데이터 가져오기
		//3. DB > DAO 위임 > update
		//4. 결과
		//5. 피드백
		
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		//2.
		String seq = req.getParameter("seq");
		String content = req.getParameter("content");
		
		String pseq = req.getParameter("pseq");
		String isSearch = req.getParameter("isSearch");
		String column = req.getParameter("column");
		String word = req.getParameter("word");

		
		//3 + 4.
		CommentDTO dto = new CommentDTO();
		dto.setSeq(seq);
		dto.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		int result = dao.editComment(dto);
		
		
		//5.
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
		writer.print("alert('댓글 수정에 실패했습니다.');");
		writer.print("history.back();");
		writer.print("</script>");
		writer.print("</body>");
		writer.print("</html>");
		
		writer.close();
		
		}
	}

}