import java.io.IOException;

public class FinalizarProceso {

	public static void main(String[] args) throws InterruptedException {
		if(args.length<1){
			System.out.println("Se necesita algún argumento para ejecutar el programa");
			System.exit(-1);
		}
		Runtime runtime = Runtime.getRuntime();
		try{
			Process process = runtime.exec(args);
			process.destroy();
		}
		catch (IOException ex){
			System.err.println("Error de Entrada/Salida");
			System.exit(-1);
		}

	}

}
