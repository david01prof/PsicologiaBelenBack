package com.project.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import com.project.security.service_implement.UserDetailImplement;

public class JwtTokenFilter extends OncePerRequestFilter {

	// Se ejecuta por cada peticion y valida cada token

	private final static Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	UserDetailImplement userDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
		
		try {
			String token = getToken(req);

			if (token != null && jwtProvider.validateToken(token)) {
				String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
				UserDetails userdetails = userDetailService.loadUserByUsername(nombreUsuario);

				UsernamePasswordAuthenticationToken auth = 
						new UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		} catch (Exception e) {
			logger.error("fail en el metodo doFilter " + e.getMessage());
		}

		filterChain.doFilter(req, res);

	}

	private String getToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");

		if (header != null && header.startsWith("Bearer"))
			return header.replace("Bearer ", "");

		return null;
	}

}
