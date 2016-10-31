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
@RequestMapping("step")
public class StepController {

private static final Logger logger = LoggerFactory.getLogger(StepController.class);
	
	@Inject //Autowired 
	private StepService stepService;
	
	@RequestMapping(value="insert", method = RequestMethod.GET)
	public void insertGET(@ModelAttribute StepVO stepVO){
		logger.info("GET:"+stepVO.toString());
	}
	@RequestMapping(value="insert", method = RequestMethod.POST)
	public void insertPOST(@ModelAttribute StepVO stepVO){
		logger.info("POST:"+stepVO.toString());
		
		try{
		stepService.insertStep(stepVO);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "selectJSON", 
			method = RequestMethod.GET, 
			headers = "Accept=application/json;charset=UTF-8",
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public List<StepVO> selectJSON() throws Exception {
		List<StepVO> list = stepService.getStepList();
		logger.info("Step리스트 "+list+"\n");
		return list;
	}
	
}
