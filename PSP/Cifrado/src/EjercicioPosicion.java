import entrada.Teclado;

public class EjercicioPosicion {
	
	public static String texto() {
		return "0. Salir del programa. \n" + "1. Cifrar Texto.\n"
				+ "2. Descifrar texto.\n";
	}

	public static void main(String[] args) {

		int opcion;
		String texto;
		String resultado;
		do {
			System.out.println(texto());
			opcion = Teclado.leerEntero("Dime una opcion \n");
			try {
				switch (opcion) {
				case 0:
					System.out.println("Fin del programa");
					break;
				case 1:
					texto = Teclado.leerCadena("Inserte texto a cifrar");
					resultado = CifradoCesar.cifrar(texto);
					System.out.println(resultado);
					break;
				case 2:
					texto = Teclado.leerCadena("Inserte texto a descifrar");
					resultado = CifradoCesar.descifrar(texto);
					System.out.println(resultado);
					break;
				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 2.");
				}
			}finally {}
		} while (opcion != 0);
		
	}

}
