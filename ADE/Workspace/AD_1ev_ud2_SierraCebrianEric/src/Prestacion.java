
public class Prestacion {

	private int codigo;
	private String descripcion;
	
	public Prestacion(int codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return 
			"Prestaci�n [C�digo = " + this.codigo + 
			", Descripci�n = " + this.descripcion + 
			"]";
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
