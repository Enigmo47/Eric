import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FTP {
    public static void main(String[] args) {
        FTPClient cliente = new FTPClient();
        
        try {
            cliente.connect("localhost");
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String respuestaStr = cliente.getReplyString();
        System.out.println("Respuesta del servidor" + respuestaStr);
        int respuestaInt = cliente.getReplyCode();
        System.out.println("Codigo respuesta del servidor "+ respuestaInt);
        String usuario ="Eric";
        String pass ="admin";
        try {
            boolean login = cliente.login(usuario, pass);
            String directorio=cliente.printWorkingDirectory();
            FTPFile[] archivos = cliente.listFiles();
            String tipos[]= {"Fichero","Directorio","Enlace"};
            for(int i =0; i<archivos.length;i++) {
                System.out.println(archivos[i].getName() + " => "+tipos[archivos[i].getType()]);
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
    }
}