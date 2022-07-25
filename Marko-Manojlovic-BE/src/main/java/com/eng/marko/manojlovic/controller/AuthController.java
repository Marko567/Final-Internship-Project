package com.eng.marko.manojlovic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eng.marko.manojlovic.dto.UserDto;
import com.eng.marko.manojlovic.service.security.MyUserDetails;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@CrossOrigin(origins="*")
	@PostMapping(path="/login", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<MyUserDetails> authenticateUser(UserDto userDto) throws BadCredentialsException {
		System.out.println("userDto: " + userDto);
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
	        		userDto.getUsername(), userDto.getPassword()));
	        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
	        System.out.println("user details: " + userDetails.getFirstname());
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	        return new ResponseEntity<>(userDetails, HttpStatus.OK);
		} catch(BadCredentialsException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
