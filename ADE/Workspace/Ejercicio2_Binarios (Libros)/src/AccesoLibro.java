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
import java.util.ArrayList;
import java.util.Iterator;


public class AccesoLibro {

	/**
	 * En este parametro estatico se almacena la direccion del fichero,
	 * esta puesto asi ya que sera necesario utilizarlo varias veces.
	 */
	public static String DIRECCION="data/libros.dat";


	/**
	 * Este metodo tiene la funcion de insertar en un archivo un objeto.
	 * @param d Es el objeto recibido para ser insertado en el fichero
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void insertar(Libro d) throws IOException, ClassNotFoundException {
		ObjectOutputStream flujoSalida1 = null;
		MyObjectOutputStream flujoSalida2 = null;
		try {
			File archivo = new File(DIRECCION);
			archivo.createNewFile(); // esta funcion creara el archivo en caso de que no exista, si ya existe no hara nada
			if (archivo.exists()) {
				flujoSalida2 = new MyObjectOutputStream(new FileOutputStream(archivo, true));
				flujoSalida2.writeObject(d);
			}else {
				flujoSalida1 = new ObjectOutputStream(new FileOutputStream(archivo));
				flujoSalida1.writeObject(d);
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
	}


	/**
	 * Este metodo te comprueba si existe un objeto de tipo Libro en el arraylist
	 * @param codigo Es el codigo del Libro que queremos comprobar si existe
	 * @return Si existe el objeto en el arraylist, lo devolvera, sino devolvera null
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Libro comprobar(int codigo) throws IOException, ClassNotFoundException {
		ArrayList<Libro> deps = ListarLibros();
		for(Libro x: deps) {
			if(x.getCodigo()==codigo) {
				return x;
			}
		}
		return null;
	}


	/**
	 * Este metodo recibe el codigo de escritor de un libro y comprueba si realmente existe un
	 * escritor con ese codigo metiendose en el archivo de escritores.
	 * 
	 * @param codigo Este codigo, es el codigo de el Escritor de un libro en concreto
	 * @return En caso de que si exista un escritor con este codigo devolvera un True, si no hay
	 * ningun escritor con ese codigo devolvera un False.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static boolean comprobarEscritor(int codigo) throws IOException, ClassNotFoundException {
		ArrayList<Escritor> escs = new ArrayList<Escritor>();
		ObjectInputStream flujoEntrada = null;
		boolean sigo = true;

		try {

			File archivo = new File("data/escritores.dat");
			archivo.createNewFile(); // si ya existe no hace nada
			flujoEntrada = new ObjectInputStream(new FileInputStream(archivo));
			try {
				while (sigo) {
					Escritor esc = (Escritor) flujoEntrada.readObject();
					escs.add(esc);
				}
			}
			catch (EOFException eofe) {
				sigo=false;
			}


		}finally {
			if(flujoEntrada!=null) {
				flujoEntrada.close();
			}
		}

		for(Escritor x: escs) {
			if(x.getCodigo()==codigo) {
				return true;
			}
		}
		return false;
	}


	/**
	 * Este metodo abre el archivo en lectura, con esto va recorriendo los objetos almacenados y
	 * los guarda en un array para tener una mayor facilidad a la hora de alterar el archivo.
	 * 
	 * @return Devuelve la lista con todos los objetos, en caso de no tener(se comprueba mas tarde), se imprime que esta vacio
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws EOFException
	 */
	public static ArrayList<Libro> ListarLibros() throws IOException, ClassNotFoundException, EOFException{
		ObjectInputStream flujoEntrada = null;
		ArrayList<Libro> libros = new ArrayList<Libro>();
		try {
			boolean sigo = true;
			File archivo = new File(DIRECCION);
			archivo.createNewFile(); // si ya existe no hace nada
			flujoEntrada = new ObjectInputStream(new FileInputStream(archivo));
			try {
				while (sigo) {
					Libro alumno = (Libro) flujoEntrada.readObject();
					libros.add(alumno);
				}
			}catch (EOFException eofe) {
				sigo=false;
			}

		}finally {
			if(flujoEntrada!=null) {
				flujoEntrada.close();
			}
		}

		return libros;
	}


	/**
	 * Este metodo recibe un ArrayList y va introduciendo uno por uno los objetos en el archivo,
	 * no tiene el true en el ObjectOutputStream porque se busca sobrescribir en caso de que exista
	 * una informacion anterior
	 * 
	 * @param libs ArrayList que queremos introducir en el fichero
	 * @throws IOException
	 */
	public static void anadirLista(ArrayList<Libro> libs) throws IOException{
		ObjectOutputStream flujoSalida1 = null;
		File archivo = new File(DIRECCION);
		try {
			archivo.createNewFile(); // si ya existe no hace nada

			flujoSalida1 = new ObjectOutputStream(new FileOutputStream(archivo));
			for(Libro l: libs) {
				flujoSalida1.writeObject(l);
			}
		}finally {
			try {
				if (flujoSalida1 != null) {
					flujoSalida1.close();
				}
			}catch (IOException ioe) {
				System.out.println(ioe.getMessage());
				ioe.printStackTrace();
			}
		}
	}

	/**
	 * Este metodo busca entre todos los libros uno con el mismo codigo, cuando lo encuentra
	 * actualiza los datos de esto cambiandolos por los datos almacenados en el Libro entrante.
	 * Para finalizar hacemos un anadirLista para que estos se añadan al fichero.
	 * 
	 * @param lib Objeto con la informacion nueva que se quiere poner en la actualizacion
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void actualizar(Libro lib) throws IOException, ClassNotFoundException {
		ArrayList<Libro> libs = ListarLibros();
		for(Libro lib2: libs) {
			if(lib2.getCodigo()==lib.getCodigo()) {

				lib2.setAno_publicacion(lib.getAno_publicacion());
				lib2.setCodigo_escritor(lib.getCodigo_escritor());
				lib2.setPrecio(lib.getPrecio());
				lib2.setTitulo(lib.getTitulo());

				anadirLista(libs);
			}
		}
	}



	/**
	 * Este metodo sirve para eliminar un Libro en concreto atraves de su codigo.
	 * Una vez eliminado del ArrayList, introducimos el ArrayList dentro del fichero
	 * a traves de anadirLista(sobrescribiendo lo anterior)
	 * 
	 * @param codigo Codigo del Libro que queremos eliminar
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void eliminar(int codigo) throws IOException, ClassNotFoundException {
		ArrayList<Libro> libs = ListarLibros();
		Iterator<Libro> iter= libs.iterator();
		ObjectOutputStream flujoSalida = null;
		boolean encontrado = false;
		try {
			while(iter.hasNext()&&encontrado==false) {

				if ((iter.next().getCodigo())==codigo) {
					iter.remove();
					encontrado =true;
				}

			}

			anadirLista(libs);

		}finally {
			try {
				if (flujoSalida != null) {
					flujoSalida.close();
				}
			}catch (IOException ioe) {
				System.out.println(ioe.getMessage());
				ioe.printStackTrace();
			}
		}

	}

}
