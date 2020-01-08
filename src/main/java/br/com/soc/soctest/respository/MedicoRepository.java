package br.com.soc.soctest.respository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.soc.soctest.model.Medico;
import br.com.soc.soctest.model.Medico.MedicoBuilder;
import br.com.soc.soctest.utils.ConnectionUtils;

public class MedicoRepository {

	public void save(Medico medico) {
		String insert = "INSERT INTO public.medico( nome, sobrenome, crm) VALUES (?, ?, ?);";
		try (PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement(insert)) {

			preparedStatement.setString(1, medico.getNome().toUpperCase());
			preparedStatement.setString(2, medico.getSobrenome().toUpperCase());
			preparedStatement.setString(3, medico.getCRM().toUpperCase());	
			preparedStatement.execute();
		} catch (SQLException e) {

			e.printStackTrace();

		}finally {
			ConnectionUtils.close();
		}
	}

	public void merge(Medico medico) {
		String insert = "UPDATE public.medico SET nome=?, sobrenome=?, CRM=? WHERE codigo_medico=?";
		try (PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement(insert)) {

			preparedStatement.setString(1, medico.getNome().toUpperCase());
			preparedStatement.setString(2, medico.getSobrenome().toUpperCase());
			preparedStatement.setString(3, medico.getCRM().toUpperCase());	

			preparedStatement.execute();

		} catch (SQLException e) {

			e.printStackTrace();

		}finally {
			ConnectionUtils.close();
		}
	}
	
	
	public void remove(Long codigo) {
		this.remove(Medico.builder().codigo(codigo).build());
	}

	public void remove(Medico medico) {
		
		try (PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement("DELETE FROM public.medico M where M.codigo_medico=?;")) {
			preparedStatement.setLong(1, medico.getCodigo());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtils.close();
		}
		
	}
	
	
	public Medico find(Long codigo) {
		try ( PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement("select * from public.medico M where M.codigo_medico=?;") ) {
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

	private Medico build(ResultSet resultSet) throws SQLException {
		MedicoBuilder builder = Medico.builder();
		builder.codigo(resultSet.getLong("codigo_medico"));
		builder.nome(resultSet.getString("nome"));
		builder.sobrenome(resultSet.getString("sobrenome"));
		builder.CRM(resultSet.getString("crm"));
		
		return builder.build();

	}

	public List<Medico> findAll() {
		List<Medico> medicos = new ArrayList<>();
		
		try( PreparedStatement statement = ConnectionUtils.getPreparedStatement( "select * from public.medico order by nome;" ) ){
			
			try (ResultSet resultSet = statement.executeQuery() ) {
				while ( resultSet.next() ) {
					medicos.add( build( resultSet ) );
				}
				return medicos;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			ConnectionUtils.close();
		}
		return null;
	}
}
