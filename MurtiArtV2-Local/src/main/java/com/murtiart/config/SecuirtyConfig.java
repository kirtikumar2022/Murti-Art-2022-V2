package com.murtiart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.murtiart.secuirty.CustomUserDetailService;
import com.murtiart.secuirty.JwtAuthenticationEnteryPoint;
import com.murtiart.secuirty.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableWebMvc // For Api documentation
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecuirtyConfig extends WebSecurityConfigurerAdapter {
	
	
//	public static final String[] PUBLIC_URLS = {
//			"/api/v1/auth/**",
//			"/v3/api-docs",
//			"/v2/api-docs",
//			"/swagger-resources/**", 
//			"/swagger-ui/**",
//			"/webjars/**" 
//			};

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private JwtAuthenticationEnteryPoint authenticationEnteryPoint;
	
	@Autowired
	private JwtAuthenticationFilter authenticationFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http .csrf().disable() .authorizeHttpRequests()
		.antMatchers("/api/auth/**") .permitAll() 
		.antMatchers("/api/remotecontrol/**") .permitAll() 
		.antMatchers(HttpMethod.GET) .permitAll() // This means all get api can access without token to any one
		.anyRequest() .authenticated() 
		.and()
		.exceptionHandling().authenticationEntryPoint(this.authenticationEnteryPoint)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(this.authenticationFilter,UsernamePasswordAuthenticationFilter.class);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 auth.userDetailsService(customUserDetailService).passwordEncoder(passworEncoder());
//	 auth.userDetailsService(customUserDetailService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	@Bean
	  PasswordEncoder passworEncoder() {
		return new BCryptPasswordEncoder();
	}
 
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
