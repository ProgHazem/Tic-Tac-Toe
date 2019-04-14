package xogame.online;

import helper.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Optional;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import xogame.IntroBase;

public class GameOptionsBase extends AnchorPane {

    protected final Button PlayRandomBtn;
    protected final Button InviteFriendBtn;
    protected final Button JoinToGame;
    protected final Button Exit;
    protected final Label title;
    protected final Button Back;

    Socket S;
    ObjectInputStream input;
    ObjectOutputStream output;
    Message message;

    public GameOptionsBase(Stage primaryStage, Socket S, ObjectInputStream input, ObjectOutputStream output) {

        this.S = S;
        this.output = output;
        this.input = input;
        PlayRandomBtn = new Button();
        InviteFriendBtn = new Button();
        JoinToGame = new Button();
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
        title.setText("Please Select Choice");
        title.setFont(new Font(30.0));

        PlayRandomBtn.setLayoutX(200.0);
        PlayRandomBtn.setLayoutY(100.0);
        PlayRandomBtn.setStyle("-fx-background-color: #4deacd; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
        PlayRandomBtn.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
        PlayRandomBtn.setMnemonicParsing(false);
        PlayRandomBtn.setPrefHeight(40.0);
        PlayRandomBtn.setPrefWidth(330.0);
        PlayRandomBtn.setText("Play Random");
        PlayRandomBtn.setOnAction((event) -> {
            try {
                output.writeObject(new Message("PlayRandom", null));
                message = (Message) input.readObject();
                if (message.type.equals("RandomSuccess")) {

                    System.out.println("play now");                    //go to play
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                OnlineGamingBase root = new OnlineGamingBase(primaryStage, S, input, output, message);
                                Scene scene = new Scene(root, 700, 400);
                                primaryStage.setTitle("OnLine Gaming");
                                primaryStage.setScene(scene);
                                primaryStage.show();
                                primaryStage.setResizable(false);
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    });

                } else {
                    //plaese resend to server
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
            }

        });

        InviteFriendBtn.setLayoutX(200.0);
        InviteFriendBtn.setLayoutY(150.0);
        InviteFriendBtn.setStyle("-fx-background-color: #4deacd; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
        InviteFriendBtn.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
        InviteFriendBtn.setMnemonicParsing(false);
        InviteFriendBtn.setPrefHeight(40.0);
        InviteFriendBtn.setPrefWidth(330.0);
        InviteFriendBtn.setText("Invite Friend");

        JoinToGame.setLayoutX(200.0);
        JoinToGame.setLayoutY(200.0);
        JoinToGame.setStyle("-fx-background-color: #4deacd; -fx-border-color: #3D3D3D; -fx-cursor: hand;");
        JoinToGame.setFont(new Font(java.awt.Font.SANS_SERIF, 15));
        JoinToGame.setMnemonicParsing(false);
        JoinToGame.setPrefHeight(40.0);
        JoinToGame.setPrefWidth(330.0);
        JoinToGame.setText("Join To Game");

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
            if (result.isPresent() && result.get() == ButtonType.OK) {
                System.exit(0);
            }
        });

        getChildren().add(PlayRandomBtn);
        getChildren().add(InviteFriendBtn);
        getChildren().add(JoinToGame);
        getChildren().add(title);
        getChildren().add(Exit);
        getChildren().add(Back);

    }

    public void alertType(Alert alert, String title, String body) {
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setResizable(true);
        alert.setContentText(body);
    }
}
