package com.mezza.authservice.web.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetailsResponse {
    private String username;
    private Set<String> roles;
}
