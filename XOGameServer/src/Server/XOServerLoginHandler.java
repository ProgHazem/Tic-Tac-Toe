/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import helper.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author midosha3ban
 */
public class XOServerLoginHandler extends Thread{

    Socket S;
    ObjectInputStream input;
    ObjectOutputStream output;
    Player player;
    Message ms;
    protected Connection con;
    protected PreparedStatement pst;

    public XOServerLoginHandler(Socket S) {

        try {
            this.S = S;
            this.output = new ObjectOutputStream(S.getOutputStream());
            this.input = new ObjectInputStream(S.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
//        listen();
            start();
           
    }

    //connect to database
    public void connect() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TicTacToe", "root", "");
    }

    //closeConnentTo dataBase
    public void closeconnection() throws SQLException {
        con.close();
    }

    @Override
    public void run() {
       try {
            System.out.println("listen");
            player= new Player(S, input, output);
            ms = (Message) input.readObject();
            System.out.println(ms.type);
            if(ms.type.equals("SignUp"))
            {
                System.out.println("Signout");
                while(  (! signUp(ms.data[0], ms.data[1])))
                 {
                     System.out.println("SignupError");
                     //massage to resgin
                     output.writeObject(new Message("SignError", null));
                     ms = (Message) input.readObject();
                   
                 }
            }
             output.writeObject(new Message("SignSuccess", null));
            
             ms = (Message) input.readObject();
            System.out.println("TTTTTTTTT"+ms.type);
                if(ms.type.equals("Login"))
                {
                    while(!login(ms.data[0], ms.data[1]))
                    {
                        System.out.println("Loginin error");
                         //massage to relogin
                        output.writeObject(new Message("LoginError", null));
                        ms = (Message) input.readObject();
                    }
                }
                 output.writeObject(new Message("LoginSuccess", null));
                 //go to play
                 player.setName(ms.data[0]);
                 new XOServerHandler(player);
                 
                 
                 
                 
             
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
        
   /* 
    //listen to User for Login Or SignUp
    public void listen() {
        try {
            System.out.println("listen");
            player= new Player(S, input, output);
            ms = (Message) input.readObject();
            System.out.println(ms.type);
            if(ms.type.equals("SignUp"))
            {
                System.out.println("Signout");
                while(  (! signUp(ms.data[0], ms.data[1])))
                 {
                     System.out.println("SignupError");
                     //massage to resgin
                     output.writeObject(new Message("SignError", null));
                     ms = (Message) input.readObject();
                   
                 }
            }
             output.writeObject(new Message("SignSuccess", null));
            
             ms = (Message) input.readObject();
            System.out.println("TTTTTTTTT"+ms.type);
                if(ms.type.equals("Login"))
                {
                    while(!login(ms.data[0], ms.data[1]))
                    {
                        System.out.println("Loginin error");
                         //massage to relogin
                        output.writeObject(new Message("LoginError", null));
                        ms = (Message) input.readObject();
                    }
                }
                 output.writeObject(new Message("LoginSuccess", null));
                 //go to play
                 player.setName(ms.data[0]);
                 new XOServerHandler(player);
                 
                 
                 
                 
             
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
*/
    public boolean signUp(String Username, String Password) {
        //database
        try {
            connect();
            pst = con.prepareStatement("INSERT INTO `Player`(`Player_Id`, `Player_Name`, `Password`) VALUES (null,?,?)");
            pst.setString(1, Username);
            pst.setString(2, Password);
            pst.execute();
//            System.err.println("hello");
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    
    
    public boolean login(String Username, String Password) {
        //database
        try{
            connect();
            String queryString = "SELECT `Player_Id` from TicTacToe.Player where Player_Name = '"+Username+"' and Password = '" +Password +"'" ;
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(queryString);
            
            if(rs.next())
            {
                System.out.println(rs.getString(1));
                player.setId(Integer.parseInt(rs.getString(1)));
                return true;                
            }
            else
                return false;
//            rs.next() != null ? return false : return true;  
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }

}
