package xogame.online;

import helper.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import xogame.LocalGameControlBase;

public class OnlineGamingBase extends AnchorPane implements Runnable {

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    public Thread th;
    protected final Label User1;
    protected final Label User2;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final Label label7;
    protected final Label label8;
    protected final Label label9;
    protected final Button btnback;
    protected final Button btnExit;
    public String MyChar, hisChar;
    public boolean IPlayNow;
    ObjectInputStream input;
    ObjectOutputStream output;
    Message message;
    Stage primaryStage;
    Socket S;

    public OnlineGamingBase(Stage primaryStage, Socket S, ObjectInputStream input, ObjectOutputStream output, Message message) throws ClassNotFoundException, IOException {

        this.S = S;
        this.primaryStage = primaryStage;
        th = new Thread(this);
        this.input = input;
        this.output = output;
        MyChar = message.data[0];
        hisChar = MyChar.equals("x") ? "o" : "x";
        User1 = new Label();
        User2 = new Label();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        label8 = new Label();
        label9 = new Label();
        btnback = new Button();
        btnExit = new Button();
        
        btnback.setOnAction((ActionEvent event) -> {
            LocalGameControlBase root = new LocalGameControlBase(primaryStage);
            Scene scene = new Scene(root, 700, 400);
            primaryStage.setTitle("Profile");
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
        });
        btnExit.setOnAction((ActionEvent event) -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you exit ?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) 
                System.exit(0);
        });

        if (message.data[0].equals("x")) {
            IPlayNow = true;
            User1.setStyle("-fx-background-color: lightblue;");
        } else {
            IPlayNow = false;
            User2.setStyle("-fx-background-color: lightblue;");
        }

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #7026ef;");
        
        User1.setLayoutX(27.0);
        User1.setLayoutY(35.0);
        User1.setPrefHeight(49.0);
        User1.setPrefWidth(166.0);
//        User1.setStyle("-fx-background-color: lightblue;");
        User1.setText(message.data[1]);

        User2.setLayoutX(352.0);
        User2.setLayoutY(44.0);
        User2.setPrefHeight(49.0);
        User2.setPrefWidth(166.0);
        User2.setText(message.data[2]);

        gridPane.setGridLinesVisible(true);
        gridPane.setLayoutX(19.0);
        gridPane.setLayoutY(130.0);
        gridPane.setPrefHeight(219.0);
        gridPane.setPrefWidth(507.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);//        label03.setText("3");

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        
        btnback.setMnemonicParsing(false);
        btnback.setPrefHeight(50.0);
        btnback.setPrefWidth(100.0);
        btnback.setText("Back");
        btnback.setStyle("-fx-background-color: lightgreen;");
        btnback.setTextFill(javafx.scene.paint.Color.valueOf("#512222"));
        btnback.setFont(new Font(15.0));
        
        btnExit.setMnemonicParsing(false);
        btnExit.setPrefHeight(50.0);
        btnExit.setPrefWidth(100.0);
        btnExit.setText("Exit");
        btnExit.setStyle("-fx-background-color: red;");
        btnExit.setFont(new Font(15.0));

        
        label1.setPrefHeight(86.0);
        label1.setPrefWidth(174.0);
        label1.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-font-size: 5em;");
//        label1.setText("1");

        GridPane.setColumnIndex(label2, 1);
        label2.setPrefHeight(86.0);
        label2.setPrefWidth(174.0);
        label2.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-font-size: 5em;");
//        label2.setText("2");

        GridPane.setColumnIndex(label3, 2);
        label3.setPrefHeight(86.0);
        label3.setPrefWidth(174.0);
        label3.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-font-size: 5em;");
//        label3.setText("3");

        GridPane.setRowIndex(label4, 1);
        label4.setPrefHeight(86.0);
        label4.setPrefWidth(174.0);
        label4.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-font-size: 5em;");

        GridPane.setColumnIndex(label5, 1);
        GridPane.setRowIndex(label5, 1);
        label5.setPrefHeight(86.0);
        label5.setPrefWidth(174.0);
        label5.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-font-size: 5em;");
//        label5.setText("5");

        GridPane.setColumnIndex(label6, 2);
        GridPane.setRowIndex(label6, 1);
        label6.setPrefHeight(86.0);
        label6.setPrefWidth(174.0);
        label6.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-font-size: 5em;");
//        label6.setText("6");

        GridPane.setRowIndex(label7, 2);
        label7.setPrefHeight(86.0);
        label7.setPrefWidth(174.0);
        label7.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-font-size: 5em;");
//        label7.setText("7");

        GridPane.setColumnIndex(label8, 1);
        GridPane.setRowIndex(label8, 2);
        label8.setPrefHeight(86.0);
        label8.setPrefWidth(174.0);
        label8.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-font-size: 5em;");
//        label8.setText("8");

        GridPane.setColumnIndex(label9, 2);
        GridPane.setRowIndex(label9, 2);
        label9.setPrefHeight(86.0);
        label9.setPrefWidth(174.0);
        label9.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-font-size: 5em;");
//        label9.setText("9");

        btnback.setLayoutX(570.0);
        btnback.setLayoutY(240.0);
        btnback.setMnemonicParsing(false);
        btnback.setPrefHeight(50.0);
        btnback.setPrefWidth(100.0);
        btnback.setText("Back");
        btnback.setStyle("-fx-background-color: lightgreen;");
        btnback.setTextFill(javafx.scene.paint.Color.valueOf("#512222"));
        btnback.setFont(new Font(15.0));
        
        btnExit.setLayoutX(570.0);
        btnExit.setLayoutY(330.0);
        btnExit.setMnemonicParsing(false);
        btnExit.setPrefHeight(50.0);
        btnExit.setPrefWidth(100.0);
        btnExit.setText("Exit");
        btnExit.setStyle("-fx-background-color: red;");
        btnExit.setFont(new Font(15.0));

        getChildren().add(User1);
        getChildren().add(User2);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(label1);
        gridPane.getChildren().add(label2);
        gridPane.getChildren().add(label3);
        gridPane.getChildren().add(label4);
        gridPane.getChildren().add(label5);
        gridPane.getChildren().add(label6);
        gridPane.getChildren().add(label7);
        gridPane.getChildren().add(label8);
        gridPane.getChildren().add(label9);
        getChildren().add(btnback);
        getChildren().add(btnExit);
        getChildren().add(gridPane);

        th.start();

        label1.setOnMouseClicked((event) -> {
            makeTurn(label1, 1);
        });

        label2.setOnMouseClicked((event) -> {
            makeTurn(label2, 2);

        });
        label3.setOnMouseClicked((event) -> {
            makeTurn(label3, 3);

        });
        label4.setOnMouseClicked((event) -> {
            makeTurn(label4, 4);

        });
        label5.setOnMouseClicked((event) -> {
            makeTurn(label5, 5);

        });
        label6.setOnMouseClicked((event) -> {
            makeTurn(label6, 6);

        });
        label7.setOnMouseClicked((event) -> {
            makeTurn(label7, 7);

        });
        label8.setOnMouseClicked((event) -> {
            makeTurn(label8, 8);

        });
        label9.setOnMouseClicked((event) -> {
            makeTurn(label9, 9);

        });
//        if (!MyChar.equals("x")) {
//            System.out.println("nnnnnnnn");
//            message = (Message) input.readObject();
//            if (message.type.equals("play")) {
//                int num = Integer.parseInt(message.data[0]);
//                doitnow(num);
//                changecolor();
//            }
//
//        }
    }

    public void doitnow(int num) {
        switch (num) {
            case 1:
                label1.setStyle("-fx-background-color: lightgreen;");
                label1.setText(hisChar);
                changecolor();
                IPlayNow = true;
                break;

            case 2:
                label2.setStyle("-fx-background-color: lightgreen;");
                label2.setText(hisChar);
                changecolor();
                IPlayNow = true;
                break;
            case 3:
                label3.setStyle("-fx-background-color: lightgreen;");
                label3.setText(hisChar);
                changecolor();
                IPlayNow = true;
                break;
            case 4:
                label4.setStyle("-fx-background-color: lightgreen;");
                label4.setText(hisChar);
                changecolor();
                IPlayNow = true;
                break;
            case 5:
                label5.setStyle("-fx-background-color: lightgreen;");
                label5.setText(hisChar);
                changecolor();
                IPlayNow = true;
                break;
            case 6:
                label6.setStyle("-fx-background-color: lightgreen;");
                label6.setText(hisChar);
                changecolor();
                IPlayNow = true;
                break;
            case 7:
                label7.setStyle("-fx-background-color: lightgreen;");
                label7.setText(hisChar);
                changecolor();
                IPlayNow = true;
                break;
            case 8:
                label8.setStyle("-fx-background-color: lightgreen;");
                label8.setText(hisChar);
                changecolor();
                IPlayNow = true;
                break;
            case 9:
                label9.setStyle("-fx-background-color: lightGreen;");
                label9.setText(hisChar);
                changecolor();
                IPlayNow = true;
                break;
        }
    }

    public void changecolor() {
        if (MyChar.equals("x")) {
            if (IPlayNow) {
                User2.setStyle("-fx-background-color: lightblue;");
                User1.setStyle("-fx-background-color: 0;");
            } else {
                User1.setStyle("-fx-background-color: lightblue;");
                User2.setStyle("-fx-background-color: 0;");
            }

        } else {
            if (IPlayNow) {
                User1.setStyle("-fx-background-color: lightblue;");
                User2.setStyle("-fx-background-color: 0;");

            } else {
                User1.setStyle("-fx-background-color: lightblue;");
                User2.setStyle("-fx-background-color: 0;");

            }

        }
    }

    public void makeTurn(Label l, int num) {
        if (IPlayNow) {
            try {
                System.out.println("load");
//                output.writeInt(num);
                output.writeInt(5);
                output.writeObject(new Message("" + num + "", null));
                System.out.println("sent");

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        l.setText(MyChar);
                        l.setStyle("-fx-background-color: red;");
                        changecolor();
                    }

                });
                IPlayNow = false;

                System.out.println("end");
            } catch (IOException e) {
                System.out.println("line 346 online gaming");
//                e.printStackTrace();
            }

        }

    }

    @Override
    public void run() {
        try {
            while (true) {

//                System.out.println("adsa");
                input.readInt();
                message = (Message) input.readObject();
                if (message.type.equals("play")) {
                    int num = Integer.parseInt(message.data[0]);
                    System.out.println("recive");

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            doitnow(num);
                            changecolor();
                        }

                    });

                } else if (message.type.equals("Winner")) {
                    System.out.println("i winner");
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            showRusalt(1);
                        }

                    });
                } else if (message.type.equals("Losser")) {
                    System.out.println("i lose");
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            showRusalt(2);
                        }

                    });
                } else if (message.type.equals("NoWinner")) {
                    System.out.println("no winner");
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            showRusalt(0);
                        }

                    });

                }
            }
        } catch (ClassNotFoundException e) {

            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        } catch (IOException ex) {
            System.out.println("IOExceptionmmmmmmmm");
            ex.printStackTrace();
        }

    }

    public void showRusalt(int num) {
        try {
            String massege = "";
            if (num == 1) {
                //player1 won
                massege = "Congratulation " + User1.getText() + " , you win";

            } else if (num == 2) {
                massege = "Goodluck next Time " + User2.getText() + "in winner  !!!";
            } else if (num == 0) {
                massege = "GoodLuck !! next Time ; please try again !!";
            }

            alert.setContentText(massege);
            alert.showAndWait();
            alert.setAlertType(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Do you want to play again?");
            System.out.println("eiiin");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                System.out.println("dddd");
                output.writeInt(5);
                output.writeObject(new Message("again", null));
                GameOptionsBase root = new GameOptionsBase(primaryStage, S, input, output);
                Scene scene = new Scene(root, 700, 400);
                primaryStage.setTitle("Profile");
                primaryStage.setScene(scene);
                primaryStage.show();
                primaryStage.setResizable(false);
            } else {
                System.exit(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
