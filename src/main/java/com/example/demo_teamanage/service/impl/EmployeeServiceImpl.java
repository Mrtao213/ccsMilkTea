package com.example.demo_teamanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo_teamanage.entity.Employee;
import com.example.demo_teamanage.mapper.EmployeeMapper;
import com.example.demo_teamanage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
		@Autowired
		private EmployeeMapper employeeMapper;

		@Override
		public void add(Employee employee) {
				employeeMapper.insert(employee);
		}
}
