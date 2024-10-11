package com.example.demo_teamanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo_teamanage.common.R;
import com.example.demo_teamanage.entity.Employee;
import com.example.demo_teamanage.entity.Tea;
import com.example.demo_teamanage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeContrller {
		@Autowired
		private EmployeeService employeeService;

		@PostMapping("/login")
		public R<Employee> loginSystem(@RequestBody Employee employee, HttpSession session){
				LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();

//				构造匹配账号密码的查询条件
				queryWrapper.eq(Employee::getUserName,employee.getUserName());
				queryWrapper.eq(Employee::getPassword,employee.getPassword());

//				依据查询条件查询数据库,如果不为空则把用户id存入session用于登录校验
			  if(employeeService.getOne(queryWrapper)!=null){
						Employee employee1 = employeeService.getOne(queryWrapper);
						session.setAttribute("employee",employee.getId());
						return R.success(employee1);
				}
				return R.error("账号或密码错误");
		}

		@GetMapping("/page")
		public R<Page> page(int page, int pageSize, String name){
				Page<Employee> pageInfo = new Page<>(page,pageSize);

				LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
				queryWrapper.like(name != null,Employee::getUserName,name);

				employeeService.page(pageInfo,queryWrapper);

				return R.success(pageInfo);
		}

		@GetMapping("/query")
		public R<Employee> queryById(int id){
				Employee employee = employeeService.getById(id);
				return R.success(employee);
		}

		@PostMapping("/add")
		public R<String> addEmployee(@RequestBody Employee employee){
				employeeService.add(employee);
				return R.success("添加成功");
		}

		@PutMapping("/update")
		public R<String> updateEmployee(@RequestBody Employee employee){
				employeeService.updateById(employee);
				return R.success("修改成功");
		}

		@DeleteMapping("/delete")
		public R<String> deleteEmployee(int id){
				employeeService.removeById(id);
				return R.success("删除成功");
		}

		@PostMapping("/logout")
		public R<String> logoutSystem(HttpSession session){
				session.setAttribute("employee",null);
				return R.success("退出系统成功");
		}
}
