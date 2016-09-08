package com.ezdi.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@EnableGlobalMethodSecurity(prePostEnabled=true)
public class Dummy2SecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(HttpSecurity http) throws Exception {
		
		/*
		 * VERY IMPORTANT ==> CALL super.configure(http); !!!
		 */
		super.configure(http);
		http.authorizeRequests()
		.antMatchers("/user/add**").hasAuthority("ROLE_ADD_PERMISSION")
		.antMatchers(HttpMethod.POST,"/user/edit**").hasAnyAuthority("ROLE_ADD_PERMISSION","ROLE_EDIT_PERMISSION")
		.antMatchers(HttpMethod.DELETE, "/user/user**").hasAuthority("ROLE_DELETE_PERMISSION")
		.antMatchers(HttpMethod.GET,"/user/user**").hasAnyAuthority("ROLE_READ_PERMISSION")
		.antMatchers("/user/me").permitAll()
		.and()
		.csrf().disable();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("trump").password("pass").authorities("ROLE_ADD_PERMISSION","ROLE_EDIT_PERMISSION","ROLE_DELETE_PERMISSION","ROLE_READ_PERMISSION")
			.and()
			.withUser("clinton").password("pass").authorities("ROLE_READ_PERMISSION");
	}


	private static final Logger LOGGER = Logger.getLogger(Dummy2SecurityConfig.class);
}
