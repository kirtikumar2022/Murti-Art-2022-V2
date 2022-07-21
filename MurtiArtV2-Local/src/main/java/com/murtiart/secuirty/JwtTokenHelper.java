package com.murtiart.secuirty;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenHelper {
	
	public static final long JWT_TOKEN_VALIDITY =  18000000; //5 * 60 * 60;
	
	private String secret = "jwtTokenKey";
	
	// return the user name from JWT token
	public String getUserNameFromToken(String token) {
		return getClaimFromToken(token,Claims::getSubject);
	}
	
	// return expire date from JWT token
	public Date getExpireationDateFromToken(String token) {
		return getClaimFromToken(token,Claims::getExpiration);
	}
	
	// return claim from JWT token
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimReslover) {
		final Claims claims = getAllClaimsromToken(token);
		return  claimReslover.apply(claims);
	}
	
	// return all claim from JWT token
	public Claims getAllClaimsromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}
	
	// check token expired
	public Boolean isTokenExpire(String token) {
		final Date expiration = getExpireationDateFromToken(token) ;
		return expiration.before(new Date());
	}
	
	// generate token
	public String generateToken(UserDetails userDetails) {
		Map<String,Object> claims = new HashMap<>() ;
		return doGeenrateToken(claims,userDetails.getUsername());
	}
	
	// token creation logic
	public String  doGeenrateToken(Map<String,Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 100))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	// validate token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String userName = getUserNameFromToken(token);
		return (userName.equals(userDetails.getUsername()) && !isTokenExpire(token)); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
