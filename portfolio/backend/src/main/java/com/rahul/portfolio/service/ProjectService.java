package com.rahul.portfolio.service;

import com.rahul.portfolio.dto.*;
import com.rahul.portfolio.entity.Project;
import com.rahul.portfolio.exception.NotFoundException;
import com.rahul.portfolio.repository.ProjectRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepository repo;

    public ProjectService(ProjectRepository repo) { this.repo = repo; }

    public List<ProjectResponse> findAll() {
        return repo.findAllByOrderByDisplayOrderAsc().stream().map(this::toDto).toList();
    }

    public ProjectResponse findById(Long id) { return toDto(get(id)); }

    public ProjectResponse create(ProjectRequest r) {
        Project p = new Project();
        apply(p, r);
        return toDto(repo.save(p));
    }

    public ProjectResponse update(Long id, ProjectRequest r) {
        Project p = get(id);
        apply(p, r);
        return toDto(repo.save(p));
    }

    public void delete(Long id) { repo.delete(get(id)); }

    private Project get(Long id) {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("Project " + id + " not found"));
    }

    private void apply(Project p, ProjectRequest r) {
        p.setName(r.name().trim());
        p.setDescription(r.description().trim());
        p.setTechnologies(r.technologies().trim());
        p.setGithubUrl(blankToNull(r.githubUrl()));
        p.setLiveUrl(blankToNull(r.liveUrl()));
        p.setCategory(r.category());
        p.setDisplayOrder(r.displayOrder());
    }

    private String blankToNull(String s) { return s == null || s.isBlank() ? null : s.trim(); }

    private ProjectResponse toDto(Project p) {
        return new ProjectResponse(p.getId(), p.getName(), p.getDescription(), p.getTechnologies(),
                p.getGithubUrl(), p.getLiveUrl(), p.getCategory(), p.getDisplayOrder());
    }
}
