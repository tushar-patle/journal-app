package com.tushar.journal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.journal.entity.User;
import com.tushar.journal.service.UserMethodsService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserMethodsService userMethodsService;
	
	@GetMapping("/all-users")
	public ResponseEntity<?> getAllUser() {
		List<User> allUserEntries = userMethodsService.getAllUserEntries();
		if(allUserEntries != null && !allUserEntries.isEmpty()) {
			return new ResponseEntity<>(allUserEntries, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/create-admin-user")
	public ResponseEntity<User> createUser(@RequestBody User newUser) {
		try {
			userMethodsService.saveNewEntry(newUser);
			return new ResponseEntity<>(newUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
