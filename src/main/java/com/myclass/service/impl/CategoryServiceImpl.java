package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.CategoryDto;
import com.myclass.entity.Category;
import com.myclass.repository.CategoryRepository;
import com.myclass.service.CategoryService;

@Service
@Transactional(rollbackOn = Exception.class)
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryDto> findAll() {
		List<CategoryDto> dtos = new ArrayList<CategoryDto>();
		List<Category> category = categoryRepository.findAll();
		for (Category category2 : category) {
			dtos.add(new CategoryDto(category2.getId(), category2.getTitle(), category2.getIcon()));
		}
		return dtos;
	}

	@Override
	public CategoryDto findById(int id) {
		Category category = categoryRepository.findById(id).get();
		return new CategoryDto(category.getId(), category.getTitle(), category.getIcon());
	}

	@Override
	public void add(CategoryDto dto) {
		Category category = new Category();
		category.setId(dto.getId());
		category.setTitle(dto.getTitle());
		category.setIcon(dto.getIcon());
		categoryRepository.save(category);
	}

	@Override
	public void update(CategoryDto dto) {
		Category category = categoryRepository.findById(dto.getId()).get();
		category.setId(dto.getId());
		category.setTitle(dto.getTitle());
		category.setIcon(dto.getIcon());
		categoryRepository.save(category);
	}

	@Override
	public void delete(int id) {
		categoryRepository.deleteById(id);
	}

}
