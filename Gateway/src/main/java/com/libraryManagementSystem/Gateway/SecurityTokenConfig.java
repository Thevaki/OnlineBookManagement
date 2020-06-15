package com.libraryManagementSystem.Gateway;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private JwtConfig jwtConfig;
 
	@Override
  	protected void configure(HttpSecurity http) throws Exception {
    	   http
				   .addFilterBefore(corsFilter(), SessionManagementFilter.class)
		.csrf().disable()
	 	    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //session won't be used to store user's state.
		.and()
		    .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)) // handle authorized attempts
		.and()
		   .addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
				   .authorizeRequests()
				   .antMatchers("/user/User" + "/admin/home**").access("hasRole('admin')") //must be an admin
				   .antMatchers("/book/Book" + "/createBook**").access("hasRole('admin')") //must be an admin
				   .antMatchers("/book/Book" + "/editBook**").access("hasRole('admin')") //must be an admin
				   .antMatchers("/book/Book" + "/deleteBook/{id}**").access("hasRole('admin')") //must be an admin
				   .antMatchers("/auth").permitAll() //allow who are accessing "auth" service
				   .antMatchers("/user/User" + "/createUser**").permitAll() //allow when creating a new user
				   .anyRequest().fullyAuthenticated(); //other request must be authenticated
	}
	
	@Bean
  	public JwtConfig jwtConfig() {
    	   return new JwtConfig();
  	}

//	@Bean
//	CorsFilter corsFilter() {
//		CorsFilter filter = new CorsFilter();
//		return filter;
//	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		//config.addAllowedOrigin("http://localhost:4200");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}