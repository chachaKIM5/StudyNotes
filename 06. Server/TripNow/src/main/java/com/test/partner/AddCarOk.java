package com.test.partner;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.common.io.Files;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.test.car.CarDAO;

@WebServlet("/partner/addcarok.do")
public class AddCarOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

req.setCharacterEncoding("UTF-8");
		
		//1.5 새로운 파일을 선택했을 때..
		String path = req.getRealPath("/images");
		int size = 1024 * 1024 * 100;
		
		
		MultipartRequest multi = null;
		
		try {
			
			multi = new MultipartRequest(
											req,
											path,
											size,
											"UTF-8",
											new DefaultFileRenamePolicy()
										);
			
		} catch (Exception e) {
			System.out.println("EditOk.doPost");
			e.printStackTrace();
		}
		
		CarOptionDTO dto = new CarOptionDTO();
		
		dto.setSeq(multi.getParameter("seq"));
		dto.setFseq(multi.getParameter("fseq"));
		dto.setHseq(multi.getParameter("hseq"));
		dto.setCtseq(multi.getParameter("ctseq"));
		dto.setLocation(multi.getParameter("location"));
		dto.setMileage(multi.getParameter("mileage"));
		dto.setGeartype(multi.getParameter("geartype"));
		dto.setPrice(multi.getParameter("price"));
		dto.setRentstart(multi.getParameter("rentstart"));
		dto.setRentend(multi.getParameter("rentend"));
		dto.setCarname(multi.getParameter("carname"));
		
		
		// 새 파일
		String filename = multi.getFilesystemName("newpath");
		String orgfilename = multi.getOriginalFileName("newpath");

		
		CarDAO dao = new CarDAO();
		
		int resultOne = 0;
		int resultTwo = 0;
		
		resultOne = dao.add(dto, multi.getParameter("id"));
		resultTwo = dao.addPath(dto);
		
		
		req.setAttribute("resultOne", resultOne);
		req.setAttribute("resultTwo", resultTwo);
		req.setAttribute("seq", dto.getSeq());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/partner/addcarok.jsp");

		dispatcher.forward(req, resp);
	}

}
