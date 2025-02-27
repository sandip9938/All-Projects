package com.sp.controller;

import com.sp.entity.User;
import com.sp.response.ApiResponse;
import com.sp.response.SignUpRequest;
import com.sp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth-api")
public class AuthController {

    @Autowired(required = false)
    private AuthService authService;


    @GetMapping("/message")
    public ApiResponse message()
    {
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setMessage("Welcome to Home Page ");
        return apiResponse;
    }
    @PostMapping("/signup")
    public ResponseEntity<User> createUserHandler(@RequestBody SignUpRequest signUpRequest) {
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setFullName(signUpRequest.getFullName());
        return ResponseEntity.ok(user);
    }
}
