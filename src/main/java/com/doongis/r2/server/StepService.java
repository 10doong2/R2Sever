package com.doongis.r2.server;

import java.util.List;

public interface StepService {

	void insertStep(StepVO stepVO) throws Exception;

	List<StepVO> getStepList() throws Exception;

}
