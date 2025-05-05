package com.jpaApi4.demo.repository;

import com.jpaApi4.demo.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ITemaRepository extends JpaRepository<Tema, UUID> {


}
