package com.jpaApi4.demo.service;

import com.jpaApi4.demo.dto.TemaDTO;
import com.jpaApi4.demo.model.Curso;
import com.jpaApi4.demo.model.Tema;
import com.jpaApi4.demo.repository.ICursoRepository;
import com.jpaApi4.demo.repository.ITemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TemaService implements ITemaService{

    @Autowired
    ITemaRepository temaRepository;
    @Autowired
    ICursoRepository cursoRepository;
    @Override
    public List<Tema> findAllTemas() {
        return temaRepository.findAll();
    }

    @Override
    public Tema findById(UUID id) {
        return temaRepository.findById(id).orElse(null);
    }

    @Override
    public void createTema(Tema newTema) {
        temaRepository.save(newTema);
    }

    @Override
    public void createTemaDto(TemaDTO newTema) {
        Tema tema = new Tema();
        tema.setName(newTema.getName());
        tema.setDescription(newTema.getDescription());

        Curso curso = cursoRepository.findById(newTema.getId_curso()).orElse(null);
        if(curso != null) tema.setCurso(curso);
        this.createTema(tema);
    }

    @Override
    public void editTema(UUID id, TemaDTO editCurso) {
        Tema temaEdited = this.findById(id);
        temaEdited.setName(editCurso.getName());
        temaEdited.setDescription(editCurso.getDescription());

        UUID cursoId = editCurso.getId_curso();
        if(cursoId != null){
            Curso curso = cursoRepository.findById(cursoId).orElse(null);
            if(curso != null) temaEdited.setCurso(curso);
        }
         this.createTema(temaEdited);
    }

    @Override
    public void deleteTema(UUID id) {
        temaRepository.deleteById(id);
    }
}
