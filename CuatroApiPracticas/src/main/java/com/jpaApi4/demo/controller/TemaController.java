package com.jpaApi4.demo.controller;

import com.jpaApi4.demo.dto.TemaDTO;
import com.jpaApi4.demo.model.Curso;
import com.jpaApi4.demo.model.Tema;
import com.jpaApi4.demo.service.ITemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tema")
public class TemaController {
    @Autowired
    ITemaService temaService;
    @GetMapping("/getAll")
    public List<Tema> getTemaList() {
        return temaService.findAllTemas();
    }
    @PostMapping("/createTema")
    public void createTema(@RequestBody TemaDTO tema) {

        temaService.createTemaDto(tema);
    }

    @PutMapping("/putTema/{id}")
    public void editTema(@PathVariable UUID id, @RequestBody TemaDTO editTema) {
        temaService.editTema(id, editTema);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTema(@PathVariable UUID id) {
            temaService.deleteTema(id);
        }
}
