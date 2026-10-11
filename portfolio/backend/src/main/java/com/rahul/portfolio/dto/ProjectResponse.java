package com.rahul.portfolio.dto;

public record ProjectResponse(Long id, String name, String description, String technologies,
                              String githubUrl, String liveUrl, String category, int displayOrder) {}
