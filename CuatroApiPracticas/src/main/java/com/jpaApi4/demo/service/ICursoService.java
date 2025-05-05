package com.jpaApi4.demo.service;

import com.jpaApi4.demo.model.Curso;
import com.jpaApi4.demo.model.Tema;

import java.util.List;
import java.util.UUID;

public interface ICursoService {

    public List<Curso> findAllCursos();
    public Curso findById(UUID id);
    public void createCurso(Curso newCurso);
    public void editCurso(UUID id, Curso editCurso);
    public List<Curso> getCursoByName(String name);
    public void deleteCurso(UUID id);
    public List<Tema> findAllTemas(UUID id);
}
