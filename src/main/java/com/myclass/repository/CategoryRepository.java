package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myclass.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
