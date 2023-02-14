package gestion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Departamento;
import modelo.Empleado;
import modelo.Fecha;
import modelo.Fichaje;
import modelo.Tiempo;

public class AccesoFichajes {

	public static Boolean insertar(Departamento departamento) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/fichajes.odb");
		EntityManager conexion = null;

		try {
			conexion = emf.createEntityManager();
			conexion.getTransaction().begin();
			conexion.persist(departamento);
			conexion.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (conexion != null) {
				conexion.close();
			}
			emf.close();
		}
	}

	public static void eliminar(int codigo) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/fichajes.odb");
		EntityManager conexion = null;

		try {
			conexion = emf.createEntityManager();
			Departamento departamento = conexion.find(Departamento.class, codigo);
			conexion.getTransaction().begin();
			conexion.remove(departamento);
			conexion.getTransaction().commit();
		} finally {
			if (conexion != null) {
				conexion.close();
			}
			emf.close();
		}

	}

	public static Boolean actualizar(String nombre, Departamento departamento) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/fichajes.odb");
		EntityManager conexion = null;

		try {
			conexion = emf.createEntityManager();
			Empleado empleado = conexion.find(Empleado.class, nombre);
			conexion.getTransaction().begin();
			empleado.setDepartamento(departamento);
			conexion.getTransaction().commit();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (conexion != null) {
				conexion.close();
			}
			emf.close();
		}

	}

	public static Departamento consultarCodigo(int codigo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/fichajes.odb");
		EntityManager conexion = null;
		Departamento departamento = null;
		try {
			conexion = emf.createEntityManager();
			departamento = conexion.find(Departamento.class, codigo);
			return departamento;
		} finally {
			if (conexion != null) {
				conexion.close();
			}
			emf.close();
		}

	}

	public static List<Empleado> consultarEmpleado(int codigo) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("data/fichajes.odb");
		EntityManager conexion = null;
		try {
			conexion = emf.createEntityManager();
			TypedQuery<Empleado> consulta = conexion
					.createQuery("select d from Empleado e, Departamento d where e.departamento =", Empleado.class);
			List<Empleado> empleados = consulta.getResultList();
			return empleados;
		} finally {
			if (conexion != null) {
				conexion.close();
			}
			emf.close();
		}

	}

}
