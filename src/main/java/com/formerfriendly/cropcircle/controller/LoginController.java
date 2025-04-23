package com.formerfriendly.cropcircle.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.formerfriendly.cropcircle.dto.LoginRequestDTO;
import com.formerfriendly.cropcircle.dto.StartupResponseDTO;
import com.formerfriendly.cropcircle.service.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginController {
     @Autowired
    private LoginService loginService;

    @PostMapping
    public StartupResponseDTO handleStartup(@RequestBody LoginRequestDTO request) {
        return loginService.processLoginInfo(request);
    }
}
