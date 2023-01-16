package acceso;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import acceso.Departamento;
import entrada.Teclado;

public class EliminarDepartamento {

	public static void main(String[] args) {
		Session sesion = null;
		Transaction transaccion = null;
		try {
			int codigo = Teclado.leerEntero("¿Código? ");
			SessionFactory fabricaSesiones = HibernateUtil.getSessionFactory();
			sesion = fabricaSesiones.openSession();
			transaccion = sesion.beginTransaction();	
			Departamento departamento = sesion.get(Departamento.class, (short) codigo);
			if (departamento == null) {
				System.out.println("No se ha encontrado ningún departamento con código " + codigo);
			}
			else {
				sesion.delete(departamento);
				transaccion.commit();
				System.out.println("Se ha eliminado un departamento de la base de datos.");
			}
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
