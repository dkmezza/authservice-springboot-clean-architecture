package com.mezza.authservice.web.controller;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mezza.authservice.application.service.AuthService;
import com.mezza.authservice.application.service.TokenBlacklistService;
import com.mezza.authservice.infrastructure.security.CustomUserDetails;
import com.mezza.authservice.web.dto.AuthRequest;
import com.mezza.authservice.web.dto.AuthResponse;
import com.mezza.authservice.web.dto.UpdateProfileRequest;
import com.mezza.authservice.web.dto.UserDetailsResponse;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final TokenBlacklistService tokenBlacklistService;


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @SecurityRequirement(name = "bearer-jwt")
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);
            tokenBlacklistService.blacklistToken(jwt);
        }
        return ResponseEntity.ok().body("Logged out successfully.");
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refreshToken(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refresh_token");
        return ResponseEntity.ok(authService.refreshToken(refreshToken));
    }

    @SecurityRequirement(name = "bearer-jwt")
    @PutMapping("/profile")
    public ResponseEntity<UserDetailsResponse> updateProfile(@RequestBody UpdateProfileRequest request,
                                                             @AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(authService.updateProfile(request, userDetails.getUser()));
    }

}
