package personal;

public class Empleado {

	// atributos de un empleado
	private int codigo;
	private String nombre;
	private String fechaAlta;
	private String departamento;
	private double salario;
	
	// Crea un empleado a partir de 5 par�metros.
	public Empleado(int codigo, String nombre, 
	                String fechaAlta, String departamento, double salario) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaAlta = fechaAlta;
		this.departamento = departamento;
		this.salario = salario;
	}

	// Devuelve una cadena de caracteres con el estado del empleado.
	@Override
	public String toString() {
		return 
			"Empleado [Codigo = " + codigo + 
			", Nombre = " + nombre + 
			", FechaAlta = " + fechaAlta + 
			", Departamento = " + departamento + 
			", Salario = " + String.format("%.2f", salario) + 
			"]";
	}

	// Devuelve el c�digo del empleado.
	public int getCodigo() {
		return codigo;
	}

	// Modifica el c�digo del empleado.
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	// Devuelve el nombre del empleado.
	public String getNombre() {
		return nombre;
	}

	// Modifica el nombre del empleado.
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Devuelve la fecha de alta del empleado.
	public String getFechaAlta() {
		return fechaAlta;
	}

	// Modifica la fecha de alta del empleado.
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	// Devuelve el departamento del empleado.
	public String getDepartamento() {
		return departamento;
	}

	// Modifica el departamento del empleado.
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	// Devuelve el salario del empleado.
	public double getSalario() {
		return salario;
	}

	// Modifica el salario del empleado.
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
}
