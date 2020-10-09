package com.myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myclass.dto.UserDto;
import com.myclass.service.RoleService;
import com.myclass.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("users", userService.findAll());
		return "user/index";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("user", new UserDto());
		model.addAttribute("users", roleService.findAll());
		return "user/add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String post(ModelMap model, @ModelAttribute("user") UserDto user,
			@RequestParam("repassword") String password,BindingResult errors) {
		if (errors.hasErrors()) {
			return "managerlayout/user/add";
		}
		try {
			userService.add(user);
			return "redirect:/user";
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("message", "them moi that bai");
		return "managerlayout/user/add";
	}

	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, ModelMap model) {
		model.addAttribute("user", userService.findById(id));
		return "managerlayout/user/edit";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(ModelMap model, @RequestParam("user") UserDto user, BindingResult errors) {
		if (errors.hasErrors()) {
			return "managerlayout/user/edit";
		}
		try {
			userService.update(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("message", "cap nhat that bai");
		return "managerlayout/user/edit";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		userService.delete(id);
		return "redirect:/user";
	}

}
