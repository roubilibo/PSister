package Soal3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAB_TI
 */
public class Server {
    public static final int SERVICE_PORT=13;
    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(SERVICE_PORT);
            System.out.println("Started");
            
            for(;;){
                // terima pesan e
                Socket nextclient = server.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(nextclient.getInputStream()));
                
                System.out.print("Pesan : "+br.readLine());
                System.out.println(" Received from "
                        +nextclient.getInetAddress()+" "+nextclient.getPort());
                

                //balas pesan
                Socket s = server.accept();
                BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Balas : ");
                OutputStream os = s.getOutputStream();
                PrintStream ps = new PrintStream(os);
            
                ps.print(r.readLine()+" ("+new java.util.Date()+") ");
                os.flush();
                os.close();
                
                nextclient.close();
            }
        }catch(BindException be){
            System.err.println("Service already running on port "+SERVICE_PORT);
        }catch(IOException e){
            System.err.println("I/O error "+e);
        }
    }
}
