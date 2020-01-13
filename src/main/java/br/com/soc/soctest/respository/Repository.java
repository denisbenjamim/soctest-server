package br.com.soc.soctest.respository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Repository<generics> {

	void save(generics generic);
	
	void merge(generics generic);
	
	void saveOrUpdate(generics generic,String sql) ;	
	
	void remove(Long codigo);

	void remove(Long codigo,String sql);
	
	void remove(generics generic);
	
	generics find(Long codigo);

	generics find(Long codigo,String sql);
	
	generics find(generics generic);
	
	List<generics> findAll(String sql);

	List<generics> findAll();
	
	generics buildResultSet(ResultSet resultSet) throws SQLException ;
	
	PreparedStatement buildPreparedStatement(generics generic,PreparedStatement preparedStatement) throws SQLException ;
	
}
