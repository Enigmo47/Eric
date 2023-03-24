import entrada.Teclado;

public class GestorVideojuego {

	public static String texto() {
		return "0. Salir del programa. \n" + "1. Insertar un juego en la base de datos.\n"
				+ "2. Consultar todos los juegos de la base de datos.\n"
				+ "3. Consultar un juego, por c�digo, de la base de datos.\n"
				+ "4. Actualizar un juego, por c�digo, de la base de datos. \n"
				+ "5. Eliminar un juego, por c�digo, de la base de datos.";
	}

	public static void main(String[] args) {

		int opcion;
		do {
			System.out.println(texto());
			opcion = Teclado.leerEntero("Dime una opcion \n");
			try {
				switch (opcion) {
				case 0:
					System.out.println("Fin del programa");
					break;
				case 1:
					int codigo = Teclado.leerEntero("�C�digo? ");
					String titulo = Teclado.leerCadena("�T�tulo? ");
					int agno = Teclado.leerEntero("�A�o? ");
					String desarrollador = Teclado.leerCadena("�Desarrollador? ");
					double precio = Teclado.leerReal("�Precio?");

					Videojuego vid = new Videojuego(codigo, titulo, agno, desarrollador, precio);
					AccesoVideojuego.insertar(vid);
					break;
				case 2:
					AccesoVideojuego.consultar();
					break;
				case 3:
					codigo = Teclado.leerEntero("�C�digo? ");
					AccesoVideojuego.consultarCodigo(codigo);
					break;
				case 4:
					codigo = Teclado.leerEntero("�C�digo? ");
					titulo = Teclado.leerCadena("�T�tulo? ");
					agno = Teclado.leerEntero("�A�o? ");
					desarrollador = Teclado.leerCadena("�Desarrollador? ");
					precio = Teclado.leerReal("�Precio? ");
					vid = new Videojuego(codigo, titulo, agno, desarrollador, precio);
					AccesoVideojuego.actualizar(vid);
					break;
				case 5:
					codigo = Teclado.leerEntero("�C�digo? ");
					AccesoVideojuego.borrar(codigo);
					break;
				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
				}
			} catch (RuntimeException e1) {
				e1.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (opcion != 0);
	}

}
