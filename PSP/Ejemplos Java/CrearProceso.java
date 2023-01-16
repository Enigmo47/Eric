import java.io.IOException;
import java.util.Arrays;

public class CrearProceso {

	public static void main(String[] args) {
		if(args.length<1){
			System.out.println("Se necesita algún argumento para ejecutar el programa");
			System.exit(-1);
		}
		ProcessBuilder pb = new ProcessBuilder(args);
		try{
			Process process = pb.start();
			int retorno = process.waitFor();
			System.out.println("Se ha ejecutado" + Arrays.toString(args) + ". Valor devuleto " + retorno);
		}
		catch (IOException ex){
			System.err.println("Error de Entrada/Salida");
			System.exit(-1);
		}
		catch (InterruptedException ex){
			System.err.println("El proceso hijo ha finalizado incorrectamente");
			System.exit(-1);
		}

	}

}
