package com.sp.controller;

import com.sp.entity.User;
import com.sp.repository.UserRepository;
import com.sp.response.ApiResponse;
import com.sp.response.SignUpRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth-api")
@RequiredArgsConstructor
public class AuthController {


	private UserRepository userRepository;

	@GetMapping("/message")
	public ApiResponse message() {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage("Welcome to Home Page ");
		return apiResponse;
	}

	@PostMapping("/signup")
	public ResponseEntity<User> createUserHandler(@RequestBody SignUpRequest signUpRequest) {
		User user = new User();
		user.setEmail(signUpRequest.getEmail());
		user.setFullName(signUpRequest.getFullName());
		User savedUser = userRepository.save(user);
		return ResponseEntity.ok(savedUser);
	}
}
 