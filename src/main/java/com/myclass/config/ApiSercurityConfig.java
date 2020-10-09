package com.myclass.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

import com.myclass.sercurity.JwtFillter;

import io.jsonwebtoken.lang.Arrays;

@Configuration
@EnableWebSecurity
@ComponentScan("com.myclass")
public class ApiSercurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	// KHỞI TẠO ĐỐI TƯỢNG AUTHENTICATIONMANAGER SỬ DỤNG ĐỂ GỌI PHƯƠNG THỨC KIỂM TRA ĐĂNG NHẬP
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
			throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.antMatcher("/api/*")
		.authorizeRequests()
		.antMatchers("/api/auth/login")
		.permitAll()
		.antMatchers("/api/role/*")// <=> action.startWith("/api/role")
		.hasAnyRole("ADMIN","LEADER")// <=> roleName.equal("ROLE_ADMIN")
		.antMatchers("/api/user/*")
		.hasAnyRole("ADMIN","LEADER")
		.antMatchers("/api/target/*")
		.hasAnyRole("ADMIN","LEADER")
		.antMatchers("/api/video/*")
		.hasAnyRole("ADMIN","LEADER")
		.antMatchers("/api/category/*")
		.hasAnyRole("ADMIN","LEADER")
		.anyRequest()
		.authenticated();
		
		http.addFilter(new JwtFillter(authenticationManager(), userDetailsService));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	@Bean
    public HttpFirewall defaultHttpFirewall() {
        return new DefaultHttpFirewall();
    }
	
}
