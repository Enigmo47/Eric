package x3_fichero_binario_secuencial_objetos;

import java.io.Serializable;

public class Alumno implements Serializable {
		
	// número de versión de la clase
	// Verifica que el escritor y el lector del alumno serializado son compatibles.
	private static final long serialVersionUID = 1L;
	
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
	
	// Devuelve una cadena de caracteres con el estado del alumno.
	@Override
	public String toString() {
		return 
			"Alumno [Código = " + this.codigo +
			", Nombre = " + this.nombre +
			", Nota = " + String.format("%.2f", this.nota) +
			"]";
	}
		
}
