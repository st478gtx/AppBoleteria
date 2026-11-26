package interfaces;

import java.util.List;

import entidad.Ticket;

public interface TicketInterface {
	
	int registrar(Ticket ticket);
	
	List<Ticket> listarTicket();
	
	Ticket obtenerTicket();
	
	int actualizarTicket (Ticket ticket);
	
	int eliminarTicket(int idTicket);
}
