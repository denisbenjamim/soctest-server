package br.com.soc.soctest.model;

import java.text.SimpleDateFormat;
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
		
	public synchronized String toString() {
		StringBuilder builder = new StringBuilder();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");
		
		builder.append("\t\tcodigo: ").append(codigo).append("\n");
		builder.append("\t\tData Emissão: ").append(formatter.format(emissao)).append("\n");
		builder.append("\t\tSolicitante: ").append(solicitante.getNome()+" "+solicitante.getSobrenome()).append("\n");
		builder.append("\t\tPaciente: ").append(paciente.getNome()+" "+paciente.getSobrenome()).append("\n");
		builder.append("\t\tExame: ").append(descricao).append("\n");
		builder.append("\t\tresultado: ").append(resultado).append("\n\n");
		
		return builder.toString();
	}
}
