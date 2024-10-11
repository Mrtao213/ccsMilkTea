package com.example.demo_teamanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo_teamanage.entity.ShoppingCart;
import com.example.demo_teamanage.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo_teamanage.mapper.ShoppingCartMapper;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
		@Autowired
		private ShoppingCartMapper shoppingCartMapper;


		@Override
		public void add(ShoppingCart shoppingCart) {
				shoppingCartMapper.insert(shoppingCart);
		}

		@Override
		public void deleteByUserId(int userId) {
				LambdaQueryWrapper<ShoppingCart> queryWrapper = new LambdaQueryWrapper<>();

				queryWrapper.eq(ShoppingCart::getUserId,userId);
				shoppingCartMapper.delete(queryWrapper);
		}
}
