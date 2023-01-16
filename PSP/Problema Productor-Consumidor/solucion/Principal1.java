
public class Principal1 {

	public static void main(String[] args) {
		Compartido1 dato = new Compartido1();
		Productor1 p = new Productor1(dato, 1);
		Consumidor1 c = new Consumidor1(dato, 1);
		p.start();
		c.start();

	}
}
