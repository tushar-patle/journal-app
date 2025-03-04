package com.tushar.journal.controller;

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
@RequestMapping("/public")
public class PublicController {
	
	@Autowired
	private UserMethodsService userMethodsService;
	
	// create new user in user db
	@PostMapping("/create-user")
	public ResponseEntity<User> createUserEntry(@RequestBody User newUserEntry) {
		try {
			userMethodsService.saveNewEntry(newUserEntry);
			return new ResponseEntity<>(newUserEntry, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/create-admin")
	public ResponseEntity<User> createAdminEntry(@RequestBody User newAdminEntry) {
		try {
			userMethodsService.saveAdmin(newAdminEntry);
			return new ResponseEntity<>(newAdminEntry, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/health-check")
	public String healthCheck() {
		return "OK";
	}
}
