package com.recode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.recode.model.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
	
	@EntityGraph(attributePaths = "id")
    List<Cliente> findAll();
	
}
