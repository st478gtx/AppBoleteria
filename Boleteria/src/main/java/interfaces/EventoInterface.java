package interfaces;

import java.util.List;

import entidad.Evento;

public interface EventoInterface {
	
	int registrarUsuario(Evento evento);
	
	List<Evento> listarEvento();
	
	Evento obtenerEvento(int id);
	
	int actualizarEvento (Evento evento);
	
	int eliminarEvento(int idEvento);
}
