package br.com.soc.soctest.respository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.soc.soctest.utils.DataSourceFactory;

public abstract class AbstractRepository<generics> implements Repository<generics> {

	@Override
	public generics find(Long codigo, String sql) {
		try (
			final Connection con = DataSourceFactory.getConnection();
			final PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			preparedStatement.setLong(1, codigo);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				resultSet.next();
				return buildResultSet(resultSet);
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<generics> findAll(String sql) {
		final List<generics> values = new ArrayList<>();

		try (
			final Connection con = DataSourceFactory.getConnection();
			final PreparedStatement preparedStatement = con.prepareStatement(sql)
		) {

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					values.add(buildResultSet(resultSet));
				}
				return values;
			}
		} catch (Throwable e) {

			e.printStackTrace();
		}
		return values;
	}

	@Override
	public void saveOrUpdate(generics generic, String sql) {
		try (
			final Connection con = DataSourceFactory.getConnection();
			final PreparedStatement preparedStatement = con.prepareStatement(sql)
		) {

			buildPreparedStatement(generic, preparedStatement).execute();

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Long codigo, String sql) {
		try (
			final Connection con = DataSourceFactory.getConnection();
			final PreparedStatement preparedStatement = con.prepareStatement(sql)
		) {
			preparedStatement.setLong(1, codigo);
			preparedStatement.execute();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
}
