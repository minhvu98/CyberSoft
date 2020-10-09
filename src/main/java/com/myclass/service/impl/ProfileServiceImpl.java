package com.myclass.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDto;
import com.myclass.repository.ProfileRepository;
import com.myclass.service.ProfileService;

@Service
@Transactional(rollbackOn = Exception.class)
public class ProfileServiceImpl implements ProfileService{
	
	@Autowired
	private ProfileRepository profileResponsitory;

	@Override
	public List<UserDto> findAll() {
		
		return null;
	}

	@Override
	public UserDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UserDto dto) {
		// TODO Auto-generated method stub
		
	}
	
	
}
