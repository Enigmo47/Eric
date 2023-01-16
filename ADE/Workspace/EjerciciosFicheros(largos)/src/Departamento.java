
public class Departamento {
	private int codigo;
	private String nombre;
	private String ubicacion;
	
	
	
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
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	
	
	
	public Departamento(int codigo, String nombre,String ubicacion) {
		if(codigo>0) {
			this.codigo=codigo;
		}else {
			  throw new RuntimeException("El codigo debe ser positivo");
		}
		this.nombre=nombre;
		this.ubicacion=ubicacion;
	}
	public Departamento(String cadena) {
		String separar [];
		separar=cadena.split(";");
		if(Integer.parseInt(separar[0])>0) {
			this.codigo=Integer.parseInt(separar[0]);
		}else {
			  throw new RuntimeException("El codigo debe ser positivo");
		}
		this.nombre=separar[1];
		this.ubicacion=separar[2];
	}
	@Override
	public String toString() {
		return "Departamento [Codigo=" + codigo + ", Nombre=" + nombre + ", Ubicacion=" + ubicacion + "]";
	}
	
	public String toStringWithSeparators() {
		return Integer.toString(getCodigo())+";"+getNombre()+";"+getUbicacion();
	}
	
	
}
