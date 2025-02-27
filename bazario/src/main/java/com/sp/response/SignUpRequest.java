package com.sp.response;

import lombok.Data;

@Data
public class SignUpRequest {

    private String fullName;
    private String email;
    private String otp;


}
