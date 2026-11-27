package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Categoria;
import interfaces.CategoriaInterface;
import util.MySQLConnection;

public class CategoriaModel implements CategoriaInterface {

	@Override
	public int registrarCategoria(Categoria categoria) {
		int value = 0;
		
		String sql = "INSERT INTO categorias (nombre, descripcion, estado) "
				+ "VALUES (?,?,?) ";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setString(1, categoria.getNombre());
			psm.setString(2, categoria.getDescripcion());
			psm.setBoolean(3, categoria.isEstado());			
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public List<Categoria> listarCategoria() {
		
		List<Categoria> lista = new ArrayList<>();
		
		String sql = "SELECT * FROM categorias";
		
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
	public Categoria obtenerCategoria(int idCategoria) {
		
		Categoria categoria = null;
		
		String sql = "SELECT * FROM categoria  WHERE id_categoria = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {
			psm.setInt(1, idCategoria);
			try (ResultSet rs = psm.executeQuery();){
				if (rs.next()) {
					categoria = mapear(rs);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return categoria;
	}

	@Override
	public int actualizarCategoria(Categoria categoria) {
		
		int value = 0;
		
		String sql = "UPDATE categorias SET nombre = ?, descripcion = ?, estado = ?, "
				+ "WHERE id_categoria = ?";
		
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {

			psm.setString(1, categoria.getNombre());
			psm.setString(2, categoria.getDescripcion());
			psm.setBoolean(3, categoria.isEstado());
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}

	@Override
	public int eliminarCategoria(int idCategoria) {
		
		int value = 0;
		String sql = "DELETE FROM categorias "
				+ "WHERE id_categoria = ?";
		try (Connection cn = MySQLConnection.getConnection();
				PreparedStatement psm = cn.prepareStatement(sql);) {
			psm.setInt(1, idCategoria);
			value = psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}


		return value;
	}
	
	private Categoria mapear(ResultSet rs ) throws SQLException {

		Categoria d = new Categoria();
		d.setId(rs.getInt("id_categoria"));
		d.setNombre(rs.getString("nombre"));
		d.setDescripcion(rs.getString("descripcion"));
		
		return d;
	}

}
