package com.assignment.SpringBootRestAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.inMemoryAuthentication().withUser("admin").password("admin")
	 * .roles("ADMIN") .and().withUser("user") .password("user").roles("USER") ; }
	 */

	
	
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	public UserDetailsService userService() {
		InMemoryUserDetailsManager memory = new InMemoryUserDetailsManager();
		memory.createUser(User.withUsername("admin").password(passwordEncoder().encode("admin")).authorities("read").build());
		return memory;
	}

	/*
	 * @Bean public PasswordEncoder getPasswordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */

	
	 @Bean 
	 public BCryptPasswordEncoder passwordEncoder() { 
		 return new BCryptPasswordEncoder();
	 
	 }
	

}