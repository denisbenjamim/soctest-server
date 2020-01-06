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
@EqualsAndHashCode(of = "CPF")
public class Paciente {
	
	private Long codigo;
	private String nome;
	private String sobrenome;
	private String CPF;
	private String RG;	
	private Date nascimento;
	private Sexo sexo;	
	
}
