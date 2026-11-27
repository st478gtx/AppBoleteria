package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.DetalleOrden;
import interfaces.DetalleOrdenInterface;
import util.MySQLConnection;

public class DetalleOrdenModel implements DetalleOrdenInterface {

	@Override
	public int registrarDetalleOrden(DetalleOrden detalleOrden) {

		int value = 0;
		
		String sql = "INSERT INTO detalle_orden (id_orden, id_ticket, cantidad, precio_unitario, subtotal) "
				+ "VALUES (?,?,?,?,?) ";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setInt(1, detalleOrden.getIdOrden());
			psm.setInt(2, detalleOrden.getIdTicket());
			psm.setInt(3, detalleOrden.getCantidad());
			psm.setBigDecimal(4, detalleOrden.getPrecioUnitario());
			psm.setBigDecimal(5, detalleOrden.getSubTotal());
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public List<DetalleOrden> listarDetalleOrden() {

		List<DetalleOrden> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM detalle_orden";
		
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
	public DetalleOrden obtenerDetalleOrden(int idDetalleOrden) {

		DetalleOrden detalleOrden = null;
		
		String sql = "SELECT * FROM detalle_orden WHERE id_detalle = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {
			psm.setInt(1, idDetalleOrden);
			try (ResultSet rs = psm.executeQuery();){
				if (rs.next()) {
					detalleOrden = mapear(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return detalleOrden;
	}

	@Override
	public int actualizarDetalleOrden(DetalleOrden detalleOrden) {

		int value = 0;
		
		String sql = "UPDATE detalle_orden SET id_orden = ?, id_ticket = ?, "
				+ "cantidad = ?, precio_unitario = ?, subtotal = ? "
				+ "WHERE id_detalle = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setInt(1, detalleOrden.getIdOrden());
			psm.setInt(2, detalleOrden.getIdTicket());
			psm.setInt(3, detalleOrden.getCantidad());
			psm.setBigDecimal(4, detalleOrden.getPrecioUnitario());
			psm.setBigDecimal(5, detalleOrden.getSubTotal());			
			psm.setInt(6, detalleOrden.getId());
			
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public int eliminarDetalleOrden(int idDetalleOrden) {

		int value = 0;
		
		String sql = "DELETE FROM detalle_orden "
				+ "WHERE id_detalle = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {			
			psm.setInt(1, idDetalleOrden);
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	private DetalleOrden mapear(ResultSet rs ) throws SQLException {

		DetalleOrden detalleOrden = new DetalleOrden();
		detalleOrden.setId(rs.getInt("id_detalle"));
		detalleOrden.setIdOrden(rs.getInt("id_orden"));
		detalleOrden.setIdTicket(rs.getInt("id_ticket"));
		detalleOrden.setCantidad(rs.getInt("cantidad"));
		detalleOrden.setPrecioUnitario(rs.getBigDecimal("precio_unitario"));
		detalleOrden.setSubTotal(rs.getBigDecimal("subtotal"));
		
		return detalleOrden;
	}

}
