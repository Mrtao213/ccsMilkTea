package com.example.demo_teamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo_teamanage.entity.Category;
import com.example.demo_teamanage.entity.Employee;

import java.util.List;

public interface CategoryService extends IService<Category> {
		public void add(Category category);

		public List<Category> getAll();
}
