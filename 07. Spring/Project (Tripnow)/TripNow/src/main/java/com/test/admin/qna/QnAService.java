package com.test.admin.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.admin.stats.StatsDTO;

public interface QnAService {

	List<QnADTO> getQnAList(HashMap<String, String> map);

	HashMap<String, String> pagenation(String page);

	List<QnADTO> getQnANoticeList();

	String getPagebar(HashMap<String, String> map);

	QnADTO getView(String seq);

	int addNotice(QnADTO dto);

	QnADTO addAnswer(QnADTO dto);

	int delAnswer(String qseq);


}
