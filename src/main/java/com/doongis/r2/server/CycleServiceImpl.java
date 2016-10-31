package com.doongis.r2.server;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class CycleServiceImpl implements CycleService{

	@Inject
	private QueryMapper queryMapper;
	
	@Override
	public void insertCycle(CycleVO cycleVO) throws Exception {
		queryMapper.insertCycle(cycleVO);
	}

	@Override
	public List<CycleVO> getCycleList() throws Exception {
		return queryMapper.selectCycle();
	}

}
