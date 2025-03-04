package com.tushar.journal.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tushar.journal.repository.UserRepository;

@SpringBootTest
@Disabled
public class UserMethodsServiceTests {

	@Autowired
	private UserRepository userRepository;
	
	@ParameterizedTest
	@CsvSource({
		"Tushar",
		"TusharOne",
		"TusharTwo"
	})
	public void testFindByUsername(String username) {
		assertNotNull(userRepository.findByUsername(username));
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,1,2",
		"10,9,19",
		"6,7,13"
	})
	public void test(int a, int b, int c) {
		assertEquals(c, a+b);
	}
}
