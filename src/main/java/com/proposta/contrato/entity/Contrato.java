package com.proposta.contrato.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table
@Data
public class Contrato {

	@Id
	@GeneratedValue
	private Long id;
	
	private Long codigoProposta;
	private Long codigoCliente;
	
	@Temporal(TemporalType.DATE)
	private Date dataContrato;
	
	private BigDecimal valorContrato;
	
	
}
