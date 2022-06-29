package com.test.toy.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		//View.java
		//1. 데이터 가져오기(글번호) + 검색 정보
		String seq = req.getParameter("seq");
		
			//검색 정보
		String isSearch = req.getParameter("isSearch");
		String column = req.getParameter("column");
		String word = req.getParameter("word");
		
		//2. DB작업 > DAO 위임 > select + 3. 결과 받기
		BoardDAO dao = new BoardDAO();
		
				//3.5
				//출력 데이터 조작하기
				//- 조회수 증가
				if (session.getAttribute("read") == null || session.getAttribute("read").toString().equals("n")) {
					dao.updateReadcound(seq);
					session.setAttribute("read", "y");
				}
		
		BoardDTO dto = dao.get(seq);
		
				//- 엔터를 <br>로, 태그를 비활성화할 수 있게 "<", ">"를 entity로
				dto.setSubject(dto.getSubject().replace("<", "&lt;").replace(">", "&gt;"));
				dto.setContent(dto.getContent().replace("<", "&lt;").replace(">", "&gt;"));
				dto.setContent(dto.getContent().replace("\r\n", "<br>"));
		
				//- 검색어 하이라이트 표시하기
				
				if (isSearch.equals("y") && column.equals("content")) {
					dto.setContent(dto.getContent().replace(word, "<span style=\"background-color: #EBE8FF; font-weight: bold; color: #6B66FF;\">" + word + "</span>"));
				}
				
				
				
				
		
		// +++ 3.7 댓글 목록 가져오기 추가
				
		ArrayList<CommentDTO> clist = dao.listComment(seq);
		
		
				
		//4. JSP 호출 + 결과 전달
		req.setAttribute("dto", dto);
		
		req.setAttribute("isSearch", isSearch);
		req.setAttribute("column", column);
		req.setAttribute("word", word);
		req.setAttribute("clist", clist);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/view.jsp");
		dispatcher.forward(req, resp);

	}

}