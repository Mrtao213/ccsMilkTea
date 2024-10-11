package com.example.demo_teamanage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("employee")
public class Employee implements Serializable {
		private static final long serialVersionUID = 1L;

		private int id;

		private String userName;

		private String password;

		private String phone;

		private String address;
}
