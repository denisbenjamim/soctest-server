package br.com.soc.soctest.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {
	private static String url = "jdbc:postgresql://ec2-174-129-33-147.compute-1.amazonaws.com";
	private static String user = "vyvndlnycahjim";
	private static String password = "10f27e3b75361caff2bb9653372482bf3754569f9018dc47f0adb85fa651c049";
	private static String database = "d3g5a2oqc8nivp";
	private static Integer port = 5432;
	private static Connection con;
	static {

	}

	private static Properties getPropertiesDefault() {
		Properties properties = new Properties();
		properties.put("user", user);
		properties.put("ssl", "true");
		properties.put("password", password);
		return properties;
	}

	public static String urlConnection() {
		return new StringBuilder()
				.append(url)
				.append(":")
				.append(port)
				.append("/")
				.append(database)
				.append("?sslfactory=org.postgresql.ssl.NonValidatingFactory").toString();
	}

	private static void connect() throws SQLException {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		con = DriverManager.getConnection(urlConnection(), getPropertiesDefault());

	}

	public static PreparedStatement getPreparedStatement(String query) throws SQLException {
		try {					
				con.close();			
		} catch (NullPointerException exception) {
			
		}
		
		connect();
		return con.prepareStatement(query);

	}
	
	public static void close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
