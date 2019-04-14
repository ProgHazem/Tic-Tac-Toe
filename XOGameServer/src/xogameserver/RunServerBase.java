package xogameserver;

import Server.XOServer;
import static javafx.application.Application.launch;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public  class RunServerBase extends AnchorPane {

    protected final Button button;
    protected final Label label;
    boolean isrun;
    XOServer server;
    Stage primary;

    public RunServerBase(Stage s) {
        primary=s;
        isrun=false;
        button = new Button();
        label = new Label();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: black;");

        button.setDefaultButton(true);
        button.setLayoutX(73.0);
        button.setLayoutY(207.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(57.0);
        button.setPrefWidth(419.0);
        button.setStyle("-fx-background-color: darkred;");
        button.setText("Run Server");
        button.setTextOverrun(javafx.scene.control.OverrunStyle.CENTER_ELLIPSIS);
        button.setWrapText(true);

        label.setLayoutX(53.0);
        label.setLayoutY(73.0);
        label.setPrefHeight(84.0);
        label.setPrefWidth(479.0);
        label.setText("Tic Tac  Toe Server");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#f5ecec"));
        label.setFont(new Font("System Bold Italic", 39.0));

        button.setOnAction((event)->{
            if(isrun)
            {
                button.setStyle("-fx-background-color: darkred;");
                button.setText("run Server");
                isrun=false;
                 server.close();
                
            }else
            {
                button.setStyle("-fx-background-color: lightgreen;");
                button.setText("Stop Server");
                server = new XOServer();
                isrun=true;
            }
        
        
        });
        
        
        
        
        
        getChildren().add(button);
        getChildren().add(label);
        
        primary.setOnCloseRequest((event)->{
            if(isrun)
                server.close();
        });

    }
    
   
}
