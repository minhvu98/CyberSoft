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

import com.myclass.dto.CategoryDto;
import com.myclass.service.CategoryService;

@Controller
@RequestMapping("category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(ModelMap model) {
		List<CategoryDto> list = categoryService.findAll();
		model.addAttribute("categories", list);
		return "managerlayout/category/index";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap model) {
		model.addAttribute("category", new CategoryDto());
		return "managerlayout/category/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String post(ModelMap model, @ModelAttribute("categories") CategoryDto category,
			BindingResult errors) {
		if (errors.hasErrors()) {
			return "managerlayout/category/add";
		}
		try {
			categoryService.add(category);
			return "redirect:/category";
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("message", "them moi that bai");
		return "managerlayout/category/add";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String edit(@RequestParam("id") int id, ModelMap model) {
		model.addAttribute("category", categoryService.findById(id));
		return "managerlayout/category/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(ModelMap model, @ModelAttribute("category") CategoryDto category,
			BindingResult errors) {
		if (errors.hasErrors()) {
			return "managerlayout/category/edit";
		}
		try {
			categoryService.update(category);
		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("message", "cap nhat that bai");
		return "managerlayout/category/edit";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		categoryService.delete(id);
		return "redirect:/category";
	}
}
