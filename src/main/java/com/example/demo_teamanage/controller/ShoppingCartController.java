package com.example.demo_teamanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo_teamanage.common.R;
import com.example.demo_teamanage.entity.ShoppingCart;
import com.example.demo_teamanage.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
		@Autowired
		private ShoppingCartService shoppingCartService;

		@GetMapping("/query")
		public R<List<ShoppingCart>> queryCart(int userId){
				LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();

				queryWrapper.eq(ShoppingCart::getUserId,userId);
				List<ShoppingCart> cartList = shoppingCartService.list(queryWrapper);
				return R.success(shoppingCartService.list(queryWrapper));

		}

		@PostMapping("/add")
		public R<String> addGoods(@RequestBody ShoppingCart shoppingCart){
				shoppingCartService.add(shoppingCart);

				return R.success("添加成功");
		}

		@DeleteMapping("/delete")
		public R<String> deleteAll(int userId){
				shoppingCartService.deleteByUserId(userId);
				return R.success("删除成功");
		}
}
