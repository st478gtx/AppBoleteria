package dao;

import interfaces.CategoriaInterface;
import interfaces.UsuarioInterface;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	public static final int ORACLE = 3;
	public static final int POSTGRES = 4;
	
	public abstract CategoriaInterface getCategoria();
	public abstract UsuarioInterface getUsuario();
	
	public static DAOFactory getDaoFactory(int tipo) {
		switch (tipo) {
		case MYSQL: {			
			return new MysqlDAOFactory();
		}
		case SQLSERVER: {			
			return null;
		}
		case ORACLE: {			
			return null;
		}
		case POSTGRES: {			
			return null;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipo);
		}
	}
	
}
