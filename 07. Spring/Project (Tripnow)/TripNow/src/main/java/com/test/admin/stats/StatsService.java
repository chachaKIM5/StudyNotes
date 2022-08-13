package com.test.admin.stats;

import java.util.List;

public interface StatsService {

	List<StatsDTO> getHomeStats();

	List<StatsDTO> getCarStats();

	List<StatsDTO> getActStats();

	List<GenderDTO> getGStats();
}
