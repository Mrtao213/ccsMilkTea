package com.example.demo_teamanage.config;

import com.example.demo_teamanage.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

		@ExceptionHandler
		public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){
				if(ex.getMessage().contains("Duplicate entry")){
						String[] split = ex.getMessage().split(" ");
						log.info(ex.getMessage());
						return R.error(split[2]+"已存在");
				}
				return R.error("保存失败");
		}
}
