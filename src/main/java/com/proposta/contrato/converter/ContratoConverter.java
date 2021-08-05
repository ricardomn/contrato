package com.proposta.contrato.converter;

import com.proposta.contrato.dto.ContratoDto;
import com.proposta.contrato.entity.Contrato;

public final class ContratoConverter {

	private ContratoConverter() {
		//não instanciar 
	}
	
	public static Contrato converter(ContratoDto contratoDto) {
		Contrato contrato = new Contrato();
		contrato.setCodigoCliente(contratoDto.getCodigoCliente());
		contrato.setCodigoProposta(contratoDto.getCodigoProposta());
		contrato.setDataContrato(contratoDto.getDataContrato());
		contrato.setValorContrato(contratoDto.getValorContrato());
		return contrato;
	}
}
