package Soal3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAB_TI
 */
public class client {
    public static final int SERVICE_PORT=13;
    public static void main(String[]args){
        try{
            String hostname = "localhost";
            System.out.println("Conection estabilished");
            for(;;){
            //kirim pesan e
            Socket daytime = new Socket(hostname,SERVICE_PORT);
            daytime.setSoTimeout(2000);
            
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("kirim pesan : ");
            
            OutputStream os = daytime.getOutputStream();
            PrintStream ps = new PrintStream(os);
            
            ps.print(r.readLine()+" ("+new java.util.Date()+") ");
            os.flush();
            os.close();

            // terima pesan e
            Socket daytime1 = new Socket(hostname,SERVICE_PORT);
            BufferedReader r1 = new BufferedReader(new InputStreamReader(daytime1.getInputStream()));
            System.out.println("Server : "+r1.readLine());
            daytime.close();
            }
        }catch (IOException ioe){
            System.err.println("error "+ioe);
        }
    }
    
}
