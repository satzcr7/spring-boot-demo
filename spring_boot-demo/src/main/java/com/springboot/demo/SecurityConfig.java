package com.springboot.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("MasterSE").password("{noop}admin").roles("ADMIN","USER").and()
		.withUser("Satheesh").password("{noop}user").roles("USER").and()
		.withUser("Aayushie").password("{noop}user").roles("USER").and()
		.withUser("Rajashree").password("{noop}user").roles("USER");
	}
	
    @Override
    protected void configure(HttpSecurity http) throws Exception{
    	
    	http
    	.authorizeRequests()
    	.antMatchers("/admin/**").hasAnyRole("ADMIN")
    	.antMatchers("/emp/**").hasAnyRole("USER")
    	.antMatchers("/").permitAll()
    	.and()
    	.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//    	.anyRequest().authenticated()
    	.and()
    	.formLogin()
    	.and()
    	.httpBasic();
//    	.and().oauth2Login();
//    	http.csrf().disable();
     }
    
}



