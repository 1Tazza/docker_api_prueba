package com.jpaApi4.demo.controller;

import com.jpaApi4.demo.model.Curso;
import com.jpaApi4.demo.model.Tema;
import com.jpaApi4.demo.service.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    ICursoService cursoService;
    @GetMapping("/getAll")
    public List<Curso> getCursoList() {
        return cursoService.findAllCursos();
    }
    @GetMapping("/getAllTemas/{id}")
    public List<Tema> getTemasList(@PathVariable UUID id) {
        return cursoService.findAllTemas(id);
    }

    @GetMapping("/getByName")
    public List<Curso> getCursoByName(@RequestParam String name){
        return cursoService.getCursoByName(name);
    };
    @PostMapping("/createCurso")
    public void createCurso(@RequestBody Curso curso) {
        cursoService.createCurso(curso);
    }

    @PutMapping("/putCurso/{id}")
    public void editCurso(@PathVariable UUID id, @RequestBody Curso editCurso) {
        cursoService.editCurso(id, editCurso);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCurso(@PathVariable UUID id) {
        cursoService.deleteCurso(id);
    }
}
