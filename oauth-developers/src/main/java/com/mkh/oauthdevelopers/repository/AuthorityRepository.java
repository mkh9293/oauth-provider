package com.mkh.oauthdevelopers.repository;

import com.mkh.oauthdevelopers.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
