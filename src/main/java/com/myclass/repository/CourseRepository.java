package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myclass.dto.CourseDto;
import com.myclass.entity.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Integer>{
	
	@Query("FROM Courses ORDER BY view_count DESC")
	public List<Courses> GetCourseBigToSmall();
}
