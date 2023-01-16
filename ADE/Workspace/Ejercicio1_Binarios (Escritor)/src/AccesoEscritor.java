import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Iterator;


public class AccesoEscritor {

public static String DIRECCION="data/escritores.dat";
	
	public static boolean insertar(Escritor e) throws IOException, ClassNotFoundException, StreamCorruptedException {
		if(comprobar(e.getCodigo())) {
			ObjectOutputStream flujoSalida1 = null;
			MyObjectOutputStream flujoSalida2 = null;
			File fichero = new File(DIRECCION);
			try {
				File archivo2 = new File(DIRECCION);
				archivo2.createNewFile(); // si ya existe no hace nada

				if (fichero.exists()) {
					flujoSalida2 = new MyObjectOutputStream(new FileOutputStream(fichero, true));
					flujoSalida2.writeObject(e);
				}
				// Crear el fichero e insertar el alumno al principio del fichero.
				else {
					flujoSalida1 = new ObjectOutputStream(new FileOutputStream(fichero));
					flujoSalida1.writeObject(e);
				}
			}finally {
					try {
						if (flujoSalida1 != null) {
							flujoSalida1.close();
						}
						if (flujoSalida2 != null) {
							flujoSalida2.close();
						}
					}
					catch (IOException ioe) {
						System.out.println(ioe.getMessage());
						ioe.printStackTrace();
					}
				}
			return true;
		}
		return false;
	}
	
	public static boolean comprobar(int codigo) throws IOException, ClassNotFoundException {
		ArrayList<Escritor> escritores = ListarEscritores();
		for(Escritor x: escritores) {
			if(x.getCodigo()==codigo) {
				return false;
			}
		}
			return true;
	}
	
	
	
	
	public static ArrayList<Escritor> ListarEscritores() throws IOException, StreamCorruptedException, ClassNotFoundException{
		ObjectInputStream flujoEntrada = null;
		ArrayList<Escritor> escritores = new ArrayList<Escritor>();
		try {
			boolean sigo=true;
			File archivo = new File(DIRECCION);
			archivo.createNewFile(); // si ya existe no hace nada
			flujoEntrada = new ObjectInputStream(new FileInputStream(archivo));
			try {
				while (sigo) {
					Escritor escritor = (Escritor) flujoEntrada.readObject();
					escritores.add(escritor);
				}
			}catch (EOFException eofe) {
				sigo=false;
			}
			
		}finally {
			if(flujoEntrada!=null) {
				flujoEntrada.close();
			}
		}
		return escritores;
	}
	
	
	
	public static Escritor consultar(int codigo) throws IOException, ClassNotFoundException {
		
		ArrayList<Escritor> escr = ListarEscritores();
		Escritor e1=null;
		for(Escritor e: escr) {
			if(e.getCodigo()==codigo) {
				e1=e;
			}
		}
		
		return e1;
	}
	
	
	public static void actualizar(Escritor e1) throws IOException, ClassNotFoundException {
		ArrayList<Escritor> escritores = ListarEscritores();
		for(Escritor e: escritores) {
			if(e.getCodigo()==e1.getCodigo()) {
				eliminar(e.getCodigo());
				insertar(e1);
			}
		}
	}
	
	
	public static void eliminar(int codigo) throws IOException, ClassNotFoundException {
		ArrayList<Escritor> escritores = ListarEscritores();
		Iterator<Escritor> iter= escritores.iterator();
		boolean encontrado = false;
		ObjectOutputStream flujoSalida1 = null;
		try {
			while(iter.hasNext()&&encontrado==false) {
				if ((iter.next().getCodigo())==codigo) {
					iter.remove();
					encontrado =true;
				}
			}
			File archivo2 = new File(DIRECCION);
			
			archivo2.createNewFile(); // si ya existe no hace nada
			flujoSalida1 = new ObjectOutputStream(new FileOutputStream(archivo2));
			for(Escritor e: escritores) {
					flujoSalida1.writeObject(e);
			}
		}finally {
				try {
					if (flujoSalida1 != null) {
						flujoSalida1.close();
					}
				}
				catch (IOException ioe) {
					System.out.println(ioe.getMessage());
					ioe.printStackTrace();
				}
			}
		
		
	}
	
}

