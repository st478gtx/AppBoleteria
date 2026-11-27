package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Ticket;
import interfaces.TicketInterface;
import util.MySQLConnection;

public class TicketModel implements TicketInterface {

	@Override
	public int registrar(Ticket ticket) {

		int value = 0;
		
		String sql = "INSERT INTO tickets (id_evento, nombre, descripcion, precio, stock) "
				+ "VALUES (?,?,?,?,?) ";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setInt(1, ticket.getIdEvento());
			psm.setString(2, ticket.getNombre());	
			psm.setString(3, ticket.getDescripcion());
			psm.setBigDecimal(4, ticket.getPrecio());
			psm.setInt(5, ticket.getStock());
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public List<Ticket> listarTicket() {
		
		List<Ticket> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM tickets";
		
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
	public Ticket obtenerTicket(int idTicket) {
		
		Ticket ticket = null;
		
		String sql = "SELECT * FROM tickets WHERE id_ticket = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {
			psm.setInt(1, idTicket);
			try (ResultSet rs = psm.executeQuery();){
				if (rs.next()) {
					ticket = mapear(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ticket;
	}

	@Override
	public int actualizarTicket(Ticket ticket) {

		int value = 0;
		
		String sql = "UPDATE tickets SET id_evento = ?, nombre = ?, "
				+ "descripcion = ?, precio = ?, stock = ? "
				+ "WHERE id_ticket = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setInt(1, ticket.getIdEvento());
			psm.setString(2, ticket.getNombre());
			psm.setString(3, ticket.getDescripcion());
			psm.setBigDecimal(4, ticket.getPrecio());
			psm.setInt(5, ticket.getStock());
			psm.setInt(6, ticket.getId());
			
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public int eliminarTicket(int idTicket) {

		int value = 0;
		
		String sql = "DELETE FROM tickets "
				+ "WHERE id_ticket = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {			
			psm.setInt(1, idTicket);
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	private Ticket mapear(ResultSet rs ) throws SQLException {

		Ticket ticket = new Ticket();
		ticket.setId(rs.getInt("id_ticket"));
		ticket.setIdEvento(rs.getInt("id_evento"));
		ticket.setNombre(rs.getString("nombre"));
		ticket.setDescripcion(rs.getString("descripcion"));
		ticket.setPrecio(rs.getBigDecimal("precio"));
		ticket.setStock(rs.getInt("stock"));
		
		return ticket;
	}

}
