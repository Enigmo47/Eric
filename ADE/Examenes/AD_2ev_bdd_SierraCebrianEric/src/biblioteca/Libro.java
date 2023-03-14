package biblioteca;

public class Libro {

	// atributos de un libro
	private int codigo;
	private String titulo;
	private String escritor;
	private int agno;
	private String idiomaOrigen;
	private int numeroPaginas;
	
	// Crea un libro a partir de 6 par�metros.
	public Libro(int codigo, String titulo, String escritor, 
	             int agno, String idiomaOrigen, int numeroPaginas) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.escritor = escritor;
		this.agno = agno;
		this.idiomaOrigen = idiomaOrigen;
		this.numeroPaginas = numeroPaginas;
	}
	
	// Crea un libro a partir de 1 par�metro.
	public Libro(String elemento) {
		String texto = extraerTexto(elemento, "codigo");
		this.codigo = Integer.parseInt(texto);
		this.titulo = extraerTexto(elemento, "titulo");
		this.escritor = extraerTexto(elemento, "escritor");
		texto = extraerTexto(elemento, "agno");
		this.agno = Integer.parseInt(texto);
		this.idiomaOrigen = extraerTexto(elemento, "idioma_origen");
		texto = extraerTexto(elemento, "numero_paginas");
		this.numeroPaginas = Integer.parseInt(texto);
	}
	
	// Extrae el texto correspondiente a una etiqueta de un elemento XML. 
	private static String extraerTexto(String elemento, String etiqueta) {
		String marcaInicio = "<" + etiqueta + ">";
		String marcaFin = "</" + etiqueta + ">";
		int posicionInicio = elemento.indexOf(marcaInicio) + marcaInicio.length();
		int posicionFin = elemento.indexOf(marcaFin);
		String texto = elemento.substring(posicionInicio, posicionFin);
		return texto;
	}
	
	// Devuelve una cadena de caracteres con el estado del libro.
	@Override
	public String toString() {
		return 
			"Libro [C�digo = " + codigo + 
			", T�tulo = " + titulo + 
			", Escritor = " + escritor + 
			", A�o = " + agno + 
			", IdiomaOrigen = " + idiomaOrigen + 
			", N�meroPaginas = " + numeroPaginas + 
			"]";
	}

	// Devuelve el c�digo del libro.
	public int getCodigo() {
		return codigo;
	}

	// Devuelve el t�tulo del libro.
	public String getTitulo() {
		return titulo;
	}

	// Devuelve el escritor del libro.
	public String getEscritor() {
		return escritor;
	}

	// Devuelve el a�o del libro.
	public int getAgno() {
		return agno;
	}

	// Devuelve el idioma de origen del libro.
	public String getIdiomaOrigen() {
		return idiomaOrigen;
	}

	// Devuelve el n�mero de p�ginas del libro.
	public int getNumeroPaginas() {
		return numeroPaginas;
	}
	
}
