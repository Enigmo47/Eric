public class Productor1 extends Thread
{
    private Compartido1 dato;
    private int num;
 
   
    public Productor1(Compartido1 c, int n) 
    {
        this.dato = c;
        this.num = n;
    }
 
    public void run() 
    {
    	for (int i=0; i<5;i++){
    		dato.set(i);
    		System.out.println(i + " => Productor: " + num + ", produce: " + i);
    	}
        try{
        	sleep(100);
        }
        catch(InterruptedException e){
        	System.err.println(e.toString());
        }
    }
}