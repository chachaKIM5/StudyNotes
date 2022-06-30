package com.test.toy.board;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/board/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//AddOk.java
		//1. 인코딩
		//2. 데이터 가져오기(subject, content)
		//3. DB작업 > DAO 위임 > insert
		//4. 결과
		//5. JSP 호출하기
		
		
		HttpSession session = req.getSession();
		
		//1.
		req.setCharacterEncoding("UTF-8");
		
		
		//2.
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		
		
		
		//2.5 답변 - 현재 새글 작성중인지, 답변글 작성중인지 판단
		String reply = req.getParameter("reply");
		
		int thread = -1;
		int depth = -1;
			
		BoardDAO dao = new BoardDAO();
		if (reply.equals("")) {
			//새글
			//a.현존하는 모든 게시물 중에서 가장 큰 thread 값을 찾아서, 그 값에 +1000을 한 값을 새 글의 thread 값으로 사용한다.
			//b. 새 글의 depth는 항상 0을 넣는다.
			thread = dao.getMaxThread() + 1000;
			depth = 0;
			
		} else {
			//답변글
			//a. 현존하는 모든 게시물의 thread 값을 대상으로 현재 작성 중인 답변글의 부모글 thread값보다 작고, 이전 새글의 thread값보다 큰 thread를 모두 찾아서 -1을 한다.
			//b. 현재 답변글의 thread값은 부모글의 thread-1을 넣는다.
			//c. 현재 답변글의 depth 값은 부모글의 depth+1을 넣는다.
			
			//부모 글의 thread, depth
			int parentThread = Integer.parseInt(req.getParameter("thread"));
			int parentDepth = Integer.parseInt(req.getParameter("depth"));
			
			
			//'이전 새글의 thread'
			int previousThread = (int)Math.floor((parentThread - 1) / 1000) * 1000;
			
			
			//a.
			
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("parentThread", parentThread);
			map.put("previousThread", previousThread);
			
			dao.updateThread(map);
			
			
			//b.
			thread = parentThread - 1;
			
			//c.
			depth = parentDepth + 1;
			

		}
		

		
		//3.
		BoardDTO dto = new BoardDTO();
		
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setId((String)session.getAttribute("auth"));
		
		dto.setThread(thread);
		dto.setDepth(depth);
		
		
		int result = 0;
		
		
		if (session.getAttribute("auth") != null) {
			result = dao.add(dto);
		}
		
		//4.
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/addok.jsp");
		dispatcher.forward(req, resp);

	}

}