package com.libraryManagementSystem.AuthService;

import javax.servlet.http.HttpServletResponse;

//import com.libraryManagementSystem.AuthService.Filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.libraryManagementSystem.AuthService.Filters.JwtConfig;
import com.libraryManagementSystem.AuthService.Filters.JwtUsernameAndPasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;

@EnableWebSecurity
public class SecurityCredentialsConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtConfig jwtConfig;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				//.addFilterBefore(corsFilter(), SessionManagementFilter.class)
		    .csrf().disable()
	            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //session won't be used to store user's state.
	        .and() 
	            .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED)) // handle an authorized attempts
	        .and()
		    .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager(), jwtConfig))	 //authenticate the user by passing user credentials
		.authorizeRequests()
		    .antMatchers(HttpMethod.POST, jwtConfig.getUri()).permitAll() //allow post requests
		    .anyRequest().authenticated(); //other requests must be authenticated
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()); //to load the user from database
	}
	
	@Bean
	public JwtConfig jwtConfig() {
        	return new JwtConfig();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

//	@Bean
//	CorsFilter corsFilter() {
//		CorsFilter filter = new CorsFilter();
//		return filter;
//	}
}
