package com.test.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.test.dao.EventDAO;
import com.test.dto.EventDTO;
import com.test.dto.PagingDTO;

@Service
public class EventServiceImpl implements EventService {
	
	private EventDAO dao;
	
	@Autowired
	public EventServiceImpl(EventDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<EventDTO> eventList(PagingDTO pdto,String column ,String word) {
		// TODO Auto-generated method stub
		return dao.eventList(pdto,column, word);
	}
	
	
	@Override
	public PagingDTO paging(String nowPage, PagingDTO pdto,String column ,String word) {
		
		int total = dao.countEvent(column, word);
				
		if (nowPage == null) {
			nowPage = "1";
		}
		
		return pdto = new PagingDTO(total, Integer.parseInt(nowPage));
	}

	

//	@Override
//	public List<EventDTO> list() {
//		// TODO Auto-generated method stub
//		return dao.list();
//	}

	@Override
	public EventDTO get(String seq) {
		// TODO Auto-generated method stub
		return dao.get(seq);
	}
	
	@Override
	public int addevent(EventDTO edto, HttpServletRequest req) {
		
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
		MultipartFile file = multi.getFile("attach");
		
		String filename = file.getOriginalFilename();
		String path = "C:\\class\\server\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\5조_WebProject\\images";
		
		//파일명 중복 방지
		//filename = getFileName(path,filename);
		
		//파일 이동하기
		File file2 = new File(path + "\\" + filename); //희망 경로
		
		try {
			
			//file.renameTo(file2)
			file.transferTo(file2); //임시 폴더 > 업로드 폴더
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		edto.setBennerpicture("/tripnow/images/"+file.getOriginalFilename());
		
		//이벤트 글쓰기
		int seq = dao.getSeq();
		
		edto.setSeq(seq+"");
			
		int result = dao.addevent(edto);
		
		return result;
	}

	@Override
	public int editevent(EventDTO edto, HttpServletRequest req) {
		
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest)req;
		MultipartFile file = multi.getFile("attach");
		if(file.isEmpty()) {
			
			return dao.edit(edto);
		}
		
		String filename = file.getOriginalFilename();
		String path = "C:\\class\\server\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\5조_WebProject\\images";
		
		//파일명 중복 방지
		//filename = getFileName(path,filename);
		
		//파일 이동하기
		File file2 = new File(path + "\\" + filename); //희망 경로
		
		try {
			
			//file.renameTo(file2)
			file.transferTo(file2); //임시 폴더 > 업로드 폴더
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		edto.setBennerpicture("/tripnow/images/"+file.getOriginalFilename());
	
		
		return dao.edit(edto);
	}





	
	
}


























