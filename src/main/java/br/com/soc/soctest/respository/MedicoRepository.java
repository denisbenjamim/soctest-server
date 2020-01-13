package br.com.soc.soctest.respository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.soc.soctest.model.Medico;
import br.com.soc.soctest.model.Medico.MedicoBuilder;

public class MedicoRepository extends AbstractRepository<Medico>{
	
	public void save(Medico medico) {
		StringBuilder insert = new StringBuilder();
		insert.append("INSERT INTO public.medico")
		      .append("(nome, sobrenome, crm) ")
		      .append("VALUES (?, ?, ?);");
		
		saveOrUpdate(medico, insert.toString());
	}

	public void merge(Medico medico) {
		StringBuilder update = new StringBuilder();
		update.append("UPDATE public.medico ")
	      	  .append("SET nome=?, sobrenome=?, CRM=? ")
	      	  .append("WHERE codigo_medico=?;");
		
		saveOrUpdate(medico, update.toString());
	}
	
	
	public void remove(Long codigo) {
		this.remove(Medico.builder().codigo(codigo).build());
	}

	public void remove(Medico medico) {
		
		StringBuilder delete = new StringBuilder();		
		delete.append("DELETE FROM public.medico ")
			  .append("WHERE codigo_medico=?;");
		
		this.remove(medico.getCodigo(),delete.toString());
		
	}	
	
	public Medico find(Long codigo) {
		return find(Medico.builder().codigo(codigo).build());
	}
	
	@Override
	public Medico find(Medico medico) {
		StringBuilder select = new StringBuilder();		
		select.append("SELECT * FROM public.medico ")
			  .append("WHERE codigo_medico=?;");
		
		return find(medico.getCodigo(), select.toString());
	}

	

	public List<Medico> findAll() {
		return findAll("select * from public.medico order by nome;");
	}
	
	@Override
	public PreparedStatement buildPreparedStatement(Medico medico, PreparedStatement preparedStatement)	throws SQLException {
		preparedStatement.setString(1, medico.getNome().toUpperCase());
		preparedStatement.setString(2, medico.getSobrenome().toUpperCase());
		preparedStatement.setString(3, medico.getCRM().toUpperCase());	
		if(medico.getCodigo()!=null) {
			preparedStatement.setLong(4, medico.getCodigo());			
		}
		return preparedStatement;
	}
	
	@Override
	public Medico buildResultSet(ResultSet resultSet) throws SQLException {
		MedicoBuilder builder = Medico.builder();
		builder.codigo(resultSet.getLong("codigo_medico"));
		builder.nome(resultSet.getString("nome"));
		builder.sobrenome(resultSet.getString("sobrenome"));
		builder.CRM(resultSet.getString("crm"));
		
		return builder.build();
	}
}
