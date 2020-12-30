package com.myclass.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.myclass.filter.JwtAuthenticateFilter;

@Configuration
@EnableWebSecurity

public class ApiSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
	
//	public ApiSecurityConfig(UserDetailsService userDetailsService) {
//		this.userDetailsService = userDetailsService;
//	}

//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.cors();
		http.csrf()
		.disable()
		.antMatcher("/api/**")//Chỉ những link bắt đầu bằng /api/ thì mới thực hiện phân quyền
		.authorizeRequests()
		.antMatchers("/api/auth", 
				"/api/category", 
				"/api/role/get-all-not-admin", 
				"/api/user/add", 
				"/api/user/file/load/**",
				"/api/course/file/load/**",
				"/api/course")//Đối với link này thì không cần check thông tin đăng nhập
		.permitAll()
		.antMatchers("/api/role/**")
		.hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/api/user", "/api/user/delete/**")
		.hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/api/user/get/**")
		.hasAnyAuthority("ROLE_ADMIN","ROLE_TEACHER")
		.anyRequest()// Các link còn lại bắt buộc phải đăng nhập trước mới có thể  truy cập (cần phải có token)
		.authenticated();
		
		http.addFilter(new JwtAuthenticateFilter(authenticationManager(), userDetailsService));
		
		http.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring()
		.antMatchers("/v2/api-docs",
				"/configuration/ui",
				"/swagger-resources/**",
				"configuration/security",
				"/swagger-ui.html",
				"webjars/**");
	}
	
}
