package com.tushar.journal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tushar.journal.entity.User;
import com.tushar.journal.service.UserMethodsService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserMethodsService userMethodsService;

	private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	// fetch all the user entries for admin
	/*
	 * @GetMapping() public ResponseEntity<?> getAllUserEntries() { List<User>
	 * allUserEntries = userMethodsService.getAllUserEntries(); return new
	 * ResponseEntity<>(allUserEntries, HttpStatus.OK); }
	 */

	// fetch user entry of authenticated and authorized user
	@GetMapping()
	public ResponseEntity<?> getAllUserEntries() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		User userEntry = userMethodsService.getAllUserEntries(username);
		return new ResponseEntity<>(userEntry, HttpStatus.OK);
	}

	// update existing user details of authenticated and authorized user
	@PutMapping()
	public ResponseEntity<User> updateUserEntry(@RequestBody User newuserEntry) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User oldUserEntry = userMethodsService.getAllUserEntries(username);
		oldUserEntry.setUsername(newuserEntry.getUsername());
		oldUserEntry.setPassword(passwordEncoder.encode(newuserEntry.getPassword()));
		userMethodsService.saveEntry(oldUserEntry);
		return new ResponseEntity<>(oldUserEntry, HttpStatus.OK);
	}

	// delete existing entry of authenticated and authoorized user
	@DeleteMapping()
	public ResponseEntity<?> deleteUserEntry() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User userEntry = userMethodsService.getAllUserEntries(username);
		userMethodsService.deleteEntry(userEntry);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
