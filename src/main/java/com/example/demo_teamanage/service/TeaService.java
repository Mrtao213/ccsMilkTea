package com.example.demo_teamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo_teamanage.common.R;
import com.example.demo_teamanage.entity.Tea;

import java.util.List;

public interface TeaService extends IService<Tea> {
		public void saveTea(Tea tea);

		public void deleteTea(int id);

		public R<Tea> queryById(int id);

		public List<Tea> queryByCategoryId(int id);

		public void deleteItems(List<Integer> list);

		public void updateTea(Tea tea);

}
