package com.recode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recode.model.Funcionario;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long>{

	Optional<Funcionario> findByEmail(String email);
}
