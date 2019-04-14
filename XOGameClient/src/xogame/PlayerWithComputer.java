/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xogame;

import javafx.scene.text.Font;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.stage.Stage;

/**
 *
 * @author hazem
 */
public class PlayerWithComputer extends GridPane {

    protected final ColumnConstraints colConst1;
    protected final ColumnConstraints colConst2;
    protected final ColumnConstraints colConst3;
    protected final ColumnConstraints colConst4;
    protected final ColumnConstraints colConst5;
    protected final RowConstraints rowConst1;
    protected final RowConstraints rowConst2;
    protected final RowConstraints rowConst3;
    protected final Button btnGrad1;
    protected final Button btnGrad2;
    protected final Button btnGrad3;
    protected final Button btnGrad4;
    protected final Button btnGrad5;
    protected final Button btnGrad6;
    protected final Button btnGrad7;
    protected final Button btnGrad8;
    protected final Button btnGrad9;
    protected final Button btnback;
    protected final Button btnExit;
    protected final Label playerX;
    protected final Label playerO;
    protected final Label numWinX;
    protected final Label numWinO;
    private String startGame = "X";
    private int xcount = 0;
    private int ocount = 0;
    List<Button> list = new ArrayList<>();
    protected Stage primaryStage;

    
    private void check() {
        Alert alert = new Alert(AlertType.INFORMATION, "No winner! Play again ?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            resett();
        } else if (alert.getResult() == ButtonType.NO) {
            System.exit(0);
        }
    }
    public void gameScore() {
        numWinX.setText(String.valueOf(xcount));
        numWinX.setStyle("-fx-font-size: 5em;-fx-padding:5px;-fx-text-fill:#fff;");
        numWinO.setText(String.valueOf(ocount));
        numWinO.setStyle("-fx-font-size: 5em;-fx-padding:5px;-fx-text-fill:#fff;");
    }
    public void MessageWin() {
        Alert alert = new Alert(AlertType.INFORMATION, "Play again ?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.YES) {
            resett();
        } else if (alert.getResult() == ButtonType.NO) {
            System.exit(0);
        }
    }
    public Button computerPlay() {
        int shuffleIndex = ThreadLocalRandom.current().nextInt(list.size());
        Button get = list.get(shuffleIndex);
        return get;
    }
    public boolean checkList() {
        for (Button button : list) {
            if (button.getText().length() == 0) 
                return true;
        }
        return false;
    }
    public void SetXO(Button btn) {
        btn.setText(startGame);
        btn.setStyle("-fx-background-color:orange;-fx-font-size: 8em; ");
        btn.setDisable(true);
        if (checkList() == true) {
            Button random;
            do {
                random = computerPlay();
            } while (random.getText().length() > 0);
            random.setText("O");
            random.setStyle("-fx-background-color:blue;-fx-font-size: 8em; ");
            random.setDisable(true);
            winner();
        } else {
            check();
        }
    }
    public void winX(Button btn1, Button btn2, Button btn3)
    {
        xcount++;
        gameScore();
        btn1.setStyle("-fx-background-color:yellow;-fx-font-size: 8em;");
        btn2.setStyle("-fx-background-color:yellow;-fx-font-size: 8em;");
        btn3.setStyle("-fx-background-color:yellow;-fx-font-size: 8em;");
        Alert winalert = new Alert(AlertType.INFORMATION, "Player x win");
        winalert.showAndWait();
    }
    
    public void winO(Button btn1, Button btn2, Button btn3)
    {
        ocount++;
        gameScore();
        btn1.setStyle("-fx-background-color:yellow;-fx-font-size: 8em;");
        btn2.setStyle("-fx-background-color:yellow;-fx-font-size: 8em;");
        btn3.setStyle("-fx-background-color:yellow;-fx-font-size: 8em;");
        Alert winalert = new Alert(AlertType.INFORMATION, "Player O win");
        winalert.showAndWait();
    }
    public void resett()
    {
        btnGrad1.setDisable(false);
        btnGrad8.setDisable(false);
        btnGrad2.setDisable(false);
        btnGrad3.setDisable(false);
        btnGrad9.setDisable(false);
        btnGrad4.setDisable(false);
        btnGrad5.setDisable(false);
        btnGrad6.setDisable(false);
        btnGrad7.setDisable(false);
        btnGrad1.setText("");
        btnGrad8.setText("");
        btnGrad2.setText("");
        btnGrad3.setText("");
        btnGrad9.setText("");
        btnGrad4.setText("");
        btnGrad5.setText("");
        btnGrad6.setText("");
        btnGrad7.setText("");
        btnGrad1.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        btnGrad8.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        btnGrad2.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        btnGrad3.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        btnGrad9.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        btnGrad4.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        btnGrad5.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        btnGrad6.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        btnGrad7.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
    }
    public PlayerWithComputer(Stage primaryStage1) {
        primaryStage = primaryStage1;
        colConst1 = new ColumnConstraints();
        colConst2 = new ColumnConstraints();
        colConst3 = new ColumnConstraints();
        colConst4 = new ColumnConstraints();
        colConst5 = new ColumnConstraints();
        rowConst1 = new RowConstraints();
        rowConst2 = new RowConstraints();
        rowConst3 = new RowConstraints();
        btnGrad1 = new Button();
        btnGrad2 = new Button();
        btnGrad3 = new Button();
        btnGrad4 = new Button();
        btnGrad5 = new Button();
        btnGrad6 = new Button();
        btnGrad7 = new Button();
        btnGrad9 = new Button();
        btnGrad8 = new Button();
        btnback = new Button();
        btnExit = new Button();
        playerX = new Label();
        playerO = new Label();
        numWinX = new Label();
        numWinO = new Label();
        list.add(btnGrad1);
        list.add(btnGrad8);
        list.add(btnGrad2);
        list.add(btnGrad3);
        list.add(btnGrad9);
        list.add(btnGrad4);
        list.add(btnGrad5);
        list.add(btnGrad6);
        list.add(btnGrad7);
        
        btnGrad1.setOnAction((ActionEvent event) -> {
            SetXO(btnGrad1);
        });
        btnGrad2.setOnAction((ActionEvent event) -> {
            SetXO(btnGrad2);
        });
        btnGrad3.setOnAction((ActionEvent event) -> {
            SetXO(btnGrad3);
        });
        btnGrad4.setOnAction((ActionEvent event) -> {
            SetXO(btnGrad4);
        });
        btnGrad5.setOnAction((ActionEvent event) -> {
            SetXO(btnGrad5);
        });
        btnGrad6.setOnAction((ActionEvent event) -> {
            SetXO(btnGrad6);
        });
        btnGrad7.setOnAction((ActionEvent event) -> {
            SetXO(btnGrad7);
        });
        btnGrad8.setOnAction((ActionEvent event) -> {
            SetXO(btnGrad8);
        });
        btnGrad9.setOnAction((ActionEvent event) -> {
            SetXO(btnGrad9);
        });
        btnback.setOnAction((ActionEvent event) -> {
            LocalGameControlBase root = new LocalGameControlBase(primaryStage);
            Scene scene = new Scene(root, 700, 400);
            primaryStage.setTitle("Profile");
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
        });
        btnExit.setOnAction((ActionEvent event) -> {
            Alert alert = new Alert(AlertType.CONFIRMATION, "Do you exit ?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) 
                System.exit(0);
        });
        setGridLinesVisible(true);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #20120F;");
        colConst1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        colConst1.setMinWidth(10.0);
        colConst1.setPrefWidth(100.0);
        colConst2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        colConst2.setMinWidth(10.0);
        colConst2.setPrefWidth(100.0);
        colConst3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        colConst3.setMinWidth(10.0);
        colConst3.setPrefWidth(100.0);
        colConst4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        colConst4.setMinWidth(10.0);
        colConst4.setPrefWidth(100.0);
        colConst5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        colConst5.setMinWidth(10.0);
        colConst5.setPrefWidth(100.0);
        rowConst1.setMinHeight(10.0);
        rowConst1.setPrefHeight(30.0);
        rowConst1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        rowConst2.setMinHeight(10.0);
        rowConst2.setPrefHeight(30.0);
        rowConst2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        rowConst3.setMinHeight(10.0);
        rowConst3.setPrefHeight(30.0);
        rowConst3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);
        btnGrad1.setMnemonicParsing(false);
        btnGrad1.setPrefHeight(152.0);
        btnGrad1.setPrefWidth(215.0);
        btnGrad1.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        GridPane.setColumnIndex(btnGrad2, 2);
        btnGrad2.setMnemonicParsing(false);
        btnGrad2.setPrefHeight(162.0);
        btnGrad2.setPrefWidth(238.0);
        btnGrad2.setStyle("-fx-background-color: #c8e6f7;-fx-margin: 2px;-fx-border-color:black;");
        GridPane.setRowIndex(btnGrad3, 1);
        btnGrad3.setMnemonicParsing(false);
        btnGrad3.setPrefHeight(198.0);
        btnGrad3.setPrefWidth(291.0);
        btnGrad3.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        GridPane.setColumnIndex(btnGrad4, 2);
        GridPane.setRowIndex(btnGrad4, 1);
        btnGrad4.setMnemonicParsing(false);
        btnGrad4.setPrefHeight(178.0);
        btnGrad4.setPrefWidth(206.0);
        btnGrad4.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        GridPane.setRowIndex(btnGrad5, 2);
        btnGrad5.setMnemonicParsing(false);
        btnGrad5.setPrefHeight(220.0);
        btnGrad5.setPrefWidth(276.0);
        btnGrad5.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        GridPane.setColumnIndex(btnGrad6, 1);
        GridPane.setRowIndex(btnGrad6, 2);
        btnGrad6.setMnemonicParsing(false);
        btnGrad6.setPrefHeight(156.0);
        btnGrad6.setPrefWidth(241.0);
        btnGrad6.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        GridPane.setColumnIndex(btnGrad7, 2);
        GridPane.setRowIndex(btnGrad7, 2);
        btnGrad7.setMnemonicParsing(false);
        btnGrad7.setPrefHeight(191.0);
        btnGrad7.setPrefWidth(212.0);
        btnGrad7.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        GridPane.setColumnIndex(btnGrad8, 1);
        btnGrad8.setMnemonicParsing(false);
        btnGrad8.setPrefHeight(258.0);
        btnGrad8.setPrefWidth(395.0);
        btnGrad8.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        GridPane.setColumnIndex(btnGrad9, 1);
        GridPane.setRowIndex(btnGrad9, 1);
        btnGrad9.setMnemonicParsing(false);
        btnGrad9.setPrefHeight(169.0);
        btnGrad9.setPrefWidth(254.0);
        btnGrad9.setStyle("-fx-background-color: #c8e6f7;-fx-border-color:black;");
        
        GridPane.setColumnIndex(btnback, 3);
        GridPane.setRowIndex(btnback, 2);
        btnback.setMnemonicParsing(false);
        btnback.setPrefHeight(169.0);
        btnback.setPrefWidth(254.0);
        btnback.setText("Back");
        btnback.setStyle("-fx-background-color: lightgreen;");
        btnback.setTextFill(javafx.scene.paint.Color.valueOf("#512222"));
        btnback.setFont(new Font(26.0));
        
        GridPane.setColumnIndex(btnExit, 4);
        GridPane.setRowIndex(btnExit, 2);
        btnExit.setMnemonicParsing(false);
        btnExit.setPrefHeight(169.0);
        btnExit.setPrefWidth(254.0);
        btnExit.setText("Exit");
        btnExit.setStyle("-fx-background-color: red;");
        btnExit.setFont(new Font(36.0));
        GridPane.setColumnIndex(playerX, 3);
        playerX.setPrefHeight(177.0);
        playerX.setPrefWidth(136.0);
        playerX.setText("Player x");
        playerX.setStyle("-fx-padding: 5px;-fx-text-fill: #FFF;");
        playerX.setFont(new Font(15.0));
        GridPane.setColumnIndex(playerO, 3);
        GridPane.setRowIndex(playerO, 1);
        playerO.setPrefHeight(210.0);
        playerO.setPrefWidth(143.0);
        playerO.setText("Computer o");
        playerO.setStyle("-fx-padding: 5px;-fx-text-fill: #FFF;");
        playerO.setFont(new Font(18.0));
        GridPane.setColumnIndex(numWinX, 4);
        numWinX.setPrefHeight(164.0);
        numWinX.setPrefWidth(117.0);
        GridPane.setColumnIndex(numWinO, 4);
        GridPane.setRowIndex(numWinO, 1);
        numWinO.setPrefHeight(163.0);
        numWinO.setPrefWidth(158.0);
        getColumnConstraints().add(colConst1);
        getColumnConstraints().add(colConst2);
        getColumnConstraints().add(colConst3);
        getColumnConstraints().add(colConst4);
        getColumnConstraints().add(colConst5);
        getRowConstraints().add(rowConst1);
        getRowConstraints().add(rowConst2);
        getRowConstraints().add(rowConst3);
        getChildren().add(btnGrad1);
        getChildren().add(btnGrad2);
        getChildren().add(btnGrad3);
        getChildren().add(btnGrad4);
        getChildren().add(btnGrad5);
        getChildren().add(btnGrad6);
        getChildren().add(btnGrad7);
        getChildren().add(btnGrad8);
        getChildren().add(btnGrad9);
        getChildren().add(btnback);
        getChildren().add(btnExit);
        getChildren().add(playerX);
        getChildren().add(playerO);
        getChildren().add(numWinX);
        getChildren().add(numWinO);
    }
    public void winner() {
        String btngrad1 = btnGrad1.getText();
        String btngrad2 = btnGrad8.getText();
        String btngrad3 = btnGrad2.getText();
        String btngrad4 = btnGrad3.getText();
        String btngrad5 = btnGrad9.getText();
        String btngrad6 = btnGrad4.getText();
        String btngrad7 = btnGrad5.getText();
        String btngrad8 = btnGrad6.getText();
        String btngrad9 = btnGrad7.getText();
        if ((btngrad1 == "X" && btngrad2 == "X" && btngrad3 == "X")) {
            winX(btnGrad1,btnGrad8,btnGrad2);
            MessageWin();
        } else if (btngrad4 == "X" && btngrad5 == "X" && btngrad6 == "X") {
            winX(btnGrad3,btnGrad9,btnGrad4);
            MessageWin();
        } else if (btngrad7 == "X" && btngrad8 == "X" && btngrad9 == "X") {
            winX(btnGrad5,btnGrad6,btnGrad7);
            MessageWin();
        } else if (btngrad7 == "X" && btngrad8 == "X" && btngrad9 == "X") {
            winX(btnGrad5,btnGrad6,btnGrad7);
            MessageWin();
        } else if (btngrad1 == "X" && btngrad4 == "X" && btngrad7 == "X") {
            winX(btnGrad1,btnGrad3,btnGrad5);
            MessageWin();
        } else if (btngrad2 == "X" && btngrad5 == "X" && btngrad8 == "X") {
            winX(btnGrad8,btnGrad9,btnGrad6);
            MessageWin();
        } else if (btngrad3 == "X" && btngrad6 == "X" && btngrad9 == "X") {
            winX(btnGrad2,btnGrad4,btnGrad7);
            MessageWin();
        } else if (btngrad1 == "X" && btngrad5 == "X" && btngrad9 == "X") {
            winX(btnGrad1,btnGrad9,btnGrad7);
            MessageWin();
        } else if (btngrad3 == "X" && btngrad5 == "X" && btngrad7 == "X") {
            winX(btnGrad2,btnGrad9,btnGrad5);
            MessageWin();
        } 
        else if ((btngrad1 == "O" && btngrad2 == "O" && btngrad3 == "O")) {
            winO(btnGrad1,btnGrad8,btnGrad2);
            MessageWin();
        } else if (btngrad4 == "O" && btngrad5 == "O" && btngrad6 == "O") {
            winO(btnGrad3,btnGrad9,btnGrad4);
            MessageWin();
        } else if (btngrad7 == "O" && btngrad8 == "O" && btngrad9 == "O") {
            winO(btnGrad5,btnGrad6,btnGrad7);
            MessageWin();
        } else if (btngrad7 == "O" && btngrad8 == "O" && btngrad9 == "O") {
            winO(btnGrad5,btnGrad6,btnGrad7);
            MessageWin();
        } else if (btngrad1 == "O" && btngrad4 == "O" && btngrad7 == "O") {
            winO(btnGrad1,btnGrad3,btnGrad5);
            MessageWin();
        } else if (btngrad2 == "O" && btngrad5 == "O" && btngrad8 == "O") {
            winO(btnGrad8,btnGrad9,btnGrad6);
            MessageWin();
        } else if (btngrad3 == "O" && btngrad6 == "O" && btngrad9 == "O") {
            winO(btnGrad2,btnGrad4,btnGrad7);
            MessageWin();
        } else if (btngrad1 == "O" && btngrad5 == "O" && btngrad9 == "O") {
            winO(btnGrad1,btnGrad9,btnGrad7);
            MessageWin();
        } else if (btngrad3 == "O" && btngrad5 == "O" && btngrad7 == "O") {
            winO(btnGrad2,btnGrad9,btnGrad5);
            MessageWin();
        } else if ((btnGrad1.getText() != "") && (btnGrad8.getText() != "") && (btnGrad2.getText() != "") && (btnGrad3.getText() != "") && (btnGrad9.getText() != "") && (btnGrad4.getText() != "") && (btnGrad5.getText() != "") && (btnGrad6.getText() != "") && (btnGrad7.getText() != "")) {
            check();
        }
    }
}