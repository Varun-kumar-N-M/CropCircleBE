
package com.formerfriendly.cropcircle.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.formerfriendly.cropcircle.dto.RegisterRequestDTO;
import com.formerfriendly.cropcircle.dto.StartupResponseDTO;
import com.formerfriendly.cropcircle.service.RegisterService;

@RestController
@RequestMapping("/api/register")
public class RegisterController {
     @Autowired
    private RegisterService registerService;

    @PostMapping
    public StartupResponseDTO handleStartup(@RequestBody RegisterRequestDTO request) {
        return registerService.processRegisterInfo(request);
    }
}
