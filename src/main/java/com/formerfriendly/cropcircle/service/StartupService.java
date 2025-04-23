package com.formerfriendly.cropcircle.service;

import com.formerfriendly.cropcircle.dto.StartupRequestDTO;
import com.formerfriendly.cropcircle.dto.StartupResponseDTO;
import com.formerfriendly.cropcircle.entity.StartupInfo;
import com.formerfriendly.cropcircle.repository.StartupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StartupService {

    @Autowired
    private StartupRepository startupRepository;

    public StartupResponseDTO processStartupInfo(StartupRequestDTO request) {
        try {
            StartupInfo info = StartupInfo.builder()
                    .odid(request.getOdid())
                    .device(request.getDevice())
                    .build(request.getBuild())
                    .idfv(request.getIdfv())
                    .idfa(request.getIdfa())
                    .deviceModel(request.getDeviceModel())
                    .deviceName(request.getDeviceName())
                    .osName(request.getOsName())
                    .osVersion(request.getOsVersion())
                    .osOtherInfo(request.getOsOtherInfo())
                    .deviceLocalizedModel(request.getDeviceLocalizedModel())
                    .deviceManufacturer(request.getDeviceManufacturer())
                    .bundleId(request.getBundleId())
                    .countryCode(request.getCountryCode())
                    .countryName(request.getCountryName())
                    .systemLocale(request.getSystemLocale())
                    .currentLocale(request.getCurrentLocale())
                    .availableExternalMemory(request.getAvailableExternalMemory())
                    .totalExternalMemory(request.getTotalExternalMemory())
                    .availableInternalMemory(request.getAvailableInternalMemory())
                    .totalInternalMemory(request.getTotalInternalMemory())
                    .availableRam(request.getAvailableRam())
                    .totalRam(request.getTotalRam())
                    .build();

            // Save to database
            startupRepository.save(info);

            // Return response DTO
            return new StartupResponseDTO("Startup info received  successfully.");

        } catch (Exception e) {
            // Log and throw the error for proper debugging
            e.printStackTrace();
            return new StartupResponseDTO("Error occurred while processing startup info.");
        }
    }
}
