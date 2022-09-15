package com.example.app.repository;

import java.util.List;
import com.example.app.model.Project;

public interface ProjectRepo {

    List<Project> allProjects();

    void updateProject(Project project);

    Project getById(Long id);

    Project createProject(Project project);

    void deleteProject(Project project);

}
