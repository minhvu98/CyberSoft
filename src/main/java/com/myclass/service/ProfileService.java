package com.myclass.service;

import java.util.List;

import com.myclass.dto.UserDto;

public interface ProfileService {
	List<UserDto> findAll();
	UserDto findById(int id);
	void update(UserDto dto);
}
