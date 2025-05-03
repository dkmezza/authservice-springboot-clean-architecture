package com.mezza.authservice.application.service.impl;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.mezza.authservice.application.service.TokenBlacklistService;
import com.mezza.authservice.domain.model.BlacklistedToken;
import com.mezza.authservice.infrastructure.repository.BlacklistedTokenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenBlacklistServiceImpl implements TokenBlacklistService {

    private final BlacklistedTokenRepository tokenRepository;

    @Override
    public void blacklistToken(String token) {
        if (!tokenRepository.existsByToken(token)) {
            tokenRepository.save(
                BlacklistedToken.builder()
                    .token(token)
                    .blacklistedAt(Instant.now())
                    .build()
            );
        }
    }

    @Override
    public boolean isTokenBlacklisted(String token) {
        return tokenRepository.existsByToken(token);
    }
}
