package com.Allamanos.Fundacao.Repository;

import com.Allamanos.Fundacao.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> id(Long id);
}
