package x4_fichero_texto_secuencial_objetos;

public class Alumno {
	
	private static final String SEPARADOR = ";";
	
	// atributos de objeto
	private int codigo;
	private String nombre;
	private double nota;
	
	// Crea un alumno a partir de 3 parámetros.
	public Alumno(int codigo, String nombre, double nota) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.nota = nota;
	}
	
	// Crea un alumno a partir de una línea.
	public Alumno(String linea) {
		String[] datos = linea.split(SEPARADOR);
		this.codigo = Integer.parseInt(datos[0]);
		this.nombre = datos[1];
		this.nota = Double.parseDouble(datos[2]);
	}
	
	// Devuelve una cadena de caracteres con el estado del alumno.
	// Se utiliza para escribir el alumno en consola.
	@Override
	public String toString() {
		return 
			"Alumno [Código = " + this.codigo +
			", Nombre = " + this.nombre +
			", Nota = " + String.format("%.2f", this.nota) +
			"]";
	}
	
	// Devuelve una cadena de caracteres con el estado del alumno.
	// Se utiliza para escribir el alumno en un fichero de texto.
	public String toStringWithSeparators() {
		return 
			this.codigo + SEPARADOR + 
			this.nombre + SEPARADOR + 
			String.format("%.4f", this.nota).replace(',', '.');
	}
		
}
