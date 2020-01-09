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

public class ExameRepository {

	public void save(Exame exame) {
		String insert = "INSERT INTO public.exame(data_emissao, data_previsaoentrega, codigo_medico, codigo_paciente, descricao_exame, resultado_exame) VALUES (?, ?, ?, ?, ?, ?);";
		try (PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement(insert)) {
			
			preparedStatement.setDate(1, new Date(exame.getEmissao().getTime()));
			preparedStatement.setDate(2, new Date(exame.getPrevisaoEntrega().getTime()));
			preparedStatement.setLong(3, exame.getSolicitante().getCodigo());
			preparedStatement.setLong(4, exame.getPaciente().getCodigo());
			preparedStatement.setString(5, exame.getDescricao().toUpperCase());
			preparedStatement.setString(6, exame.getResultado().toUpperCase());
			
			

			System.out.println("Inserido com sucesso -> " + preparedStatement.execute());

		} catch (SQLException e) {

			e.printStackTrace();

		}finally {
			ConnectionUtils.close();
		}
	}

	public void merge(Exame exame) {
		
		String update = "UPDATE public.exame SET data_emissao=?, data_previsaoentrega=?, codigo_medico=?, codigo_paciente=?, descricao_exame=?, resultado_exame=? WHERE codigo_exame=?";
		try (PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement(update)) {

			preparedStatement.setDate(1, new Date(exame.getEmissao().getTime()));
			
			preparedStatement.setDate(2, new Date(exame.getPrevisaoEntrega().getTime()));
			preparedStatement.setLong(3, exame.getSolicitante().getCodigo());
			preparedStatement.setLong(4, exame.getPaciente().getCodigo());
			preparedStatement.setString(5, exame.getDescricao().toUpperCase());
			preparedStatement.setString(6, exame.getResultado().toUpperCase());
			preparedStatement.setLong(7, exame.getCodigo());
			

		} catch (SQLException e) {

			e.printStackTrace();

		}finally {
			ConnectionUtils.close();
		}
	}
	
	
	public void remove(Long codigo) {
		this.remove(Exame.builder().codigo(codigo).build());
	}

	public void remove(Exame exame) {
		try (PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement("DELETE FROM public.exame p where p.codigo_exame=?;")) {
			preparedStatement.setLong(1, exame.getCodigo());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtils.close();
		}
	}
	
	
	public Exame find(Long codigo) {
		try ( PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement("select codigo_exame,data_emissao,data_previsaoentrega,m.codigo_medico codigoMedico,m.nome nomeMedico,m.sobrenome sobrenomeMedico,p.codigo_paciente codigoPaciente,p.nome nomePaciente,p.sobrenome sobrenomePaciente,descricao_exame,resultado_exame from public.exame e LEFT JOIN public.paciente p ON e.codigo_paciente = p.codigo_paciente LEFT JOIN public.medico m ON e.codigo_medico = m.codigo_medico where e.codigo_exame=?;") ) {
			preparedStatement.setLong(1, codigo);
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				
				resultSet.next();
				
				return build(resultSet);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtils.close();
		}

		return null;
	}
	public synchronized List<Exame>  findByPacienteCodigo(Long codigo) {
		try ( PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement("select codigo_exame,data_emissao,data_previsaoentrega,m.codigo_medico codigoMedico,m.nome nomeMedico,m.sobrenome sobrenomeMedico,p.codigo_paciente codigoPaciente,p.nome nomePaciente,p.sobrenome sobrenomePaciente,descricao_exame,resultado_exame from public.exame e LEFT JOIN public.paciente p ON e.codigo_paciente = p.codigo_paciente LEFT JOIN public.medico m ON e.codigo_medico = m.codigo_medico where p.codigo_paciente=?;") ) {
			preparedStatement.setLong(1, codigo);
			ArrayList list  = new ArrayList<>();
			try(ResultSet resultSet = preparedStatement.executeQuery()){
				
				while(resultSet.next()) {				
					Exame exame  = build(resultSet);					
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

	

	private Exame build(ResultSet resultSet) throws SQLException {
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

	public List<Exame> findAll() {
		List<Exame> exames = new ArrayList<>();
		
		try( PreparedStatement statement = ConnectionUtils.getPreparedStatement( "select codigo_exame,data_emissao,data_previsaoentrega,m.codigo_medico codigoMedico,m.nome nomeMedico,m.sobrenome sobrenomeMedico,p.codigo_paciente codigoPaciente,p.nome nomePaciente,p.sobrenome sobrenomePaciente,descricao_exame,resultado_exame from public.exame e LEFT JOIN public.paciente p ON e.codigo_paciente = p.codigo_paciente LEFT JOIN public.medico m ON e.codigo_medico = m.codigo_medico order by codigo_exame;" ) ){
			
			try (ResultSet resultSet = statement.executeQuery() ) {
				while ( resultSet.next() ) {
					exames.add( build( resultSet ) );					
				}
				return exames;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			ConnectionUtils.close();
		}
		return null;
	}
}
