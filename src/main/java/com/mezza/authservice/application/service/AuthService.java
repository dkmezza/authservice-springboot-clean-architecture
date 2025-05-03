package com.mezza.authservice.application.service;

import com.mezza.authservice.web.dto.AuthRequest;
import com.mezza.authservice.web.dto.AuthResponse;

public interface AuthService {
    AuthResponse register(AuthRequest request);
    AuthResponse login(AuthRequest request);
    AuthResponse refreshToken(String refreshToken);
}
