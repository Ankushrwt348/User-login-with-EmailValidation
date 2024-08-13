package com.Ankush.Userlogin.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {
    @Autowired
    private RegistrationRequest registrationRequest;
    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public String test(){
        return "ok";
    }
    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        String result = registrationService.register(request);
        return result;
    }

    @GetMapping("confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
