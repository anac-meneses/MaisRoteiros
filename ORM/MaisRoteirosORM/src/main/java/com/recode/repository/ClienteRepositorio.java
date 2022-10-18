package com.recode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recode.model.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
