package com.example.app.service.impl;

import com.example.app.model.Project;
import com.example.app.repository.ProjectRepo;
import com.example.app.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepo projectRepo;

    public ProjectServiceImpl(ProjectRepo projectRepo) {
        this.projectRepo = projectRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Project> getAllProjects() {
        return projectRepo.allProjects();
    }

    @Override
    @Transactional
    public Project updateProject(Project projectS) {
        Project project = projectRepo.getById(projectS.getId());
        projectRepo.updateProject(project);
        return project;
    }

    @Override
    @Transactional
    public Project createProject(Project project) {
        return projectRepo.createProject(project);
    }

    @Override
    @Transactional
    public void deleteProject(Long id) {
        Project project = projectRepo.getById(id);
        projectRepo.deleteProject(project);
    }
}
