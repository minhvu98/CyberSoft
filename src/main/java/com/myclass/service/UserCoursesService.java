package com.myclass.service;

import java.util.List;

import com.myclass.dto.UserCoursesDto;
import com.myclass.entity.UserCourses;

public interface UserCoursesService {
	List<UserCoursesDto> findAll();
	UserCoursesDto findById(int id);
	void add(UserCoursesDto dto);
	void update(UserCoursesDto dto);
	void delete(int id);
	List<UserCoursesDto> getDiscount();
	public UserCoursesDto getUserCourseById(int id);
}