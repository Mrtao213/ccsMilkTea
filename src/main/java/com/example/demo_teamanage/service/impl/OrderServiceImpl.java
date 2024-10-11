package com.example.demo_teamanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo_teamanage.common.R;
import com.example.demo_teamanage.entity.Order;
import com.example.demo_teamanage.mapper.OrderMapper;
import com.example.demo_teamanage.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

		@Autowired
		private OrderMapper orderMapper;

		@Override
		public void add(Order order) {orderMapper.insert(order); }

		@Override
		public void updateById(int id) {}

		@Override
		public void deleteById(int id) {
				 orderMapper.deleteById(id);
		}

		@Override
		public Order queryById(int id) {
				return orderMapper.selectById(id);
		}

		@Override
		public void deleteItems(List list) {
				orderMapper.deleteBatchIds(list);
		}
}
