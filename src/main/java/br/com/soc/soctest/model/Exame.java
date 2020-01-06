package br.com.soc.soctest.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder 
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Exame {
	
	private Long codigo;
	private Date emissao;
	private Date previsaoEntrega;
	private Medico solicitante;	
	private Paciente paciente;
	private String descricao;
	private String resultado;	
		
}
