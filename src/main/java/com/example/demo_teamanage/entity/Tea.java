package com.example.demo_teamanage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tea")
public class Tea implements Serializable {

		private static final long serialVersionUID = 1L;

		private int id;
		private String teaName;
		private int price;
		private String description;
		private String image;
		private int categoryId;
}
