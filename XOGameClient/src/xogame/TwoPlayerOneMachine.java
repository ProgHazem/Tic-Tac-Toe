/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xogame;

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

/**
 *
 * @author hazem
 */

public class TwoPlayerOneMachine extends AnchorPane {

    public int ComputerState;
    public int[] game;
    public int whoPlay;
    protected final Label username1;
    protected final Label username2;
    protected final GridPane gridPane;
    protected final ColumnConstraints colConst1;
    protected final ColumnConstraints colConst2;
    protected final ColumnConstraints colConst3;
    protected final RowConstraints rowConst1;
    protected final RowConstraints rowConst2;
    protected final RowConstraints rowConst3;
    protected final Label labGrad1;
    protected final Label labGrad2;
    protected final Label labGrad3;
    protected final Label labGrad4;
    protected final Label labGrad5;
    protected final Label labGrad6;
    protected final Label labGrad7;
    protected final Label labGrad8;
    protected final Label labGrad9;
    protected final Button btnback;
    protected final Button btnExit;
    protected Stage primaryStage;
    
    public TwoPlayerOneMachine(Stage primaryStage1) {
        primaryStage = primaryStage1;
        game = new int[9];
        for (int i = 0; i < 9; i++) {
            game[i] = 0;
        }
        whoPlay = 1;
        username1 = new Label();
        username2 = new Label();
        gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        colConst1 = new ColumnConstraints();
        colConst2 = new ColumnConstraints();
        colConst3 = new ColumnConstraints();
        rowConst1 = new RowConstraints();
        rowConst2 = new RowConstraints();
        rowConst3 = new RowConstraints();
        labGrad1 = new Label();
        labGrad2 = new Label();
        labGrad3 = new Label();
        labGrad4 = new Label();
        labGrad5 = new Label();
        labGrad6 = new Label();
        labGrad7 = new Label();
        labGrad8 = new Label();
        labGrad9 = new Label();
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
        
        Font f = new Font(25);
        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #20120F;");
        username1.setLayoutX(28.0);
        username1.setLayoutY(22.0);
        username1.setPrefHeight(52.0);
        username1.setPrefWidth(168.0);
        username1.setText("Player1");
        username1.setStyle("-fx-background-color: lightBlue;-fx-text-fill:#fff;-fx-font-size: 2em;");

        username2.setLayoutX(395.0);
        username2.setLayoutY(22.0);
        username2.setPrefHeight(52.0);
        username2.setPrefWidth(168.0);
        username2.setText("Player2");
        username2.setStyle("-fx-background-color: lightBlue;-fx-text-fill:#fff;-fx-font-size: 2em;");


        gridPane.setLayoutX(25.0);
        gridPane.setLayoutY(110.0);
        gridPane.setPrefHeight(272.0);
        gridPane.setPrefWidth(529.0);

        colConst1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        colConst1.setMinWidth(10.0);
        colConst1.setPrefWidth(100.0);

        colConst2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        colConst2.setMinWidth(10.0);
        colConst2.setPrefWidth(100.0);

        colConst3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        colConst3.setMinWidth(10.0);
        colConst3.setPrefWidth(100.0);

        rowConst1.setMinHeight(10.0);
        rowConst1.setPrefHeight(30.0);
        rowConst1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConst2.setMinHeight(10.0);
        rowConst2.setPrefHeight(30.0);
        rowConst2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConst3.setMinHeight(10.0);
        rowConst3.setPrefHeight(30.0);
        rowConst3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        
        
        
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

        labGrad1.setPrefHeight(86.0);
        labGrad1.setPrefWidth(174.0);
        labGrad1.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-font-size: 5em;");
        labGrad1.setOnMouseClicked((event) -> {
            if (isavailable()) {
                maketurn(labGrad1, 1);
                if (check() == 0) {
                    changetheRole();
                } else {
                    showWinner(check());
                }
            } else {
                showWinner(0);
            }
            labGrad1.setDisable(true);
        });
        GridPane.setColumnIndex(labGrad2, 2);
        labGrad2.setPrefHeight(86.0);
        labGrad2.setPrefWidth(174.0);
        labGrad2.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-text-fill:#fff;-fx-font-size: 5em;");
        labGrad2.setOnMouseClicked((event) -> {
            if (isavailable()) {
                maketurn(labGrad2, 3);
                if (check() == 0) {
                    changetheRole();
                } else {
                    showWinner(check());
                }
            } else {
                showWinner(0);
            }
            labGrad2.setDisable(true);
        });
        GridPane.setColumnIndex(labGrad3, 1);
        GridPane.setRowIndex(labGrad3, 2);
        labGrad3.setPrefHeight(86.0);
        labGrad3.setPrefWidth(174.0);
        labGrad3.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-text-fill:#fff;-fx-font-size: 5em;");
        labGrad3.setOnMouseClicked((event) -> {
            if (isavailable()) {
                maketurn(labGrad3, 8);
                if (check() == 0) {
                    changetheRole();
                } else {
                    showWinner(check());
                }
            } else {
                showWinner(0);
            }
            labGrad3.setDisable(true);
        });
        GridPane.setColumnIndex(labGrad4, 1);
        GridPane.setRowIndex(labGrad4, 1);
        labGrad4.setPrefHeight(86.0);
        labGrad4.setPrefWidth(174.0);
        labGrad4.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-text-fill:#fff;-fx-font-size: 5em;");
        labGrad4.setOnMouseClicked((event) -> {
            if (isavailable()) {
                maketurn(labGrad4, 5);
                if (check() == 0) {
                    changetheRole();
                } else {
                    showWinner(check());
                }
            } else {
                showWinner(0);
            }
            labGrad4.setDisable(true);
        });
        GridPane.setRowIndex(labGrad5, 2);
        labGrad5.setPrefHeight(86.0);
        labGrad5.setPrefWidth(174.0);
        labGrad5.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-text-fill:#fff;-fx-font-size: 5em;");
        labGrad5.setOnMouseClicked((event) -> {
            if (isavailable()) {
                maketurn(labGrad5, 7);
                if (check() == 0) {
                    changetheRole();
                } else {
                    showWinner(check());
                }
            } else {
                showWinner(0);
            }
            labGrad5.setDisable(true);
        });
        GridPane.setRowIndex(labGrad6, 1);
        labGrad6.setPrefHeight(86.0);
        labGrad6.setPrefWidth(174.0);
        labGrad6.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-text-fill:#fff;-fx-font-size: 5em;");
        labGrad6.setOnMouseClicked((event) -> {
            if (isavailable()) {
                maketurn(labGrad6, 4);
                if (check() == 0) {
                    changetheRole();
                } else {
                    showWinner(check());
                }
            } else {
                showWinner(0);
            }
            labGrad6.setDisable(true);
        });
        GridPane.setColumnIndex(labGrad7, 1);
        labGrad7.setPrefHeight(86.0);
        labGrad7.setPrefWidth(174.0);
        labGrad7.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-text-fill:#fff;-fx-font-size: 5em;");
        labGrad7.setOnMouseClicked((event) -> {
            if (isavailable()) {
                maketurn(labGrad7, 2);
                if (check() == 0) {
                    changetheRole();
                } else {
                    showWinner(check());
                }
            } else {
                showWinner(0);
            }
            labGrad7.setDisable(true);
        });
        GridPane.setColumnIndex(labGrad8, 2);
        GridPane.setRowIndex(labGrad8, 2);
        labGrad8.setPrefHeight(86.0);
        labGrad8.setPrefWidth(174.0);
        labGrad8.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-text-fill:#fff;-fx-font-size: 5em;");
        labGrad8.setOnMouseClicked((event) -> {
            if (isavailable()) {
                maketurn(labGrad8, 9);
                if (check() == 0) {
                    changetheRole();
                } else {
                    showWinner(check());
                }
            } else {
                showWinner(0);
            }
            labGrad8.setDisable(true);
        });
        GridPane.setColumnIndex(labGrad9, 2);
        GridPane.setRowIndex(labGrad9, 1);
        labGrad9.setPrefHeight(86.0);
        labGrad9.setPrefWidth(174.0);
        labGrad9.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;-fx-text-fill:#fff;-fx-font-size: 5em;");
        labGrad9.setOnMouseClicked((event) -> {
            if (isavailable()) {
                maketurn(labGrad9, 6);
                if (check() == 0) {
                    changetheRole();
                } else {
                    showWinner(check());
                }
            } else {
                showWinner(0);
            }
            labGrad9.setDisable(true);
        });
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
        
        getChildren().add(username1);
        getChildren().add(username2);
        gridPane.getColumnConstraints().add(colConst1);
        gridPane.getColumnConstraints().add(colConst2);
        gridPane.getColumnConstraints().add(colConst3);
        gridPane.getRowConstraints().add(rowConst1);
        gridPane.getRowConstraints().add(rowConst2);
        gridPane.getRowConstraints().add(rowConst3);
        gridPane.getChildren().add(labGrad1);
        gridPane.getChildren().add(labGrad2);
        gridPane.getChildren().add(labGrad3);
        gridPane.getChildren().add(labGrad4);
        gridPane.getChildren().add(labGrad5);
        gridPane.getChildren().add(labGrad6);
        gridPane.getChildren().add(labGrad7);
        gridPane.getChildren().add(labGrad8);
        gridPane.getChildren().add(labGrad9);
        getChildren().add(btnback);
        getChildren().add(btnExit);
        getChildren().add(gridPane);
    }
    public void changetheRole() {
        if (whoPlay == 1) {
            username2.setStyle("-fx-background-color: lightBlue;-fx-font-size: 2em;");
            username1.setStyle("-fx-background-color: 0;-fx-font-size: 2em;");
            whoPlay = 2;
        } else {
            username1.setStyle("-fx-background-color: lightBlue;-fx-font-size: 2em;");
            username2.setStyle("-fx-background-color: 0;-fx-font-size: 2em;");
            whoPlay = 1;
        }
    }
    public void maketurn(Label lab1, int state) {
        if (whoPlay == 1) {
            lab1.setText("x");
            lab1.setStyle("-fx-background-color:blue;-fx-font-size: 5em;");
            game[state - 1] = 1;
        } else {
                lab1.setText("o");
                lab1.setStyle("-fx-background-color:pink;-fx-font-size: 5em;");
                game[state - 1] = 2;
        }
    }

    public int check() {
        if ((game[0] == 1 && game[1] == 1 && game[2] == 1) || (game[3] == 1 && game[4] == 1 && game[5] == 1)
                || (game[6] == 1 && game[7] == 1 && game[8] == 1) || (game[0] == 1 && game[4] == 1 && game[8] == 1)
                || (game[2] == 1 && game[4] == 1 && game[6] == 1) || (game[0] == 1 && game[3] == 1 && game[6] == 1)
                || (game[1] == 1 && game[7] == 1 && game[4] == 1) || (game[2] == 1 && game[5] == 1 && game[8] == 1)) {
            return 1;
        } else if ((game[0] == 2 && game[1] == 2 && game[2] == 2) || (game[3] == 2 && game[4] == 2 && game[5] == 2)
                || (game[6] == 2 && game[7] == 2 && game[8] == 2) || (game[0] == 2 && game[4] == 2 && game[8] == 2)
                || (game[2] == 2 && game[4] == 2 && game[6] == 2) || (game[0] == 2 && game[3] == 2 && game[6] == 2)
                || (game[1] == 2 && game[7] == 2 && game[4] == 2) || (game[2] == 2 && game[5] == 2 && game[8] == 2)) {
            return 2;
        }
        return 0;
    }

    public boolean isavailable() {
        for (int i = 0; i < 9; i++) {
            if (game[i] == 0) {
                return true;
            }
        }
        return false;
    }

    public void showWinner(int x) {
        String massege;
        if (x == 1) {
            massege = "Congratulation player 1 , you win";
        } else if (x == 0) {
            massege = "Goodluck next Time !!!";
        } else {
            if (ComputerState == 1) {
                massege = "goodluck For You , you state lose";
            } else {
                massege = "Congratulation Your Friend , good luck for you and Your friend win";
            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(massege);
        alert.showAndWait();
        alert.setAlertType(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Do you want to play again?");
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            TwoPlayerOneMachine root = new TwoPlayerOneMachine(primaryStage);
            Scene scene = new Scene(root, 700, 400);
            primaryStage.setTitle("Gaming");
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
        } else {
            System.exit(0);
        }
    }
}
