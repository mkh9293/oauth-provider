package com.mkh.authserver.repository;

import com.mkh.authserver.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{
    User findByUsername(String username);
}
