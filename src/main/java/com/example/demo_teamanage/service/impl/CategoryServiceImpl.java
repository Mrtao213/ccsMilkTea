package com.example.demo_teamanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo_teamanage.entity.Category;
import com.example.demo_teamanage.mapper.CategoryMapper;
import com.example.demo_teamanage.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
		@Autowired
		private CategoryMapper categoryMapper;

		@Override
		public void add(Category category) {
				categoryMapper.insert(category);
		}

		@Override
		public List<Category> getAll() {
				LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
				queryWrapper.like(Category::getCategoryName,"%");
				List<Category> categoryList = categoryMapper.selectList(queryWrapper);
				return categoryList;
		}
}
