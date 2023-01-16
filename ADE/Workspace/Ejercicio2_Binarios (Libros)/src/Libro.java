import java.io.Serializable;

public class Libro implements Serializable{

	private static final long serialVersionUID = 1L;
	private int codigo; // mayor que 0
	private int codigo_escritor;// mayor que 0
	private String titulo;
	private String ano_publicacion; //validar
	private double precio; // en euros


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo_escritor() {
		return codigo_escritor;
	}

	public void setCodigo_escritor(int codigo_escritor) {
		this.codigo_escritor = codigo_escritor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAno_publicacion() {
		return ano_publicacion;
	}

	public void setAno_publicacion(String ano_publicacion) {
		this.ano_publicacion = ano_publicacion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public Libro(int codigo, int codigo_escritor, String titulo, String ano_publicacion, double precio) {
		this.codigo=codigo;
		this.codigo_escritor=codigo_escritor;
		this.titulo=titulo;
		this.ano_publicacion=ano_publicacion;
		this.precio=precio;
	}

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", codigo_escritor=" + codigo_escritor + ", titulo=" + titulo
				+ ", ano_publicacion=" + ano_publicacion + ", precio=" + precio + "]";
	}
}
