/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xogameserver;

import Server.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author midosha3ban
 */
public class XOGameServer extends Application {
    
    @Override
    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setMnemonicParsing(false);
//        btn.setPrefHeight(40.0);
//        btn.setPrefWidth(218.0);
//        btn.setStyle("-fx-background-color: darkred; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
//        btn.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
//        btn.setText("Run Server");
//        btn.setOnAction((ActionEvent event)-> {
//                btn.setText("Stop Server");
//                btn.setStyle("-fx-background-color: lightpink; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
//                new XOServer();
//        });
//        
//        Button btnclose = new Button();
//        btnclose.setMnemonicParsing(false);
//        btnclose.setPrefHeight(40.0);
//        btnclose.setPrefWidth(218.0);
//        btnclose.setStyle("-fx-background-color: darkred; -fx-margin-top: 100px;-fx-border-color: #3D3D3D; -fx-cursor: hand;");
//        btnclose.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
//        btnclose.setText("Close");
//        btnclose.setOnAction((ActionEvent event)-> {
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do you exit ?", ButtonType.YES, ButtonType.NO);
//            alert.showAndWait();
//            if (alert.getResult() == ButtonType.YES) 
//                System.exit(0);
//        });
        
        RunServerBase root = new RunServerBase(primaryStage);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Server Page");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
