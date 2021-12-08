 package com.project.security;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.project.security.jwt.JwtEntryPoint;
import com.project.security.jwt.JwtTokenFilter;
import com.project.security.service_implement.UserDetailImplement;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailImplement userDetailService;
	
	@Autowired
	JwtEntryPoint jwtEntryPoint;
	
	@Bean
	public JwtTokenFilter jwtTokenfilter() {
		return new JwtTokenFilter();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}


	@Override
	protected AuthenticationManager authenticationManager() throws Exception {

		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.cors().and().csrf().disable()
					.authorizeRequests()
					.antMatchers("/auth/**","/articulo/**","/seccion/**","/sobremi/**","/contacto/**").permitAll()
					.anyRequest().authenticated()
					.and()
					.exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
					.and()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtTokenfilter(),UsernamePasswordAuthenticationFilter.class);
	}
	
	
}
