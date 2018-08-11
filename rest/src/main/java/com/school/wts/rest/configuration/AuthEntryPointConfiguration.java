package com.school.wts.rest.configuration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

/**
 * @author Youba
 *
 */
@Configuration
public class AuthEntryPointConfiguration extends BasicAuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {

		response.addHeader("WWW-Authenticate", "Basic realm -" + getRealmName());
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		writer.println("Http Status 401 " + authException.getMessage());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName("MightyJava");
		super.afterPropertiesSet();
	}
}