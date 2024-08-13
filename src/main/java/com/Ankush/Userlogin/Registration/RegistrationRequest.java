package com.Ankush.Userlogin.Registration;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class RegistrationRequest {
    private  String firstName;
    private String lastName;
    private  String email;
    private String password;
}
