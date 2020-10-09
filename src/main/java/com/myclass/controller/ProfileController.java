package com.myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myclass.dto.UserDto;
import com.myclass.service.UserService;

@Controller
@RequestMapping("profile")
public class ProfileController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("user", new UserDto());
		return "profile/index";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String add(ModelMap model, @ModelAttribute("user") UserDto user,
			BindingResult errors) {
		if (errors.hasErrors()) {
			return "profile";
		}
		try {
			userService.add(user);
			return "redirect:/profile";
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("message", "them that bai");
		return "profile";
	}
}
