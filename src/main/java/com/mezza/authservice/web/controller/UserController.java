package com.mezza.authservice.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mezza.authservice.infrastructure.security.CustomUserDetails;
import com.mezza.authservice.web.dto.UserDetailsResponse;

@RestController
@RequestMapping("/auth")
public class UserController {

    @GetMapping("/me")
    public UserDetailsResponse getUserDetails(@AuthenticationPrincipal CustomUserDetails userDetails) {
        return new UserDetailsResponse(
                userDetails.getUsername(),
                userDetails.getUser().getRoles().stream()
                        .map(role -> role.getName().name())
                        .collect(java.util.stream.Collectors.toSet())
        );
    }
}
