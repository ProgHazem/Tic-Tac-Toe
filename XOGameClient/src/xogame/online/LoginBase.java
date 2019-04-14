package xogame.online;

import helper.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import xogame.IntroBase;

public class LoginBase extends AnchorPane {

    protected final TextField UserNameTxt;
    protected final PasswordField PasswordTxt;
    protected final Button LoginBtn;
    protected final Button SignBtn;
    protected final Button Exit;
    protected final Label title;
    protected final Button Back;
    Socket S;
    ObjectInputStream input;
    ObjectOutputStream output;
    Message ms;

    public LoginBase(Stage primaryStage, Socket S, ObjectInputStream input, ObjectOutputStream output) {

        this.output = output;
        this.input = input;
        this.S = S;
        UserNameTxt = new TextField();
        PasswordTxt = new PasswordField();
        LoginBtn = new Button();
        SignBtn = new Button();
        Exit = new Button();
        title = new Label();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #7026ef;");
        
        title.setLayoutX(169.0);
        title.setLayoutY(44.0);
        title.setPrefHeight(36.0);
        title.setPrefWidth(382.0);
        title.setStyle("-fx-text-fill: #FFF;");
        title.setText("Please Fill Login Form");
        title.setFont(new Font(30.0));
        
        UserNameTxt.setLayoutX(200.0);
        UserNameTxt.setLayoutY(100.0);
        UserNameTxt.setPrefHeight(40.0);
        UserNameTxt.setPrefWidth(300.0);
        UserNameTxt.setPromptText("Enter Your User Name");

        PasswordTxt.setLayoutX(200.0);
        PasswordTxt.setLayoutY(150.0);
        PasswordTxt.setPrefHeight(40.0);
        PasswordTxt.setPrefWidth(300.0);
        PasswordTxt.setPromptText("Enter Your Password");

        LoginBtn.setLayoutX(400.0);
        LoginBtn.setLayoutY(300.0);
        LoginBtn.setMnemonicParsing(false);
        LoginBtn.setPrefHeight(40.0);
        LoginBtn.setPrefWidth(218.0);
        LoginBtn.setStyle("-fx-background-color: #4deacd; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
        LoginBtn.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
        LoginBtn.setText("LogIn");
        LoginBtn.setOnAction((event) -> {
            if (UserNameTxt.getText().length() < 4) {
                System.out.println("inter valid name");
            } else if (PasswordTxt.getText().length() == 0) {
                System.out.println("please inter password");
            } else if (PasswordTxt.getText().length() < 6) {
                System.out.println("please the password >= 6");
            } else {
                //call with server
                try {
                    output.writeObject(new Message("Login", new String[]{UserNameTxt.getText(), PasswordTxt.getText()}));
                    ms = (Message) input.readObject();
                    if (ms.type.equals("LoginError")) {
                        //alert
                        System.out.println("database false");
                    } else if (ms.type.equals("LoginSuccess")) {
                        //go to Ligin page
                        GameOptionsBase root = new GameOptionsBase(primaryStage, S, input, output);
                        Scene scene = new Scene(root, 700, 400);
                        primaryStage.setTitle("Game Option");
                        primaryStage.setScene(scene); 
                        primaryStage.show();
                        primaryStage.setResizable(false);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException c) {
                    c.printStackTrace();
                }
            }

        });

        SignBtn.setLayoutX(150.0);
        SignBtn.setLayoutY(300.0);
        SignBtn.setMnemonicParsing(false);
        SignBtn.setPrefHeight(40.0);
        SignBtn.setPrefWidth(218.0);
        SignBtn.setStyle("-fx-background-color: #4deacd; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
        SignBtn.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
        SignBtn.setText("Sing Up");
        SignBtn.setOnAction((event) -> {
            SignUpBase root = new SignUpBase(primaryStage);
            Scene scene = new Scene(root, 700, 400);
            primaryStage.setTitle("Register");
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);

        });
        Back = new Button();        
        Back.setLayoutX(150.0);
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
        
        Exit.setLayoutX(400.0);
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

        getChildren().add(UserNameTxt);
        getChildren().add(PasswordTxt);
        getChildren().add(LoginBtn);
        getChildren().add(title);
        getChildren().add(Exit);
        getChildren().add(Back);
        getChildren().add(SignBtn);

    }
    
    public void alertType(Alert alert, String title, String body)
    {
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setResizable(true);
        alert.setContentText(body);
    }
}
