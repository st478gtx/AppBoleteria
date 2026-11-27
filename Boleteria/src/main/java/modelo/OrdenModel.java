package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import entidad.Orden;
import interfaces.OrdenInterface;
import util.MySQLConnection;
import util.enums.EstadoOrden;

public class OrdenModel implements OrdenInterface {

	@Override
	public int registrarUsuario(Orden orden) {

		int value = 0;
		
		String sql = "INSERT INTO ordenes (id_usuario, codigo, total) "
				+ "VALUES (?,?,?) ";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setInt(1, orden.getIdUsuario());
			psm.setString(2, orden.getCodigo());
			psm.setBigDecimal(3, orden.getTotal());
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public List<Orden> listarOrden() {
		
		List<Orden> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM ordenes";
		
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
	public Orden obtenerOrden(int idOrden) {
		
		Orden orden = null;
		
		String sql = "SELECT * FROM ordenes WHERE id_orden = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {
			psm.setInt(1, idOrden);
			try (ResultSet rs = psm.executeQuery();){
				if (rs.next()) {
					orden = mapear(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return orden;
	}

	@Override
	public int actualizarOrden(Orden orden) {

		int value = 0;
		
		String sql = "UPDATE ordenes SET id_usuario = ?, codigo = ?, "
				+ "fecha_orden = ?, total = ?, estado = ? "
				+ "WHERE id_orden = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setInt(1, orden.getIdUsuario());
			psm.setString(2, orden.getCodigo());
			psm.setTimestamp(3, Timestamp.valueOf(orden.getFechaOrden()));
			psm.setBigDecimal(4, orden.getTotal());
			psm.setString(5, orden.getEstado().name());
			psm.setInt(6, orden.getId());
			
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public int eliminarOrden(int idOrden) {

		int value = 0;
		
		String sql = "DELETE FROM ordenes "
				+ "WHERE id_orden = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {			
			psm.setInt(1, idOrden);
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	private Orden mapear(ResultSet rs ) throws SQLException {

		Orden orden = new Orden();
		orden.setId(rs.getInt("id_orden"));
		orden.setIdUsuario(rs.getInt("id_usuario"));
		orden.setCodigo(rs.getString("codigo"));
		orden.setFechaOrden(rs.getTimestamp("fecha_orden").toLocalDateTime());
		orden.setTotal(rs.getBigDecimal("total"));
		orden.setEstado(EstadoOrden.valueOf(rs.getString("estado")));
		
		return orden;
	}
}
