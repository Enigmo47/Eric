package biblioteca;

public class Prestamo {

	// atributos de un pr�stamo
	private String dniSocio;
	private int codigoLibro;
	private String fechaInicio;
	private String fechaFin;
	private String fechaDevolucion;
	
	// Crea un pr�stamo a partir de 5 par�metros.
	public Prestamo(String dniSocio, int codigoLibro, 
	                String fechaInicio, String fechaFin, String fechaDevolucion) {
		this.dniSocio = dniSocio;
		this.codigoLibro = codigoLibro;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaDevolucion = fechaDevolucion;
	}
	
	// Crea un pr�stamo a partir de 1 par�metro.
	public Prestamo(String elemento) {
		this.dniSocio = extraerTexto(elemento, "dni_socio");
		String texto = extraerTexto(elemento, "codigo_libro");
		this.codigoLibro = Integer.parseInt(texto);
		this.fechaInicio = extraerTexto(elemento, "fecha_inicio");
		this.fechaFin = extraerTexto(elemento, "fecha_fin");
		this.fechaDevolucion = extraerTexto(elemento, "fecha_devolucion");
	}
	
	// Extrae el texto correspondiente a una etiqueta de un elemento XML. 
	private static String extraerTexto(String elemento, String etiqueta) {
		String marcaInicio = "<" + etiqueta + ">";
		String marcaFin = "</" + etiqueta + ">";
		int posicionInicio = elemento.indexOf(marcaInicio) + marcaInicio.length();
		int posicionFin = elemento.indexOf(marcaFin);
		String texto = elemento.substring(posicionInicio, posicionFin);
		return texto;
	}

	// Devuelve una cadena de caracteres con el estado del pr�stamo.
	@Override
	public String toString() {
		return 
			"Pr�stamo [DniSocio = " + dniSocio + 
			", C�digoLibro = " + codigoLibro + 
			", FechaInicio = " + fechaInicio + 
			", FechaFin = " + fechaFin + 
			", FechaDevoluci�n = " + fechaDevolucion + 
			"]";
	}

	// Devuelve el DNI de socio del pr�stamo.
	public String getDniSocio() {
		return dniSocio;
	}

	// Devuelve el c�digo de libro del pr�stamo.
	public int getCodigoLibro() {
		return codigoLibro;
	}

	// Devuelve la fecha de inicio del pr�stamo.
	public String getFechaInicio() {
		return fechaInicio;
	}

	// Devuelve la fecha de fin del pr�stamo.
	public String getFechaFin() {
		return fechaFin;
	}

	// Devuelve la fecha de devoluci�n del pr�stamo.
	public String getFechaDevolucion() {
		return fechaDevolucion;
	}
	
}
