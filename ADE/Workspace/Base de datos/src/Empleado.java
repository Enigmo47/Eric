
public class Empleado {

	private int codigo;
	private String nombre;
	private String fecha_alta;
	private double salario;
	private int codigo_departamento;

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", nombre=" + nombre + ", fecha_alta=" + fecha_alta + ", salario="
				+ salario + ", codigo_departamento=" + codigo_departamento + "]";
	}

	public Empleado(int codigo, String nombre, String fecha_alta, double salario, int codigo_departamento) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.fecha_alta = fecha_alta;
		this.salario = salario;
		this.codigo_departamento = codigo_departamento;
	}

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

	public String getFecha_alta() {
		return fecha_alta;
	}

	public void setFecha_alta(String fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getCodigo_departamento() {
		return codigo_departamento;
	}

	public void setCodigo_departamento(int codigo_departamento) {
		this.codigo_departamento = codigo_departamento;
	}

}
