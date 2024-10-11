package com.example.demo_teamanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo_teamanage.common.R;
import com.example.demo_teamanage.entity.Order;
import com.example.demo_teamanage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
		@Autowired
		private OrderService orderService;

		@GetMapping("/page")
		public R<Page> page(int page, int pageSize, String userName){
				Page<Order> pageInfo = new Page<>(page,pageSize);

				LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
				queryWrapper.like(userName != null,Order::getUserName,userName);

				orderService.page(pageInfo,queryWrapper);


				return R.success(pageInfo);
		}

		@PostMapping("/add")
		public R<String> addOrder(@RequestBody Order order){
				orderService.add(order);
				return R.success("新增订单成功");
		}

		@DeleteMapping("/delete")
		public R<String> deleteOrder(int id){
				orderService.deleteById(id);
				return R.success("删除订单成功");
		}

		@DeleteMapping("/batchDelete")
		public R<String> deleteOrder(@RequestBody List<Integer> list){
				orderService.deleteItems(list);
				return R.success("批量删除订单成功");
		}
}

