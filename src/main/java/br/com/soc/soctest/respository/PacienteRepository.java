package br.com.soc.soctest.respository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.soc.soctest.model.Paciente;
import br.com.soc.soctest.model.Paciente.PacienteBuilder;
import br.com.soc.soctest.model.Sexo;
import br.com.soc.soctest.utils.ConnectionUtils;

public class PacienteRepository {

	public void save(Paciente paciente) {
		String insert = "INSERT INTO public.paciente(nome, sobrenome, cpf, rg, nascimento, sexo) VALUES (?, ?, ?, ?, ?, ?);";
		try (PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement(insert)) {

			preparedStatement.setString(1, paciente.getNome().toUpperCase());
			preparedStatement.setString(2, paciente.getSobrenome().toUpperCase());
			preparedStatement.setString(3, paciente.getCPF().toUpperCase());
			preparedStatement.setString(4, paciente.getRG().toUpperCase());
			preparedStatement.setDate(5, new Date(paciente.getNascimento().getTime()));
			
			preparedStatement.setString(6, paciente.getSexo().name());

			System.out.println("Inserido com sucesso -> " + preparedStatement.execute());

		} catch (SQLException e) {

			e.printStackTrace();

		}finally {
			ConnectionUtils.close();
		}
	}

	public void merge(Paciente paciente) {
		String insert = "UPDATE public.paciente	SET nome=?, sobrenome=?, cpf=?, rg=?, nascimento=?, sexo=? WHERE codigo_paciente=?";
		try (PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement(insert)) {

			preparedStatement.setString(1, paciente.getNome().toUpperCase());
			preparedStatement.setString(2, paciente.getSobrenome().toUpperCase());
			preparedStatement.setString(3, paciente.getCPF().toUpperCase());
			preparedStatement.setString(4, paciente.getRG().toUpperCase());
			preparedStatement.setDate(5, new Date(paciente.getNascimento().getTime()));
			preparedStatement.setString(6, paciente.getSexo().name());
			preparedStatement.setLong(7, paciente.getCodigo());

			System.out.println("Atualizado com sucesso -> " + preparedStatement.execute());

		} catch (SQLException e) {

			e.printStackTrace();

		}finally {
			ConnectionUtils.close();
		}
	}
	
	
	public void remove(Long codigo) {
		this.remove(Paciente.builder().codigo(codigo).build());
	}

	public void remove(Paciente paciente) {
		try (PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement("DELETE FROM public.paciente p where p.codigo_paciente=?;")) {
			preparedStatement.setLong(1, paciente.getCodigo());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtils.close();
		}
	}
	
	
	public Paciente find(Long codigo) {
		try ( PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement("select * from public.paciente p where p.codigo_paciente=?;") ) {
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

	

	private Paciente build(ResultSet resultSet) throws SQLException {
		PacienteBuilder builder = Paciente.builder();
		builder.codigo(resultSet.getLong("codigo_paciente"));
		builder.nome(resultSet.getString("nome"));
		builder.sobrenome(resultSet.getString("sobrenome"));
		builder.CPF(resultSet.getString("cpf"));
		builder.RG(resultSet.getString("rg"));
		builder.nascimento(resultSet.getDate("nascimento"));
		builder.sexo(Sexo.valueOf(resultSet.getString("sexo")));
		return builder.build();

	}

	public List<Paciente> findAll() {
		List<Paciente> pacientes = new ArrayList<>();
		
		try( PreparedStatement statement = ConnectionUtils.getPreparedStatement( "select * from public.paciente order by nome;" ) ){
			
			try (ResultSet resultSet = statement.executeQuery() ) {
				while ( resultSet.next() ) {
					pacientes.add( build( resultSet ) );
				}
				return pacientes;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			ConnectionUtils.close();
		}
		return null;
	}
}
