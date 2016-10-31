package com.doongis.r2.server;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Inject
	private QueryMapper queryMapper;
	
	@Override
	public void insertArticle(ArticleVO articleVO) throws Exception {
		queryMapper.insertArticle(articleVO);
	}
	
	@Override
	public List<ArticleVO> getArticleList() throws Exception {
		return queryMapper.selectArticle();
	}
	
}
