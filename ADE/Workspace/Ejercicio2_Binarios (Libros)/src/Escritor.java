import java.io.Serializable;

public class Escritor implements Serializable{

	private static final long serialVersionUID = 1L;
	private int codigo; // mayor que 0
	private String nombre;
	private String fecha_nacimiento; //validar
	private String nacionalidad; // en euros


	public int getCodigo() {
		return codigo;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}



	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}



	public String getNacionalidad() {
		return nacionalidad;
	}



	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}



	public Escritor(int codigo, String nombre, String fecha_nacimiento, String nacionalidad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nacionalidad = nacionalidad;
	}



	@Override
	public String toString() {
		return "Escritor [codigo=" + codigo + ", nombre=" + nombre + ", fecha_nacimiento=" + fecha_nacimiento
				+ ", nacionalidad=" + nacionalidad + "]";
	}


}
