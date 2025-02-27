package com.sp.controller;

import com.sp.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/home-api")
public class HomeController {

    @GetMapping("/message")
   public ApiResponse message()
    {
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setMessage("Welcome to Home Page ");
        return apiResponse;
    }

}
