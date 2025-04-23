package com.formerfriendly.cropcircle.service;
import com.formerfriendly.cropcircle.dto.StartupResponseDTO;
import com.formerfriendly.cropcircle.dto.RegisterRequestDTO;
import com.formerfriendly.cropcircle.entity.RegisterInfo;
import com.formerfriendly.cropcircle.repository.RegisterRepository;
import com.formerfriendly.cropcircle.utils.JwtUtil;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
     
    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public StartupResponseDTO processRegisterInfo(RegisterRequestDTO request) {
        try {
            RegisterInfo info = RegisterInfo.builder()
                    .odid(request.getOdid())
                    .device(request.getDevice())
                    .build(request.getBuild())
                    .email(request.getEmail())
                    .mobilenumber(request.getMobilenumber())
                    .password(request.getPassword())
                    .build();

            // Save to database
                 Optional<RegisterInfo> existingUser = Optional.empty();
            if (request.getEmail() != null && !request.getEmail().isEmpty()) {
                existingUser = registerRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());
                System.out.println(existingUser);
            } 
            if(existingUser.isPresent()){
                return new StartupResponseDTO("This user is  Already exist please Login.");
            }else{
            registerRepository.save(info);
            String token = jwtUtil.generateToken(request.getEmail());
            // Return response DTO
            return new StartupResponseDTO("Registered  successfully."+ "Token:" + token );
            }
        } catch (Exception e) {
            // Log and throw the error for proper debugging
            e.printStackTrace();
            return new StartupResponseDTO("Error occurred while processing Login info.");
        }
    }
}
