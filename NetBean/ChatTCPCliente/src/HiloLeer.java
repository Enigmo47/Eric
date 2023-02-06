
import java.io.BufferedReader;
import javax.swing.JTextArea;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alu
 */
public class HiloLeer extends Thread{
    private JTextArea etiqueta;
    private BufferedReader fEntrada;

    public HiloLeer(JTextArea etiqueta, BufferedReader fEntrada) {
        this.etiqueta = etiqueta;
        this.fEntrada = fEntrada;
    }
    
    @Override
    public void run(){
        try{
            String respuesta;
            respuesta = fEntrada.readLine();
            while(respuesta != null && !respuesta.equals("FIN")){
                System.out.println("Recibido");
                etiqueta.setText(etiqueta.getText() + respuesta + "\n");
                respuesta = fEntrada.readLine();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
