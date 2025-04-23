package com.formerfriendly.cropcircle.repository;
import com.formerfriendly.cropcircle.entity.StartupInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StartupRepository extends JpaRepository<StartupInfo, Long> {
}
