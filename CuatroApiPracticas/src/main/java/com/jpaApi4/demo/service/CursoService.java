package com.jpaApi4.demo.service;

import com.jpaApi4.demo.model.Curso;
import com.jpaApi4.demo.model.Tema;
import com.jpaApi4.demo.repository.ICursoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;
import java.util.UUID;

@Service
public class CursoService implements ICursoService{

    private String removeAccentsAddOr(String text){
        String input = Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();

        String[] palabras = input.split("\\s+");
        String consulta = String.join(" OR ", palabras);
        return consulta;
    }

    @Autowired
    ICursoRepository cursoRepository;
    @Override
    public List<Curso> findAllCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public List<Tema> findAllTemas(UUID id) {
        Curso curso = this.findById(id);
        return curso.getListaDeTemas();
    }
    @Override
    public Curso findById(UUID id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Curso> getCursoByName(String name){
        String cleanText = removeAccentsAddOr(name);
        System.out.println(cleanText);
        return cursoRepository.findCursoByName(cleanText);
    }

    @Override
    public void deleteCurso(UUID id) {
        cursoRepository.deleteById(id);
    }

    ;
    @Override
    public void createCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public void editCurso(UUID id, Curso editCurso) {
        Curso findCurso = this.findById(id);

        if(findCurso != null) {
            findCurso.setName(editCurso.getName());
            findCurso.setModality(editCurso.getModality());
            findCurso.setEndDate(editCurso.getEndDate());
            if (editCurso.getListaDeTemas() != null && !editCurso.getListaDeTemas().isEmpty()) {
                findCurso.setListaDeTemas(editCurso.getListaDeTemas());
            }
            this.createCurso(findCurso);
        }else {
            throw new EntityNotFoundException("Curso con ID " + id + " no encontrado");
        }
    }
}
