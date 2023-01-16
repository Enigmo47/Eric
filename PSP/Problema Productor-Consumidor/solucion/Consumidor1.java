
public class Consumidor1 extends Thread
	{
	    private Compartido1 dato;
	    private int num;
	 
	   
	    public Consumidor1(Compartido1 c, int n) 
	    {
	        this.dato = c;
	        this.num = n;
	    }
	 
	    public void run() 
	    {
	    	int valor = 0;
	    	for (int i=0; i<5;i++){
	    		valor = dato.get();
	    		System.out.println(i + " => Consumidor: " + num + ", consume: " + valor);
	    	}
	    }
	}