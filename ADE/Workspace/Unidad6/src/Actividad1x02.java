import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;
import entrada.Teclado;

public class Actividad1x02 {

	public static void insertar() {

		Collection coleccion = null;
		try {
			Class cl = Class.forName("org.exist.xmldb.DatabaseImpl");
			Database database = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(database);

			String url = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionPruebas";
			coleccion = DatabaseManager.getCollection(url, "admin", "admin");
			if (coleccion == null) {
				System.out.println("La colección no existe.");
			} else {
				System.out.println("Conectado con éxito a la colección.");

				int codigo = Teclado.leerEntero("¿Código? ");
				String sentenciaBuscarZonaPorCodigo = "for $zon in /zonas/zona " + " where $zon/cod_zona = " + codigo
						+ " return $zon";
				XPathQueryService servicio = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
				ResourceSet resultados = servicio.query(sentenciaBuscarZonaPorCodigo);

				ResourceIterator iterador = resultados.getIterator();
				if (iterador.hasMoreResources()) {
					System.out.println("Ya existe una zona con el código " + codigo + " en el XML.");
				} else {
					String nombre = Teclado.leerCadena("¿Nombre? ");
					String director = Teclado.leerCadena("¿Cual es el director de la zona?");

					String sentenciaInsertarProducto = "update insert " + "<zona>" + "<cod_zona>" + codigo
							+ "</cod_zona>" + "<nombre>" + nombre + "</nombre>" + "<director>" + director
							+ "</director>" + "</zona> " + "into /zonas";
					ResourceSet resultados2 = servicio.query(sentenciaInsertarProducto);

					System.out.println("Se ha insertado con éxito una nueva zona en el XML.");
				}

			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
		} catch (InstantiationException ie) {
			System.out.println("Error de instanciación de base de datos XML: " + ie.getMessage());
		} catch (IllegalAccessException iae) {
			System.out.println("Error de acceso ilegal: " + iae.getMessage());
		} catch (XMLDBException xmldbe) {
			System.out.println("Error de base de datos XML: " + xmldbe.getMessage());
		} finally {
			if (coleccion != null) {
				try {
					coleccion.close();
				} catch (XMLDBException xmldbe) {
					System.out.println("Error de base de datos XML: " + xmldbe.getMessage());
				}
			}
		}

	}

	public static void consultar() {

		try {
			Class cl = Class.forName("org.exist.xmldb.DatabaseImpl");
			Database database = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(database);

			String url = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionPruebas";
			Collection coleccion = DatabaseManager.getCollection(url, "admin", "admin");
			if (coleccion == null) {
				System.out.println("La colección no existe.");
			} else {

				System.out.println("Conectado con éxito a la colección.");

				int codigo = Teclado.leerEntero("¿Código? ");
				String sentenciaBuscarZonaPorCodigo = "for $zon in /zonas/zona " + " where $zon/cod_zona = " + codigo
						+ " return $zon";
				XPathQueryService servicio = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
				ResourceSet resultados = servicio.query(sentenciaBuscarZonaPorCodigo);

				int contador = 0;
				ResourceIterator iterador = resultados.getIterator();
				while (iterador.hasMoreResources()) {
					Resource recurso = iterador.nextResource();
					String producto = (String) recurso.getContent();
					System.out.println(producto);
					contador++;
				}
				System.out.println("Se han consultado " + contador + " zonas.");
				if (contador == 0) {
					System.out.println("No se ha encontrado ninguna zona.");
				}

				coleccion.close();
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
		} catch (InstantiationException ie) {
			System.out.println("Error de instanciación de base de datos XML: " + ie.getMessage());
		} catch (IllegalAccessException iae) {
			System.out.println("Error de acceso ilegal: " + iae.getMessage());
		} catch (XMLDBException xmldbe) {
			System.out.println("Error de base de datos XML: " + xmldbe.getMessage());
		}

	}

	public static void consultarPorCodigo() {

		Collection coleccion = null;
		try {
			Class cl = Class.forName("org.exist.xmldb.DatabaseImpl");
			Database database = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(database);

			String url = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionPruebas";
			coleccion = DatabaseManager.getCollection(url, "admin", "admin");
			if (coleccion == null) {
				System.out.println("La colección no existe.");
			} else {
				System.out.println("Conectado con éxito a la colección.");

				XPathQueryService servicio = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
				String consulta = "for $zon in /zonas/zona " + " order by $zon/nombre " + " return $zon";
				ResourceSet resultados = servicio.query(consulta);

				int contador = 0;
				ResourceIterator iterador = resultados.getIterator();
				while (iterador.hasMoreResources()) {
					Resource recurso = iterador.nextResource();
					String producto = (String) recurso.getContent();
					System.out.println(producto);
					contador++;
				}
				System.out.println("Se han consultado " + contador + " zonas.");
				if (contador == 0) {
					System.out.println("No se ha encontrado ninguna zona.");
				}

				coleccion.close();
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
		} catch (InstantiationException ie) {
			System.out.println("Error de instanciación de base de datos XML: " + ie.getMessage());
		} catch (IllegalAccessException iae) {
			System.out.println("Error de acceso ilegal: " + iae.getMessage());
		} catch (XMLDBException xmldbe) {
			System.out.println("Error de base de datos XML: " + xmldbe.getMessage());
		}

	}

	public static void eliminar() {
		Collection coleccion = null;
		try {
			Class cl = Class.forName("org.exist.xmldb.DatabaseImpl");
			Database database = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(database);

			String url = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionPruebas";
			coleccion = DatabaseManager.getCollection(url, "admin", "admin");
			if (coleccion == null) {
				System.out.println("La colección no existe.");
			} else {
				System.out.println("Conectado con éxito a la colección.");

				int codigo = Teclado.leerEntero("¿Código? ");
				String sentenciaBuscarZonaPorCodigo = "for $zon in /zonas/zona " + " where $zon/cod_zona = " + codigo
						+ " return $zon";

				XPathQueryService servicio = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
				ResourceSet resultados = servicio.query(sentenciaBuscarZonaPorCodigo);

				ResourceIterator iterador = resultados.getIterator();
				if (iterador.hasMoreResources()) {
					String sentenciaEliminarZona = "update delete " + "/zonas/zona[cod_zona = " + codigo + "]";
					ResourceSet resultados2 = servicio.query(sentenciaEliminarZona);

					System.out.println("Se ha eliminado con éxito una zona del XML.");
				} else {
					System.out.println("No existe una zona con el código " + codigo + " en el XML.");
				}

			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
		} catch (InstantiationException ie) {
			System.out.println("Error de instanciación de base de datos XML: " + ie.getMessage());
		} catch (IllegalAccessException iae) {
			System.out.println("Error de acceso ilegal: " + iae.getMessage());
		} catch (XMLDBException xmldbe) {
			System.out.println("Error de base de datos XML: " + xmldbe.getMessage());
		} finally {
			if (coleccion != null) {
				try {
					coleccion.close();
				} catch (XMLDBException xmldbe) {
					System.out.println("Error de base de datos XML: " + xmldbe.getMessage());
				}
			}
		}
	}

	public static void actualizar() {

		Collection coleccion = null;
		try {
			Class cl = Class.forName("org.exist.xmldb.DatabaseImpl");
			Database database = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(database);

			String url = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionPruebas";
			coleccion = DatabaseManager.getCollection(url, "admin", "admin");
			if (coleccion == null) {
				System.out.println("La colección no existe.");
			} else {
				System.out.println("Conectado con éxito a la colección.");

				int codigo = Teclado.leerEntero("¿Código? ");
				String sentenciaBuscarZonaPorCodigo = "for $zon in /zonas/zona " + " where $zon/cod_zona = " + codigo
						+ " return $zon";

				XPathQueryService servicio = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
				ResourceSet resultados = servicio.query(sentenciaBuscarZonaPorCodigo);

				ResourceIterator iterador = resultados.getIterator();
				if (iterador.hasMoreResources()) {
					String nombre = Teclado.leerCadena("¿Nombre? ");
					String director = Teclado.leerCadena("¿Cual es el director de la zona?");

					String sentenciaActualizarProducto = "update replace " + "/productos/produc[cod_prod = " + codigo
							+ "] with " + "<produc>" + "<cod_prod>" + codigo + "</cod_prod>" + "<nombre>" + nombre
							+ "</nombre>" + "<director>" + director + "</director>" + "</produc>";
					ResourceSet resultados2 = servicio.query(sentenciaActualizarProducto);

					System.out.println("Se ha actualizado con éxito una zona del XML.");
				} else {
					System.out.println("No existe una zona con el código " + codigo + " en el XML.");
				}

			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
		} catch (InstantiationException ie) {
			System.out.println("Error de instanciación de base de datos XML: " + ie.getMessage());
		} catch (IllegalAccessException iae) {
			System.out.println("Error de acceso ilegal: " + iae.getMessage());
		} catch (XMLDBException xmldbe) {
			System.out.println("Error de base de datos XML: " + xmldbe.getMessage());
		} finally {
			if (coleccion != null) {
				try {
					coleccion.close();
				} catch (XMLDBException xmldbe) {
					System.out.println("Error de base de datos XML: " + xmldbe.getMessage());
				}
			}
		}

	}

	public static String texto() {
		return "0. Salir del programa. \n" + "1. Insertar una zona en la base de datos\n"
				+ "2. Consultar zonas en la base de datos.\n" + "3. Consultar una zona por código.\n"
				+ "4. Eliminar una zona.\n" + "5. Actualizar una zona.";
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
					insertar();
					break;
				case 2:
					consultar();
					break;
				case 3:
					consultarPorCodigo();
					break;
				case 4:
					eliminar();
					break;
				case 5:
					actualizar();
					break;

				default:
					System.out.println("La opcion de menu debe estar comprendida entre 0 y 3.");
				}
			} catch (RuntimeException e1) {
				System.out.println(e1.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (opcion != 0);

	}

}
