package com.example.demo_teamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo_teamanage.common.R;
import com.example.demo_teamanage.entity.Order;

import java.util.List;

public interface OrderService extends IService<Order> {
		public void add(Order order);

		public void updateById(int id);

		public void deleteById(int id);

		public Order queryById(int id);

		public void deleteItems(List list);
}
