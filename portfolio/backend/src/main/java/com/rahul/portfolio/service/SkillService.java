package com.rahul.portfolio.service;

import com.rahul.portfolio.dto.SkillResponse;
import com.rahul.portfolio.repository.SkillRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
    private final SkillRepository repo;

    public SkillService(SkillRepository repo) { this.repo = repo; }

    public List<SkillResponse> findAll() {
        return repo.findAllByOrderByDisplayOrderAsc().stream()
                .map(s -> new SkillResponse(s.getId(), s.getName(), s.getCategory())).toList();
    }
}
