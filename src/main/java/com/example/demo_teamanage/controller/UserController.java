package com.example.demo_teamanage.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo_teamanage.entity.User;
import com.example.demo_teamanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo_teamanage.common.R;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

		@Autowired
		private UserService userService;

		@PostMapping("/login")
		public R<User>  userLogin(@RequestBody User user, HttpSession session){
				LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

				queryWrapper.eq(User::getUserName,user.getUserName());
				queryWrapper.eq(User::getPassword,user.getPassword());

				User userInfo = userService.getOne(queryWrapper);
				if(userInfo!=null){
						session.setAttribute("user",userInfo.getId());
						return R.success(userInfo);
				}
				return R.error("账号或密码错误");
		}

		@GetMapping("/query")
		public R<User> queryUserInfo(int id){
				User user = userService.getById(id);
				return R.success(user);
		}

		@PutMapping("/update")
		public R<String> updateUserInfo(@RequestBody User user){
				userService.updateById(user);
				return R.success("修改成功");
		}

		@PostMapping("/logout")
		public R<String> logoutSystem(HttpSession session){
				session.setAttribute("user",null);
				return R.success("退出系统成功");
		}

}
