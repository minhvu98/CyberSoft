package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myclass.dto.UserCoursesDto;
import com.myclass.entity.UserCourses;

@Repository
public interface UserCoursesRepository extends JpaRepository<UserCourses, Integer>{

	@Query("FROM UserCourses uc JOIN uc.user JOIN uc.courses_user ucu WHERE ucu.discount != 0")
	public List<UserCourses> getDiscount();
	
}
