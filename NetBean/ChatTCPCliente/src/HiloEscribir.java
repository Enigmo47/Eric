/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author alu
 */
public class HiloEscribir extends Thread{
    private PrintWriter fSalida;
    private String mensaje;
    
    public HiloEscribir(PrintWriter fSalida,String nombre, String mensaje) throws IOException{
        this.fSalida = fSalida;
        this.mensaje = nombre + ". "+ mensaje;
    }
    
    public HiloEscribir(PrintWriter fSalida, String mensaje) throws IOException{
        this.fSalida = fSalida;
        this.mensaje = mensaje;
    }
    
    @Override
    public void run(){
        fSalida.println(mensaje);
        fSalida.flush();
    }
}
