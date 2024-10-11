package com.example.demo_teamanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo_teamanage.common.R;
import com.example.demo_teamanage.entity.Category;
import com.example.demo_teamanage.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
		@Autowired
		private CategoryService categoryService;

		@GetMapping("/page")
		public R<Page> page(int page, int pageSize, String name){
				Page<Category> pageInfo = new Page<>(page,pageSize);

				LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
				queryWrapper.like(name != null,Category::getCategoryName,name);

				categoryService.page(pageInfo,queryWrapper);

				return R.success(pageInfo);
		}

		@GetMapping("/queryAll")
		public R<List<Category>> queryAll(){

				List<Category> categoryList = categoryService.getAll();

				if(categoryList != null){
						return R.success(categoryList);
				}
				else{
						return R.error("查询分类失败");
				}

		}

		@GetMapping("/query")
		public R<Category> queryById(int id){
				Category Category = categoryService.getById(id);
				return R.success(Category);
		}

		@PostMapping("/add")
		public R<String> addCategory(@RequestBody Category Category){
				categoryService.add(Category);
				return R.success("添加成功");
		}

		@PutMapping("/update")
		public R<String> updateCategory(@RequestBody Category Category){
				categoryService.updateById(Category);
				return R.success("修改成功");
		}

		@DeleteMapping("/delete")
		public R<String> deleteCategory(int id){
				categoryService.removeById(id);
				return R.success("删除成功");
		}
}
