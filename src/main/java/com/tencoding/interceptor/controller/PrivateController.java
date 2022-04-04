package com.tencoding.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tencoding.interceptor.Auth;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/private")
@Auth // 직접 정의한 어노테션을 사용
public class PrivateController {

	@GetMapping("/hello")
	public String hello() {
		log.info("private hello controller");
		return "private hello";
	}
}
