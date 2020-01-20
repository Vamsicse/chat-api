package com.galaxy.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author VAMSI KRISHNA MYALAPALLI (vamsikrishna.vasu@gmail.com)
 *
 */
// @EnableWebSecurity
public class SecurityConfig // extends WebSecurityConfigurerAdapter {
{
	@Autowired
	DataSource dataSource;
	// This method is for Authentication
	//@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		// LDAP Authentication
		/*
		authenticationManagerBuilder.ldapAuthentication()
			.userDnPatterns("uid={0},ou=people")
			.groupSearchBase("ou=groups")
			.contextSource()
			.url("ldap://localhost:8389/dc=springframework,dc=org")
			.and()
			.passwordCompare()
			.passwordEncoder(new LdapShaPasswordEncoder())
			.passwordAttribute("userPassword");
		*/
		
		// JDBC Authentication
		/*
		authenticationManagerBuilder.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
		*/
		
		// In memory authentication
		
		authenticationManagerBuilder.inMemoryAuthentication()
		.withUser("vamsi").password("krishna").roles("USER")
		.and()
		.withUser("vasu").password("krishna").roles("ADMIN");
		
	}
	
	// This method is for Authorization
	//@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests()
			.antMatchers("/admin").hasRole("ADMIN")
			.antMatchers("/user").hasAnyRole("ADMIN", "USER")
			.antMatchers("/").permitAll()
			.and().formLogin();
	}
	
	// @Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}