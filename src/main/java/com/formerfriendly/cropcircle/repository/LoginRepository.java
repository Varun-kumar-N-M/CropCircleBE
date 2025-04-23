package com.formerfriendly.cropcircle.repository;

import com.formerfriendly.cropcircle.entity.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginInfo, Long> {
    Optional<LoginInfo> findByEmailAndPassword(String email, String password);
    Optional<LoginInfo> findByMobilenumberAndPassword(String mobilenumber, String password);
}
