package com.example.demo_teamanage.filter;

import com.alibaba.fastjson.JSON;
import com.example.demo_teamanage.common.R;
import com.sun.org.apache.xpath.internal.objects.XBoolean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginCheckFilter",urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
		public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();


		@Override
		public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
				HttpServletRequest request = (HttpServletRequest) servletRequest;
				HttpServletResponse response = (HttpServletResponse) servletResponse;

				String[] urls ={
								"/employee/login",
								"/user/login",
								"/backend/**",
								"/static/**",
								"/front/**",
								"/favicon.ico",
								"/alipay/pay",
								"/alipay/notify"
				};

//				获取请求路径
				String requestURI = request.getRequestURI();

//				判断请求是否需要拦截
			  boolean check = check(urls,requestURI);

//				不需要拦截直接放行
				if(check){
					log.info("本次请求不需要处理",requestURI);
					filterChain.doFilter(request,response);
					return;
				}

//				拦截请求并判断登录状态，如果已登录则放行
				log.info("拦截到请求"+requestURI);
				if(request.getSession().getAttribute("employee")!=null){
						filterChain.doFilter(request,response);
						return;
				}
				if(request.getSession().getAttribute("user")!=null){
						filterChain.doFilter(request,response);
						return;
				}

				log.info("用户未登录");
				response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));

		}

		public boolean check(String[] urls,String requestURI){
				for (String url : urls) {
						boolean match = PATH_MATCHER.match(url,requestURI);
						if(match){
								return true;
						}
				}
				return false;
		}
}
