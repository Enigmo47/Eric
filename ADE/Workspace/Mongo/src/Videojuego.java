
public class Videojuego {

	// atributos de un videojuego
	private int codigo;
	private String titulo;
	private int agno;
	private String desarrollador;
	private double precio;
	
	// Crea un videojuego a partir de 5 parmetros.
	public Videojuego(int codigo, String titulo, 
	                 int agno, String desarrollador, double precio) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.agno = agno;
		this.desarrollador = desarrollador;
		this.precio = precio;
	}

	// Devuelve una cadena de caracteres con el estado del videojuego.
	@Override
	public String toString() {
		return 
			"Videojuego [C�digo = " + codigo + 
			", Titulo = " + titulo + 
			", Año = " + agno + 
			", Desarrollador = " + desarrollador + 
			", Precio = " + String.format("%.2f", precio) + 
			"]";
	}

	// Devuelve el cdigo del videojuego.
	public int getCodigo() {
		return codigo;
	}

	// Devuelve el ttulo del videojuego.
	public String getTitulo() {
		return titulo;
	}

	// Devuelve el ao del videojuego.
	public int getAgno() {
		return agno;
	}

	// Devuelve el desarrollador del videojuego.
	public String getDesarrollador() {
		return desarrollador;
	}

	// Devuelve el precio del videojuego.
	public double getPrecio() {
		return precio;
	}
	
}
