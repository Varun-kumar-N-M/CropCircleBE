package com.formerfriendly.cropcircle.service;

import com.formerfriendly.cropcircle.dto.LoginRequestDTO;
import com.formerfriendly.cropcircle.dto.StartupResponseDTO;
import com.formerfriendly.cropcircle.entity.LoginInfo;
import com.formerfriendly.cropcircle.repository.LoginRepository;
import com.formerfriendly.cropcircle.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import java.util.Optional;
@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Transactional(propagation = Propagation.REQUIRED)
    public StartupResponseDTO processLoginInfo(LoginRequestDTO request) {
        try {
            // Check if both email and mobile number are empty
            if ((request.getEmail() == null || request.getEmail().isEmpty()) && 
                (request.getMobilenumber() == null || request.getMobilenumber().isEmpty())) {
                return new StartupResponseDTO("Please provide email or mobile number" + null + false);
            }
            
            Optional<LoginInfo> existingUser = Optional.empty();
            String loginIdentifier = null;
            
            // Check if email is provided
            if (request.getEmail() != null && !request.getEmail().isEmpty()) {
                existingUser = loginRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());
                loginIdentifier = request.getEmail();
            } 
            // If email is not provided or no user found, try with mobile number
            else if (request.getMobilenumber() != null && !request.getMobilenumber().isEmpty()) {
                existingUser = loginRepository.findByMobilenumberAndPassword(request.getMobilenumber(), request.getPassword());
                loginIdentifier = request.getMobilenumber();
            }
            
            if (existingUser.isPresent()) {
                LoginInfo user = existingUser.get();
                String token = jwtUtil.generateToken(user.getEmail()); // Use email for token
                return new StartupResponseDTO("Login successful"+ "Token:" + token );
            } else {
                return new StartupResponseDTO("Invalid credentials"+ null +false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new StartupResponseDTO("Error occurred during login"+ null + false);
        }
    }
}