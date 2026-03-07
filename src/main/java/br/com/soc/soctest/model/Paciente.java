package br.com.soc.soctest.model;

import java.util.Date;

public class Paciente {
	
	private Long codigo;
	private String nome;
	private String sobrenome;
	private String CPF;
	private String RG;	
	private Date nascimento;
	private Sexo sexo;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
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
		Paciente other = (Paciente) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		return true;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}	

	public static PacienteBuilder builder() {
		return new PacienteBuilder();
	}
	public final static class PacienteBuilder {
		private final Paciente paciente;
		
		public PacienteBuilder() {
			this.paciente = new Paciente();
		}

		public PacienteBuilder codigo(Long codigo) {
			this.paciente.codigo = codigo;
			return this;
		}
		public PacienteBuilder nome(String nome) {
			this.paciente.nome = nome;
			return this;
		}
		public PacienteBuilder sobrenome(String sobrenome) {
			this.paciente.sobrenome = sobrenome;
			return this;
		}
		public PacienteBuilder CPF(String cPF) {
			this.paciente.CPF = cPF;
			return this;
		}
		public PacienteBuilder RG(String rG) {
			this.paciente.RG = rG;
			return this;
		}
		public PacienteBuilder nascimento(Date nascimento) {
			this.paciente.nascimento = nascimento;
			return this;
		}
		public PacienteBuilder sexo(Sexo sexo) {
			this.paciente.sexo = sexo;
			return this;
		}

		public Paciente build() {
			return this.paciente;
		}
	}
}
