package Ejercicio2;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Equipo;
import modelo.Fecha;
import modelo.Jugador;
import modelo.Partido;

public class AccesoBaseDatos {

	public static Boolean insertar(Equipo equipo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/campeonato.odb");
		EntityManager conexion = null;

		try {
			conexion = emf.createEntityManager();
			conexion.getTransaction().begin();
			conexion.persist(equipo);
			conexion.getTransaction().commit();
			return true;
		}catch (Exception e) {
			return false;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			emf.close();
		}
	}
	
	public static List<Equipo> consultar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/campeonato.odb");
		EntityManager conexion = null;
		try {
			conexion = emf.createEntityManager();
			TypedQuery<Equipo> consulta = conexion.createQuery("SELECT e FROM Equipo e", 
			                                                    Equipo.class);
			List<Equipo> equipos = consulta.getResultList();
			return equipos;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			emf.close();
		}
	
	}
	
	public static Equipo consultarCodigo(String nombre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/campeonato.odb");
		EntityManager conexion = null;
		Equipo equipo=null;
		try {
			conexion = emf.createEntityManager();
			equipo = conexion.find(Equipo.class, nombre);
			return equipo;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			emf.close();
		}
	
	}
	
	public static Boolean actualizar(String nombre, String ciudad) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/campeonato.odb");
		EntityManager conexion = null;
		
		try {
			conexion = emf.createEntityManager();
			Equipo equipo = conexion.find(Equipo.class, nombre);
			conexion.getTransaction().begin();
			equipo.setCiudad(ciudad);
			conexion.getTransaction().commit();
			return true;
		}
		catch(Exception e) {
			return false;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			emf.close();
		}
		
	}
	
	public static List<Jugador> consultarEquipo(String nombre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/campeonato.odb");
		EntityManager conexion = null;
		try {
			conexion = emf.createEntityManager();
			TypedQuery<Jugador> consulta = conexion.createQuery("select j from Equipo e, Jugador j where e.jugadores.contains(j) and e.nombre ='"+nombre+"'", 
			                                                    Jugador.class);
			List<Jugador> jugadores = consulta.getResultList();
			return jugadores;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			emf.close();
		}
	
	}
	
	public static List<Partido> consultarPartido(String nombre) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/campeonato.odb");
		EntityManager conexion = null;
		try {
			conexion = emf.createEntityManager();
			TypedQuery<Partido> consulta = conexion.createQuery("select p from Partido p where p.equipoLocal.nombre ='"+nombre+"' or p.equipoVisitante.nombre ='"+nombre+"'", 
		            Partido.class);
			List<Partido> partidos = consulta.getResultList();
			return partidos;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			emf.close();
		}
	
	}
	
	public static void eliminar (String codigo) {
	

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/campeonato.odb");
		EntityManager conexion = null;
		
		try {
			conexion = emf.createEntityManager();
			Jugador jugador = conexion.find(Jugador.class, codigo);
			conexion.getTransaction().begin();
			conexion.remove(jugador);
			conexion.getTransaction().commit();
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			emf.close();
		}
		
	}
	
	
}
