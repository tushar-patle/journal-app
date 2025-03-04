package com.tushar.journal.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import com.tushar.journal.entity.User;

import com.tushar.journal.repository.UserRepository;

@Disabled
public class UserDetailsServiceImplTests {

	@InjectMocks
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Mock
	private UserRepository userRepository;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void loadUserByUsernameTest() {
		when(userRepository.findByUsername(ArgumentMatchers.anyString())).thenReturn(User.builder().username("TusharOne").password("jhjvjkjhkk").roles(new ArrayList<>()).build());
		UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername("TusharOne");
		assertNotNull(userDetails);
	}
}
