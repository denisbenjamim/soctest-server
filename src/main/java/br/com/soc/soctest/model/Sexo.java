package br.com.soc.soctest.model;

public enum Sexo {
	F, M, O;

	public Sexo findByToString() {
		switch (this.toString()) {
		case "Feminino":
			return F;
		case "Masculino":
			return M;
		case "Outro":
			return O;
		}
		throw new IllegalArgumentException("Este Genero de Sexo não é valido");
	}
	
	public String descricao() {
		switch (valueOf(name())) {
		case F:
			return "Feminino";
		case M:
			return "Masculino";
		case O:
			return "Outro";
		default:
			return super.toString();
		}
	}

	/**@Override
	public String toString() {
		switch (valueOf(name())) {
		case F:
			return "Feminino";
		case M:
			return "Masculino";
		case O:
			return "Outro";
		default:
			return super.toString();
		}
	}**/
}
