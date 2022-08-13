package com.test.admin.stats;

import java.util.List;

public interface StatsDAO {


	List<StatsDTO> getHomeStats(int nMonth);

	List<StatsDTO> getCarStats(int nMonth);

	List<StatsDTO> getActStats(int nMonth);

	List<GenderDTO> getGStats(int nMonth);

}
