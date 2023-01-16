import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Billete;
import modelo.Estacion;
import modelo.Viajero;
import modelo.Clase;

public class AccesoTransporteFerroviario {
	
	public static void insertar(Billete billete) {
		Session sesion = null;
		Transaction transaccion = null;
		try {

			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			transaccion = sesion.beginTransaction();
			sesion.save(billete);
			transaccion.commit();
		}
		catch (Exception e) {
			if (transaccion != null) {
				transaccion.rollback();
			}
			throw e;
		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
	}

	public static Estacion elegirEstacion(int codigo) {
		Estacion estacion = null;
		Session sesion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			estacion = sesion.get(Estacion.class, (short) codigo);

		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		return estacion;
	}




	public static ArrayList<Estacion> imprimirEstacion() {
		ArrayList<Estacion> estaciones=new ArrayList<Estacion>();
		Session sesion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			String sentenciaHQL = "select e from Estacion e";
			TypedQuery<Estacion> consulta = sesion.createQuery(sentenciaHQL);
			List<Estacion> listaEstaciones = consulta.getResultList();

			for (Estacion estacion1 : listaEstaciones) {
				estaciones.add(estacion1);
			}

		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		return estaciones;
	}

	public static Viajero elegirViajero(int codigo) {
		Viajero viajero = null;
		Session sesion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			viajero = sesion.get(Viajero.class, (short) codigo);

		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		return viajero;
	}

	public static ArrayList<Viajero> imprimirViajero() {
		ArrayList<Viajero> viajeros=new ArrayList<Viajero>();
		Session sesion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			String sentenciaHQL = "select v from Viajero v";
			TypedQuery<Viajero> consulta = sesion.createQuery(sentenciaHQL);
			viajeros = (ArrayList<Viajero>) consulta.getResultList();

		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		return viajeros;
	}

	public static ArrayList<Billete> consultar(){
		ArrayList<Billete> billetes=new ArrayList<Billete>();
		Session sesion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			String sentenciaHQL = "select b from Billete b";
			TypedQuery<Billete> consulta = sesion.createQuery(sentenciaHQL, Billete.class);
			billetes = (ArrayList<Billete>) consulta.getResultList();
			for(Billete billete : billetes) {
				System.out.println(billete);
			}

		}
		finally {
			if (sesion != null) {
				sesion.close();
			}

		}

		return billetes;
	}

	public static Billete consultarCodigo(int codigo) {
		Billete clase = null;
		Session sesion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			clase = sesion.get(Billete.class, (short) codigo);
		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		return clase;
	}


	public static ArrayList<Viajero> consultarViajerodeClase(int codigo){
		ArrayList<Viajero> viajeros=new ArrayList<Viajero>();
		Session sesion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			String sentenciaHQL = "select v from Viajero v INNER JOIN v.clase c where c.codigo="+codigo;
			TypedQuery<Viajero> consulta = sesion.createQuery(sentenciaHQL, Viajero.class);
			viajeros = (ArrayList<Viajero>) consulta.getResultList();

			for(Viajero v: viajeros) {
				System.out.println(v);
			}
		}
		finally {
			if (sesion != null) {
				sesion.close();
			}

		}

		return viajeros;
	}
	public static boolean borrar(int codigo) {
		Session sesion = null;
		Transaction transaccion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			transaccion = sesion.beginTransaction();	
			Billete billete = sesion.get(Billete.class, (short) codigo);
			if (billete == null) {
				return false;
			}
			else {
				sesion.delete(billete);
				transaccion.commit();
			}
		}
		catch (Exception e) {
			if (transaccion != null) {
				transaccion.rollback();
			}
			throw e;
		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		return true;
	}

	public static boolean actualizar(Billete billete){
		Session sesion = null;
		Transaction transaccion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			transaccion = sesion.beginTransaction();	

			sesion.update(billete);
			transaccion.commit();
			
			return true;
		}
		catch (Exception e) {
			if (transaccion != null) {
				transaccion.rollback();
			}
			throw e;
		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
	}

	public static Clase consultarClase(int codigo) {
		Clase clase = null;
		Session sesion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			clase = sesion.get(Clase.class, (short) codigo);
		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
		return clase;
	}

	public static boolean borrarClase(Clase clase) {
		Session sesion = null;
		Transaction transaccion = null;
		try {
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			transaccion = sesion.beginTransaction();
			for (Object viajero : clase.getViajeros()) {
				for(Object billete :((Viajero)viajero).getBilletes()) {
					sesion.delete((Billete)billete);
				}
				sesion.delete((Viajero)viajero);
			}

			sesion.delete(clase);
			transaccion.commit();
			return true;

		}
		catch (Exception e) {
			if (transaccion != null) {
				transaccion.rollback();
			}
			throw e;
		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
	}

}
