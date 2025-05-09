package com.mezza.authservice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsResponse {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
