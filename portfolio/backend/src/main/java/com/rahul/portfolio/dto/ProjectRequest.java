package com.rahul.portfolio.dto;

import jakarta.validation.constraints.*;

public record ProjectRequest(
        @NotBlank @Size(max = 150) String name,
        @NotBlank @Size(max = 2000) String description,
        @NotBlank @Size(max = 500) String technologies,
        @Size(max = 500) @Pattern(regexp = "^(https?://.*)?$", message = "must be an http(s) URL") String githubUrl,
        @Size(max = 500) @Pattern(regexp = "^(https?://.*)?$", message = "must be an http(s) URL") String liveUrl,
        @NotBlank @Pattern(regexp = "PROFESSIONAL|DEMO", message = "must be PROFESSIONAL or DEMO") String category,
        int displayOrder) {}
