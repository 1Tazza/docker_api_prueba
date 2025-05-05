package com.jpaApi4.demo.repository;

import com.jpaApi4.demo.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ICursoRepository extends JpaRepository<Curso, UUID> {

    @Query(value = "SELECT * FROM Curso WHERE to_tsvector('spanish', unaccent(name)) @@  websearch_to_tsquery('spanish', :text)", nativeQuery = true)
    List<Curso> findCursoByName(@Param("text") String text);
}
