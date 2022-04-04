package com.tencoding.interceptor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tencoding.interceptor.interceptor.AuthInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private final AuthInterceptor authInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		필요한 주소를 넣거나 빼고 싶은 주소를 지정할 수 있다. 
//		registry.addInterceptor(authInterceptor).addPathPatterns("/api/private/*");
//		registry.addInterceptor(authInterceptor).excludePathPatterns("/api/private/*")
		registry.addInterceptor(authInterceptor);
	}
	
}
