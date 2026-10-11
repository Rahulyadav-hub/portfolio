package com.rahul.portfolio.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100) private String name;
    @Column(nullable = false, length = 50) private String category;
    @Column(name = "display_order", nullable = false) private int displayOrder;

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getDisplayOrder() { return displayOrder; }
    public void setDisplayOrder(int displayOrder) { this.displayOrder = displayOrder; }
}
