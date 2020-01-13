package br.com.soc.soctest.respository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.soc.soctest.model.Paciente;
import br.com.soc.soctest.model.Paciente.PacienteBuilder;
import br.com.soc.soctest.model.Sexo;

public class PacienteRepository extends AbstractRepository<Paciente> {
	
	
	public void save(Paciente paciente) {
		StringBuilder insert = new StringBuilder();
		insert.append("INSERT INTO public.paciente")
		      .append("(nome, sobrenome, cpf, rg, nascimento, sexo) ")
		      .append("VALUES (?, ?, ?, ?, ?, ?);");
		
		saveOrUpdate(paciente, insert.toString());
	}
	
	public void merge(Paciente paciente) {
		StringBuilder update = new StringBuilder();
		update.append("UPDATE public.paciente ")
	      	  .append("SET nome=?, sobrenome=?, cpf=?, rg=?, nascimento=?, sexo=? ")
	      	  .append("WHERE codigo_paciente=?;");
		
		saveOrUpdate(paciente, update.toString());
	}
	
	public void remove(Long codigo) {
		remove(Paciente.builder().codigo(codigo).build());
	}
	
	@Override
	public void remove(Paciente paciente) {
		StringBuilder delete = new StringBuilder();		
		delete.append("DELETE FROM public.paciente ")
			  .append("WHERE codigo_paciente=?;");
		
		this.remove(paciente.getCodigo(),delete.toString());
	}
	
	public Paciente find(Long codigo) {
		return find(Paciente.builder().codigo(codigo).build());
	}
	
	@Override
	public Paciente find(Paciente paciente) {
		StringBuilder select = new StringBuilder();		
		select.append("SELECT * FROM public.paciente ")
			  .append("WHERE codigo_paciente=?;");
		
		return find(paciente.getCodigo(), select.toString());
	}	
	
	public List<Paciente> findAll() {
		return findAll("select * from public.paciente order by nome;");
	}

	
	@Override
	public Paciente buildResultSet(ResultSet resultSet) throws SQLException {
		PacienteBuilder builder = Paciente.builder()
					.codigo(resultSet.getLong("codigo_paciente"))
					.nome(resultSet.getString("nome"))
					.sobrenome(resultSet.getString("sobrenome"))
					.CPF(resultSet.getString("cpf"))
					.RG(resultSet.getString("rg"))
					.nascimento(resultSet.getDate("nascimento"))
					.sexo(Sexo.valueOf(resultSet.getString("sexo")));
		
		return builder.build();
	}

	
	@Override
	public PreparedStatement buildPreparedStatement(Paciente paciente,PreparedStatement preparedStatement) throws SQLException {
		
		preparedStatement.setString(1, paciente.getNome().toUpperCase());
		preparedStatement.setString(2, paciente.getSobrenome().toUpperCase());
		preparedStatement.setString(3, paciente.getCPF().toUpperCase());
		preparedStatement.setString(4, paciente.getRG().toUpperCase());
		preparedStatement.setDate(5, new Date(paciente.getNascimento().getTime()));			
		preparedStatement.setString(6, paciente.getSexo().name());
		if(paciente.getCodigo()!=null) {
			preparedStatement.setLong(7, paciente.getCodigo());
		}
		return preparedStatement;
	}
	
}
