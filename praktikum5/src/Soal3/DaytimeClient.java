/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Soal3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author gholib29
 */
public class DaytimeClient {
    public static final int SERVICE_PORT=13;
    public static void main(String[] args) {
        try{
            String host="localhost";

            Socket daytime = new Socket (host,SERVICE_PORT);
            System.out.println("Connection Estabilished");

            daytime.setSoTimeout(2000);

            BufferedReader reader = new BufferedReader (
                    new InputStreamReader(daytime.getInputStream()));
            System.out.println("Result : "+reader.readLine());

            daytime.close();
        }catch(IOException e){
            System.out.println("error : "+e);
        }
    }

}
