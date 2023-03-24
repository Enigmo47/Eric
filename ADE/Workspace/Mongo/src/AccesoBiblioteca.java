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

import entrada.Teclado;

public class AccesoBiblioteca {

	public static void insertar(Libro libros1) {

		MongoClient cliente = new MongoClient();
		MongoDatabase bd = cliente.getDatabase("biblioteca");
		MongoCollection<Document> libros = bd.getCollection("libros");
		Document libroEncontrado = libros.find(eq("codigo", libros1.getCodigo())).first();
		if (libroEncontrado == null) {

			Document libro = new Document();
			libro.put("codigo", libros1.getCodigo());
			libro.put("titulo", libros1.getTitulo());
			libro.put("autor", libros1.getAutor());
			libro.put("agno", libros1.getAgno());
			libro.put("genero", libros1.getGenero());
			libros.insertOne(libro);
			System.out.println("Se ha insertado un libro con código " + libros1.getCodigo() + ".");
		} else {
			System.out.println("Se ha encontrado un libro con código " + libros1.getCodigo() + ".");
		}
		cliente.close();
	}

	public static void consultar() {
		MongoClient cliente = new MongoClient();
		MongoDatabase bd = cliente.getDatabase("biblioteca");
		MongoCollection<Document> libros = bd.getCollection("libros");
		List<Document> resultados = libros.find().into(new ArrayList<Document>());
		if (resultados.isEmpty()) {
			System.out.println("No se ha encontrado ningún libro.");
		} else {
			for (int i = 0; i < resultados.size(); i++) {
				Document libro = resultados.get(i);
				System.out.println(libro.toString());
			}
			System.out.println("Se han consultado " + resultados.size() + " libros.");
		}
		cliente.close();
	}

	public static void consultarCodigo(int codigo) {

		MongoClient cliente = new MongoClient();
		MongoDatabase bd = cliente.getDatabase("biblioteca");
		MongoCollection<Document> libros = bd.getCollection("libros");
		Document cursor = libros.find(eq("codigo", codigo)).sort(ascending("agno")).first();
		System.out.println(cursor);

		cliente.close();
	}

	public static void actualizar(Libro libro) {
	    MongoClient cliente = new MongoClient();
	    try {
	        MongoDatabase bd = cliente.getDatabase("biblioteca");
	        MongoCollection<Document> libros = bd.getCollection("libros");
	        Bson filtro = eq("codigo", libro.getCodigo());
	        Bson modificaciones = combine(
	            set("titulo", libro.getTitulo()),
	            set("autor", libro.getAutor()),
	            set("agno", libro.getAgno()),
	            set("genero", libro.getGenero())
	        );
	        UpdateResult resultado = libros.updateOne(filtro, modificaciones);
	        long librosActualizados = resultado.getModifiedCount();
	        if (librosActualizados == 0) {
	            System.out.println("No se ha encontrado ningún libro con código " + libro.getCodigo() + ".");
	        } else {
	            System.out.println("Se ha actualizado " + librosActualizados + " libro.");
	        }
	    } finally {
	        cliente.close();
	    }
	}

	public static void borrar(int codigo) {
	    MongoClient cliente = new MongoClient();
	    MongoDatabase bd = cliente.getDatabase("biblioteca");
	    MongoCollection<Document> libros = bd.getCollection("libros");
	    DeleteResult resultado = libros.deleteOne(eq("codigo", codigo));
	    long librosEliminados = resultado.getDeletedCount();
	    if (librosEliminados == 0) {
	        System.out.println("No se ha encontrado ningún libro con código " + codigo + ".");
	    } else {
	        System.out.println("Se ha eliminado " + librosEliminados + " libro.");
	    }
	    cliente.close();
	}


}
