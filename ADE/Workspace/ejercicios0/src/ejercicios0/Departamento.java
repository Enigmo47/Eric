package ejercicios0;

public class Departamento {
	private static final String SEPARADOR = ";";
	private int código;
	private String nombre, ubicación;
	
	public Departamento(int código, String nombre, String ubicación) {
		this.nombre = nombre;
		this.ubicación = ubicación;
		this.código = código;
	}
	public Departamento(String cadenaAtributos){
		String[] datos = cadenaAtributos.split(SEPARADOR);
		código = Integer.parseInt(datos[0]);
		nombre = datos[1];
		ubicación = datos[2];
	}
	@Override
	public String toString() {
		return "Departamento [código=" + código + ", nombre=" + nombre + ", ubicación=" + ubicación + "]";
	}
	
	public String toStringWithSeparators() {
		return código + SEPARADOR + nombre + SEPARADOR + ubicación;
	}
	public int getCódigo() {
		return código;
	}
	
}