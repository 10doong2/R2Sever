package com.doongis.r2.server;

import java.util.List;

public interface QueryMapper {

	/*UserVO*/
	void insertUser(UserVO userVO) throws Exception;

	/*ArticleVO*/
	void insertArticle(ArticleVO articleVO) throws Exception;
	List<ArticleVO> selectArticle() throws Exception;

	/*StepVO*/
	void insertStep(StepVO stepVO) throws Exception;
	List<StepVO> selectStep() throws Exception;

	/*CycleVO*/
	void insertCycle(CycleVO cycleVO) throws Exception;
	List<CycleVO> selectCycle() throws Exception;


}
