package com.rahul.portfolio.repository;

import com.rahul.portfolio.entity.Project;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByOrderByDisplayOrderAsc();
}
