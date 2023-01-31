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
	private List <Integer> listaHoras;
	private List <Integer> listaMovida;
	private List <Integer> listaSuave;
	private List <Integer> listaGusta;
	private List <Integer> listaNoGusta;
	int hora;
	String tipo;
	String gusta;
	private int contador,contador1,contador2,contador3;


	
	public Hilo(Socket cliente, int numero, List<Integer> listaHoras, List<Integer> listaMovida,
			List<Integer> listaSuave, List<Integer> listaGusta, List<Integer> listaNoGusta, int hora, String tipo,
			String gusta, int contador, int contador1, int contador2, int contador3) {
		this.cliente = cliente;
		this.numero = numero;
		this.listaHoras = listaHoras;
		this.listaMovida = listaMovida;
		this.listaSuave = listaSuave;
		this.listaGusta = listaGusta;
		this.listaNoGusta = listaNoGusta;
		this.hora = hora;
		this.tipo = tipo;
		this.gusta = gusta;
		this.contador = contador;
		this.contador1 = contador1;
		this.contador2 = contador2;
		this.contador3 = contador3;
	}
	
	public Hilo(Socket cliente, int numero, List<Integer> listaHoras, List<Integer> listaMovida,
			List<Integer> listaSuave, List<Integer> listaGusta, List<Integer> listaNoGusta) {
		this.cliente = cliente;
		this.numero = numero;
		this.listaHoras = listaHoras;
		this.listaMovida = listaMovida;
		this.listaSuave = listaSuave;
		this.listaGusta = listaGusta;
		this.listaNoGusta = listaNoGusta;
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
			
			for(int i = 1; i <= 4; i++) {
				String pregunta = pregunta(i);
				fsalida.println("Pregunta número " + i + ": " + pregunta);
				System.out.println("Cliente número " + numero + " pregunta " + i);
				
				String respuesta = fentrada.readLine(); // lectura desde cliente
				System.out.println("Respuesta de cliente número " + numero + ": " + respuesta);
				if(i == 1) {
					hora = Integer.parseInt(respuesta);
				}if(i == 3) {
					tipo = respuesta;
					if(respuesta.equals("movida")) {
						contador = contador + 1;
					}else {
						contador1 = contador1 +1;
					}
				}if(i == 4) {
					gusta = respuesta;
					if(respuesta.equals("si")) {
						contador2 = contador2 + 1;
					}else {
						contador3 = contador3 +1;
					}
				}
			}
			listaHoras.add(hora);
			listaMovida.add(contador);
			listaSuave.add(contador1);
			listaGusta.add(contador2);
			listaNoGusta.add(contador3);
			System.out.println("hora: " + hora);
			System.out.println(listaHoras);
			System.out.println("a " + contador + " persona/s le/s gusta/n la música movida ");
			System.out.println(listaMovida);
			System.out.println("a " + contador1 + " persona/s le/s gusta/n la música suave ");
			System.out.println(listaSuave);			
			System.out.println("a " + contador2 + " persona/s le/s gusta/n la música");
			System.out.println(listaGusta);			
			System.out.println("a " + contador3 + " persona/s no le/s gusta/n la música");
			System.out.println(listaNoGusta);				
			double horaTotal = 0;
			for(Integer Horas: listaHoras) {
				horaTotal += Horas;
			}
			int movidaTotal = 0;
			for(Integer Movida: listaMovida) {
				movidaTotal += Movida;
			}
			int suaveTotal = 0;
			for(Integer Suave: listaSuave) {
				suaveTotal += Suave;
			}
			int gustaTotal = 0;
			for(Integer Gusta: listaGusta) {
				gustaTotal += Gusta;
			}
			int noGustaTotal = 0;
			for(Integer NoGusta: listaNoGusta) {
				noGustaTotal += NoGusta;
			}
			System.out.println("hora total: " + horaTotal);
			System.out.println("Tamaño lista: " + listaHoras.size());
			System.out.println("Tamaño lista: " + listaMovida.size());
			System.out.println("Tamaño lista: " + listaSuave.size());
			System.out.println("Tamaño lista: " + listaGusta.size());
			System.out.println("Tamaño lista: " + listaNoGusta.size());
			
			fsalida.println("hora media de los clientes: " + horaTotal / listaHoras.size());
			fsalida.println("a estos clientes les gusta la música movida: " + movidaTotal);
			fsalida.println("a estos clientes les gusta la música suave: " + suaveTotal);
			fsalida.println("a estos clientes les gusta la música" + gustaTotal);
			fsalida.println("a estos clientes no les gusta la música:  " + noGustaTotal);
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
	private String pregunta(int i) {
		if(i == 1) {
			return "¿Cuántas horas escuchas musica al día? (numero entero)";
		}
		else if(i == 2) {
			return "¿Quien es tu cantante favorito?";
		}
		else if(i == 3) {
			return "¿Te gusta más la musica movida o la tranquila? (movida/tranquila)";
		}
		else 
			return "¿Te gusta la musica?  (si/no)";
	}
}

