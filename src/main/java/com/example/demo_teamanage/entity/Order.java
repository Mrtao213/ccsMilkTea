package com.example.demo_teamanage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("orders")
public class Order implements Serializable {

		private static final long serialVersionUID = 1L;

		private int id;

		private int userId;

		private String userName;

		private String phone;

		private String address;

		private LocalDateTime orderTime;

		private LocalDateTime checkoutTime;

		private String status;

		private Double money;

		private String paymentMethod;


}
