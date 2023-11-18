package com.example.mvctest.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityRestController {

    @GetMapping("/profile")
    public Authentication authentication(Authentication authentication) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
}
