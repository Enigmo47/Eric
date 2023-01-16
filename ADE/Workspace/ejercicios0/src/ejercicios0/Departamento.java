package ejercicios0;

public class Departamento {
	private static final String SEPARADOR = ";";
	private int c�digo;
	private String nombre, ubicaci�n;
	
	public Departamento(int c�digo, String nombre, String ubicaci�n) {
		this.nombre = nombre;
		this.ubicaci�n = ubicaci�n;
		this.c�digo = c�digo;
	}
	public Departamento(String cadenaAtributos){
		String[] datos = cadenaAtributos.split(SEPARADOR);
		c�digo = Integer.parseInt(datos[0]);
		nombre = datos[1];
		ubicaci�n = datos[2];
	}
	@Override
	public String toString() {
		return "Departamento [c�digo=" + c�digo + ", nombre=" + nombre + ", ubicaci�n=" + ubicaci�n + "]";
	}
	
	public String toStringWithSeparators() {
		return c�digo + SEPARADOR + nombre + SEPARADOR + ubicaci�n;
	}
	public int getC�digo() {
		return c�digo;
	}
	
}