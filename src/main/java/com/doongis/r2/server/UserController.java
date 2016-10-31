package com.doongis.r2.server;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Inject //Autowired 
	private UserService userService;
	
	@RequestMapping(value="insert", method = RequestMethod.GET)
	public void insertGET(@ModelAttribute UserVO userVO){
		logger.info("GET:"+userVO.toString());
	}
	@RequestMapping(value="insert", method = RequestMethod.POST)
	public void insertPOST(@ModelAttribute UserVO userVO){
		logger.info("POST:"+userVO.toString());
		
		try{
		userService.insertUser(userVO);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
