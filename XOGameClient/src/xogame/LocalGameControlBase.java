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

public  class LocalGameControlBase extends AnchorPane {

    protected final Button WithComputerBtn;
    protected final Button TwoPlayerBtn;
    protected final Button Back;
    protected final Label title;

    public LocalGameControlBase(Stage primaryStage) {
        
        title = new Label();
        WithComputerBtn = new Button();        
        WithComputerBtn.setOnAction((event)->{
        PlayerWithComputer root = new PlayerWithComputer(primaryStage);
        Scene scene = new Scene(root, 700, 400);
        primaryStage.setTitle("Gaming");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        });
        TwoPlayerBtn = new Button();
        TwoPlayerBtn.setOnAction((event)->{
        TwoPlayerOneMachine root = new TwoPlayerOneMachine(primaryStage);
        Scene scene = new Scene(root, 700, 400);
        primaryStage.setTitle("Gaming");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        });
        

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #7026ef;");
        
        title.setLayoutX(200.0);
        title.setLayoutY(44.0);
        title.setPrefHeight(36.0);
        title.setPrefWidth(382.0);
        title.setStyle("-fx-text-fill: #FFF;");
        title.setText("Welcom");
        title.setFont(new Font(java.awt.Font.SANS_SERIF, 50));

        WithComputerBtn.setLayoutX(200.0);
        WithComputerBtn.setLayoutY(180.0);
        WithComputerBtn.setMnemonicParsing(false);
        WithComputerBtn.setPrefHeight(40.0);
        WithComputerBtn.setPrefWidth(218.0);
        WithComputerBtn.setStyle("-fx-background-color: #4deacd; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
        WithComputerBtn.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
        WithComputerBtn.setText("With Computer");
        

        TwoPlayerBtn.setLayoutX(200.0);
        TwoPlayerBtn.setLayoutY(240.0);
        TwoPlayerBtn.setMnemonicParsing(false);
        TwoPlayerBtn.setPrefHeight(40.0);
        TwoPlayerBtn.setPrefWidth(218.0);
        TwoPlayerBtn.setStyle("-fx-background-color: #4deacd; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
        TwoPlayerBtn.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
        TwoPlayerBtn.setText("Two Players");
        
        Back = new Button();        
        Back.setLayoutX(450.0);
        Back.setLayoutY(350.0);
        Back.setMnemonicParsing(false);
        Back.setPrefHeight(40.0);
        Back.setPrefWidth(218.0);
        Back.setStyle("-fx-background-color: #d35050; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
        Back.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
        Back.setText("Back");
        
        
        // closing The program
        Back.setOnAction((ActionEvent event) -> {
            IntroBase root = new IntroBase(primaryStage);
            Scene scene = new Scene(root, 700, 400);
            primaryStage.setTitle("Gaming");
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
        });

        getChildren().add(WithComputerBtn);
        getChildren().add(TwoPlayerBtn);        
        getChildren().add(title);
        getChildren().add(Back);


    }
}
