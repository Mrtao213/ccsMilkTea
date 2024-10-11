package com.example.demo_teamanage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@TableName("shopping_cart")
public class ShoppingCart implements Serializable {
		private static final long serialVersionUID = 1L;

		private int id;

		private int userId;

		private String teaName;

		private BigDecimal price;

		private String template;

		private String sugarDegree;

		private String addMaterial;

		private String image;

}
