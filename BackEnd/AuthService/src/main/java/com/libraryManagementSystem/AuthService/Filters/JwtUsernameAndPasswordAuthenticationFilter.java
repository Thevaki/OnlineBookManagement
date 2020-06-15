package com.libraryManagementSystem.AuthService.Filters;

import java.io.IOException;
import java.sql.Date;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.libraryManagementSystem.AuthService.Filters.JwtConfig;
import org.springframework.web.bind.annotation.CrossOrigin;

/*validate user credentials, and generate tokens*/
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter   {
	
	private AuthenticationManager authManager;
	
	private JwtConfig jwtConfig;

	public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authManager, JwtConfig jwtConfig) {
		this.authManager = authManager;
		this.jwtConfig = jwtConfig;
		
		this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(jwtConfig.getUri(), "POST")); //override the defaults uri to auth uri
	}
	
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {
			
			UserCredentials credentials = new ObjectMapper().readValue(request.getInputStream(), UserCredentials.class); //get credentials from request
			
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
					credentials.getUsername(), credentials.getPassword(), Collections.emptyList()); //create auth object for auth manager use
			
			return authManager.authenticate(authToken); //load user with load user method and authenticate the user
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/*Upon successful authentication, generate a token.*/
	@Override
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		
		Long now = System.currentTimeMillis();
		String token = Jwts.builder()
			.setSubject(auth.getName())	
			.claim("authorities", auth.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority).collect(Collectors.toList())) //Convert to list of strings to get it from gateway
			.setIssuedAt(new Date(now))
			.setExpiration(new Date(now + jwtConfig.getExpiration() * 1000))  // in milliseconds
			.signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())
			.compact();

		response.addHeader("Access-Control-Expose-Headers", "Authorization");
		response.addHeader("Access-Control-Allow-Headers", "Authorization, Origin,  Content-Type, Accept");
		response.addHeader(jwtConfig.getHeader(), jwtConfig.getPrefix() + token); // add token to header
		//response.setContentType(jwtConfig.getPrefix() + token);

	}

	private static class UserCredentials {
	    private String username, password;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		} 
	}
}

