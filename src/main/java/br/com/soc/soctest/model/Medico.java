package br.com.soc.soctest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder 
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(of = "CRM")
public class Medico {
	
	private Long codigo;
	private String nome;
	private String sobrenome;
	private String CRM;	
		
}
