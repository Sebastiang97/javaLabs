package com.bharath.springcloud.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {


	@PostMapping("/coupons")
	public String requestBody() {
		return "hi";

	}

	@GetMapping("/coupons/{code}")
	public String getExample(@PathVariable("code") String code) {
		return "hi";
	}
}
