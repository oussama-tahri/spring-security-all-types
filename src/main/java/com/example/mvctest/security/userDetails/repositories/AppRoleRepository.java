package com.example.mvctest.security.userDetails.repositories;

import com.example.mvctest.security.userDetails.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,String> {
}
