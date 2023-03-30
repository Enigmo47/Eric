package personal;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Sorts.ascending;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class AccesoPersonal {
	
	/**
	 * Método que sirve para consultar todos los empleados de la base de datos filtrado por salario ascendente (de menor a mayor)
	 * 
	 */
	
	public static void consultar() {
		MongoClient cliente = new MongoClient();
		MongoDatabase bd = cliente.getDatabase("personal");
		MongoCollection<Document> empleados = bd.getCollection("empleados");
		List<Document> resultados = empleados.find().into(new ArrayList<Document>());
		MongoCursor<Document> cursor = empleados.find().sort(ascending("salario")).iterator();
		int contador = 0;
		while (cursor.hasNext()) {
			Document empleado = cursor.next();
			System.out.println(empleado.toString());
			contador++;
		}
		if (contador == 0) {
			System.out.println("No se ha encontrado ningún empleado.");
		}
		else {
			System.out.println("Se han consultado " + contador + " empleado.");
		}
		cliente.close();
		
	}
	
	/**
	 * Método que sirve para añadir un nuevo empleado a la base de datos
	 */
	
	public static void insertar(Empleado empleado) {

		MongoClient cliente = new MongoClient();
		MongoDatabase bd = cliente.getDatabase("personal");
		MongoCollection<Document> empleados = bd.getCollection("empleados");
		Document libroEncontrado = empleados.find(eq("codigo", empleado.getCodigo())).first();
		if (libroEncontrado == null) {

			Document emp = new Document();
			emp.put("codigo", empleado.getCodigo());
			emp.put("titulo", empleado.getNombre());
			emp.put("agno", empleado.getFechaAlta());
			emp.put("desarrollador", empleado.getDepartamento());
			emp.put("precio", empleado.getSalario());
			empleados.insertOne(emp);
			System.out.println("Se ha insertado un empleado con código " + empleado.getCodigo() + ".");
		} else {
			System.out.println("Se ha encontrado un empleado con código " + empleado.getCodigo() + ".");
		}
		cliente.close();
	}
	
	/**
	 *Método que sirve para borrar empleado de la base de datos 
	 */
	
	public static void borrar(int codigo) {
	    MongoClient cliente = new MongoClient();
	    MongoDatabase bd = cliente.getDatabase("personal");
	    MongoCollection<Document> empleados = bd.getCollection("empleados");
	    DeleteResult resultado = empleados.deleteOne(eq("codigo", codigo));
	    long empleadosEliminados = resultado.getDeletedCount();
	    if (empleadosEliminados == 0) {
	        System.out.println("No se ha encontrado ningún empleado con código " + codigo + ".");
	    } else {
	        System.out.println("Se ha eliminado " + empleadosEliminados + " empleados.");
	    }
	    cliente.close();
	}

}
