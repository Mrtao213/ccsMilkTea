package com.example.demo_teamanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo_teamanage.entity.User;
import com.example.demo_teamanage.mapper.UserMapper;
import com.example.demo_teamanage.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
