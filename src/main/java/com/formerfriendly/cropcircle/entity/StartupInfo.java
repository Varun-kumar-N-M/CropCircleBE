package com.formerfriendly.cropcircle.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "crpcrcle_startup")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StartupInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String odid;
    private String device;
    private String build;
    private String idfv;
    private String idfa;

    @JsonProperty("device_model")
    private String deviceModel;

    @JsonProperty("device_name")
    private String deviceName;

    @JsonProperty("os_name")
    private String osName;

    @JsonProperty("os_version")
    private String osVersion;

    @JsonProperty("os_other_info")
    private String osOtherInfo;

    @JsonProperty("device_localized_model")
    private String deviceLocalizedModel;

    @JsonProperty("device_manufacturer")
    private String deviceManufacturer;

    @JsonProperty("bundle_id")
    private String bundleId;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("system_locale")
    private String systemLocale;

    @JsonProperty("current_locale")
    private String currentLocale;

    @JsonProperty("available_external_memory")
    private String availableExternalMemory;

    @JsonProperty("total_external_memory")
    private String totalExternalMemory;

    @JsonProperty("available_internal_memory")
    private String availableInternalMemory;

    @JsonProperty("total_internal_memory")
    private String totalInternalMemory;

    @JsonProperty("available_ram")
    private String availableRam;

    @JsonProperty("total_ram")
    private String totalRam;
}
