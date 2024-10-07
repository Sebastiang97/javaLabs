package com.bharath.springcloud.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerReactiveAuthenticationManagerResolver;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class ResourceServerConfig {
	
	@Bean
	JwtAuthenticationConverter jwtAuthConverter() {
		
		JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
		jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("roles");
		jwtGrantedAuthoritiesConverter.setAuthorityPrefix("");
	
		
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();	
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
		
		return jwtAuthenticationConverter;
		
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		/*JwtIssuerReactiveAuthenticationManagerResolver authenticationManagerResolver = new JwtIssuerReactiveAuthenticationManagerResolver
				("https://idp.example.org/issuerOne", "https://idp.example.org/issuerTwo");

		http
				.authorizeExchange(exchanges -> exchanges
						.anyExchange().authenticated()
				)
				.oauth2ResourceServer(oauth2 -> oauth2
						.authenticationManagerResolver(authenticationManagerResolver)
				);
		*/
		//http.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthConverter());
		http.authorizeHttpRequests()
		.requestMatchers(HttpMethod.GET,"/couponapi/coupons/{code:^[A-Z]*$}")
		.hasAnyRole("USER","ADMIN")
		.requestMatchers(HttpMethod.POST,"/couponapi/coupons")
		.hasRole("ADMIN").anyRequest().authenticated();
		return http.build();
		
		//return http.build();
	}
}
