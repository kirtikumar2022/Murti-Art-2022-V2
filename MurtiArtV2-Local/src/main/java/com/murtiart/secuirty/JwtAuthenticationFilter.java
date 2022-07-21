package com.murtiart.secuirty;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

// this class call when API hit

@Component 
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// Get Token
		String requestToken = request.getHeader("Authorization");
		
		String userName = null;
		String token = null;
		
		if (requestToken!=null && requestToken.startsWith("Bearer")) {
			
				token=	requestToken.substring(7);
				
				try {
					userName = this.jwtTokenHelper.getUserNameFromToken(token);
				} catch (IllegalArgumentException e) {
					System.out.println("Unable to get jwt token");
				} catch (ExpiredJwtException e) {
					System.out.println("Expire jwt token ");
				} catch (MalformedJwtException e) {
					System.out.println("Invalid Jwt");
				}
			
				
		} else {
			System.out.println("Jwt token does not begin with bearer");
		}

		// now Validate get Token
		if(userName!=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
			
			if (this.jwtTokenHelper.validateToken(token, userDetails )) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			} else {
				System.out.println("Invalid Jwt Token");
			}
			
		} else {
			System.out.println("User is null or context is null");
		}
		
		filterChain.doFilter(request, response);
	}
}
