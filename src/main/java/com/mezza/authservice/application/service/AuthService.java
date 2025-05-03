package com.mezza.authservice.application.service;

import com.mezza.authservice.domain.model.User;
import com.mezza.authservice.web.dto.AuthRequest;
import com.mezza.authservice.web.dto.AuthResponse;
import com.mezza.authservice.web.dto.UpdateProfileRequest;
import com.mezza.authservice.web.dto.UserDetailsResponse;

public interface AuthService {
    AuthResponse register(AuthRequest request);
    AuthResponse login(AuthRequest request);
    AuthResponse refreshToken(String refreshToken);
    UserDetailsResponse updateProfile(UpdateProfileRequest request, User user);
}
