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

import com.myclass.dto.RoleDto;
import com.myclass.dto.TargetDto;
import com.myclass.repository.TargetRepository;
import com.myclass.service.CourseService;
import com.myclass.service.TargetService;

@Controller
@RequestMapping("target")
public class TargetController {
	
	@Autowired
	private TargetService targetService;
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<TargetDto> list = targetService.findAll();
		model.addAttribute("targets", list);
		return "managerlayout/target/index";
	}
	
	@RequestMapping(value ="add", method = RequestMethod.GET)
	public String add( ModelMap model) {
		model.addAttribute("target", new TargetDto());
		model.addAttribute("targets", courseService.findAll());
		return "managerlayout/target/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String post(ModelMap model, @ModelAttribute("target") TargetDto target,
			 BindingResult errors) {
		if (errors.hasErrors()) {
			return "managerlayout/target/add";
		}
		try {
			targetService.add(target);
			return "redirect:/target";
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("message", "them moi that bai");
		return "managerlayout/target/add";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, ModelMap model) {
		model.addAttribute("target", targetService.findById(id));
		model.addAttribute("targets", courseService.findAll());
		return "managerlayout/target/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(ModelMap model, @ModelAttribute("target") TargetDto target,
			BindingResult errors) {
		if (errors.hasErrors()) {
			return "managerlayout/target/edit";
		}
		try {
			targetService.update(target);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("message", "cap nhat that bai");
		return "managerlayout/target/edit";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		targetService.delete(id);
		return "redirect:/target";
	}
}
