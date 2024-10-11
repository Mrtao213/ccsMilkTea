package com.example.demo_teamanage.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class R <T>{
		private Integer code;

		private String msg;

		private T data;

		private Map map = new HashMap();

		public static <T> R<T> success(T object){
				R<T> r = new R<T>();
				r.code=1;
				r.data=object;
				return r;
		}

		public static <T> R<T> error(String msg){
				R r = new R();
				r.code=0;
				r.msg=msg;
				return r;
		}

		public R<T> add(String key, Objects value){
				this.map.put(key,value);
				return this;
		}
}
