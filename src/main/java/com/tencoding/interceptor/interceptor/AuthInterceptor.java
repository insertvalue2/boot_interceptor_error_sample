package com.tencoding.interceptor.interceptor;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import com.tencoding.interceptor.Auth;
import com.tencoding.interceptor.exception.AuthException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

//		(ContentCachingRequestWrapper) request;
		String url = request.getRequestURI();
		URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI()).query(request.getQueryString()).build()
				.toUri();

		log.info("request url : {}", url);
		boolean hasAnnotation = checkAnnotation(handler, Auth.class);
		log.info("has annotation : {} ", hasAnnotation);

		// 나의 서버는 모두 public 으로 동작 하는데
		// Auth 권한을 가진 요청에 대해서는 보통 세션, 쿠키로 처리 여기서는 query 로 연습 합니다.
		// Auth 어노테이션을 가지고 있는 녀셕은 권한을 체크를 합니다.
		if (hasAnnotation) {
			// 권한 체크
			String query = uri.getQuery();
			log.info("query : {} ", query);
			if (query.equals("name=mark")) {
				return true;
			}
			// <<<<<< 여기 부분에서 널 포인트 발생 !!!  >>>>>>>>>>>>>
			throw new AuthException();
		}

		return true; // true 일 때 컨트롤러로 이동
	}

	public boolean checkAnnotation(Object handler, Class clazz) {
		// resource javascript, html ... pass
		if (handler instanceof ResourceHttpRequestHandler) {
			return true;
		}

		// annotation check
		HandlerMethod handlerMethod = (HandlerMethod) handler;
		if (null != handlerMethod.getMethodAnnotation(clazz)
				|| null != handlerMethod.getBeanType().getAnnotation(clazz)) {
			// Auth annotation 이 있을 때는 무조건 true
			return true;
		}
		return false;
	}
}
