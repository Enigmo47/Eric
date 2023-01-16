import java.io.IOException;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import entrada.Teclado;

public class Actividad_3x01 {



	public static String texto() {
		return "0. Salir del programa. \n"
				+ "1. Insertar un escritor en el fichero binario.\n"
				+ "2. Consultar todos los escritores del fichero binario.\n"
				+ "3. Consultar un escritor, por código, del fichero binario.\n"
				+ "4. Actualizar un escritor, por código, del fichero binario.\n"
				+ "5. Eliminar un escritor, por código, del fichero binario.";
	}

	public static void insertar() throws StreamCorruptedException, ClassNotFoundException, IOException {
		String fecha[];
		int codigo=Teclado.leerEntero("Dime el codigo del escritorio");
		String nombre=Teclado.leerCadena("Dime el nombre del escritor");
		String fecha_nac=Teclado.leerCadena("Dime la fecha de nacimiento del escritor");
		fecha=fecha_nac.split("/");
		if(fecha.length <4 && (Integer.parseInt(fecha[2])<= 3000 && Integer.parseInt(fecha[2])>=0) &&
				(Integer.parseInt(fecha[1])<= 12 && Integer.parseInt(fecha[1])>=1) &&
				(Integer.parseInt(fecha[0])<= 31 && Integer.parseInt(fecha[0])>=1)) {
			String nacionalidad=Teclado.leerCadena("Dime la nacionalidad del escritor");
			Escritor esc=new Escritor(codigo,nombre,fecha_nac,nacionalidad);
			if(AccesoEscritor.insertar(esc)) {
				System.out.println("Se ha insertado un escritor en el fichero de texto.");
			}else {
				System.out.println("Ya existe otro escritor con ese coddigo en el fichero de texto.");
			}
		}
	}
	public static void consultar() throws StreamCorruptedException, ClassNotFoundException, IOException {
		ArrayList<Escritor> escr = AccesoEscritor.ListarEscritores();
		if(escr.size()!=0) {
			for(Escritor d: escr) {
				System.out.println(d);
			}
		}else {
			System.out.println("El fichero de texto no tiene ningun escritor.");
		}
	}


	public static void consultarUno() throws ClassNotFoundException, IOException{
		int codigo1 = Teclado.leerEntero("Dime el codigo del escritor");
		if(!AccesoEscritor.comprobar(codigo1)) {
			Escritor e = AccesoEscritor.consultar(codigo1);
			System.out.println(e);
		}else {
			System.out.println("No existe ningun escritor con ese codigo en el fichero de texto. ");
		}
	}


	public static void actualizar() throws NumberFormatException, ClassNotFoundException, IOException {
		String fecha[];
		int codigo=Teclado.leerEntero("Dime el codigo del escritorio");
		if(!AccesoEscritor.comprobar(codigo)) {
			String nombre=Teclado.leerCadena("Dime el nombre del escritor");
			String fecha_nac=Teclado.leerCadena("Dime la fecha de nacimiento del escritor");
			fecha=fecha_nac.split("/");
			if(fecha.length <4 && (Integer.parseInt(fecha[2])<= 3000 && Integer.parseInt(fecha[2])>=0) &&
					(Integer.parseInt(fecha[1])<= 12 && Integer.parseInt(fecha[1])>=1) &&
					(Integer.parseInt(fecha[0])<= 31 && Integer.parseInt(fecha[0])>=1)) {
				String nacionalidad=Teclado.leerCadena("Dime la nacionalidad del escritor");
				Escritor esc = new Escritor(codigo,nombre,fecha_nac,nacionalidad);
				AccesoEscritor.actualizar(esc);
				System.out.println("Contacto actualizado");
			}else {
				System.out.println("No existe ningun escritor con esa fecha en el fichero de texto.");
			}
		}else {
			System.out.println("El codigo no existe");
		}
	}
	public static void eliminar() throws ClassNotFoundException, IOException {

		int codigo3 = Teclado.leerEntero("Dime el codigo del escritor");
		if(!AccesoEscritor.comprobar(codigo3)) {
			AccesoEscritor.eliminar(codigo3);
			System.out.println("Se ha eliminado un escritor del fichero de texto.");
		}else {
			System.out.println("No existe ningun escritor con ese codigo en el fichero de texto.");
		}

	}


	public static void main(String[] args) {
		try {
			int opcion;
			do {
				System.out.println(texto());
				opcion=Teclado.leerEntero("Dime una opcion \n");
				switch (opcion) {
				case 0:
					System.out.println("Fin del programa");
					break;

				case 1: 
					insertar();
					break;

				case 2:
					consultar();
					break;

				case 3:
					consultarUno();
					break;
				case 4:
					actualizar();
					break;
				case 5:
					eliminar();
					break;
				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
				}
			}while(opcion!=0);
		} catch (RuntimeException e1) {
			System.out.println(e1.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(StreamCorruptedException SCE){
			SCE.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}


