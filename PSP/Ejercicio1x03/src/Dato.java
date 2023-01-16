
public class Dato {
	
	private String pingPong;
	private boolean disponible = false;
	private int turnoP;
	
	public synchronized String get(){
		while(!disponible){
			try{
				wait();
			}
			catch(InterruptedException e){
	        	System.err.println(e.toString());
	        }
		}
		disponible = false;
		notifyAll();
		return pingPong;
		 
	}
	
	public synchronized void set (int n){
		while(disponible){
			try{
				wait();
			}
			catch(InterruptedException e){
	        	System.err.println(e.toString());
	        }
		}
		
		pingPong = "";
		disponible = true;
		notifyAll();
	}
	
	

}
