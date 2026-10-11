package com.rahul.portfolio.controller;

import com.rahul.portfolio.dto.ProjectResponse;
import com.rahul.portfolio.service.ProjectService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService service;

    public ProjectController(ProjectService service) { this.service = service; }

    @GetMapping public List<ProjectResponse> all() { return service.findAll(); }
    @GetMapping("/{id}") public ProjectResponse one(@PathVariable Long id) { return service.findById(id); }
}