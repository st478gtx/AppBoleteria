package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Usuario;
import interfaces.UsuarioInterface;
import util.MySQLConnection;

public class UsuarioModel implements UsuarioInterface {

	@Override
	public int registrarUsuario(Usuario usuario) {
		int value = 0;
		
		String sql = "INSERT INTO usuarios (nombres, apellidos, email, password, telefono) "
				+ "VALUES (?,?,?,?,?,?) ";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setString(1, usuario.getNombre());
			psm.setString(1, usuario.getApellido());	
			psm.setString(1, usuario.getEmail());	
			psm.setString(1, usuario.getPassword());	
			psm.setString(1, usuario.getTelefono());
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public List<Usuario> listarUsuario() {
		
		List<Usuario> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM usuarios";
		
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
	public Usuario obtenerUsuario(int idUsuario) {
		
		Usuario usuario = null;
		
		String sql = "SELECT * FROM usuarios WHERE id_usuario = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {
			psm.setInt(1, idUsuario);
			try (ResultSet rs = psm.executeQuery();){
				if (rs.next()) {
					usuario = mapear(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
	}

	@Override
	public int actualizarUsuario(Usuario usuario) {
		
		int value = 0;
		
		String sql = "UPDATE usuarios SET nombres = ?, apellidos = ? "
				+ "email = ?, password = ?, telefono = ? "
				+ "WHERE id_usuario = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setString(1, usuario.getNombre());
			psm.setString(2, usuario.getApellido());
			psm.setString(3, usuario.getEmail());
			psm.setString(4, usuario.getPassword());
			psm.setString(5, usuario.getTelefono());
			psm.setInt(6, usuario.getId());
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public int eliminarUsuario(int idUsuario) {
		
		int value = 0;
		
		String sql = "DELETE FROM usuarios "
				+ "WHERE id_usuario = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {			
			psm.setInt(1, idUsuario);
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	private Usuario mapear(ResultSet rs ) throws SQLException {

		Usuario usr = new Usuario();
		usr.setId(rs.getInt("id_usuario"));
		usr.setNombre(rs.getString("nombres"));
		usr.setApellido(rs.getString("apellidos"));
		usr.setEmail(rs.getString("email"));
		usr.setPassword(rs.getString("password"));
		usr.setTelefono(rs.getString("telefono"));
		
		return usr;
	}

	@Override
	public boolean existeCorreo(String correo, int idExcluir) {
		
		boolean existe = false;

		String sql="SELECT COUNT(id_usuario) FROM usuarios WHERE email = ? AND id_usuario <> ?";
		
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
