package interfaces;

import java.util.List;

import entidad.Usuario;

public interface UsuarioInterface {
	
	int registrarUsuario(Usuario usuario);
	
	List<Usuario> listarUsuario();
	
	Usuario obtenerUsuario(int idUsuario);
	
	int actualizarUsuario (Usuario usuario);
	
	int eliminarUsuario(int idUsuario);
	
}
