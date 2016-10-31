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
@RequestMapping("cycle")
public class CycleController {

	private static final Logger logger = LoggerFactory.getLogger(CycleController.class);

	@Inject // Autowired
	private CycleService cycleService;

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public void insertGET(@ModelAttribute CycleVO cycleVO) {
		logger.info("GET:" + cycleVO.toString());
	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public void insertPOST(@ModelAttribute CycleVO cycleVO) {
		logger.info("POST:" + cycleVO.toString());

		try {
			cycleService.insertCycle(cycleVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "selectJSON", 
			method = RequestMethod.GET, 
			headers = "Accept=application/json;charset=UTF-8",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public List<CycleVO> selectJSON() throws Exception {
		List<CycleVO> list = cycleService.getCycleList();
		logger.info("Cycle리스트 "+list+"\n");
		return list;
	}
}
