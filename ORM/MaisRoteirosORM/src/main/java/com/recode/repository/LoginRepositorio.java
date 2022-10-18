package com.recode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recode.model.Login;

public interface LoginRepositorio extends JpaRepository<Login, Long>{

}
