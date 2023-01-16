
public class Productor extends Thread{
	
	private Dato dato;
	private int num;
	 
    public Productor(Dato d, String p) 
    {
        this.dato = d;
        this.pingPong = p;
    }
    
    public void run() 
    {
    	for (int i=0; i<25;i++){
    		dato.set(i);
    		System.out.println("Ping");
    	}
        try{
        	sleep(100);
        }
        catch(InterruptedException e){
        	System.err.println(e.toString());
        }
    }

}
