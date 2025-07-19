package com.cafemate.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafemate.dto.LoginRequest;
import com.cafemate.dto.SignupRequest;
import com.cafemate.entity.User;
import com.cafemate.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/auth")
public class AuthController {
	private final UserRepository userRepository;

	public AuthController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

//For Sign Up
	@PostMapping("/signup")
	public String signup(@RequestBody SignupRequest request) {
		// Check if email already exists
		if (userRepository.findByEmail(request.getEmail()) != null) {
			return "Email already exists!";
		}

		// Convert DTO → Entity
		User user = new User();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());

		userRepository.save(user); // save to DB

		return "Signup successful!";
	}
//for Login

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		User user = userRepository.findByEmail(request.getEmail());
		if (user == null) {
			return "User not found!";
		}
		if (!user.getPassword().equals(request.getPassword())) {
			return "Invalid password!";
		}
		return "Login successful!";
	}

}
