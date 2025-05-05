package com.jpaApi4.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_curso;
    @Basic
    private String name, modality;
    @Basic
    private LocalDate endDate;
    @OneToMany(mappedBy = "curso")
    private List<Tema> listaDeTemas = new ArrayList<>();;
    public Curso() {}
    public Curso(String name, String modality, LocalDate endDate, List<Tema> listaDeTemas) {
        this.name = name;
        this.modality = modality;
        this.endDate = endDate;
        this.listaDeTemas = listaDeTemas;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Tema> getListaDeTemas() {
        return listaDeTemas;
    }

    public void setListaDeTemas(List<Tema> listaDeTemas) {
        this.listaDeTemas = listaDeTemas;
    }
}
