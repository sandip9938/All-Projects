package com.sp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LinkVaultController { // Fixed typo in class name

    @GetMapping("/")
    public String welcomePage() {
        return "welcome"; // Ensure there's a 'welcome.jsp' in /WEB-INF/views/
    }
}
