package com.mkh.oauthdevelopers.repository;

import com.mkh.oauthdevelopers.domain.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppRepository extends JpaRepository<App, String> {

}
