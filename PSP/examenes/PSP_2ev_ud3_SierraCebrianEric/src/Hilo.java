import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Hilo extends Thread{
	private Socket cliente;
	private int numero;
	private String listaEquipos;
	private List <Integer> votos;
	int voto;
	int eq;


	public Hilo(Socket cliente, int numero, String listaEquipos, List<Integer> votos, int voto, int eq) {
		super();
		this.cliente = cliente;
		this.numero = numero;
		this.listaEquipos = listaEquipos;
		this.votos = votos;
		this.voto = voto;
		this.eq = eq;
	}

	public Hilo(Socket cliente, int numero, String listaEquipos, List<Integer> votos) {
		super();
		this.cliente = cliente;
		this.numero = numero;
		this.listaEquipos = listaEquipos;
		this.votos = votos;
	}

	@Override
	public void run() {
		PrintWriter fsalida = null;
		BufferedReader fentrada = null;
		try {
			// Se crea flujo de salida al servidor
			fsalida = new PrintWriter (cliente.getOutputStream(), true);
			// Se crea flujo de entrada del servidor
			fentrada = new BufferedReader (new InputStreamReader(cliente.getInputStream()));
			eq = fentrada.read();
			
			for(int i = 1; i <= eq; i++) {
				String pregunta ="Puntuación del Equipo";
				
				fsalida.println(listaEquipos);
				fsalida.println("Equipo número " + i + ": " + pregunta);
				System.out.println("Cliente número " + numero + " pregunta " + i);
				
				int respuesta = fentrada.read(); // lectura desde cliente
				System.out.println("Respuesta de cliente número " + numero + ": " + respuesta);
			}
			votos.add(voto);
			System.out.println("votos " + voto);
			System.out.println(listaEquipos);
				
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		finally {
			if(fsalida != null)
				fsalida.close();
			if(fentrada != null) {
				try {
					fentrada.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(cliente != null) {
				try {
					cliente.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
		}
	}
	private String equipos(int eq) {
		for(int i = 0; i<= eq; i++) {
			listaEquipos = "Equipo"+i ;
		}
		return null;
	}
		
}

