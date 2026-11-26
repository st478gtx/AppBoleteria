package interfaces;

import java.util.List;

import entidad.Orden;

public interface OrdenInterface {
	
	int registrarUsuario(Orden orden);
	
	List<Orden> listarOrden();
	
	Orden obtenerOrden();
	
	int actualizarOrden (Orden orden);
	
	int eliminarOrden(int idOrden);
	
}
