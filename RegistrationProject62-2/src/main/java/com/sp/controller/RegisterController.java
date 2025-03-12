package com.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.sp.entity.RegisterPerson;
import com.sp.service.RegisterService;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registerPerson", new RegisterPerson());
        return "register"; // Returns register.html
    }

    @PostMapping("/register")
    public String processRegistration(RegisterPerson registerPerson, Model model) {
        String message = registerService.registerData(registerPerson);
        model.addAttribute("message", message);
        return "success"; // Redirect to success page
    }
}
