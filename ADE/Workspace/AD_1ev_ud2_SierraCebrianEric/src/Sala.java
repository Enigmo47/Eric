
public class Sala {

	private int codigo;
	private String nombre;
	private int numeroButacas;
	private double precioNormal;
	private double precioReducido;
	
	public Sala(int codigo, String nombre, int numeroButacas, 
	            double precioNormal, double precioReducido) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.numeroButacas = numeroButacas;
		this.precioNormal = precioNormal;
		this.precioReducido = precioReducido;
	}

	
	public Sala(String nombre, int numeroButacas, double precioNormal, double precioReducido) {
		this.nombre = nombre;
		this.numeroButacas = numeroButacas;
		this.precioNormal = precioNormal;
		this.precioReducido = precioReducido;
	}


	@Override
	public String toString() {
		return 
			"Sala [C�digo = " + this.codigo + 
			", Nombre = " + this.nombre + 
			", N�meroButacas = " + this.numeroButacas + 
			", PrecioNormal = " + String.format("%.2f", this.precioNormal) +
			", PrecioReducido = " + String.format("%.2f", this.precioReducido) + 
			"]";
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroButacas() {
		return this.numeroButacas;
	}

	public void setNumeroButacas(int numeroButacas) {
		this.numeroButacas = numeroButacas;
	}

	public double getPrecioNormal() {
		return this.precioNormal;
	}

	public void setPrecioNormal(double precioNormal) {
		this.precioNormal = precioNormal;
	}

	public double getPrecioReducido() {
		return this.precioReducido;
	}

	public void setPrecioReducido(double precioReducido) {
		this.precioReducido = precioReducido;
	}
	
}
