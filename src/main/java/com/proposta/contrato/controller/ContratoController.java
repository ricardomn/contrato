package com.proposta.contrato.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.proposta.contrato.dto.ContratoDto;
import com.proposta.contrato.entity.Contrato;
import com.proposta.contrato.exception.ContratoException;
import com.proposta.contrato.repository.ContratoRepository;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/contrato")
public class ContratoController {
	
	@Autowired
	private ContratoRepository contratoRepository;
	
	@ApiOperation(value = "Adiciona um contrato")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Adiciona um contrato de acordo com o json passado ao servico"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@PostMapping(produces="application/json", consumes = "application/json")
	public Contrato adicionar(@Valid @RequestBody Contrato contrato) throws ContratoException {
		return contratoRepository.save(contrato);
	}
	
	@ApiOperation(value = "Retorna um contrato de acordo com o ID passado")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna um contrato de acordo com o ID passado"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<ContratoDto> buscar(@PathVariable Long id) throws ContratoException, Exception{
		Optional<Contrato> contrato = contratoRepository.findById(id);			
		
		if(contrato.isEmpty()) {
			throw new ContratoException("Contrato não encontrato: " + id);
		}
		
		ContratoDto contratoDto = new ContratoDto(contrato.get());
		
		return ResponseEntity.ok().body(contratoDto);

	}
	
	@ApiOperation(value = "Retorna uma lista de contratos")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista de contratos"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<Contrato>> listarContratos() throws ContratoException{
		return ResponseEntity.ok().body(contratoRepository.findAll());

	}
	
	@ApiOperation(value = "Atualiza um contrato")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Atualiza um contrato de acordo com  JSON contento o objeto passado ao recurso"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@PutMapping(produces="application/json", consumes = "application/json")
	public ResponseEntity<ContratoDto> atualizar(@Valid @RequestBody Contrato contrato) throws ContratoException{
		Optional<Contrato> record = contratoRepository.findById(contrato.getId());	
		
		if(record.isEmpty()) {
			throw new ContratoException("Contrato não encontrato: " + contrato.getId());
		}
		
		Contrato contratoAtualizado = contratoRepository.save(contrato);
		
		ContratoDto contratoDto = new ContratoDto(contratoAtualizado);
		return ResponseEntity.ok().body(contratoDto);
		
	}
	
	@ApiOperation(value = "Deleta um contrato de acordo com o ID passado")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Deleta um contrato de acordo com o ID passado ao recurso"),
		    @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
		    @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
		})
	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) throws ContratoException{
		
		Optional<Contrato> record = contratoRepository.findById(id);	
		
		if(record.isEmpty()) {
			throw new ContratoException("Contrato não encontrato: " + id);
		}
		
		contratoRepository.deleteById(id);
		
		return ResponseEntity.ok().build();
		
		
	}

}
