package com.myclass.sercurity;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class JwtFillter extends BasicAuthenticationFilter{

	private UserDetailsService userDetailsService;
	
	public JwtFillter(AuthenticationManager authenticationManager,
			UserDetailsService userDetailsService) {
		super(authenticationManager);
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// lay token tu header 
		String tokenHeader = request.getHeader("Authorization");
		// kiểm tra xem token có được gửi lên hay không
		// Token có bắt đầu bằng từ khóa Bearer hay không
		if(tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
			String token = tokenHeader.replace("Bearer ", "");
			// giải mã token => lấy email
			String email = Jwts.parser()
			.setSigningKey("CYBERSOFT")
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
			// sử dụng email truy vấn db lấy thông tin user
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
			
			Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			// set thông tin user vào SecurityContext để cho Security phân quyền
			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(request, response);
		}
		else {
			response.sendError(401, "Chưa đăng nhập!");
		}
		
	}

}
