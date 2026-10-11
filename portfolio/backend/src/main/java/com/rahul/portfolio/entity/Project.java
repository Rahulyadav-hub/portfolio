package com.rahul.portfolio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150) private String name;
    @Column(nullable = false, length = 2000) private String description;
    @Column(nullable = false, length = 500) private String technologies;
    @Column(name = "github_url", length = 500) private String githubUrl;
    @Column(name = "live_url", length = 500) private String liveUrl;
    @Column(nullable = false, length = 30) private String category;
    @Column(name = "display_order", nullable = false) private int displayOrder;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getTechnologies() { return technologies; }
    public void setTechnologies(String technologies) { this.technologies = technologies; }
    public String getGithubUrl() { return githubUrl; }
    public void setGithubUrl(String githubUrl) { this.githubUrl = githubUrl; }
    public String getLiveUrl() { return liveUrl; }
    public void setLiveUrl(String liveUrl) { this.liveUrl = liveUrl; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getDisplayOrder() { return displayOrder; }
    public void setDisplayOrder(int displayOrder) { this.displayOrder = displayOrder; }
}
