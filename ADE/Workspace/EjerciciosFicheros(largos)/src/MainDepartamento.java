	import java.io.IOException;
	import java.util.ArrayList;
	
	import entrada.Teclado;

public class MainDepartamento {

	
	
	
	public static String texto() {
		return 	  "0. Salir del programa. \n"
				+ "1. Insertar un departamento en el fichero de texto.\n"
				+ "2. Consultar todos los departamentos del fichero de texto.\n"
				+ "3. Consultar un departamento, por codigo, del fichero de texto.\n"
				+ "4. Actualizar un departamento, por codigo, del fichero de texto.\n"
				+ "5. Eliminar un departamento, por codigo, del fichero de texto";
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
					int codigo=Teclado.leerEntero("Dime el codigo del departamento");
					String nombre=Teclado.leerCadena("Dime el nombre del departamento");
					String ubicacion=Teclado.leerCadena("Dime la ubicacion de departamento");
					Departamento dep = new Departamento(codigo,nombre,ubicacion);
					
					if(AccesoDepartamento.insertar(dep)) {
						System.out.println("Se ha insertado un departamento en el fichero de texto.");
					}else {
						System.out.println("Ya existe otro departamento con ese coddigo en el fichero de texto.");
					}
					break;
					
				case 2:
					ArrayList<Departamento> deps =AccesoDepartamento.ListarDepartamento();
					if(deps.size()!=0) {
						for(Departamento d: deps) {
							System.out.println(d);
						}
					}else {
						System.out.println("El fichero de texto no tiene ningun departamento.");
					}
					break;
					
				case 3:
					int codigo1 = Teclado.leerEntero("Dime el codigo del departamento");
					if(!AccesoDepartamento.comprobar(codigo1)) {
						Departamento d = AccesoDepartamento.consultar(codigo1);
						System.out.println(d);
					}else {
						System.out.println("No existe ningun departamento con ese codigo en el fichero de texto. ");
						}
					break;
				case 4:
					
					int codigo2 = Teclado.leerEntero("Dime el codigo del departamento");
					if(!AccesoDepartamento.comprobar(codigo2)) {
						String nombre2=Teclado.leerCadena("Dime el nombre del departamento");
						String ubicacion2=Teclado.leerCadena("Dime la ubicacion de departamento");
						Departamento dep2 = new Departamento(codigo2,nombre2,ubicacion2);
						AccesoDepartamento.actualizar(dep2);
					}else {
						System.out.println("No existe ningun departamento con ese codigo en el fichero de texto.");
					}
					
					break;
				case 5:
					int codigo3 = Teclado.leerEntero("Dime el codigo del departamento");
					if(!AccesoDepartamento.comprobar(codigo3)) {
						if(AccesoDepartamento.comprobarEmpleado(codigo3)) {
							AccesoDepartamento.eliminar(codigo3);
							System.out.println("Se ha eliminado un departamento del fichero de texto.");
						}else {
							System.out.println("Existe al menos un empleado referenciado a ese departamento.");
						}
					}else {
						System.out.println("No existe ningun departamento con ese codigo en el fichero de texto.");
					}
					
					
					break;
				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 5.");
				}
			}while(opcion!=0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeException e1) {
			System.out.println(e1.getMessage());
		}

	}
}
