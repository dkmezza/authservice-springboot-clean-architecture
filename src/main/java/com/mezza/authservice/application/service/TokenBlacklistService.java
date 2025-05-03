package com.mezza.authservice.application.service;

public interface TokenBlacklistService {
    void blacklistToken(String token);
    boolean isTokenBlacklisted(String token);
}
