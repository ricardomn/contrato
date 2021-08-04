package com.proposta.contrato.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proposta.contrato.entity.Contrato;
import com.proposta.contrato.repository.ContratoRepository;

@RestController
@RequestMapping("/contrato")
public class ContratoController {
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	@PostMapping
	public Contrato adicionar(@RequestBody Contrato contrato) {
		return contratoRepository.save(contrato);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contrato> buscar(@PathVariable Long id){
		return contratoRepository.findById(id).map(record -> ResponseEntity.ok().body(record))
		           .orElse(ResponseEntity.notFound().build());

	}
	
	@GetMapping
	public ResponseEntity<List<Contrato>> listarContratos(){
		return ResponseEntity.ok().body(contratoRepository.findAll());

	}

}
