package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myclass.dto.CategoryDto;
import com.myclass.dto.CourseDto;
import com.myclass.dto.UserCoursesDto;
import com.myclass.service.CategoryService;
import com.myclass.service.CourseService;
import com.myclass.service.UserCoursesService;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	private UserCoursesService userCoursesService;
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<UserCoursesDto> list = userCoursesService.findAll();
		model.addAttribute("userCourse", list);
		System.out.println(list);
		List<UserCoursesDto> list2 = userCoursesService.getDiscount();
		model.addAttribute("discount", list2);
		System.out.println(list2);
		return "home/index";
	}
}
