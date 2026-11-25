package tags;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PrecioTag extends SimpleTagSupport {

	// String y no BigDecimal: JSP no sabe convertir un valor escrito a mano como valor="120" a BigDecimal.
	private String valor;

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (valor == null || valor.isBlank()) {
			return;
		}

		// BigDecimal y no double: con double, 0.1 + 0.2 da 0.30000000000000004, y con dinero eso no se acepta.
		BigDecimal monto;
		try {
			monto = new BigDecimal(valor.trim());
		} catch (NumberFormatException e) {
			throw new JspException("bol:precio recibió un valor que no es número: " + valor, e);
		}

		// Locale.US porque en Perú los precios se escriben con coma de miles y punto decimal: S/ 1,250.50
		String precioFormateado = String.format(Locale.US, "S/ %,.2f", monto);
		getJspContext().getOut().write(precioFormateado);
	}
}
