package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.CourseDto;
import com.myclass.entity.Courses;
import com.myclass.repository.CourseRepository;
import com.myclass.service.CourseService;

@Service
@Transactional(rollbackOn = Exception.class)
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<CourseDto> findAll() {
		List<CourseDto> dtos = new ArrayList<CourseDto>();
		List<Courses> courses = courseRepository.findAll();
		for (Courses courses2 : courses) {
			dtos.add(new CourseDto(courses2.getId(), courses2.getTitle(),
					courses2.getImage(), courses2.getLetures_count(), 
					courses2.getHour_count(), courses2.getView_count(), 
					courses2.getPrice(), courses2.getDiscount(), 
					courses2.getPromotion_price(), courses2.getDescription(), 
					courses2.getContent(), courses2.getCategory_id(), 
					courses2.getLast_update()));
		}
		return dtos;
	}

	@Override
	public CourseDto findById(int id) {
		Courses courses = courseRepository.findById(id).get();
		return new CourseDto(courses.getId(), courses.getTitle(), courses.getImage(), courses.getLetures_count(),
				courses.getHour_count(), courses.getView_count(), courses.getPrice(), 
				courses.getDiscount(), courses.getPromotion_price(),
				courses.getDescription(), courses.getContent(), 
				courses.getCategory_id(), courses.getLast_update());
	}

	@Override
	public void add(CourseDto dto) {
		Courses courses = new Courses();
		courses.setId(dto.getId());
		courses.setTitle(dto.getTitle());
		courses.setImage(dto.getImage());
		courses.setLetures_count(dto.getLetures_count());
		courses.setHour_count(dto.getHour_count());
		courses.setView_count(dto.getView_count());
		courses.setPrice(dto.getPrice());
		courses.setDiscount(dto.getDiscount());
		courses.setPromotion_price(dto.getPromotion_price());
		courses.setDescription(dto.getDescription());
		courses.setContent(dto.getContent());
		courses.setCategory_id(dto.getCategory_id());
		courses.setLast_update(dto.getLast_update());
		courseRepository.save(courses);
	}

	@Override
	public void update(CourseDto dto) {
		Courses courses = courseRepository.findById(dto.getId()).get();
		courses.setId(dto.getId());
		courses.setTitle(dto.getTitle());
		courses.setImage(dto.getImage());
		courses.setLetures_count(dto.getLetures_count());
		courses.setHour_count(dto.getHour_count());
		courses.setView_count(dto.getView_count());
		courses.setPrice(dto.getPrice());
		courses.setDiscount(dto.getDiscount());
		courses.setPromotion_price(dto.getPromotion_price());
		courses.setDescription(dto.getDescription());
		courses.setContent(dto.getContent());
		courses.setCategory_id(dto.getCategory_id());
		courses.setLast_update(dto.getLast_update());
		courseRepository.save(courses);
	}

	@Override
	public void delete(int id) {
		courseRepository.deleteById(id);
	}

	@Override
	public List<CourseDto> GetCourseBigToSmall() {
		List<CourseDto> dtos = new ArrayList<CourseDto>();
		List<Courses> courses = courseRepository.GetCourseBigToSmall();
		for (Courses courses2 : courses) {
			dtos.add(new CourseDto(courses2.getId(), courses2.getTitle(), courses2.getImage(), courses2.getLetures_count()
					, courses2.getHour_count(), courses2.getView_count(), courses2.getPrice(), courses2.getDiscount()
					, courses2.getPromotion_price(), courses2.getDescription(), courses2.getContent()
					 , courses2.getCategory_id(), courses2.getLast_update()));
		}
		return dtos;
	}
	
}
