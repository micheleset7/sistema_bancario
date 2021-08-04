package com.accenture.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.projeto.entity.Extrato;

public interface ExtratoRepository extends JpaRepository<Extrato,Integer> {

}
