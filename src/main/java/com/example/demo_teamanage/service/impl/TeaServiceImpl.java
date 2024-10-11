package com.example.demo_teamanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo_teamanage.common.R;
import com.example.demo_teamanage.entity.Tea;
import com.example.demo_teamanage.mapper.TeaMapper;
import com.example.demo_teamanage.service.TeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeaServiceImpl extends ServiceImpl<TeaMapper, Tea> implements TeaService {

		@Autowired
		private TeaMapper teaMapper;
		@Override
		public void saveTea(Tea tea) {
				teaMapper.insert(tea);
		}

		@Override
		public void deleteTea(int id) {
				teaMapper.deleteById(id);
		}

		@Override
		public R<Tea> queryById(int id) {
				return R.success(teaMapper.selectById(id));
		}

		@Override
		public List<Tea> queryByCategoryId(int id) {
				LambdaQueryWrapper<Tea> queryWrapper = new LambdaQueryWrapper<>();

				queryWrapper.eq(Tea::getCategoryId,id);

				return teaMapper.selectList(queryWrapper);
		}

		@Override
		public void deleteItems(List<Integer> list) {
				teaMapper.deleteBatchIds(list);
		}

		@Override
		public void updateTea(Tea tea) {
				teaMapper.updateById(tea);
		}
}
