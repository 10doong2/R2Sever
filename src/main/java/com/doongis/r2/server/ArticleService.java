package com.doongis.r2.server;

import java.util.List;

public interface ArticleService {

	void insertArticle(ArticleVO articleVO) throws Exception;

	List<ArticleVO> getArticleList() throws Exception;

}
