package com.example.demo_teamanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo_teamanage.common.R;
import com.example.demo_teamanage.entity.Tea;
import com.example.demo_teamanage.service.TeaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/tea")
@Slf4j
public class TeaController {
		@Autowired
		private TeaService teaService;

		@Autowired
		private RedisTemplate redisTemplate;

		@GetMapping("/page")
		public R<Page> page(int page,int pageSize,String name){
				Page<Tea> pageInfo = new Page<>(page,pageSize);

				LambdaQueryWrapper<Tea> queryWrapper = new LambdaQueryWrapper<>();
				queryWrapper.like(name != null,Tea::getTeaName,name);

				teaService.page(pageInfo,queryWrapper);

				return R.success(pageInfo);
		}

		@PostMapping("/add")
		public R<String> addTea(@RequestBody Tea tea){
				teaService.saveTea(tea);
				return R.success("新增茶品成功");
		}
		@PutMapping("/update")
		public R<String> updateTea(@RequestBody Tea tea){
				teaService.updateTea(tea);
				return R.success("修改茶品成功");
		}

		@GetMapping("/query")
		public R<Tea> queryTea(int id){
				return teaService.queryById(id);
		}

		@GetMapping("/category")
		public R<List<Tea>> queryByCategory(int id){
				List<Tea> teaCacheList = (List<Tea>)redisTemplate.opsForValue().get(id);
				if(redisTemplate.opsForValue().get(id)!=null){
						log.info("从缓存返回数据");
						return R.success(teaCacheList);
				}


				log.info("查询数据库");
				List<Tea> teaList = teaService.queryByCategoryId(id);
				redisTemplate.opsForValue().set(id,teaList,1, TimeUnit.MINUTES);
				return R.success(teaList);
		}

		@DeleteMapping("/delete")
		public R<String> deleteTea(int id){
				teaService.deleteTea(id);
				return R.success("删除茶品成功");
		}

		@DeleteMapping("/batchDelete")
		public R<String> deleteOrder(@RequestBody List<Integer> list){
				teaService.deleteItems(list);
				return R.success("批量删除茶品成功");
		}
}
