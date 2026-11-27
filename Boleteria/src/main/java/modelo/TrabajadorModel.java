package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Trabajador;
import interfaces.TrabajadorInterface;
import util.MySQLConnection;

public class TrabajadorModel implements TrabajadorInterface {

	@Override
	public int registrarUsuario(Trabajador trabajador) {
		
		int value = 0;
		
		String sql = "INSERT INTO trabajadores (nombres, apellidos, email, password, cargo) "
				+ "VALUES (?,?,?,?,?,?) ";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setString(1, trabajador.getNombre());
			psm.setString(2, trabajador.getApellido());	
			psm.setString(3, trabajador.getEmail());	
			psm.setString(4, trabajador.getPassword());	
			psm.setString(5, trabajador.getCargo());
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public List<Trabajador> listarTrabajador() {
		
		List<Trabajador> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM trabajadores";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);
				ResultSet rs = psm.executeQuery();	) {

			while(rs.next()) {
				lista.add(mapear(rs));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return lista;
	}

	@Override
	public Trabajador obtenerTrabajador(int idTrabajador) {
		
		Trabajador trabajador = null;
		
		String sql = "SELECT * FROM trabajadores WHERE id_trabajador = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {
			psm.setInt(1, idTrabajador);
			try (ResultSet rs = psm.executeQuery();){
				if (rs.next()) {
					trabajador = mapear(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return trabajador;
	}

	@Override
	public int actualizarTrabajador(Trabajador trabajador) {
		
		int value = 0;
		
		String sql = "UPDATE trbajadores SET nombres = ?, apellidos = ?, "
				+ "email = ?, password = ?, cargo = ? "
				+ "WHERE id_trabajador = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setString(1, trabajador.getNombre());
			psm.setString(2, trabajador.getApellido());
			psm.setString(3, trabajador.getEmail());
			psm.setString(4, trabajador.getPassword());
			psm.setString(5, trabajador.getCargo());
			psm.setInt(6, trabajador.getId());
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public int eliminarTrabajador(int idTrabajador) {
		
		int value = 0;
		
		String sql = "DELETE FROM trabajadores "
				+ "WHERE id_trabajador = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {			
			psm.setInt(1, idTrabajador);
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	private Trabajador mapear(ResultSet rs ) throws SQLException {

		Trabajador usr = new Trabajador();
		usr.setId(rs.getInt("id_trabajador"));
		usr.setNombre(rs.getString("nombres"));
		usr.setApellido(rs.getString("apellidos"));
		usr.setEmail(rs.getString("email"));
		usr.setPassword(rs.getString("password"));
		usr.setCargo(rs.getString("cargo"));
		
		return usr;
	}

	@Override
	public boolean existeCorreo(String correo, int idExcluir) {
		boolean existe = false;

		String sql="SELECT COUNT(id_trabajador) FROM trabajadores WHERE email = ? AND id_trabajador <> ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setString(1, correo);
			psm.setInt(2, idExcluir);
			try (ResultSet rs = psm.executeQuery()){
				if (rs.next()) {
					existe = rs.getInt(1) > 0;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}

}
