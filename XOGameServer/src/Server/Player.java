/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author midosha3ban
 */
public class Player {
       public Socket S;
       public ObjectInputStream input;
       public ObjectOutputStream output;
       public String  name;
       public int id;

    public Player(Socket S , ObjectInputStream i,ObjectOutputStream o , String n, int id ) {
        this.S=S;
        input=i;
        output=o;
        name=n;
        this.id=id;
    }
    
    
    public Player(Socket S , ObjectInputStream i,ObjectOutputStream o  ) {
        this.S=S;
        input=i;
        output=o;
        name="none";
        this.id=0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    

    public Socket getS() {
        return S;
    }

    public void setS(Socket S) {
        this.S = S;
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public void setInput(ObjectInputStream input) {
        this.input = input;
    }

    public ObjectOutputStream getOutput() {
        return output;
    }

    public void setOutput(ObjectOutputStream output) {
        this.output = output;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
       
       
}
