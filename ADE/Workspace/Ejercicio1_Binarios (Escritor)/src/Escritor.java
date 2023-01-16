import java.io.Serializable;

public class Escritor implements Serializable{

	private static final long serialVersionUID = 1L;
	private int codigo;
	private String nombre;
	private String fecha_nac;
	private String nacionalidad;
	
	
	
	
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
	public String getFecha_nac() {
		return fecha_nac;
	}
	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	
	
	public Escritor(int codigo, String nombre,String fecha_nac,String nacionalidad) {
		if(codigo>0) {
			this.codigo=codigo;
		}else {
			  throw new RuntimeException("El codigo debe ser positivo");
		}
		this.nombre=nombre;
		this.fecha_nac=fecha_nac;
		this.nacionalidad=nacionalidad;
	}

	@Override
	public String toString() {
		return "Escritor [codigo=" + codigo + ", nombre=" + nombre + ", fecha_nac=" + fecha_nac + ", nacionalidad="
				+ nacionalidad + "]";
	}
	
	
	
}
