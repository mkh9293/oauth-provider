package com.mkh.oauthdevelopers.repository;

import com.mkh.oauthdevelopers.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public static final String USERS_BY_EMAIL_CACHE = "usersByEmail";
    public static final String USERS_BY_LOGIN_CACHE = "usersByLogin";
}
