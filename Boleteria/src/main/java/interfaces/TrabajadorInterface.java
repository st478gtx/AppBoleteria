package interfaces;

import java.util.List;

import entidad.Trabajador;

public interface TrabajadorInterface {

int registrarUsuario(Trabajador trabajador);
	
	List<Trabajador> listarTrabajador();
	
	Trabajador obtenerTrabajador(int idTrabajador);
	
	int actualizarTrabajador (Trabajador trabajador);
	
	int eliminarTrabajador(int idTrabajador);
}
