/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import helper.Message;
import java.io.IOException;

/**
 *
 * @author midosha3ban
 */
public class GameContraller extends Thread{
    
    Player player1, player2;
    Message ms;
    
    public GameContraller(Player player1,Player player2) {
            this.player1=player1;
            this.player2=player2;
            start();
    
    }

    @Override
    public void run() {
        managePlay(player1, player2);
    }
    
    
    
    public  void managePlay(Player player1, Player player2) {
        //playing
        int temp;
        Message ms;
        int role = 1;
        int[] states = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        String Record = "";
        try {
            while (isavilable(states) && check(states) == 0) {
                System.out.println("start");
                if (role == 1) {
                    System.out.println("startAgaIN");
//                        temp = player1.input.readInt();
                    player1.input.readInt();
                    ms = (Message) player1.input.readObject();
                    temp = Integer.parseInt(ms.type);
                    System.out.println("kkkkkkkkkkk" + temp);
                    states[temp - 1] = 1;
                    player2.output.writeInt(5);
                    player2.output.writeObject(new Message("play", new String[]{"" + temp}));
                    Record = Record.concat(player1.name + ":" + temp + ";");
                    role = 2;
                } else {
//                        temp = player2.input.readInt();
                    System.out.println("player2 turn");
                    player2.input.readInt();
                    System.out.println("after read int");
                    ms = (Message) player2.input.readObject();
                    temp = Integer.parseInt(ms.type);
                    states[temp - 1] = 2;
                    System.out.println("beforw write int");
                    player1.output.writeInt(5);
                    player1.output.writeObject(new Message("play", new String[]{"" + temp}));
                    role = 1;
                    System.out.println("after write object");
//                    player1.output.writeInt(temp);

                }
            }

            if (check(states) == 1) {
                System.out.println(player1.name + "is winner ");
                player1.output.writeInt(5);
                player1.output.writeObject(new Message("Winner", null));
                player2.output.writeInt(5);
                player2.output.writeObject(new Message("Losser", null));
                listenAfterGame();

            } else if (check(states) == 2) {
                System.out.println(player2.name + "is winner ");
                player2.output.writeInt(5);
                player2.output.writeObject(new Message("Winner", null));
                player1.output.writeInt(5);
                player1.output.writeObject(new Message("Losser", null));
                listenAfterGame();
               
                

            } else if (check(states) == 0 && !isavilable(states)) {
                System.out.println("no winner");
                player2.output.writeInt(5);
                player2.output.writeObject(new Message("NoWinner", null));
                player1.output.writeInt(5);
                player1.output.writeObject(new Message("NOWinner", null));
                listenAfterGame();
            }

        } catch (IOException e) {
            System.out.println("server ex IO");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("server ex IO");

            ex.printStackTrace();
        }

    }
    
    public void listenAfterGame()
    {
        try {
          player1.input.readInt();
          player2.input.readInt();
        ms = (Message) player1.input.readObject();
        if(ms.type.equals("again"))
        {
            System.out.println("player1 again");
            new XOServerHandler(player1);
        }else
        {
            player1.S.close();
        }
         
        ms = (Message) player2.input.readObject();
        if(ms.type.equals("again"))
        {
            System.out.println("player2 again");
            new XOServerHandler(player2);
            
        }else
        {
            player2.S.close();
        }
        } catch (Exception e) {
        }
       
    }

    public  boolean isavilable(int[] states) {
        for (int i = 0; i < states.length; i++) {
            if (states[i] == 0) {
                return true;
            }
        }
        return false;
    }

    public  int check(int[] game) {
        if ((game[0] == 1 && game[1] == 1 && game[2] == 1) || (game[3] == 1 && game[4] == 1 && game[5] == 1)
                || (game[6] == 1 && game[7] == 1 && game[8] == 1) || (game[0] == 1 && game[4] == 1 && game[8] == 1)
                || (game[2] == 1 && game[4] == 1 && game[6] == 1) || (game[0] == 1 && game[3] == 1 && game[6] == 1)
                || (game[1] == 1 && game[7] == 1 && game[4] == 1) || (game[2] == 1 && game[5] == 1 && game[8] == 1)) {
//            System.out.println("you won");
            return 1;
        } else if ((game[0] == 2 && game[1] == 2 && game[2] == 2) || (game[3] == 2 && game[4] == 2 && game[5] == 2)
                || (game[6] == 2 && game[7] == 2 && game[8] == 2) || (game[0] == 2 && game[4] == 2 && game[8] == 2)
                || (game[2] == 2 && game[4] == 2 && game[6] == 2) || (game[0] == 2 && game[3] == 2 && game[6] == 2)
                || (game[1] == 2 && game[7] == 2 && game[4] == 2) || (game[2] == 2 && game[5] == 2 && game[8] == 2)) {
//            System.out.println("you lose");
            return 2;
        }
        return 0;
    }
}
