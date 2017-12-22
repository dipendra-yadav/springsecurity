package com.niit.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource datasource;

	// <security:http
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("configure called******");

		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/")
		.access("permitAll")
		.antMatchers("/login")
		.access("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
		
		

		.and()
		.formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/j_spring_security_check")
		.usernameParameter("j_username").passwordParameter("j_password").defaultSuccessUrl("/home")
		.failureUrl("/login?error").and().logout().logoutUrl("/j_spring_security_logout")
		.logoutSuccessUrl("/login?logout").invalidateHttpSession(true)
        .and().exceptionHandling().accessDeniedPage("/invalid-access");

	}

	// <security:authentication-manager>
	// <security:authentication-provider>
	/*
	 * public void configureGlobal(AuthenticationManagerBuilder auth) throws
	 * Exception { System.out.println("configureGlobal called*******");
	 * auth.jdbcAuthentication().dataSource(datasource)
	 * .usersByUsernameQuery("select name,password,enabled,from user where name=?"
	 * ) .authoritiesByUsernameQuery("select name,role from user where name=?");
	 * }
	 */

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configAuthentication called****");
		auth.jdbcAuthentication().dataSource(datasource)
				.usersByUsernameQuery("select name,password, enabled from user where name=?")
				.authoritiesByUsernameQuery("select name, role from user where name=?");
	}

}
