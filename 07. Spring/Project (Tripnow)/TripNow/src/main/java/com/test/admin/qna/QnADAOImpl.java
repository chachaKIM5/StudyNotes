package com.test.admin.qna;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.admin.stats.StatsDTO;

@Repository
public class QnADAOImpl implements QnADAO {

	@Autowired
	private SqlSessionTemplate template;
	
	@Override
	public List<QnADTO> getQnAList(HashMap<String, String> map) {
		
		
		return template.selectList("mapper.qnalist", map);
	}
	
	@Override
	public int getTotalCount() {
		
		return template.selectOne("mapper.qnatotal");
	}
	
	@Override
	public List<QnADTO> getQnANoticeList() {
		
		return template.selectList("mapper.qnanlist");
	}
	
	@Override
	public QnADTO getView(String seq) {
		
		return template.selectOne("mapper.qnaview", seq);
	}
	
	@Override
	public int addNotice(QnADTO dto) {
		
		return template.insert("mapper.qnaadd", dto);
	}
	
	@Override
	public QnADTO addAnswer(QnADTO dto) {
		
		template.insert("mapper.addanswer", dto);
		
		return template.selectOne("mapper.qnaview", dto.getQseq());
	}
	
	@Override
	public int delAnswer(String qseq) {
		
		return template.delete("mapper.delanswer", qseq);
	}
	
}
