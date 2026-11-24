package test;

import util.MySQLConnection;

public class TestConexion {
	public static void main(String[] args) {

        if (MySQLConnection.probarConexion()) {
            System.out.println("Conexion exitosa a MySQL");
        } else {
            System.out.println("Error al conectar con MySQL");
        }
    }
}
