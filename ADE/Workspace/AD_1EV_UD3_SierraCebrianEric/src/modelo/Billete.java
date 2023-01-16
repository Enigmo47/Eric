package modelo;
// Generated 2 dic 2022 17:26:13 by Hibernate Tools 6.1.3.Final

import java.math.BigDecimal;

/**
 * Billete generated by hbm2java
 */
public class Billete implements java.io.Serializable {

	@Override
	public String toString() {
		return "Billete [codigo=" + codigo + ", estacionByCodigoEstacionDestino=" + estacionByCodigoEstacionDestino
				+ ", estacionByCodigoEstacionOrigen=" + estacionByCodigoEstacionOrigen + ", viajero=" + viajero
				+ ", fecha=" + fecha + ", horaSalida=" + horaSalida + ", horaLlegada=" + horaLlegada + ", importe="
				+ importe + "]";
	}

	private Short codigo;
	private Estacion estacionByCodigoEstacionDestino;
	private Estacion estacionByCodigoEstacionOrigen;
	private Viajero viajero;
	private String fecha;
	private String horaSalida;
	private String horaLlegada;
	private BigDecimal importe;

	public Billete() {
	}

	public Billete(Estacion estacionByCodigoEstacionDestino, Estacion estacionByCodigoEstacionOrigen, Viajero viajero,
			String fecha, String horaSalida, String horaLlegada, BigDecimal importe) {
		this.estacionByCodigoEstacionDestino = estacionByCodigoEstacionDestino;
		this.estacionByCodigoEstacionOrigen = estacionByCodigoEstacionOrigen;
		this.viajero = viajero;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.importe = importe;
	}

	public Short getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Short codigo) {
		this.codigo = codigo;
	}

	public Estacion getEstacionByCodigoEstacionDestino() {
		return this.estacionByCodigoEstacionDestino;
	}

	public void setEstacionByCodigoEstacionDestino(Estacion estacionByCodigoEstacionDestino) {
		this.estacionByCodigoEstacionDestino = estacionByCodigoEstacionDestino;
	}

	public Estacion getEstacionByCodigoEstacionOrigen() {
		return this.estacionByCodigoEstacionOrigen;
	}

	public void setEstacionByCodigoEstacionOrigen(Estacion estacionByCodigoEstacionOrigen) {
		this.estacionByCodigoEstacionOrigen = estacionByCodigoEstacionOrigen;
	}

	public Viajero getViajero() {
		return this.viajero;
	}

	public void setViajero(Viajero viajero) {
		this.viajero = viajero;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getHoraLlegada() {
		return this.horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

}
