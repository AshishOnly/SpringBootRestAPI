package com.assignment.SpringBootRestAPI.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.assignment.SpringBootRestAPI.service.EmpService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}
	
	
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		 auth.inMemoryAuthentication() 
		 .withUser("admin") 
		 .password("admin")
		 .roles("ADMIN") 
		 .and() 
		 .withUser("user") 
		 .password("user") 
		 .roles("USER");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http
		.authorizeRequests()
		.antMatchers(HttpMethod.POST).hasAnyAuthority("ADMIN", "USER")
		.antMatchers("/employee/**").hasAuthority("ADMIN")
		.antMatchers("/employees").hasAnyAuthority("ADMIN", "USER")
		.antMatchers("/deleteAllEmployees").hasAnyRole("ADMIN");
		
		http.cors().disable();
		http.csrf().disable();
	}

}
