
public class Actividad1x03 {
	
	Dato dato = new Dato();
	Productor p = new Productor(dato, 1);
	Consumidor c = new Consumidor(dato, 1);
	p.start();
	c.start();
	
}
