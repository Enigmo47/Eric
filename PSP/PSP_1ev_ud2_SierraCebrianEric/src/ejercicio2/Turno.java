package ejercicio2;

public class Turno {

	/*
	 * Monitor
	 * 
	 * vector para puestos y atributo auxiliar para ver huecos libres(dato-- cuando
	 * entre uno nuevo)
	 * 
	 * entrar=wait sair= notifyall
	 */
	private int puestos[];
	private int libres;

	Turno(int nPuestos) {
		puestos = new int[nPuestos];
		libres = nPuestos;
	}

	synchronized public int entrada(int coche) throws InterruptedException {
		int puesto = 0;
		while (libres == 0) {
			System.out.println("Coche " + coche + " esperando");
			wait();
		}
		while (puestos[puesto] != 0) {
			puesto++;
		}
		puestos[puesto] = coche;
		libres--;
		return puesto;
	}

	synchronized public void salida(int puesto) {
		puestos[puesto] = 0; // vuelve el valor del puesto que queda vacio a 0
		libres++;
		notify();
	}

	/*
	 * Run: entrar// como son sync si no puede se quedara pillado mostrar salir
	 */

}
