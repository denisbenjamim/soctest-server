package br.com.soc.soctest.respository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.soc.soctest.model.Exame;
import br.com.soc.soctest.model.Exame.ExameBuilder;
import br.com.soc.soctest.model.Medico;
import br.com.soc.soctest.model.Paciente;
import br.com.soc.soctest.utils.ConnectionUtils;

public class ExameRepository extends AbstractRepository<Exame> {

	@Override
	public void save(Exame exame) {
		StringBuilder insert = new StringBuilder();
		insert.append("INSERT INTO public.exame")
		      .append("(data_emissao, data_previsaoentrega, codigo_medico, codigo_paciente, descricao_exame, resultado_exame) ")
		      .append("VALUES (?, ?, ?, ?, ?, ?);");
		
		saveOrUpdate(exame, insert.toString());
	}
	
	@Override
	public void merge(Exame exame) {
		StringBuilder update = new StringBuilder();
		update.append("UPDATE public.exame ")
	      	  .append("SET data_emissao=?, data_previsaoentrega=?, codigo_medico=?, codigo_paciente=?, descricao_exame=?, resultado_exame=? ")
	      	  .append("WHERE codigo_exame=?;");
		
		saveOrUpdate(exame, update.toString());		
	}
	
	@Override
	public void remove(Long codigo) {
		remove(Exame.builder().codigo(codigo).build());
	}

	@Override
	public void remove(Exame exame) {
		StringBuilder delete = new StringBuilder();		
		delete.append("DELETE FROM public.exame ")
			  .append("WHERE codigo_exame=?;");		
		remove(exame.getCodigo(),delete.toString());		
	}
	
	@Override
	public Exame find(Long codigo) {
		return find(Exame.builder().codigo(codigo).build());
	}
	
	@Override
	public Exame find(Exame exame) {
		StringBuilder select = new StringBuilder();		
		select.append("select  ")
			  .append("codigo_exame,data_emissao,data_previsaoentrega,m.codigo_medico codigoMedico,m.nome nomeMedico,m.sobrenome sobrenomeMedico, ")
			  .append("p.codigo_paciente codigoPaciente,p.nome nomePaciente,p.sobrenome sobrenomePaciente, ")
			  .append("descricao_exame,resultado_exame from public.exame e ")
			  .append("LEFT JOIN public.paciente p ON e.codigo_paciente = p.codigo_paciente ")
			  .append("LEFT JOIN public.medico m ON e.codigo_medico = m.codigo_medico ")
			  .append("where e.codigo_exame=?;");
		
		return find(exame.getCodigo(), select.toString());
	}
	
	
	public synchronized List<Exame>  findByPacienteCodigo(Long codigo) {
		StringBuilder select = new StringBuilder();		
		select.append("select  ")
			  .append("codigo_exame,data_emissao,data_previsaoentrega,m.codigo_medico codigoMedico,m.nome nomeMedico,m.sobrenome sobrenomeMedico, ")
			  .append("p.codigo_paciente codigoPaciente,p.nome nomePaciente,p.sobrenome sobrenomePaciente,descricao_exame,resultado_exame from public.exame e ")
			  .append("LEFT JOIN public.paciente p ON e.codigo_paciente = p.codigo_paciente ")
			  .append("LEFT JOIN public.medico m ON e.codigo_medico = m.codigo_medico ")
			  .append("where e.codigo_paciente=?;");
		try ( PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement(select.toString()) ) {
			
			preparedStatement.setLong(1, codigo);
			List<Exame> list  = new ArrayList<>();
			
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				
				while(resultSet.next()) {				
					Exame exame  = buildResultSet(resultSet);					
					list.add(exame);
				}
			}
			return  list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtils.close();
		}
		
		return null;
	}

	@Override
	public List<Exame> findAll() {
		StringBuilder select = new StringBuilder();	
		select.append("select  ")
		  .append("codigo_exame,data_emissao,data_previsaoentrega,m.codigo_medico codigoMedico,m.nome nomeMedico,m.sobrenome sobrenomeMedico, ")
		  .append("p.codigo_paciente codigoPaciente,p.nome nomePaciente,p.sobrenome sobrenomePaciente,descricao_exame,resultado_exame from public.exame e ")
		  .append("LEFT JOIN public.paciente p ON e.codigo_paciente = p.codigo_paciente ")
		  .append("LEFT JOIN public.medico m ON e.codigo_medico = m.codigo_medico ")
		  .append("order by codigo_exame;");
		return findAll(select.toString());
	}
	
	@Override
	public PreparedStatement buildPreparedStatement(Exame exame, PreparedStatement preparedStatement)	throws SQLException {
		preparedStatement.setDate(1, new Date(exame.getEmissao().getTime()));
		preparedStatement.setDate(2, new Date(exame.getPrevisaoEntrega().getTime()));
		preparedStatement.setLong(3, exame.getSolicitante().getCodigo());
		preparedStatement.setLong(4, exame.getPaciente().getCodigo());
		preparedStatement.setString(5, exame.getDescricao().toUpperCase());
		preparedStatement.setString(6, exame.getResultado().toUpperCase());
		if(exame.getCodigo()!=null) {
			preparedStatement.setLong(7, exame.getCodigo());
		}
		return preparedStatement;
	}
	
	@Override
	public Exame buildResultSet(ResultSet resultSet) throws SQLException {
		ExameBuilder builder = Exame.builder();
		
		builder.codigo( resultSet.getLong( "codigo_exame" ) );
		
		builder.emissao( resultSet.getTimestamp( "data_emissao" ) );
		
		builder.previsaoEntrega(resultSet.getDate( "data_previsaoentrega" ) );		
		
		builder.solicitante( Medico.builder()
							.codigo( resultSet.getLong( "codigoMedico" ) )
							.nome( resultSet.getString( "nomeMedico" ) )
							.sobrenome( resultSet.getString( "sobrenomeMedico" ) )
							.build() );
		
		builder.paciente( Paciente.builder()
							.codigo ( resultSet.getLong( "codigoPaciente" ) )
							.nome( resultSet.getString( "nomePaciente" ) )
							.sobrenome( resultSet.getString( "sobrenomePaciente" ) )
							.build() );
		
		builder.descricao( resultSet.getString("descricao_exame") );
		
		builder.resultado( resultSet.getString("resultado_exame") );		
	
		return builder.build();
	}
}
