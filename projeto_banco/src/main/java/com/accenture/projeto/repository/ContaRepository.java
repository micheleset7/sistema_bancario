package com.accenture.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.projeto.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> { 
	
}

