package com.doongis.r2.server;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class StepServiceImpl implements StepService{

	@Inject
	private QueryMapper queryMapper;
	
	@Override
	public void insertStep(StepVO stepVO) throws Exception {
		queryMapper.insertStep(stepVO);
	}

	@Override
	public List<StepVO> getStepList() throws Exception {
		return queryMapper.selectStep();
	}

}
