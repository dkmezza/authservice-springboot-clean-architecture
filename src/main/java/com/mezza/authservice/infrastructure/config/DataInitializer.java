package com.mezza.authservice.infrastructure.config;

import org.springframework.stereotype.Component;

import com.mezza.authservice.domain.model.Role;
import com.mezza.authservice.domain.model.RoleType;
import com.mezza.authservice.infrastructure.repository.RoleRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final RoleRepository roleRepository;

    @PostConstruct
    public void init() {
        if (roleRepository.findByName(RoleType.USER).isEmpty()) {
            Role userRole = Role.builder()
                .name(RoleType.USER)
                .build();
            roleRepository.save(userRole);
        }

        if (roleRepository.findByName(RoleType.ADMIN).isEmpty()) {
            Role adminRole = Role.builder()
                .name(RoleType.ADMIN)
                .build();
            roleRepository.save(adminRole);
        }
    }
}
