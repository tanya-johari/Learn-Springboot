package com.example.mobilt.app.ws.ui.controller;

import com.example.mobilt.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.mobilt.app.ws.ui.model.request.UserDetailsRequestModel;
import com.example.mobilt.app.ws.ui.model.response.UserRest;
import com.example.mobilt.app.ws.userservice.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // http://localhost:8080/users

public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping()
	public String getUser(@RequestParam(value="page", defaultValue="1") int page, 
			@RequestParam(value="limit", defaultValue="50") int limit, 
			@RequestParam(value="sort", defaultValue="desc", required=false) String sort) {
		return "get user was called with page = " + page + " and limit = " + limit + " and sort = " + sort;
	}
	
	@GetMapping(path="/{userId}", produces =
			{MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
		UserRest fetchedUserDetails = userService.getUser(userId);
		if (fetchedUserDetails != null) {
			return new ResponseEntity<>(fetchedUserDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
				 produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

			UserRest returnUser = userService.createUser(userDetails);
        return new ResponseEntity<>(returnUser, HttpStatus.OK);
	}
	
	@PutMapping(path="/{userId}",
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> updateUser(@PathVariable String userId,
											   @RequestBody UpdateUserDetailsRequestModel userDetails) {
		UserRest updatedUserDetails = userService.updateUser(userId, userDetails);
		if (updatedUserDetails == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(updatedUserDetails, HttpStatus.OK);
	}
	
	@DeleteMapping(path="/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		userService.deleteUser(userId);
		return ResponseEntity.noContent().build();
	}
}
