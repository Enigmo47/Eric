
public class Departamento {

	private int codigo;
	private String nombre;
	private String planta;

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

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public Departamento(int codigo, String nombre, String planta) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.planta = planta;
	}

	public Departamento(String nombre2, String ubicacion) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", planta=" + planta + "]";
	}

}
