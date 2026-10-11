package com.rahul.portfolio.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.rahul.portfolio.dto.ProjectRequest;
import com.rahul.portfolio.entity.Project;
import com.rahul.portfolio.exception.NotFoundException;
import com.rahul.portfolio.repository.ProjectRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class ProjectServiceTest {
    private final ProjectRepository repo = mock(ProjectRepository.class);
    private final ProjectService service = new ProjectService(repo);

    @Test void createTrimsAndSaves() {
        when(repo.save(any(Project.class))).thenAnswer(i -> i.getArgument(0));
        var res = service.create(new ProjectRequest(" App ", "desc", "Java", "", null, "DEMO", 1));
        assertEquals("App", res.name());
        assertNull(res.githubUrl());
    }

    @Test void missingProjectThrows() {
        when(repo.findById(9L)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> service.findById(9L));
    }
}
