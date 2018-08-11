/**
 * 
 */
package com.school.wts.rest.configuration.service;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.wts.rest.entity.User;
import com.school.wts.rest.repository.UserRepository;

/**
 * @author Youba
 *
 */
@Service
public class WtsUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = userRepository.findByLogin(login);
		if (user == null) {
			throw new UsernameNotFoundException("login : " + login + "Not Found");
		}
		return new org.springframework.security.core.userdetails.User(user.getLogin(), passwordEncoder.encode(user.getPassword()),
				getGrantedAuthorities(user));
	}

	private Collection<GrantedAuthority> getGrantedAuthorities(User user) {

		Collection<GrantedAuthority> grantedAuthority = new ArrayList<>();
		if (StringUtils.isNotBlank(user.getRole())) {
			grantedAuthority.add(new SimpleGrantedAuthority(StringUtils.upperCase(user.getRole())));
		}else {
			grantedAuthority.add(new SimpleGrantedAuthority("VISITOR"));
		}
		return grantedAuthority;
	}
}