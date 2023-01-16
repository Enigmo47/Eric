package ejercicios0;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AccesoDepartamento {
	public static final String NOMBRE_FICHERO_DEPARTAMENTOS = "data//departamento.txt";
	
	private static List deFicheroALista() throws IOException{
		BufferedReader flujoEntrada = new BufferedReader(new FileReader(NOMBRE_FICHERO_DEPARTAMENTOS));
		List<Departamento> lista = new ArrayList<>();
		String linea = flujoEntrada.readLine(); 
  		while (linea != null) {  
  			lista.add(new Departamento(linea));
  			linea = flujoEntrada.readLine();
  		}
  		flujoEntrada.close();
  		return lista;
	}
	public static List getDeFicheroALista() throws IOException {
		return deFicheroALista();
	}
	private static void deListaAFichero(List nuevaLista) throws IOException {
		List <Departamento> lista = nuevaLista;
		BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(NOMBRE_FICHERO_DEPARTAMENTOS));
		for(Departamento d: lista) {
			flujoSalida.write(d.toStringWithSeparators() + "\n");
		}
		flujoSalida.close();
	}
	public static void getDeListaAFichero(List nuevaLista) throws IOException {
		deListaAFichero(nuevaLista);
	}
	public static boolean existeDepartamento(Departamento departamento) throws IOException{
		List <Departamento> lista = deFicheroALista();
		for(Departamento d: lista) {
			if(d.getC�digo() == departamento.getC�digo()) {
				return true;
			}
		}
		return false;
	}
	public static boolean existeDepartamento(int c�digo) throws IOException{
		List <Departamento> lista = deFicheroALista();
		for(Departamento d: lista) {
			if(d.getC�digo() == c�digo)
				return true;
		}
		return false;
	}
	public static void insertarDepartamento(Departamento departamento) throws IOException{
		BufferedWriter flujoSalida = new BufferedWriter(new FileWriter(NOMBRE_FICHERO_DEPARTAMENTOS, true));
		flujoSalida.write(departamento.toStringWithSeparators() + "\n");
		flujoSalida.close();
	}
	public static boolean est�Vacio() throws IOException{
		boolean vacio = false;
		BufferedReader flujoEntrada = new BufferedReader(new FileReader(NOMBRE_FICHERO_DEPARTAMENTOS));
		String linea = flujoEntrada.readLine();
		if(linea == null) 
			vacio = true;
		flujoEntrada.close();
		return vacio;
	}
	public static Departamento devuelveDepartamento(int c�digo) throws IOException{
		List <Departamento> lista = deFicheroALista();
		for(Departamento d: lista) {
			if(d.getC�digo() == c�digo)
				return d;
		}
		return null;
	}
	public static List eliminarDepartamento(int c�digo) throws IOException{
		List <Departamento> lista = deFicheroALista();
		Iterator <Departamento> iterador = lista.iterator();
		while(iterador.hasNext()) {
			Departamento departamentoIterador = iterador.next();
			if(departamentoIterador.getC�digo() == c�digo) {
				iterador.remove();
			}
		}
		return lista;
	}
}