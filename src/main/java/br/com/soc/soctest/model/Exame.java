package br.com.soc.soctest.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exame {

	private Long codigo;
	private Date emissao;
	private Date previsaoEntrega;
	private Medico solicitante;
	private Paciente paciente;
	private String descricao;
	private String resultado;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exame other = (Exame) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public synchronized String toString() {
		StringBuilder builder = new StringBuilder();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyy");

		builder.append("\t\tcodigo: ").append(codigo).append("\n");
		builder.append("\t\tData Emissão: ").append(formatter.format(emissao)).append("\n");
		builder.append("\t\tSolicitante: ").append(solicitante.getNome() + " " + solicitante.getSobrenome())
				.append("\n");
		builder.append("\t\tPaciente: ").append(paciente.getNome() + " " + paciente.getSobrenome()).append("\n");
		builder.append("\t\tExame: ").append(descricao).append("\n");
		builder.append("\t\tresultado: ").append(resultado).append("\n\n");

		return builder.toString();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public Date getPrevisaoEntrega() {
		return previsaoEntrega;
	}

	public void setPrevisaoEntrega(Date previsaoEntrega) {
		this.previsaoEntrega = previsaoEntrega;
	}

	public Medico getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Medico solicitante) {
		this.solicitante = solicitante;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public static ExameBuilder builder() {
		return new ExameBuilder();
	}

	public final static class ExameBuilder {
		private final Exame exame;

		public ExameBuilder() {
			this.exame = new Exame();
		}

		public ExameBuilder codigo(Long codigo) {
			this.exame.setCodigo(codigo);
			return this;
		}

		public ExameBuilder emissao(Date emissao) {
			this.exame.setEmissao(emissao);
			return this;
		}

		public ExameBuilder previsaoEntrega(Date previsaoEntrega) {
			this.exame.setPrevisaoEntrega(previsaoEntrega);
			return this;
		}

		public ExameBuilder solicitante(Medico solicitante) {
			this.exame.setSolicitante(solicitante);
			return this;
		}

		public ExameBuilder paciente(Paciente paciente) {
			this.exame.setPaciente(paciente);
			return this;
		}

		public ExameBuilder descricao(String descricao) {
			this.exame.setDescricao(descricao);
			return this;
		}

		public ExameBuilder resultado(String resultado) {
			this.exame.setResultado(resultado);
			return this;
		}

		public Exame build() {
			return this.exame;
		}
		
	}
}
