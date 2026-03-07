package br.com.soc.soctest.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public final class DataSourceFactory {
    private final static DataSource ds;

    static {
        final HikariConfig config = new HikariConfig();
        config.setJdbcUrl(System.getenv("DB_URL"));
        config.setUsername(System.getenv("DB_USER"));
        config.setPassword(System.getenv("DB_PASSWORD"));

        config.setMaximumPoolSize(10);

        ds = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException{
        return ds.getConnection();
    }
}
