package com.formerfriendly.cropcircle.controller;

import com.formerfriendly.cropcircle.dto.StartupRequestDTO;
import com.formerfriendly.cropcircle.dto.StartupResponseDTO;
import com.formerfriendly.cropcircle.service.StartupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/startup")
public class StartupController {

    @Autowired
    private StartupService startupService;

    @PostMapping
    public StartupResponseDTO handleStartup(@RequestBody StartupRequestDTO request) {
        return startupService.processStartupInfo(request);
    }
}
