package com.doongis.r2.server;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Inject
	private QueryMapper queryMapper;

	@Override
	public void insertUser(UserVO userVO) throws Exception {
		queryMapper.insertUser(userVO);
	}
	
}
