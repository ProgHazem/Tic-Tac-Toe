package xogame;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import xogame.online.SignUpBase;

public  class IntroBase extends AnchorPane {

    protected final Button Local;
    protected final Button Online;    
    protected final Button Exit;
    protected final Label title;

    public IntroBase(Stage primaryStage) {

        title = new Label();
        Local = new Button();
        Exit = new Button();
        Local.setOnAction((event)->{
        LocalGameControlBase root = new LocalGameControlBase(primaryStage);
        Scene scene = new Scene(root, 700, 400);
        primaryStage.setTitle("Local Playing");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        });
        
        
        Online = new Button();
        Online.setOnAction((event)->{
        SignUpBase root = new SignUpBase(primaryStage);
        Scene scene = new Scene(root, 700, 400);
        primaryStage.setTitle("Rigister");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        });

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #7026ef;");

        title.setLayoutX(170.0);
        title.setLayoutY(44.0);
        title.setPrefHeight(36.0);
        title.setPrefWidth(382.0);
        title.setStyle("-fx-text-fill: #FFF;");
        title.setText("Toc Tac Tae");
        title.setFont(new Font(java.awt.Font.SANS_SERIF, 50));
        
        Local.setLayoutX(200.0);
        Local.setLayoutY(180.0);
        Local.setMnemonicParsing(false);
        Local.setPrefHeight(40.0);
        Local.setPrefWidth(218.0);
        Local.setStyle("-fx-background-color: #4deacd; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
        Local.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
        Local.setText("local");
        

        Online.setLayoutX(200.0);
        Online.setLayoutY(240.0);
        Online.setMnemonicParsing(false);
        Online.setPrefHeight(40.0);
        Online.setPrefWidth(218.0);
        Online.setStyle("-fx-background-color: #4deacd; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
        Online.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
        Online.setText("online");
        
        Exit.setLayoutX(450.0);
        Exit.setLayoutY(350.0);
        Exit.setMnemonicParsing(false);
        Exit.setPrefHeight(40.0);
        Exit.setPrefWidth(218.0);
        Exit.setStyle("-fx-background-color: #d35050; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
        Exit.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
        Exit.setText("Exit");
        
        
        // closing The program
        Exit.setOnAction((ActionEvent event) -> {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alertType(alert, "Close Program", "Are you Want To Close?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) 
            {
                System.exit(0);
            }
        });

        getChildren().add(Local);
        getChildren().add(Online);
        getChildren().add(title);
        getChildren().add(Exit);
        

    }
    public void alertType(Alert alert, String title, String body)
    {
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setResizable(true);
        alert.setContentText(body);
    }
}
