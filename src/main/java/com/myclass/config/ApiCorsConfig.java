/**
 * Dec 28, 2020
 * 3:42:59 AM
 * @author LeThien
 */
package com.myclass.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class ApiCorsConfig implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry
		.addMapping("/api/**")
		.allowedOrigins("*")
		.allowedMethods("POST", "PUT", "GET", "DELETE")
		.allowCredentials(false)
		.maxAge(4800);
	}
}
