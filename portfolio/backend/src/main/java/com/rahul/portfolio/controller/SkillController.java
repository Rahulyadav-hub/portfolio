package com.rahul.portfolio.controller;

import com.rahul.portfolio.dto.SkillResponse;
import com.rahul.portfolio.service.SkillService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
    private final SkillService service;

    public SkillController(SkillService service) { this.service = service; }

    @GetMapping public List<SkillResponse> all() { return service.findAll(); }
}
