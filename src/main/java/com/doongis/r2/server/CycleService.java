package com.doongis.r2.server;

import java.util.List;

public interface CycleService {

	void insertCycle(CycleVO cycleVO) throws Exception;

	List<CycleVO> getCycleList() throws Exception;

}
