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
public class AccesoVideojuego {
	
	public static void insertar(Videojuego juego) {

		MongoClient cliente = new MongoClient();
		MongoDatabase bd = cliente.getDatabase("steam");
		MongoCollection<Document> juegos = bd.getCollection("videojuegos");
		Document libroEncontrado = juegos.find(eq("codigo", juego.getCodigo())).first();
		if (libroEncontrado == null) {

			Document juego1 = new Document();
			juego1.put("codigo", juego.getCodigo());
			juego1.put("titulo", juego.getTitulo());
			juego1.put("agno", juego.getAgno());
			juego1.put("desarrollador", juego.getDesarrollador());
			juego1.put("precio", juego.getPrecio());
			juegos.insertOne(juego1);
			System.out.println("Se ha insertado un juego con código " + juego.getCodigo() + ".");
		} else {
			System.out.println("Se ha encontrado un juego con código " + juego.getCodigo() + ".");
		}
		cliente.close();
	}
	
	public static void consultar() {
		MongoClient cliente = new MongoClient();
		MongoDatabase bd = cliente.getDatabase("steam");
		MongoCollection<Document> juegos = bd.getCollection("videojuegos");
		List<Document> resultados = juegos.find().into(new ArrayList<Document>());
		if (resultados.isEmpty()) {
			System.out.println("No se ha encontrado ningún libro.");
		} else {
			for (int i = 0; i < resultados.size(); i++) {
				Document juego = resultados.get(i);
				System.out.println(juego.toString());
			}
			System.out.println("Se han consultado " + resultados.size() + " juegos.");
		}
		cliente.close();
	}
	
	public static void consultarCodigo(int codigo) {

		MongoClient cliente = new MongoClient();
		MongoDatabase bd = cliente.getDatabase("steam");
		MongoCollection<Document> juegos = bd.getCollection("videojuegos");
		Document cursor = juegos.find(eq("codigo", codigo)).sort(ascending("agno")).first();
		System.out.println(cursor);

		cliente.close();
	}
	
	public static void actualizar(Videojuego juego) {
	    MongoClient cliente = new MongoClient();
	    try {
	        MongoDatabase bd = cliente.getDatabase("steam");
	        MongoCollection<Document> juegos = bd.getCollection("videojuegos");
	        Bson filtro = eq("codigo", juego.getCodigo());
	        Bson modificaciones = combine(
	            set("titulo", juego.getTitulo()),
	            set("agno", juego.getAgno()),
	            set("autor", juego.getDesarrollador()),
	            set("precio", juego.getPrecio())
	        );
	        UpdateResult resultado = juegos.updateOne(filtro, modificaciones);
	        long juegosActualizados = resultado.getModifiedCount();
	        if (juegosActualizados == 0) {
	            System.out.println("No se ha encontrado ningún juego con código " + juego.getCodigo() + ".");
	        } else {
	            System.out.println("Se ha actualizado " + juegosActualizados + " juego.");
	        }
	    } finally {
	        cliente.close();
	    }
	}
	
	public static void borrar(int codigo) {
	    MongoClient cliente = new MongoClient();
	    MongoDatabase bd = cliente.getDatabase("steam");
	    MongoCollection<Document> juegos = bd.getCollection("videojuegos");
	    DeleteResult resultado = juegos.deleteOne(eq("codigo", codigo));
	    long juegosEliminados = resultado.getDeletedCount();
	    if (juegosEliminados == 0) {
	        System.out.println("No se ha encontrado ningún juego con código " + codigo + ".");
	    } else {
	        System.out.println("Se ha eliminado " + juegosEliminados + " juego.");
	    }
	    cliente.close();
	}
	
}
