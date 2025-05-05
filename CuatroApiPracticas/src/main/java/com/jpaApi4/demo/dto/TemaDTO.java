package com.jpaApi4.demo.dto;

import java.util.UUID;

public class TemaDTO {

    private String name, description;
    private UUID id_curso;

    public TemaDTO() {
    }

    public TemaDTO(UUID id_curso) {
        this.id_curso = id_curso;
    }

    public TemaDTO(String name, String description, UUID id_curso) {
        this.name = name;
        this.description = description;
        this.id_curso = id_curso;
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

    public UUID getId_curso() {
        return id_curso;
    }

    public void setId_curso(UUID id_curso) {
        this.id_curso = id_curso;
    }
}
