package com.jpaApi4.demo.service;


import com.jpaApi4.demo.dto.TemaDTO;
import com.jpaApi4.demo.model.Tema;

import java.util.List;
import java.util.UUID;

public interface ITemaService {
    public List<Tema> findAllTemas();
    public Tema findById(UUID id);
    public void createTema(Tema newTema);
    public void createTemaDto(TemaDTO newTema);
    public void editTema(UUID id, TemaDTO editCurso);
    public void deleteTema(UUID id);
}
