package com.cognixia.jump.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import io.swagger.models.HttpMethod;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService uDetailsService;
	
	// configuration for authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication()
			.withUser("user") // user with this password allowed access
			.password(passwordEncoder().encode("password")) // encoding password
			.roles("USER_ROLE")
			.and()                // can add more users with and method
			.withUser("admin")
			.password(passwordEncoder().encode("password1234"))
			.roles("ADMIN_ROLE");
		
		
		auth.userDetailsService(uDetailsService);
	};
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	// go from most restrictive to least
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/api/admin").hasRole("ADMIN_ROLE")
		.antMatchers("/api/car").hasRole("USER_ROLE")
		.antMatchers("/api/car/*").hasRole("ADMIN_ROLE")
		.antMatchers("/error").permitAll()
		.and()
		.formLogin()
		.and().httpBasic();
	
	}

}
