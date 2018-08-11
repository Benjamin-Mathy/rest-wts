package com.school.wts.rest.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Youba
 *
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private DataSource dataSource;
	
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.
			jdbcAuthentication()
				.usersByUsernameQuery(usersQuery)
				.authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource)
				.passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/", "/test").permitAll()
		.antMatchers("/user/").hasAnyRole("USER","ADMIN")
		.antMatchers("/admin/").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().httpBasic()
		.and().csrf().disable();
		
		
//		.headers().frameOptions().disable();
		
//		http.authorizeRequests()
//			.antMatchers("/", "/test").permitAll()
//			.antMatchers("/user/").hasRole("USER")
//			.antMatchers("/admin/").hasRole("ADMIN")
//			.anyRequest().authenticated();
//			.and().csrf().disable().formLogin()
//			.loginProcessingUrl("/login").usernameParameter("login").passwordParameter("password");
	}
}
