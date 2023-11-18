package com.example.mvctest.security.userDetails.repositories;

import com.example.mvctest.security.userDetails.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
