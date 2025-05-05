package com.jpaApi4.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_tema;
    @Basic
    private String name, description;
    @ManyToOne
    @JsonIgnore
    private Curso curso;

    public Tema() {}

    public Tema(String name, String description, Curso curso) {
        this.name = name;
        this.description = description;
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Tema{" +
                "id_tema=" + id_tema +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", curso=" + curso +
                '}';
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public UUID getId_tema() {
        return id_tema;
    }

    public void setId_tema(UUID id_tema) {
        this.id_tema = id_tema;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
