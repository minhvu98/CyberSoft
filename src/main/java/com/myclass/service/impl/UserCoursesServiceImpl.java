package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserCoursesDto;
import com.myclass.entity.Courses;
import com.myclass.entity.User;
import com.myclass.entity.UserCourses;
import com.myclass.repository.UserCoursesRepository;
import com.myclass.service.UserCoursesService;

@Service
@Transactional(rollbackOn = Exception.class)
public class UserCoursesServiceImpl implements UserCoursesService{

	@Autowired
	UserCoursesRepository userCoursesRepository;
	
	@Override
	public List<UserCoursesDto> findAll() {
		List<UserCoursesDto> dtos = new ArrayList<UserCoursesDto>();
		List<UserCourses> userCourses = userCoursesRepository.findAll();
		for (UserCourses userCourse : userCourses) {
			UserCoursesDto userCourseDto = new UserCoursesDto();
			userCourseDto.setUser_id(userCourse.getUser_id());
			userCourseDto.setCourse_id(userCourse.getCourse_id());
			userCourseDto.setRole_id(userCourse.getRole_id());
			userCourseDto.setTitle(userCourse.getCourses_user().getTitle());
			userCourseDto.setImage(userCourse.getCourses_user().getImage());
			userCourseDto.setLetures_count(userCourse.getCourses_user().getLetures_count());
			userCourseDto.setPrice(userCourse.getCourses_user().getPrice());
			userCourseDto.setDiscount(userCourse.getCourses_user().getDiscount());
			userCourseDto.setPromotion_price(userCourse.getCourses_user().getPromotion_price());
			userCourseDto.setContent(userCourse.getCourses_user().getContent());
			userCourseDto.setLast_update(userCourse.getCourses_user().getLast_update());
			userCourseDto.setName(userCourse.getUser().getFullname());
			dtos.add(userCourseDto);
		}	
		return dtos;
	}
	
	@Override
	public List<UserCoursesDto> getDiscount() {
		List<UserCoursesDto> dtos = new ArrayList<UserCoursesDto>();
		List<UserCourses> userCourses = userCoursesRepository.getDiscount();
		for (UserCourses userCourse : userCourses) {
			UserCoursesDto userCourseDto = new UserCoursesDto();
			userCourseDto.setUser_id(userCourse.getUser_id());
			userCourseDto.setCourse_id(userCourse.getCourse_id());
			userCourseDto.setRole_id(userCourse.getRole_id());
			userCourseDto.setTitle(userCourse.getCourses_user().getTitle());
			userCourseDto.setImage(userCourse.getCourses_user().getImage());
			userCourseDto.setLetures_count(userCourse.getCourses_user().getLetures_count());
			userCourseDto.setPrice(userCourse.getCourses_user().getPrice());
			userCourseDto.setDiscount(userCourse.getCourses_user().getDiscount());
			userCourseDto.setPromotion_price(userCourse.getCourses_user().getPromotion_price());
			userCourseDto.setContent(userCourse.getCourses_user().getContent());
			userCourseDto.setLast_update(userCourse.getCourses_user().getLast_update());
			userCourseDto.setName(userCourse.getUser().getFullname());
			dtos.add(userCourseDto);
		}
		return dtos;
	}
	

	@Override
	public UserCoursesDto findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(UserCoursesDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserCoursesDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserCoursesDto getUserCourseById(int id) {
		UserCourses userCourse = userCoursesRepository.findById(id).get();
		UserCoursesDto dto = new UserCoursesDto();
		dto.setPrice(userCourse.getCourses_user().getPrice());
		dto.setPromotion_price(userCourse.getCourses_user().getPromotion_price());
		dto.setName(userCourse.getUser().getFullname());
		return dto;
	}
}
