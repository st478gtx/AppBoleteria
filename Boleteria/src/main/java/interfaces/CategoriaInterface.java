package interfaces;

import java.util.List;

import entidad.Categoria;

public interface CategoriaInterface {
	
	int registrarCategoria(Categoria categoria);
	
	List<Categoria> listarCategoria();
	
	Categoria obtenerCategoria(int idOrden);
	
	int actualizarCategoria (Categoria categoria);
	
	int eliminarCategoria(int idCategoria);
	
}
