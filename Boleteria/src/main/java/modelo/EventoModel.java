package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entidad.Evento;
import interfaces.EventoInterface;
import util.MySQLConnection;
import util.enums.EstadoBoleteria;

public class EventoModel implements EventoInterface {

	@Override
	public int registrarUsuario(Evento evento) {
		
		int value = 0;
		
		String sql = "INSERT INTO evento (id_categoria, id_trabajador, nombre, descripcion, lugar, direccion, fecha_evento, imagen) "
				+ "VALUES (?,?,?,?,?,?,?,?) ";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setInt(1,evento.getIdCategoria());
			psm.setInt(2,evento.getIdTrabajador());	
			psm.setString(3,evento.getNombre());	
			psm.setString(4,evento.getDescripcion());	
			psm.setString(5,evento.getLugar());
			psm.setString(6,evento.getDireccion());
			psm.setTimestamp(7,Timestamp.valueOf(evento.getFechaRegistro()));
			psm.setString(8, evento.getImagen());
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public List<Evento> listarEvento() {
		
		List<Evento> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM evento";
		
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
	public Evento obtenerEvento(int idEvento) {

		Evento evento = null;
		
		String sql = "SELECT * FROM evento WHERE id_evento = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {
			psm.setInt(1, idEvento);
			try (ResultSet rs = psm.executeQuery();){
				if (rs.next()) {
					evento = mapear(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return evento;
	}

	@Override
	public int actualizarEvento(Evento evento) {

		int value = 0;
		
		String sql = "UPDATE evento SET id_categoria = ?, id_trbajador = ?, "
				+ "nombre = ?, descripcion = ?, lugar = ?, "
				+ "fecha_registro = ?, imagen = ?, estado = ?, "
				+ "WHERE id_evento = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setInt(1, evento.getIdCategoria());
			psm.setInt(2, evento.getIdTrabajador());
			psm.setString(3, evento.getNombre());
			psm.setString(4, evento.getDescripcion());
			psm.setString(5, evento.getLugar());
			psm.setTimestamp(6, Timestamp.valueOf(evento.getFechaEvento()));
			psm.setString(7, evento.getImagen());
			psm.setString(8, evento.getEstado().name());
			psm.setInt(9, evento.getId());
			
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public int eliminarEvento(int idEvento) {

		int value = 0;
		
		String sql = "DELETE FROM evento "
				+ "WHERE id_evento = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {			
			psm.setInt(1, idEvento);
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	private Evento mapear(ResultSet rs ) throws SQLException {

		Evento evnt = new Evento();
		evnt.setId(rs.getInt("id_evento"));
		evnt.setIdCategoria(rs.getInt("id_categoria"));
		evnt.setIdTrabajador(rs.getInt("id_trabjador"));
		evnt.setNombre(rs.getString("nombre"));
		evnt.setDescripcion(rs.getString("descripcion"));
		evnt.setLugar(rs.getString("lugar"));
		evnt.setFechaEvento(rs.getTimestamp("fecha_registro").toLocalDateTime());
		evnt.setImagen(rs.getString("imagen"));
		evnt.setEstado(EstadoBoleteria.valueOf(rs.getString("estado")));
		
		return evnt;
	}

}
