package com.example.demo_teamanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo_teamanage.entity.Employee;

public interface EmployeeService extends IService<Employee> {
		public void add(Employee employee);
}
