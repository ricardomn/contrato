package com.proposta.contrato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proposta.contrato.entity.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long>{

}
