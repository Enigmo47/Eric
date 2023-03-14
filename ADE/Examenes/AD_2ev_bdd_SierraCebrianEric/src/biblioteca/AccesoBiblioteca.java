package biblioteca;

import java.util.ArrayList;

import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

import entrada.Teclado;

public class AccesoBiblioteca {

	public static Collection conectar(String nombreColeccion)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Class cl = Class.forName("org.exist.xmldb.DatabaseImpl");
		Database database = (Database) cl.newInstance();
		DatabaseManager.registerDatabase(database);
		String url = "xmldb:exist://localhost:8080/exist/xmlrpc/db/" + nombreColeccion;
		Collection coleccion = DatabaseManager.getCollection(url, "admin", "admin");
		return coleccion;
	}

	public static void desconectar(Collection coleccion) throws XMLDBException {
		if (coleccion != null) {
			coleccion.close();
		}
	}

	public static ArrayList<Libro> consultarLibros()
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion = conectar("biblioteca");
			ArrayList<Libro> libros = new ArrayList<Libro>();
			String sentenciaBuscarLibros = "for $libro in /libros/libro" + "order by $agno"
					+ " return <item>{$libro/codigp/text()" + "},{" + "$libro/titulo/text() " + "},{"
					+ "$libro/escritor/text() " + "},{" + "$libro/agno/text() " + "},{" + "$libro/idioma_origen/text() "
					+ "},{" + "$libro/numero_paginas/text()}</item>";
			XPathQueryService servicio = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
			ResourceSet resultados = servicio.query(sentenciaBuscarLibros);

			ResourceIterator iterador = resultados.getIterator();
			while (iterador.hasMoreResources()) {
				Resource recurso = iterador.nextResource();
				String libroMal = (String) recurso.getContent();
				libroMal = libroMal.replace("<item>", "");
				libroMal = libroMal.replace("</item>", "");
				String lista[] = libroMal.split(",");
				Libro libro = new Libro(Integer.parseInt(lista[1]), lista[2], lista[3], Integer.parseInt(lista[4]),
						lista[5], Integer.parseInt(lista[6]));
				libros.add(libro);
			}
			return libros;
		} finally {
			desconectar(coleccion);
		}
	}

	public static Socio consultarSocio(String dni)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion = conectar("biblioteca");
			Socio socio = null;
			String sentenciaBuscarSocioPorCodigo = "for $socio in /socios/socio" + " where $socio/dni = " + dni
					+ " return $socio";
			XPathQueryService servicio = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
			ResourceSet resultados = servicio.query(sentenciaBuscarSocioPorCodigo);

			ResourceIterator iterador = resultados.getIterator();
			while (iterador.hasMoreResources()) {
				Resource recurso = iterador.nextResource();
				String texto = (String) recurso.getContent();
				socio = new Socio(texto);

			}
			return socio;
		} finally {
			desconectar(coleccion);
		}
	}

	public static ArrayList<Prestamo> consultarPrestamos(String dni)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion = conectar("biblioteca");
			ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
			String sentenciaBuscarPrestamos = "for $prestamo in /prestamos/prestamo"
					+ " return <item>{$prestamo/dni_socio/text()" + "},{" + "$prestamo/codigo_libro/text() " + "},{"
					+ "$prestamo/fecha_inicio/text() " + "},{" + "$prestamo/fecha_fin/text() " + "},{"
					+ "$prestamo/fecha_devolucion/text()}</item>";
			XPathQueryService servicio = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");
			ResourceSet resultados = servicio.query(sentenciaBuscarPrestamos);

			ResourceIterator iterador = resultados.getIterator();
			while (iterador.hasMoreResources()) {
				Resource recurso = iterador.nextResource();
				String PrestamoMal = (String) recurso.getContent();
				PrestamoMal = PrestamoMal.replace("<item>", "");
				PrestamoMal = PrestamoMal.replace("</item>", "");
				String lista[] = PrestamoMal.split(",");
				Prestamo prestamo = new Prestamo(lista[1], Integer.parseInt(lista[2]), lista[3], lista[4], lista[5]);
				prestamos.add(prestamo);
			}
			return prestamos;
		} finally {
			desconectar(coleccion);
		}
	}

	public static void insertar(Socio socio)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion = conectar("biblioteca");

			XPathQueryService servicio = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");

			String sentenciaInsertarProducto = "update insert " + "<socio>" + "<dni>" + socio.getDni() + "</dni>"
					+ "<nombre>" + socio.getNombre() + "</nombre>" + "<localidad>" + socio.getLocalidad()
					+ "</localidad>" + "<telefono>" + socio.getTelefono() + "</telefono>" + "<correo>"
					+ socio.getCorreo() + "</correo>" + "</zona> " + "into /zonas";

			ResourceSet resultados = servicio.query(sentenciaInsertarProducto);
		} finally {
			desconectar(coleccion);
		}

	}

	public static void eliminar(String dni)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, XMLDBException {
		Collection coleccion = null;
		try {
			coleccion = conectar("biblioteca");

			XPathQueryService servicio = (XPathQueryService) coleccion.getService("XPathQueryService", "1.0");

			String sentenciaEliminarProducto = "update delete " + "/socios/socio[dni = " + dni + "]";
			servicio.query(sentenciaEliminarProducto);
		} finally {
			desconectar(coleccion);
		}

	}

}
