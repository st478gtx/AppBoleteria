package interfaces;

import java.util.List;

import entidad.DetalleOrden;

public interface DetalleOrdenInterface {
	
	int registrarDetalleOrden(DetalleOrden detalleOrden);
	
	List<DetalleOrden> listarDetalleOrden();
	
	DetalleOrden obtenerDetalleOrden(int idOrden);
	
	int actualizarDetalleOrden (DetalleOrden detalleOrden);
	
	int eliminarDetalleOrden(int idDetalleOrden);
}
