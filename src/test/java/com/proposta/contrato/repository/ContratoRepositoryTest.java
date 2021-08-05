package com.proposta.contrato.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.proposta.contrato.converter.ContratoConverter;
import com.proposta.contrato.dto.ContratoDto;
import com.proposta.contrato.entity.Contrato;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ContratoRepositoryTest {
	
	@Autowired
	private ContratoRepository contratoRepository;

	@Test
	void deverSerPossivelSalvarUmContrato() {
		ContratoDto contratoDto = new ContratoDto(1L, 1L, new Date(), BigDecimal.ONE);
		Contrato contrato = ContratoConverter.converter(contratoDto);
		contratoRepository.save(contrato);
		Integer countContrato = contratoRepository.findAll().size();
		assertEquals(1, countContrato);
	}
	
	@Test
	void deverSerPossivelVerificarValoresSalvosDeUmContrato() {
		
		ContratoDto contratoDto = new ContratoDto(3L, 4L, new Date(), BigDecimal.ONE);
		Contrato contrato = ContratoConverter.converter(contratoDto);
		Contrato record = contratoRepository.save(contrato);
		
		assertEquals(3L, record.getCodigoProposta());
		assertEquals(4L, record.getCodigoCliente());
	}
	
	@Test
	void deverSerPossivelListarContratos() {
		ContratoDto contratoDto = new ContratoDto(2L, 2L, new Date(), BigDecimal.TEN);
		Contrato contrato = ContratoConverter.converter(contratoDto);
		contratoRepository.save(contrato);
		
		ContratoDto contrato2Dto = new ContratoDto(1L, 1L, new Date(), BigDecimal.ONE);
		Contrato contrato2 = ContratoConverter.converter(contrato2Dto);
		contratoRepository.save(contrato2);
		
		
		List<Contrato> contratos = contratoRepository.findAll();
		assertTrue(contratos.size() > 1);
	}
	
	@Test
	void deverSerPossivelExcluirUmCOntrato() {
		
		ContratoDto contratoDto = new ContratoDto(1L, 1L, new Date(), BigDecimal.ONE);
		Contrato contrato = ContratoConverter.converter(contratoDto);
		contratoRepository.save(contrato);
		
		List<Contrato> contratos = contratoRepository.findAll();
		assertTrue(contratos.size() == 1);
		
		contratoRepository.deleteById(1L);
		
		List<Contrato> contratosAPosExclusao = contratoRepository.findAll();
		
		assertTrue(contratosAPosExclusao.isEmpty());
		
	}
	
	@Test
	void deverSerPossivelAtualizarContrato() {
		ContratoDto contratoDto = new ContratoDto(2L, 2L, new Date(), BigDecimal.TEN);
		Contrato contrato = ContratoConverter.converter(contratoDto);
		contrato = contratoRepository.save(contrato);
		contrato.setCodigoCliente(3L);
		Contrato record = contratoRepository.save(contrato);
		
		assertEquals(3L, record.getCodigoCliente());
	}

}
