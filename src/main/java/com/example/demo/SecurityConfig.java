package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception{
		authenticationMgr.inMemoryAuthentication()
		.withUser("devuser").password("{noop}dev").authorities("ROLE_USER")
		.and()
		.withUser("adminuser").password("{noop}admin").authorities("ROLE_USER","ROLE_ADMIN");
	}
	
	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		.antMatchers("/protectedByUserRole*").hasRole("USER")
		.antMatchers("/protectedByAdminRole*").hasRole("ADMIN")
		.antMatchers("/","/notprotected*").permitAll()
		.and()
		.httpBasic();
	}

}
