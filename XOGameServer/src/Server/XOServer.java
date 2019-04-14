/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author midosha3ban
 */
public class XOServer extends Thread {

    ServerSocket SS;

    public XOServer() {

        start();

    }

    @Override
    public void run() {
        try {
            SS = new ServerSocket(1993);
            while (true) {
                Socket S = SS.accept();
                System.out.println("Connected");
                new XOServerLoginHandler(S);
            }

        } catch (IOException e) {
            System.out.println("the ");
            e.printStackTrace();
        }
    }
    
    public void close() 
    {
        try{
            SS.close();
        }catch(IOException E)
        {
            System.out.println("the server closed");
        }
        
    }

}
