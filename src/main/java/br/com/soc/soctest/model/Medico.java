package br.com.soc.soctest.model;

public class Medico {
	
	private Long codigo;
	private String nome;
	private String sobrenome;
	private String CRM;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CRM == null) ? 0 : CRM.hashCode());
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
		Medico other = (Medico) obj;
		if (CRM == null) {
			if (other.CRM != null)
				return false;
		} else if (!CRM.equals(other.CRM))
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
	public String getCRM() {
		return CRM;
	}
	public void setCRM(String cRM) {
		CRM = cRM;
	}	

	public static MedicoBuilder builder() {
		return new MedicoBuilder();
	}

	public final static class MedicoBuilder {
		private final Medico medico;
		
		public MedicoBuilder() {
			this.medico = new Medico();
		}

		public MedicoBuilder codigo(Long codigo) {
			this.medico.setCodigo(codigo);
			return this;
		}
		public MedicoBuilder nome(String nome) {
			this.medico.setNome(nome);
			return this;
		}
		public MedicoBuilder sobrenome(String sobrenome) {
			this.medico.setSobrenome(sobrenome);
			return this;
		}
		public MedicoBuilder CRM(String cRM) {
			this.medico.setCRM(cRM);
			return this;
		}
		public Medico build() {
			return this.medico;
		}
		
	}

}
