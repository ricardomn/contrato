package com.proposta.contrato.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table
@Data
public class Contrato {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message = "Codigo da proposta é obrigatório")
	private Long codigoProposta;
	@NotNull(message = "Codigo do cliente é obrigatório")
	private Long codigoCliente;
	
	@NotNull(message = "Data é obrigatória")
	@Temporal(TemporalType.DATE)
	private Date dataContrato;
	
	@NotNull(message = "Valor de contrato é obrigatório")
	private BigDecimal valorContrato;
	
	
}
