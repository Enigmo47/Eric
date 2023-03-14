package biblioteca;

public class Socio {

	// atributos de un socio
	private String dni;
	private String nombre;
	private String localidad;
	private String telefono;
	private String correo;
	
	// Crea un socio a partir de 5 par�metros.
	public Socio(String dni, String nombre, String localidad, 
	             String telefono, String correo) {
		this.dni = dni;
		this.nombre = nombre;
		this.localidad = localidad;
		this.telefono = telefono;
		this.correo = correo;
	}
	
	// Crea un socio a partir de 1 par�metro.
	public Socio(String elemento) {
		this.dni = extraerTexto(elemento, "dni");
		this.nombre = extraerTexto(elemento, "nombre");
		this.localidad = extraerTexto(elemento, "localidad");
		this.telefono = extraerTexto(elemento, "telefono");
		this.correo = extraerTexto(elemento, "correo");
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
	
	// Devuelve una cadena de caracteres con el estado del socio.
	@Override
	public String toString() {
		return 
			"Socio [DNI = " + dni + 
			", Nombre = " + nombre + 
			", Localidad = " + localidad + 
			", Teléfono = " + telefono + 
			", Correo = " + correo + 
			"]";
	}

	// Devuelve el DNI del socio.
	public String getDni() {
		return dni;
	}

	// Devuelve el nombre del socio.
	public String getNombre() {
		return nombre;
	}

	// Devuelve la localidad del socio.
	public String getLocalidad() {
		return localidad;
	}

	// Devuelve el tel�fono del socio.
	public String getTelefono() {
		return telefono;
	}

	// Devuelve el correo del socio.
	public String getCorreo() {
		return correo;
	}

}
