package com.example.app.service;

import java.util.List;
import com.example.app.model.Project;

public interface ProjectService {

    List<Project> getAllProjects();

    Project updateProject(Project project);

    Project createProject(Project project);

    void deleteProject(Long id);

}
