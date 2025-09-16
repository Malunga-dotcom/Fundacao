package com.Allamanos.Fundacao.controller;

import com.Allamanos.Fundacao.Entity.Project;
import com.Allamanos.Fundacao.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/project")
    public Project postProject(@RequestBody Project project)
    {
        return projectService.postProject(project);
    }

    @GetMapping("/projects")
    public List<Project> RetrieveAllProjects(){
        return projectService.getAllProjects();
    }

    @GetMapping("/project/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project= projectService.getProjectById(id);
        if(project == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(project);
    }
    @PutMapping("/project/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project)
    {
        Project extingProject = projectService.getProjectById(id);
        if(extingProject == null)
            return ResponseEntity.notFound().build();
        extingProject.setTitle(project.getTitle());
        extingProject.setDescription(project.getDescription());
        extingProject.setImageUrl(project.getImageUrl());
        extingProject.setIsFinished(project.getIsFinished());
        return ResponseEntity.ok(projectService.updateProject(extingProject));
    }

    @DeleteMapping("/project/{id}")
    public ResponseEntity<?> deleteProject( @PathVariable Long id) {
        Project existingProjectToDelete = projectService.getProjectById(id);
        if(existingProjectToDelete == null)
            return ResponseEntity.notFound().build();
        projectService.deleteProject(id);
        return ResponseEntity.ok().build();
    }
}
