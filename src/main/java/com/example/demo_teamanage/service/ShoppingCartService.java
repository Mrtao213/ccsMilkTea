package com.example.demo_teamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo_teamanage.entity.ShoppingCart;

public interface ShoppingCartService extends IService<ShoppingCart> {
		public void add(ShoppingCart shoppingCart);

		public void deleteByUserId(int userId);
}
