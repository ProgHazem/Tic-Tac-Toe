package xogame.online;

import helper.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class SignUpBase extends AnchorPane {

    protected final TextField UsernameTxt;
    protected final PasswordField PasswordTxt;
    protected final PasswordField ConfirmPassworTxt;
    protected final Button SignUpBtn;
    protected final Button LoginBtn;
    protected final Button Exit;
    protected final Label title;
    protected final Button Back;
    public Socket S;
    ObjectInputStream input;
    ObjectOutputStream output;
    Message ms;

    public SignUpBase(Stage primaryStage) {
        try {
            S = new Socket("127.0.0.1", 1993);
            input = new ObjectInputStream(S.getInputStream());
            output = new ObjectOutputStream(S.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        LoginBtn = new Button();
        Exit = new Button();
        title = new Label();
        UsernameTxt = new TextField();
        PasswordTxt = new PasswordField();
        ConfirmPassworTxt = new PasswordField();
        SignUpBtn = new Button();
        SignUpBtn.setOnAction((ActionEvent event) -> {
            if (UsernameTxt.getText().length() < 4) {
                System.out.println("inter valid name");
            } else if (PasswordTxt.getText().length() == 0) {
                System.out.println("please inter passeord");
            } else if (ConfirmPassworTxt.getText().length() == 0) {
                System.out.println("please confirm password");

            } else if (PasswordTxt.getText().length() < 6) {
                System.out.println("please inter  valid password");
            } else if (PasswordTxt.getText().equals(ConfirmPassworTxt.getText())) {
                try {
                    System.out.println("start");
                    output.writeObject(new Message
        ("SignUp", new String[]{UsernameTxt.getText(), PasswordTxt.getText()}));
                    ms = (Message) input.readObject();
                    if (ms.type.equals("SignError")) {
                        //alert
                        System.out.println("database false");
                    } else if (ms.type.equals("SignSuccess")) {
                        //go to Ligin page
                        LoginBase root = new LoginBase(primaryStage, S, input, output);
                        Scene scene = new Scene(root, 700, 400);
                        primaryStage.setTitle("Profile");
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

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #7026ef;");
        
        title.setLayoutX(169.0);
        title.setLayoutY(44.0);
        title.setPrefHeight(36.0);
        title.setPrefWidth(382.0);
        title.setStyle("-fx-text-fill: #FFF;");
        title.setText("Please Fill Register Form");
        title.setFont(new Font(30.0));

        UsernameTxt.setLayoutX(200.0);
        UsernameTxt.setLayoutY(100.0);
        UsernameTxt.setPrefHeight(40.0);
        UsernameTxt.setPrefWidth(300.0);
        UsernameTxt.setPromptText("Enter Your User Name");

        PasswordTxt.setLayoutX(200.0);
        PasswordTxt.setLayoutY(150.0);
        PasswordTxt.setPrefHeight(40.0);
        PasswordTxt.setPrefWidth(300.0);
        PasswordTxt.setPromptText("Enter Your Password");

        ConfirmPassworTxt.setLayoutX(200.0);
        ConfirmPassworTxt.setLayoutY(200.0);
        ConfirmPassworTxt.setPrefHeight(40.0);
        ConfirmPassworTxt.setPrefWidth(300.0);
        ConfirmPassworTxt.setPromptText("Confirm Your Password");
        
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
        
        SignUpBtn.setLayoutX(150.0);
        SignUpBtn.setLayoutY(300.0);
        SignUpBtn.setMnemonicParsing(false);
        SignUpBtn.setPrefHeight(40.0);
        SignUpBtn.setPrefWidth(218.0);
        SignUpBtn.setStyle("-fx-background-color: #4deacd; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
        SignUpBtn.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
        SignUpBtn.setText("Sing Up");

        LoginBtn.setLayoutX(400.0);
        LoginBtn.setLayoutY(300.0);
        LoginBtn.setMnemonicParsing(false);
        LoginBtn.setPrefHeight(40.0);
        LoginBtn.setPrefWidth(218.0);
        LoginBtn.setStyle("-fx-background-color: #4deacd; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
        LoginBtn.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
        LoginBtn.setText("LogIn");
        LoginBtn.setOnAction((event) -> {
            System.out.println("mmmmmmmm");
//            try {
//                output.writeObject(new Message("none", null));
//            } catch (IOException ex) {
//                Logger.getLogger(SignUpBase.class.getName()).log(Level.SEVERE, null, ex);
//            }
            LoginBase root = new LoginBase(primaryStage, S, input, output);
            Scene scene = new Scene(root, 700, 400);
            primaryStage.setTitle("Login");
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
        
        getChildren().add(UsernameTxt);
        getChildren().add(PasswordTxt);
        getChildren().add(ConfirmPassworTxt);
        getChildren().add(SignUpBtn);
        getChildren().add(title);
        getChildren().add(LoginBtn);
        getChildren().add(Exit);
        getChildren().add(Back);



    }
    public void alertType(Alert alert, String title, String body)
    {
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setResizable(true);
        alert.setContentText(body);
    }
}
