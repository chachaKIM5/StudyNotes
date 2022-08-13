package com.test.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AdminDAO {

	List<QnADTO> getQnAList(HashMap<String, String> map);

	int getTotalCount();

	List<QnADTO> getQnANoticeList();

	QnADTO getView(String seq);

	int addNotice(QnADTO dto);

	QnADTO addAnswer(QnADTO dto);

	int delAnswer(String qseq);

	List<StatsDTO> getHomeStats(int nMonth);

	List<StatsDTO> getCarStats(int nMonth);

	List<StatsDTO> getActStats(int nMonth);

	List<GenderDTO> getGStats(int nMonth);


}
