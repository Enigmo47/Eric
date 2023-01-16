
public class Pelicula {

	private int codigo;
	private String titulo;
	private String sinopsis;
	private int duracion;
	private String fechaEstreno;
	private Sala sala;
	
	public Pelicula(int codigo, String titulo, String sinopsis, 
	                int duracion, String fechaEstreno, Sala sala) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.sinopsis = sinopsis;
		this.duracion = duracion;
		this.fechaEstreno = fechaEstreno;
		this.sala = sala;
	}

	@Override
	public String toString() {
		return 
			"Pel�cula [C�digo = " + this.codigo + 
			", T�tulo = " + this.titulo + 
			", Sinopsis = " + this.sinopsis + 
			", Duraci�n = " + this.duracion + 
			", FechaEstreno = " + this.fechaEstreno + ",\n" + 
			"          Sala = " + this.sala.toString() + 
			"]";
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopsis() {
		return this.sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getFechaEstreno() {
		return this.fechaEstreno;
	}

	public void setFechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
}
