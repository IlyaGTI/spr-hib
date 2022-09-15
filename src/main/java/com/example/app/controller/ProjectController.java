package com.example.app.controller;

import com.example.app.controller.msg.Message;
import com.example.app.model.Employee;
import com.example.app.model.Project;
import com.example.app.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@Api
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @GetMapping("/all")
    @ApiOperation("Список всех проектов")
    public ResponseEntity<List<Project>> allProjects() {
        return new ResponseEntity(projectService.getAllProjects(), HttpStatus.OK);
    }
    @PostMapping("/create")
    @ApiOperation("Создание проекта")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return new ResponseEntity(projectService.createProject(project), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @ApiOperation("Обновление данных проекта")
    public ResponseEntity<Project> updateProject(@RequestBody Project project) {
        return new ResponseEntity(projectService.updateProject(project), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Удаление проекта")
    public ResponseEntity<Message> deleteProject(@PathVariable(name = "id") Long id) {
        projectService.deleteProject(id);
        return new ResponseEntity(new Message("Проект удален"), HttpStatus.OK);
    }
}
