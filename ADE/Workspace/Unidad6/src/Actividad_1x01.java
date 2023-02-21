import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;
import entrada.Teclado;

public class Actividad_1x01 {

	public void insertar() {

		Collection coleccion = null;
		try {
			Class cl = Class.forName("org.exist.xmldb.DatabaseImpl");
			Database database = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(database);

			String url = "xmldb:exist://localhost:8080/exist/xmlrpc/db/productos";
			coleccion = DatabaseManager.getCollection(url, "admin", "admin");
			if (coleccion == null) {
				System.out.println("La colecci�n no existe.");
			} else {
				System.out.println("Conectado con �xito a la colecci�n.");

				int codigo = Teclado.leerEntero("�C�digo? ");
				String sentenciaBuscarProductoPorCodigo = "for $prod in /productos/produc " + " where $prod/cod_prod = "
						+ codigo + " return $prod";
				XPathQueryService servicio = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
				ResourceSet resultados = servicio.query(sentenciaBuscarProductoPorCodigo);

				ResourceIterator iterador = resultados.getIterator();
				if (iterador.hasMoreResources()) {
					System.out.println("Ya existe un producto con el c�digo " + codigo + " en el XML.");
				} else {
					String denominacion = Teclado.leerCadena("�Denominaci�n? ");
					double precio = Teclado.leerReal("�Precio? ");
					int stockActual = Teclado.leerEntero("�Stock Actual? ");
					int stockMinimo = Teclado.leerEntero("�Stock M�nimo? ");
					int codigoZona = Teclado.leerEntero("�C�digo de Zona? ");

					String sentenciaInsertarProducto = "update insert " + "<produc>" + "<cod_prod>" + codigo
							+ "</cod_prod>" + "<denominacion>" + denominacion + "</denominacion>" + "<precio>"
							+ String.format("%.2f", precio) + "</precio>" + "<stock_actual>" + stockActual
							+ "</stock_actual>" + "<stock_minimo>" + stockMinimo + "</stock_minimo>" + "<cod_zona>"
							+ codigoZona + "</cod_zona>" + "</produc> " + "into /productos";
					ResourceSet resultados2 = servicio.query(sentenciaInsertarProducto);

					System.out.println("Se ha insertado con �xito un nuevo producto en el XML.");
				}

			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
		} catch (InstantiationException ie) {
			System.out.println("Error de instanciaci�n de base de datos XML: " + ie.getMessage());
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

	public void consultar() {

		try {
			Class cl = Class.forName("org.exist.xmldb.DatabaseImpl");
			Database database = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(database);

			String url = "xmldb:exist://localhost:8080/exist/xmlrpc/db/productos";
			Collection coleccion = DatabaseManager.getCollection(url, "admin", "admin");
			if (coleccion == null) {
				System.out.println("La colecci�n no existe.");
			} else {
				System.out.println("Conectado con �xito a la colecci�n.");

				XPathQueryService servicio = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
				String consulta = "for $prod in /productos/produc " + " order by $prod/denominacion " + " return $prod";
				ResourceSet resultados = servicio.query(consulta);

				int contador = 0;
				ResourceIterator iterador = resultados.getIterator();
				while (iterador.hasMoreResources()) {
					Resource recurso = iterador.nextResource();
					String producto = (String) recurso.getContent();
					System.out.println(producto);
					contador++;
				}
				System.out.println("Se han consultado " + contador + " productos.");
				if (contador == 0) {
					System.out.println("No se ha encontrado ning�n producto.");
				}

				coleccion.close();
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
		} catch (InstantiationException ie) {
			System.out.println("Error de instanciaci�n de base de datos XML: " + ie.getMessage());
		} catch (IllegalAccessException iae) {
			System.out.println("Error de acceso ilegal: " + iae.getMessage());
		} catch (XMLDBException xmldbe) {
			System.out.println("Error de base de datos XML: " + xmldbe.getMessage());
		}

	}

	public void eliminar() {
		Collection coleccion = null;
		try {
			Class cl = Class.forName("org.exist.xmldb.DatabaseImpl");
			Database database = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(database);

			String url = "xmldb:exist://localhost:8080/exist/xmlrpc/db/productos";
			coleccion = DatabaseManager.getCollection(url, "admin", "admin");
			if (coleccion == null) {
				System.out.println("La colecci�n no existe.");
			} else {
				System.out.println("Conectado con �xito a la colecci�n.");

				int codigo = Teclado.leerEntero("�C�digo? ");
				String sentenciaBuscarProductoPorCodigo = "for $prod in /productos/produc " + " where $prod/cod_prod = "
						+ codigo + " return $prod";

				XPathQueryService servicio = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
				ResourceSet resultados = servicio.query(sentenciaBuscarProductoPorCodigo);

				ResourceIterator iterador = resultados.getIterator();
				if (iterador.hasMoreResources()) {
					String sentenciaEliminarProducto = "update delete " + "/productos/produc[cod_prod = " + codigo
							+ "]";
					ResourceSet resultados2 = servicio.query(sentenciaEliminarProducto);

					System.out.println("Se ha eliminado con �xito un producto del XML.");
				} else {
					System.out.println("No existe un producto con el c�digo " + codigo + " en el XML.");
				}

			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
		} catch (InstantiationException ie) {
			System.out.println("Error de instanciaci�n de base de datos XML: " + ie.getMessage());
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

	public void actualizar() {
		
		Collection coleccion = null;
		try {
			Class cl = Class.forName("org.exist.xmldb.DatabaseImpl");
			Database database = (Database) cl.newInstance();
			DatabaseManager.registerDatabase(database);

			String url = "xmldb:exist://localhost:8080/exist/xmlrpc/db/ColeccionPruebas";
			coleccion = DatabaseManager.getCollection(url, "admin", "admin");
			if (coleccion == null) {
				System.out.println("La colecci�n no existe.");
			}
			else {
				System.out.println("Conectado con �xito a la colecci�n.");

				int codigo = Teclado.leerEntero("�C�digo? ");
				String sentenciaBuscarProductoPorCodigo = 
						"for $prod in /productos/produc " +
						" where $prod/cod_prod = " + codigo +
						" return $prod";
				
				XPathQueryService servicio = 
						(XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
				ResourceSet resultados = servicio.query(sentenciaBuscarProductoPorCodigo);
				
				ResourceIterator iterador = resultados.getIterator();
				if (iterador.hasMoreResources()) {
					String denominacion = Teclado.leerCadena("�Denominaci�n? ");
					double precio = Teclado.leerReal("�Precio? ");
					int stockActual = Teclado.leerEntero("�Stock Actual? ");
					int stockMinimo = Teclado.leerEntero("�Stock M�nimo? ");
					int codigoZona = Teclado.leerEntero("�C�digo de Zona? ");
					
					String sentenciaActualizarProducto = 
							"update replace " +
							"/productos/produc[cod_prod = " + codigo + "] with " +
							"<produc>" +
								"<cod_prod>" + codigo + "</cod_prod>" +
								"<denominacion>" + denominacion + "</denominacion>" +
								"<precio>" + String.format("%.2f", precio) + "</precio>" +
								"<stock_actual>" + stockActual + "</stock_actual>" +
								"<stock_minimo>" + stockMinimo + "</stock_minimo>" +
								"<cod_zona>" + codigoZona + "</cod_zona>" +
							"</produc>";		
					ResourceSet resultados2 = servicio.query(sentenciaActualizarProducto);
					
					System.out.println("Se ha actualizado con �xito un producto del XML.");
				}
				else {
					System.out.println("No existe un producto con el c�digo " + codigo + " en el XML.");
				}
							
			}
		} 
		catch (ClassNotFoundException cnfe) {
			System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
		} 
		catch (InstantiationException ie) {
			System.out.println("Error de instanciaci�n de base de datos XML: " + ie.getMessage());
		} 
		catch (IllegalAccessException iae) {
			System.out.println("Error de acceso ilegal: " + iae.getMessage());
		} 
		catch (XMLDBException xmldbe) {
			System.out.println("Error de base de datos XML: " + xmldbe.getMessage());
		}
		finally {
			if (coleccion != null) {
				try {
					coleccion.close();
				} 
				catch (XMLDBException xmldbe) {
					System.out.println("Error de base de datos XML: " + xmldbe.getMessage());
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
