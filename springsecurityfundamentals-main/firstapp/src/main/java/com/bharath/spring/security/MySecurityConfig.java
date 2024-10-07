package com.bharath.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class  MySecurityConfig {

	@Bean
	UserDetailsService userDetailsService (){
		InMemoryUserDetailsManager userDetailService = new InMemoryUserDetailsManager();
		UserDetails user = User.withUsername("tom")
				.password(passwordEncoder().encode(null))
				.authorities("read").build();
		userDetailService.createUser(user);
		return userDetailService;
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		http.httpBasic();
		http.authorizeRequests().anyRequest().authenticated();
		return http.build();
	}
}
