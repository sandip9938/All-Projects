package com.sp.bazario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sp")
public class BazarioApplication {
    public static void main(String[] args) {
        SpringApplication.run(BazarioApplication.class, args);
    }
}

