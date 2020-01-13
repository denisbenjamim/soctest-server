package br.com.soc.soctest.respository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.soc.soctest.utils.ConnectionUtils;

public abstract class AbstractRepository<generics> implements Repository<generics>{

	
	@Override
	public generics find(Long codigo,String sql) {
		try ( PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement(sql) ) {
			preparedStatement.setLong(1, codigo);
			try(ResultSet resultSet = preparedStatement.executeQuery()){				
				resultSet.next();				
				return buildResultSet(resultSet);
			}			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtils.close();
		}
		return null;
	}

	

	@Override
	public List<generics> findAll(String sql) {
		List<generics> values = new ArrayList<>();
		
		try( PreparedStatement statement = ConnectionUtils.getPreparedStatement( sql ) ){
			
			try (ResultSet resultSet = statement.executeQuery() ) {
				while ( resultSet.next() ) {
					values.add( buildResultSet( resultSet ) );
				}
				return values;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			ConnectionUtils.close();
		}
		return null;
	}

	

	@Override
	public void saveOrUpdate(generics generic,String sql) {
		try (PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement(sql)) {
			
			buildPreparedStatement(generic, preparedStatement).execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtils.close();
		}
		
	}

	

	@Override
	public void remove(Long codigo, String sql) {
		try (PreparedStatement preparedStatement = ConnectionUtils.getPreparedStatement(sql)) {
			preparedStatement.setLong(1, codigo);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtils.close();
		}
		
	}

	
	
}
