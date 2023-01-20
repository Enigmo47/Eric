package Ejercicio1;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Fecha;
import modelo.Jugador;

public class AccesoBaseDatos {

	public static void insertar(Jugador jugador) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/campeonato.odb");
		EntityManager conexion = null;

		try {
			conexion = emf.createEntityManager();
			conexion.getTransaction().begin();
			conexion.persist(jugador);
			conexion.getTransaction().commit();
			
		}catch (Exception e) {
			throw e;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
		}
		emf.close();
	}
	
	public static List<Jugador> consultar() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/campeonato.odb");
		EntityManager conexion = null;
		try {
			conexion = emf.createEntityManager();
			TypedQuery<Jugador> consulta = conexion.createQuery("SELECT j FROM Jugador j", 
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
	
	public static Jugador consultarCodigo(int codigo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/campeonato.odb");
		EntityManager conexion = null;
		Jugador jugador=null;
		try {
			conexion = emf.createEntityManager();
			jugador = conexion.find(Jugador.class, codigo);
			return jugador;
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			emf.close();
		}
	
	}
	
	public static void actualizar(int codigo, String nombre, Fecha fecha) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/campeonato.odb");
		EntityManager conexion = null;
		
		try {
			conexion = emf.createEntityManager();
			Jugador jugador = conexion.find(Jugador.class, codigo);
			conexion.getTransaction().begin();
			jugador.setNombre(nombre);
			jugador.setFechaNacimiento(fecha);
			conexion.getTransaction().commit();
			System.out.println(jugador);
		}
		finally {
			if (conexion != null) {
				conexion.close();
			}
			emf.close();
		}
		
	}
	
	public static List<Jugador> consultarEquipo(int codigo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/campeonato.odb");
		EntityManager conexion = null;
		try {
			conexion = emf.createEntityManager();
			TypedQuery<Jugador> consulta = conexion.createQuery("select e from Equipo e where e.jugadores.codigo ="+codigo, 
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
	
	public static void eliminar (int codigo) {
	

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
