/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;
import Server.Player;
import static Server.XOServerHandler.RandomState;
import helper.Message;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author midosha3ban
 */
public class RandomCollocter extends Thread{
    Player player1,player2;
    static int i=0;
    private RandomCollocter() {
        System.out.println("Colloctor");
        start();
        i=1;
    }
    
    public static void create(){
        if(i==0)
             new RandomCollocter();
    }
    
            @Override
        public void run() {
           while(true)
           {
             System.out.println("jjjjjjjjjj"+RandomState.size());
               while(XOServerHandler.RandomState.size()>=2)
               {
                   System.out.println("first");
                   player1=XOServerHandler.RandomState.firstElement();
                   XOServerHandler.RandomState.remove(player1);
                                      System.out.println("second");

                   
                   
                   player2=XOServerHandler.RandomState.firstElement();
                   XOServerHandler.RandomState.remove(player2);
                   
                   try {
                     player1.output.writeObject(new Message("RandomSuccess", new String[]{"x",player1.name,player2.name}));
                     player2.output.writeObject(new Message("RandomSuccess", new String[]{"0" ,player2.name,player1.name}));  
                       System.out.println(player1);
                   } catch (Exception e) {
                   }
//                   managePlay(player1, player2);
                        new GameContraller(player1, player2);

               }
               try {
                     this.sleep(500);
               } catch (InterruptedException ex) {
                   ex.printStackTrace();
               }
           }
        }
    
}
