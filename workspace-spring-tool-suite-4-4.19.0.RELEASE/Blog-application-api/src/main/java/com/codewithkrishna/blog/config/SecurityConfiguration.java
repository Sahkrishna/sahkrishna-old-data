package com.codewithkrishna.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private CustomUserDetailService customeUserDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
//		http.csrf().disable().authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
		
		http.authorizeHttpRequests((authorize)->authorize
				.anyRequest()
				.authenticated())
		.httpBasic(Customizer.withDefaults());
		http.authenticationProvider(this.daoAuthenticationProvider());
		DefaultSecurityFilterChain build = http.build();
		
		return build;
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(this.customeUserDetailsService);
		provider.setPasswordEncoder(this.passwordEncoder());
		
		return provider;
		
	}
//	@Bean
//	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration configuration) throws Exception {
//		
//		return configuration.getAuthenticationManager();
//	}

}
