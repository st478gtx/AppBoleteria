package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	private static final String URL = "jdbc:mysql://" + EnvConfig.get("DB_HOST") + ":" + EnvConfig.get("DB_PORT") + "/"
			+ EnvConfig.get("DB_NAME") + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Lima";

	private static final String USR = EnvConfig.get("DB_USER");
	private static final String PSW = EnvConfig.get("DB_PASSWORD");

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USR, PSW);
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no instalado: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error >> de conexion con la BD; " + e.getMessage());
		}

		return con;
	}
	
	public static boolean probarConexion() {

		try (Connection con = getConnection()) {

	        if (con.isValid(3)) {
	            System.out.println("MySQL conectado correctamente");
	            System.out.println("Base de datos: " +
	                    con.getCatalog());

	            return true;
	        }

	        return false;

	    } catch (SQLException e) {

	        System.err.println("Error MySQL: " + e.getMessage());
	        return false;
	    }
    }
}
