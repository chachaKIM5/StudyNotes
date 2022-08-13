package com.test.admin.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.admin.stats.StatsDTO;

public interface QnADAO {

	List<QnADTO> getQnAList(HashMap<String, String> map);

	int getTotalCount();

	List<QnADTO> getQnANoticeList();

	QnADTO getView(String seq);

	int addNotice(QnADTO dto);

	QnADTO addAnswer(QnADTO dto);

	int delAnswer(String qseq);

}
