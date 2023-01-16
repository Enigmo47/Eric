import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class AccesoDepartamento {
	
	public static String DIRECCION="data/departamentos.txt";
	
	public static boolean insertar(Departamento d) throws IOException {
		if(comprobar(d.getCodigo())) {
			BufferedWriter salida = null;
			File archivo2 = new File(DIRECCION);
			archivo2.createNewFile(); // si ya existe no hace nada
			salida = new BufferedWriter(new FileWriter(archivo2, true)); //instanciamos archivo entrada
			salida.write(d.toStringWithSeparators()+"\n");
			salida.close();
			return true;
		}
		return false;
	}
	
	public static boolean comprobar(int codigo) throws IOException {
		ArrayList<Departamento> deps = ListarDepartamento();
		for(Departamento x: deps) {
			if(x.getCodigo()==codigo) {
				return false;
			}
		}
			return true;
	}
	
	public static boolean comprobarEmpleado(int codigo) throws IOException {
		ArrayList<Empleado> emp = new ArrayList<Empleado>();
		BufferedReader entrada = null;
		File archivo = new File("data/empleados.txt");
		archivo.createNewFile(); // si ya existe no hace nada
		entrada = new BufferedReader(new FileReader(archivo));
		String linea = entrada.readLine();
		while (linea != null) { 
			Empleado e = new Empleado(linea);
			emp.add(e);
  			linea = entrada.readLine();
  		}
		entrada.close();
		for(Empleado x: emp) {
			if(x.getCodigo_departamento()==codigo) {
				return false;
			}
		}
			return true;
	}
	
	
	
	public static ArrayList<Departamento> ListarDepartamento() throws IOException{
		BufferedReader entrada = null;
		ArrayList<Departamento> deps = new ArrayList<Departamento>();
		File archivo = new File(DIRECCION);
		archivo.createNewFile(); // si ya existe no hace nada
		entrada = new BufferedReader(new FileReader(archivo));
		String linea = entrada.readLine();
		while (linea != null) { 
			Departamento d = new Departamento(linea);
			deps.add(d);
  			linea = entrada.readLine();
  		}
		entrada.close();
		return deps;
	}
	
	
	
	public static Departamento consultar(int codigo) throws IOException {
		
		ArrayList<Departamento> deps = ListarDepartamento();
		Departamento d1=null;
		for(Departamento d: deps) {
			if(d.getCodigo()==codigo) {
				d1=d;
			}
		}
		
		return d1;
	}
	
	
	public static void actualizar(Departamento dep1) throws IOException {
		ArrayList<Departamento> deps = ListarDepartamento();
		for(Departamento dep2: deps) {
			if(dep2.getCodigo()==dep1.getCodigo()) {
				eliminar(dep2.getCodigo());
				insertar(dep1);
			}
		}
	}
	
	
	public static void eliminar(int codigo) throws IOException {
		ArrayList<Departamento> deps = ListarDepartamento();
		Iterator<Departamento> iter= deps.iterator();
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
		for(Departamento dep2: deps) {
			salida.write(dep2.toStringWithSeparators()+"\n");
		}
		salida.close();
		
	}
	
}
