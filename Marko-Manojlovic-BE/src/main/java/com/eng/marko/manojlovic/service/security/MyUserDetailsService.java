package com.eng.marko.manojlovic.service.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eng.marko.manojlovic.entity.User;
import com.eng.marko.manojlovic.repository.UserRepository;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findById(username);
        user.orElseThrow(() -> new UsernameNotFoundException("user " + username + " ne postoji!"));
        return new MyUserDetails(user.get().getUsername(), user.get().getPassword(), user.get().getFirstName(), user.get().getLastName(), user.get().getAuthoritiesList());
	}

}
