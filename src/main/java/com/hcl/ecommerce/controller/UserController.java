package com.hcl.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.LoginDTO;
import com.hcl.ecommerce.dto.UserDTO;
import com.hcl.ecommerce.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class UserController {

	private static final Logger lOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping("/user")
	public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
		lOGGER.info("inside registration");
		userService.registerUser(userDTO);
		return new ResponseEntity<>("Registration Successfull", HttpStatus.CREATED);

	}
	@PutMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO){
		userService.loginUser(loginDTO);
		lOGGER.info("logging in");
		return new ResponseEntity<>("Login Successfull", HttpStatus.OK);
	}
	
	@GetMapping("/users/{role}")
	public ResponseEntity<List<UserDTO>> getUsers(@PathVariable("role") String role){
		List<UserDTO> users = userService.getUsers(role);
		return new ResponseEntity<>(users,HttpStatus.OK);
	}
}
