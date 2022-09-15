package com.example.app.repository.impl;

import com.example.app.model.Project;
import com.example.app.repository.ProjectRepo;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ProjectRepoImpl implements ProjectRepo {

    private final LocalSessionFactoryBean sessionFactoryBean;

    public ProjectRepoImpl(LocalSessionFactoryBean sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
    }

    @Override
    public List<Project> allProjects() {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        return session.createQuery("from Project ").getResultList();
    }

    @Override
    public void updateProject(Project project) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        session.saveOrUpdate(project);
    }

    @Override
    public Project getById(Long id) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        return (Project) session.byId(Project.class);
    }

    @Override
    public Project createProject(Project project) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        session.save(project);
        return project;
    }

    @Override
    public void deleteProject(Project project) {
        Session session = sessionFactoryBean.getObject().getCurrentSession();
        session.delete(project);
    }
}
