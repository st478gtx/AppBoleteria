package listeners;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class ContadorConectadosListener implements ServletContextListener, HttpSessionListener {

	public static final String ATRIBUTO_CONECTADOS = "usuariosConectados";

	@Override
	public void contextInitialized(ServletContextEvent evento) {
		// AtomicInteger y no int: Tomcat atiende a varios visitantes a la vez y un int++ podría perder cuentas.
		evento.getServletContext().setAttribute(ATRIBUTO_CONECTADOS, new AtomicInteger(0));
	}

	@Override
	public void sessionCreated(HttpSessionEvent evento) {
		obtenerContador(evento.getSession().getServletContext()).incrementAndGet();
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent evento) {
		obtenerContador(evento.getSession().getServletContext()).decrementAndGet();
	}

	private AtomicInteger obtenerContador(ServletContext contexto) {
		return (AtomicInteger) contexto.getAttribute(ATRIBUTO_CONECTADOS);
	}
}
