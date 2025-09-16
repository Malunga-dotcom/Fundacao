package com.Allamanos.Fundacao.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String imageUrl;
    private String description;
    private Boolean isFinished;
}
