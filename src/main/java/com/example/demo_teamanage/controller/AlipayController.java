package com.example.demo_teamanage.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.easysdk.factory.Factory;
import com.example.demo_teamanage.common.AlipayTemplate;
import com.example.demo_teamanage.entity.Order;
import com.example.demo_teamanage.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * 支付宝接口
 */
@RestController
@RequestMapping("/alipay")
@Slf4j
public class AlipayController {

		@Autowired
		AlipayTemplate alipayTemplate;

		@Autowired
		private OrderService orderService;

		@GetMapping(value = "/pay", produces = "text/html")
		@ResponseBody
		public String pay(@RequestParam int id, String userName, String phone, String address, Double money) throws AlipayApiException {

				Order order = new Order();
				Random random = new Random();
				int min = 10000000;
				int orderId = random.nextInt(90000000)+min;
				order.setId(orderId);
				order.setUserId(id);
				order.setUserName(userName);
				order.setPhone(phone);
				order.setAddress(address);
				order.setMoney(money);
				order.setOrderTime(LocalDateTime.now());
				order.setStatus("未支付");

				orderService.add(order);

				return alipayTemplate.pay(order);
		}

		@PostMapping("/notify")  // 注意这里必须是POST接口
		public String payNotify(HttpServletRequest request) throws Exception {
				if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
						System.out.println("=========支付宝异步回调========");

						Map<String, String> params = new HashMap<>();
						Map<String, String[]> requestParams = request.getParameterMap();
						for (String name : requestParams.keySet()) {
								params.put(name, request.getParameter(name));
								// System.out.println(name + " = " + request.getParameter(name));
						}

						String tradeNo = params.get("out_trade_no");
						String gmtPayment = params.get("gmt_payment");
						String alipayTradeNo = params.get("trade_no");
						// 支付宝验签
						if (Factory.Payment.Common().verifyNotify(params)) {
								// 验签通过
								System.out.println("交易名称: " + params.get("subject"));
								System.out.println("交易状态: " + params.get("trade_status"));
								System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
								System.out.println("商户订单号: " + params.get("out_trade_no"));
								System.out.println("交易金额: " + params.get("total_amount"));
								System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
								System.out.println("买家付款时间: " + params.get("gmt_payment"));
								System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));
								// 更新订单状态
								Order order = orderService.queryById(Integer.parseInt(tradeNo));
								order.setCheckoutTime(LocalDateTime.now());
								order.setPaymentMethod("支付宝");
								order.setStatus("已完成");
								orderService.updateById(order);
						}
						return "success";
				}
				log.info("支付失败");
				return "fail";

		}
}

