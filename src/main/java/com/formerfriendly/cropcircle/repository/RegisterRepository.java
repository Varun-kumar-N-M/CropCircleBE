
package com.formerfriendly.cropcircle.repository;
import com.formerfriendly.cropcircle.entity.RegisterInfo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<RegisterInfo, Long> {
    Optional<RegisterInfo> findByEmailAndPassword(String email, String password);
}
