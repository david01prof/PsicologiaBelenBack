package com.project.security.jwt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {

	// Comprueba si hay un token y sino devuelve una respuesta 401

	private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);
	
	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException e) throws IOException, ServletException {
		
		logger.error("fail en el metodo commence");

		res.sendError(HttpServletResponse.SC_UNAUTHORIZED,"no autorizado");
	}

}
