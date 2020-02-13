package br.com.soc.soctest.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtils {
	private final static String url = "jdbc:postgresql://ec2-174-129-33-147.compute-1.amazonaws.com";
	
	private static Connection con;
	

	public static String urlConnection() {
		return System.getenv("JDBC_DATABASE_URL");
	}

	
	private static void connect() throws SQLException {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		con = DriverManager.getConnection(urlConnection());
	}

	@SuppressWarnings("unused")
	private static void connectConext()   {		
		InitialContext context;
		try {			
			context = new InitialContext();			
			DataSource dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/postgres");
			con = dataSource.getConnection();
		} catch (NamingException e) {			
			e.printStackTrace();
		} catch (SQLException e) {		
			e.printStackTrace();
		}	
	}
	

	public static PreparedStatement getPreparedStatement(String query) throws SQLException {
		if(con != null) {	
			if(!con.isClosed())
				con.close();			
		} 
		connect();
		return con.prepareStatement(query);

	}
	
	public static void close() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
