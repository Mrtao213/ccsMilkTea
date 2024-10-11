package com.example.demo_teamanage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
		private static final long serialVersionUID = 1L;

		private int id;

		private String userName;

		private String password;

		private String phone;

		private String address;
}
