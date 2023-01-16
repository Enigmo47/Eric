
public class Consumidor extends Thread{
	
	private Dato dato;
	private String pingPong;
 
   
    public Consumidor(Dato d, String p) 
    {
        this.dato = d;
        this.pingPong = p;
    }
 
    public void run() 
    {
    	String valor ;
    	for (int i=0; i<5;i++){
    		valor = dato.get();
    		System.out.println("pong");
    	}
    }
	
}
