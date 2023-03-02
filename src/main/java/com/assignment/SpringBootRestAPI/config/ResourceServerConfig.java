package com.assignment.SpringBootRestAPI.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId("restapi-resource");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and()
				/*
				 * .authorizeRequests().antMatchers(HttpMethod.POST,
				 * "/employee").hasRole("ADMIN") .antMatchers(HttpMethod.PUT,
				 * "/employee/**").hasRole("USER") .antMatchers(HttpMethod.GET,
				 * "/findByNameAndDesignation/**").hasRole("USER")
				 * .antMatchers(HttpMethod.DELETE, "/deleteAllEmployees/**").hasRole("USER")
				 * .antMatchers(HttpMethod.GET, "/employees").hasAnyRole("ADMIN", "USER")
				 */
				.antMatcher("/**").authorizeRequests().anyRequest().authenticated().and().csrf().disable().cors()
				.disable();
	}

}
