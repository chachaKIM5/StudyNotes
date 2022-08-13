package com.test.admin.qna;

import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.admin.stats.StatsDTO;

@Service
public class QnAServiceImpl implements QnAService {

	@Autowired
	private QnADAO dao;
	
	@Override
	public List<QnADTO> getQnAList(HashMap<String, String> map) {
		
		List<QnADTO> list = dao.getQnAList(map);
		
		for (QnADTO dto : list) {
			dto.setQregdate(dto.getQregdate().substring(0, 10));
			
			if (dto.getAregdate() != null) {				
				dto.setAregdate(dto.getAregdate().substring(0, 10));
			}
		}
		
		return list;
	}
	
	@Override
	public HashMap<String, String> pagenation(String page) {
		
		int nowPage = 0; // 현재 페이지 번호
		int begin = 0;
		int end = 0;
		int pageSize = 10; // 한 페이지 당 출력할 게시물 수

		int totalCount = 0; // 총 게시물 수
		int totalPage = 0; // 총 페이지 수
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		totalCount = dao.getTotalCount();
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		
		if (page == null || page == "") {
			nowPage = 1;
		} else {
			nowPage = Integer.parseInt(page);
		}
		
		begin = ((nowPage - 1 ) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		map.put("begin", begin + "");
		map.put("end", end + "");
		map.put("nowPage", String.valueOf(nowPage));
		map.put("totalPage", String.valueOf(totalPage));
		
		return map;
	}
	
	@Override
	public List<QnADTO> getQnANoticeList() {
		
		List<QnADTO> nlist = dao.getQnANoticeList();
		
		for (QnADTO dto : nlist) {
			dto.setQregdate(dto.getQregdate().substring(0, 10));
			
			if (dto.getAregdate() != null) {				
				dto.setAregdate(dto.getAregdate().substring(0, 10));
			}
		}
		
		return nlist;
	}
	
	@Override
	public String getPagebar(HashMap<String, String> map) {
		
		String pagebar = "";

		int nowPage = Integer.parseInt(map.get("nowPage"));
		int blockSize = 10; // 한번에 보여질 페이지 개수
		int n = 0; // 페이지 번호
		int loop = 0; // 루프

		
		
		pagebar = "";

		loop = 1;
		n = ((nowPage - 1) / blockSize) * blockSize + 1;
		
		
		pagebar += "<ul class=\"pagination\">";
		
		while (!(loop > blockSize || n > Integer.parseInt(map.get("totalPage")))) {

			if (n == nowPage) {

				pagebar += String
						.format(" <li class=\"page-item active\"><a class=\"page-link\" href=\"#!\">%d</a></li> ", n);

			} else {
				
				pagebar += String.format(
						" <li class=\"page-item\"><a class=\"page-link\" href=\"/tripnow/mypage/qna.do?page=%d\">%d</a></li> ",
						n, n);


			}

			loop++;
			n++;
		}
		
		pagebar += "</ul>";
		
		return pagebar;
	}
	
	@Override
	public QnADTO getView(String seq) {
		
		QnADTO dto = dao.getView(seq);
		
		return dto;
	}
	
	@Override
	public int addNotice(QnADTO dto) {
		
		int result = dao.addNotice(dto);
		
		return result;
	}
	
	
	@Override
	public QnADTO addAnswer(QnADTO dto) {
		
		QnADTO result = dao.addAnswer(dto); 
				
		return result;
	}
	
	@Override
	public int delAnswer(String qseq) {
		
		int result = dao.delAnswer(qseq);
		
		return result;
	}

}
