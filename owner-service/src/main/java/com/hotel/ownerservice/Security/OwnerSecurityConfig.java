package com.hotel.ownerservice.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class OwnerSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private OwnerService ownerService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(ownerService);
	}

	
	
	  @Override protected void configure(HttpSecurity http) throws Exception {
	  
	  http .csrf().disable() .authorizeRequests()
	  .antMatchers("/owner/addOwner","/owner/auth")
	  .permitAll().anyRequest().authenticated()
	  .antMatchers("/Owner/**").hasAnyRole("OWNER")
	  .and().formLogin(); 
	  }
	 
	 

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();

	}

}
