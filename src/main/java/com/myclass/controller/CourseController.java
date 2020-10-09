package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.dto.CourseDto;
import com.myclass.dto.UserDto;
import com.myclass.service.CategoryService;
import com.myclass.service.CourseService;

@Controller
@RequestMapping("course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<CourseDto> list = courseService.findAll();
		model.addAttribute("course", list);
		return "course/index";
	}
	
	@RequestMapping(value = "manager", method = RequestMethod.GET)
	public String manager(ModelMap model) {
		List<CourseDto> list = courseService.findAll();
		model.addAttribute("course", list);
		return "managerlayout/course/index";
	}
	
	@RequestMapping(value ="add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("course", new CourseDto());
		model.addAttribute("courses", categoryService.findAll());
		return "managerlayout/course/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String post(ModelMap model, @ModelAttribute("course") CourseDto course,
			BindingResult errors) {
		if (errors.hasErrors()) {
			return "managerlayout/course/add";
		}
		try {
			courseService.add(course);
			return "redirect:/course";
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("message", "them moi that bai");
		return "managerlayout/course/add";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, ModelMap model) {
		model.addAttribute("course", courseService.findById(id));
		model.addAttribute("courses", courseService.findAll());
		return "managerlayout/course/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(ModelMap model, @ModelAttribute("course") CourseDto course,
			BindingResult errors) {
		if (errors.hasErrors()) {
			return "managerlayout/course/edit";
		}
		try {
			courseService.update(course);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("message", "cap nhat that bai");
		return "managerlayout/course/edit";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		courseService.delete(id);
		return "redirect:/manager";
	}
	
}
