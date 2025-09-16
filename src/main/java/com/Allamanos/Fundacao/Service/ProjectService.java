package com.Allamanos.Fundacao.Service;

import com.Allamanos.Fundacao.Entity.Project;
import com.Allamanos.Fundacao.Repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Project postProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll() ;
    }
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }
    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

}
