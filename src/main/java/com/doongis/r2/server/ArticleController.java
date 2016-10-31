package com.doongis.r2.server;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("article")
public class ArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

	@Inject // Autowired
	private ArticleService articleService;

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public void insertGET(@ModelAttribute ArticleVO articleVO) {
		logger.info("GET:" + articleVO.toString());
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public void insertPOST(@ModelAttribute ArticleVO articleVO) {
		logger.info("POST:" + articleVO.toString());

		try {
			articleService.insertArticle(articleVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "selectJSON", 
			method = RequestMethod.GET, 
			headers = "Accept=application/json;charset=UTF-8",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public List<ArticleVO> selectJSON() throws Exception {
		List<ArticleVO> list = articleService.getArticleList();
		logger.info("Article리스트 "+list+"\n");
		return list;
	}
}
