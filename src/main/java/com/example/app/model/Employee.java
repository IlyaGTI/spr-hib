package com.example.app.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    @ManyToOne
    @JoinColumn(name = "empl_id", insertable = false, updatable = false)
    private Position position;

    @ManyToMany(mappedBy = "employees")
    private Set<Project> projects;

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Employee() {
    }

    public Employee(Long id, String name, String surname, Position position, Set<Project> projects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.projects = projects;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}