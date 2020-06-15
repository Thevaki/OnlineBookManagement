package com.libraryManagementSystem.AuthService.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.libraryManagementSystem.AuthService.Model.AppUser;
import com.libraryManagementSystem.AuthService.Repository.UserRepository;

/*loads the user from the database by the given username*/
@Service
public class UserDetailsServiceImpl implements UserDetailsService  {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		AppUser appUser = userRepository.findByUsername(username); //get user from database
//		if(appUser==null)
//			throw new UsernameNotFoundException("User 404");
		
			if(appUser.getUsername().equals(username)) {
				
				List<GrantedAuthority> grantedAuthorities = AuthorityUtils
		                	.commaSeparatedStringToAuthorityList("ROLE_" + appUser.getRole()); //compare roles with the provided role
				
				return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities); //User clss provided by spring for authentication
			}
		
		
		throw new UsernameNotFoundException("Username: " + username + " not found");
	}

}
