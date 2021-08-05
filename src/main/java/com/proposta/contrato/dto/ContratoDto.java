package com.proposta.contrato.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.proposta.contrato.entity.Contrato;

public class ContratoDto {

	private Long id;
	private Long codigoProposta;
	private Long codigoCliente;
	private Date dataContrato;
	private BigDecimal valorContrato;
	
	
	
	public ContratoDto(Contrato contrato) {
		super();
		this.id = contrato.getId();
		this.codigoProposta = contrato.getCodigoProposta();
		this.codigoCliente = contrato.getCodigoCliente();
		this.dataContrato = contrato.getDataContrato();
		this.valorContrato = contrato.getValorContrato();
	}
	
	public ContratoDto(Long codigoProposta, Long codigoCliente, Date dataContrato, BigDecimal valorContrato) {
		super();
		this.codigoProposta = codigoProposta;
		this.codigoCliente = codigoCliente;
		this.dataContrato = dataContrato;
		this.valorContrato = valorContrato;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCodigoProposta() {
		return codigoProposta;
	}
	public void setCodigoProposta(Long codigoProposta) {
		this.codigoProposta = codigoProposta;
	}
	public Long getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public Date getDataContrato() {
		return dataContrato;
	}
	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}
	public BigDecimal getValorContrato() {
		return valorContrato;
	}
	public void setValorContrato(BigDecimal valorContrato) {
		this.valorContrato = valorContrato;
	}
	
	
	
}
