package com.test.toy.board;

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

@WebServlet("/board/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doTemp(req, resp);

	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		doTemp(req, resp);
//		
//	}

	private void doTemp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//List.java
		//1. DB 작업 > DAO 위임 > select
		//2. 결과
		//3. JSP 호출 + 결과 전달
		
		
		//doTemp가 목록에서 호출됐는지 or 검색에서 호출됐는지 판단
		// - list.do
		// - list.do + (column + word)
		
		req.setCharacterEncoding("UTF-8");

		String column = req.getParameter("column");
		String word = req.getParameter("word");
		
		String isSearch = "n";
		
		if ((column == null || word == null) || (column == "" || word == "")) {
			isSearch = "n";
		} else {
			isSearch = "y";
		}
			
	
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("word", word);
		map.put("isSearch", isSearch);
		
		
		
		//페이징
		
		int nowPage = 0; 		//현재 페이지 번호
		int begin = 0;			
		int end = 0;
		int pageSize = 10;		//한 페이지 당 출력할 게시물 수
		
		int totalCount = 0;		//총 게시물 수
		int totalPage = 0; 		//총 페이지 수
		
		
		//list.do > list.do?page=1
		//list.do?page=3
		
		String page = req.getParameter("page");
		
		if (page == null || page == "") {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		//nowPage > 현재 보게 될 페이지 번호
		//list.do?page=1 > where rnum between 1 and 10
		//list.do?page=2 > where rnum between 11 and 20...
		
		begin = ((nowPage - 1 ) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		map.put("begin", begin + "");
		map.put("end", end + "");
		
		
		HttpSession session = req.getSession();
		
		
		//1 + 2.
		BoardDAO dao = new BoardDAO();
		
		ArrayList<BoardDTO> list = dao.list(map);
		
		//2.5
		//- 출력 데이터의 가공!
		
		Calendar now = Calendar.getInstance();
		String strNow = String.format("%tF", now); //"2022-06-29"
		
		for (BoardDTO dto : list) {
			
			//오늘일 경우 글 쓴 시간 표시, 오늘이 아니면 날짜 표시
			//시분초를 자르고 글 쓴 날짜만 남기기
			if (dto.getRegdate().startsWith(strNow)) {
				//오늘
				dto.setRegdate(dto.getRegdate().substring(11, 16));
			} else {
				//오늘 X
				dto.setRegdate(dto.getRegdate().substring(0, 10));
			}
			
			//제목이 길면 자르기
			if (dto.getSubject().length() > 28) {
				dto.setSubject(dto.getSubject().substring(0, 28) + "...");
			}
			
			dto.setSubject(dto.getSubject().replace("<", "&lt;").replace(">", "&gt;"));
			
		}
		
		//2.6 총 페이지 수 구하기
		
		// - 2.6.1 총 게시물 수 -> 262
		totalCount = dao.getTotalCount(map);
		
		// - 2.6.2 총 페이지 수 -> 262 / 10 = 26.2페이지
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		
		
		String pagebar = "";
		
		int blockSize = 10;		//한번에 보여질 페이지 개수
		int n = 0;			//페이지 번호
		int loop = 0;		//루프
		
		pagebar = "";
		
		loop = 1;
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		
//		for (n = 1 ; n<=totalPage ; n++) {
//			
//			if (n == nowPage) {
//				
//				pagebar += String.format(" <a href='#!' style='color: #D6C7ED;'>%d</a> ", n, n);
//			
//			} else {
//				pagebar += String.format(" <a href='/toy/board/list.do?page=%d'>%d</a> ", n, n);
//				
//			}
//		}
		
		
	  
		
		
		pagebar += "<ul class=\"pagination\">";
		
		//이전 10페이지 버튼
		
//		if (n == 1) {
//			
//			pagebar += String.format("<a href='#!'><i class=\"fa-solid fa-angle-left\"></i></a>");
//			
//		} else {
//			pagebar += String.format("<a href='/toy/board/list.do?page=%d'><i class=\"fa-solid fa-angle-left\"></i></a>", n - 1);
//		
//		}
		
		if (n == 1) {
			
			pagebar += String.format("		    <li class=\"page-item\">\r\n"
					+ "		      <a class=\"page-link\" href=\"#\" aria-label=\"Previous\">\r\n"
					+ "		        <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "		      </a>\r\n"
					+ "		    </li>");
			
		} else {
			pagebar += String.format("		    <li class=\"page-item\">\r\n"
					+ "		      <a class=\"page-link\" href=\"/toy/board/list.do?page=%d\" aria-label=\"Previous\">\r\n"
					+ "		        <span aria-hidden=\"true\">&laquo;</span>\r\n"
					+ "		      </a>\r\n"
					+ "		    </li>", n - 1);
			
		}
		
//		while (!(loop > blockSize || n > totalPage)) {
//			
//			if (n == nowPage) {
//			
//			pagebar += String.format(" <a href='#!' style='color: #D6C7ED;'>%d</a> ", n);
//		
//			} else {
//				pagebar += String.format(" <a href='/toy/board/list.do?page=%d'>%d</a> ", n, n);
//				
//			}
//			
//			loop++;
//			n++;
//		}
		while (!(loop > blockSize || n > totalPage)) {
			
			if (n == nowPage) {
				
				pagebar += String.format(" <li class=\"page-item active\"><a class=\"page-link\" href=\"#!\">%d</a></li> ", n);
				
			} else {
				pagebar += String.format(" <li class=\"page-item\"><a class=\"page-link\" href=\"/toy/board/list.do?page=%d\">%d</a></li> ", n, n);
				
			}
			
			loop++;
			n++;
		}
		
		
		//다음 10페이지 버튼
//		if (n > totalPage) {
//			
//			pagebar += String.format("<a href='#!'><i class=\"fa-solid fa-angle-right\"></i></a>");
//
//		} else {
//			
//			pagebar += String.format("<a href='/toy/board/list.do?page=%d'><i class=\"fa-solid fa-angle-right\"></i></a>", n);
//		}
		if (n > totalPage) {
			
			pagebar += String.format("		    <li class=\"page-item\">\r\n"
					+ "		      <a class=\"page-link\" href=\"#!\" aria-label=\"Next\">\r\n"
					+ "		        <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "		      </a>\r\n"
					+ "		    </li>");
			
		} else {
			
			pagebar += String.format("		    <li class=\"page-item\">\r\n"
					+ "		      <a class=\"page-link\" href=\"/toy/board/list.do?page=%d\" aria-label=\"Next\">\r\n"
					+ "		        <span aria-hidden=\"true\">&raquo;</span>\r\n"
					+ "		      </a>\r\n"
					+ "		    </li>", n);
		}
		
		
		pagebar += "</ul>";
		
		
		//2.7 새로고침으로 인한 조회수 증가 방지
		session.setAttribute("read", "n");
		
		//3.
		req.setAttribute("list", list);
		
		req.setAttribute("map", map);
		
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("nowPage", nowPage);
		req.setAttribute("pagebar", pagebar);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/list.jsp");
		dispatcher.forward(req, resp);
	}

}