package entidad;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import util.enums.EstadoOrden;

public class Orden {
	private int id;
	private int idUsuario;
	
	private String codigo;
	private LocalDateTime fechaOrden;
	private BigDecimal total; //new BigDecimal("15.60")
	private EstadoOrden estado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public LocalDateTime getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(LocalDateTime fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public EstadoOrden getEstado() {
		return estado;
	}
	public void setEstado(EstadoOrden estado) {
		this.estado = estado;
	}
}
