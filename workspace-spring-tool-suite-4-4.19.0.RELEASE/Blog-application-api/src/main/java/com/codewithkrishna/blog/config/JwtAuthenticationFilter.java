package com.codewithkrishna.blog.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserDetailsService userDetailService;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		//getting the token from request
		String requestToken = request.getHeader("Authorization");
		
		//Bearer 2345t43rt4rio43rkmfn
		System.out.println(requestToken);
		
		String userName=null;
		
		String token=null;
		
		if(request!=null&&requestToken.startsWith("Bearer")) {
			
			 token = requestToken.substring(7);
			 
			 try {
			  userName = this.jwtTokenHelper.getUserNameFromToken(token);
			 }
			 catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Exception");
			}
			 catch (ExpiredJwtException e) {
				System.out.println("JWT exception is expired");
			}
			 catch (MalformedJwtException e) {
				System.out.println("Invalid JWT");
			}
			
		}
		else {
			System.out.println("Request Token does not start with Bearer");
		}
		
		if(userName!=null&&SecurityContextHolder.getContext().getAuthentication()==null) {
			
			UserDetails userDetails = this.userDetailService.loadUserByUsername(userName);
			
			if(this.jwtTokenHelper.validateToken(token, userDetails)) {
				
				UsernamePasswordAuthenticationToken userNamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
				userNamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(userNamePasswordAuthenticationToken);
			}
			else {
				System.out.println("Invalid token");
			}
		}
		else {
			System.out.println("username is null or context is not null");
			
		}
		filterChain.doFilter(request, response);
		
	}

}
