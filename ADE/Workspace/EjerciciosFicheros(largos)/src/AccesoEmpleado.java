import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class AccesoEmpleado {

	public static String DIRECCION="data/empleados.txt";


	public static boolean comprobar(int codigo) throws IOException {
		ArrayList<Empleado> emps = ListarEmpleado();
		for(Empleado x: emps) {
			if(x.getCodigo()==codigo) {
				return false;
			}
		}
		return true;
	}

	public static boolean comprobarDepartamento(int codigo) throws IOException {
		ArrayList<Departamento> deps = new ArrayList<Departamento>();
		BufferedReader entrada = null;
		File archivo = new File("data/departamentos.txt");
		archivo.createNewFile(); // si ya existe no hace nada
		entrada = new BufferedReader(new FileReader(archivo));
		String linea = entrada.readLine();
		while (linea != null) { 
			Departamento d = new Departamento(linea);
			deps.add(d);
			linea = entrada.readLine();
		}
		entrada.close();
		for(Departamento x: deps) {
			if(x.getCodigo()==codigo) {
				return true;
			}
		}
		return false;
	}

	public static ArrayList<Empleado> ListarEmpleado() throws IOException{
		BufferedReader entrada = null;
		ArrayList<Empleado> emps = new ArrayList<Empleado>();
		File archivo = new File(DIRECCION);
		archivo.createNewFile(); // si ya existe no hace nada
		entrada = new BufferedReader(new FileReader(archivo));
		String linea = entrada.readLine();
		while (linea != null) { 
			Empleado e = new Empleado(linea);
			emps.add(e);
			linea = entrada.readLine();
		}
		entrada.close();


		return emps;
	}
	public static void anadirLista(ArrayList<Empleado> emps) throws IOException{
		BufferedWriter salida = null;
		File archivo = new File(DIRECCION);
		try {
			archivo.createNewFile(); // si ya existe no hace nada
			salida = new BufferedWriter(new FileWriter(archivo));
			for (Empleado e: emps) { 
				salida.write(e.toStringWithSeparators()+"\n");
			}
		}finally {
			salida.close();
		}
	}

	public static void insertar(Empleado e) throws IOException {

		BufferedWriter salida = null;
		File archivo = new File(DIRECCION);;
		try {
			archivo.createNewFile(); // si ya existe no hace nada
			salida = new BufferedWriter(new FileWriter(archivo, true));
			salida.write(e.toStringWithSeparators()+"\n");
		}finally{
			salida.close();
		}
	}

	public static Empleado consultar(int codigo) throws IOException {
		ArrayList<Empleado> emps = ListarEmpleado();
		Empleado e1 = null;
		for(Empleado e: emps) {
			if(e.getCodigo()==codigo) {
				e1=e;
			}
		}

		return e1;
	}

	public static void actualizar(Empleado emp1) throws IOException {
		ArrayList<Empleado> emps = ListarEmpleado();
		for(Empleado e: emps) {
			if(e.getCodigo()==emp1.getCodigo()) {
				/*
				eliminar(e.getCodigo());
				insertar(dep1);
				 */
				e.setCodigo_departamento(emp1.getCodigo_departamento());
				e.setNombre(emp1.getNombre());
				e.setFecha_alta(emp1.getFecha_alta());
				e.setSalario(emp1.getSalario());
				anadirLista(emps);
			}
		}
	}
	public static void eliminar(int codigo) throws IOException {
		ArrayList<Empleado> emps = ListarEmpleado();
		Iterator<Empleado> iter= emps.iterator();
		int num=0;
		while(iter.hasNext()) {
			if ((iter.next().getCodigo())==codigo) {
				iter.remove();
			}
		}
		BufferedWriter salida = null;
		File archivo2 = new File(DIRECCION);
		archivo2.createNewFile(); // si ya existe no hace nada
		salida = new BufferedWriter(new FileWriter(archivo2));
		for(Empleado e: emps) {
			salida.write(e.toStringWithSeparators()+"\n");
		}
		salida.close();

	}

}
