
public class Empleado {

	private int codigo;
	private int codigo_departamento;
	private String nombre;
	private String fecha_alta;
	private Double salario;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo_departamento() {
		return codigo_departamento;
	}

	public void setCodigo_departamento(int codigo_departamento) {
		this.codigo_departamento = codigo_departamento;
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
	
	
	
	public Empleado(int codigo, int codigo_departamento, String nombre, String fecha_alta, Double salario) {
		
		if(codigo>0) {
			this.codigo=codigo;
		}else {
			  throw new RuntimeException("El codigo debe ser positivo");
		}
		if(codigo_departamento>0) {
			this.codigo_departamento=codigo_departamento;
		}else {
			  throw new RuntimeException("El codigo del departamento debe ser positivo");
		}
		
		this.nombre=nombre;
		this.fecha_alta=fecha_alta;
		this.salario=salario;
		salario = Math.round(salario * 100.0) / 100.0;
	}
	
	public Empleado(String texto) {
		String separar [];
		separar=texto.split(";");
		this.codigo=Integer.parseInt(separar[0]);
		this.codigo_departamento=Integer.parseInt(separar[1]);
		if(codigo < 0) {
			throw new RuntimeException("El codigo debe ser positivo");
		}
		if(codigo_departamento < 0) {
			throw new RuntimeException("El codigo del departamento debe ser positivo");
		}
		this.nombre=separar[2];
		this.fecha_alta=separar[3];
		this.salario=Double.parseDouble(separar[4]);
		salario = Math.round(salario * 100.0) / 100.0;
	}

	@Override
	public String toString() {
		return "Empleado [Codigo=" + codigo + ", Codigo_departamento=" + codigo_departamento + ", Nombre=" + nombre
				+ ", FechaAlta=" + fecha_alta + ", Salario=" + salario + "]";
	}
	
	public String toStringWithSeparators() {
		return Integer.toString(getCodigo())+";"+Integer.toString(getCodigo_departamento())+";"+getNombre()+
				";"+getFecha_alta()+";"+getSalario();
	}
	
}
