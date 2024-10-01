package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig{
	
	@Bean
	public BCryptPasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails normalUser=User.withUsername("krishna").password(this.passEncoder().encode("password")).roles("NORMAL").build();
		
		UserDetails adminUser=User.withUsername("admin").password(this.passEncoder().encode("admin")).roles("ADMIN").build();
		
		 InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(normalUser,adminUser);
		 
		 return inMemoryUserDetailsManager;
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/users/normal")
		.hasRole("NORMAL")
		.requestMatchers("/users/admin")
		.hasRole("ADMIN")
		.anyRequest()
		.permitAll().and().formLogin();

	return http.build();
		
	}

}
