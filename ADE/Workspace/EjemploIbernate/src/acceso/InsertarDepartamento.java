package acceso;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import acceso.Departamento;
import entrada.Teclado;

public class InsertarDepartamento {

	public static void main(String[] args) {
		Session sesion = null;
		Transaction transaccion = null;
		try {
			String nombre = Teclado.leerCadena("¿Nombre? ");
			String ubicacion = Teclado.leerCadena("¿Ubicación? ");
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			transaccion = sesion.beginTransaction();
			Departamento departamento = new Departamento(nombre, ubicacion);
			sesion.save(departamento);
			transaccion.commit();
			System.out.println("Se ha insertado un departamento en la base de datos.");
		}
		catch (Exception e) {
			if (transaccion != null) {
				transaccion.rollback();
			}
			System.out.println("Error de MySQL o Hibernate: " + e.getMessage());
		}
		finally {
			if (sesion != null) {
				sesion.close();
			}
		}
	}

}
