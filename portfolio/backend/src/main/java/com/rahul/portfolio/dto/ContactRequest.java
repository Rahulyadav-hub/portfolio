package com.rahul.portfolio.dto;

import jakarta.validation.constraints.*;

public record ContactRequest(
        @NotBlank @Size(min = 2, max = 100) String name,
        @NotBlank @Email @Size(max = 150) String email,
        @NotBlank @Size(min = 3, max = 200) String subject,
        @NotBlank @Size(min = 10, max = 3000) String message,
        String website) {} // honeypot: must stay empty
