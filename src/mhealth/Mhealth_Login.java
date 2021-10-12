package Mhealth;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Pair;

/**
 *
 * @author G-nap
 */
public class Mhealth_Login extends Application {

    private List<Pair<String, String>> user = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {

        //scene1
        user.add(new Pair<>("eiei", "bibi"));
        user.add(new Pair<>("hello", "home"));
        HBox hbox = new HBox();
        VBox vbox = new VBox();
        /*File file = new File("image.png");
        FileInputStream fileImage = new FileInputStream(file);
        Image image = new Image(fileImage);
        ImageView imageView = new ImageView(image);*/
        ImageView imageView2 = new ImageView(new Image(new FileInputStream(new File("test.png"))));
        hbox.getChildren().addAll(imageView2, vbox);

        Label title1 = new Label("SIGN IN");
        VBox.setMargin(title1, new Insets(5));
        title1.setTextFill(Color.WHITE);
        title1.setFont(Font.loadFont(new FileInputStream("Quicksand-VariableFont_wght.ttf"), 35));

        Label title2 = new Label("TO ACCESS THE PORTAL");
        VBox.setMargin(title2, new Insets(5, 5, 25, 5));
        title2.setTextFill(Color.WHITE);
        title2.setFont(Font.loadFont(new FileInputStream("Quicksand-VariableFont_wght.ttf"), 18));

        TextField username = new TextField();
        username.setMaxSize(200, 60);
        username.setPromptText("Enter User Name Here");
        username.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            //
        });
        VBox.setMargin(username, new Insets(10, 10, 5, 10));
        PasswordField password = new PasswordField();
        password.setMaxSize(200, 60);
        password.setPromptText("Enter Password");
        VBox.setMargin(password, new Insets(10, 10, 10, 10));

        Button button = new Button("Login");
        VBox.setMargin(button, new Insets(20, 20, 10, 20));
        button.setMaxSize(200, 60);
        button.setStyle("-fx-background-color: #00FA9A ");

        //button.setOnAction(e -> primaryStage.setScene(scene2)); 
        button.setOnAction((ActionEvent e) -> {
            //System.out.println("Hello world");

            for (int i = 0; i < user.size(); i++) {//[]
                if (username.getText().equals(user.get(i).getKey()) && password.getText().equals(user.get(i).getValue())) {
                    System.out.println("Login success! " + "[UserName : " + user.get(i).getKey() + "]");
                }

            }

        });

        Hyperlink hyperLink = new Hyperlink("Register");
        hyperLink.setTextFill(Color.WHITE);
        hyperLink.setFont(Font.loadFont(new FileInputStream("Quicksand-VariableFont_wght.ttf"), 14));
        hyperLink.setOnAction((ActionEvent e) -> {
            System.out.println("Reset password");
        });

        //Label title3 = new Label("Copyright 2020 OOP CE KMITL TECH Ltd. All rights reserved.");
        vbox.getChildren().addAll(title1, title2, username, password, button, hyperLink);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefSize(980 - 300, 720);
        vbox.setStyle("-fx-background-color: linear-gradient(#3d1fc2, #CC66FF);");
        //vbox.setStyle("-fx-border-color: blue; -fx-border-width: 1 1 1 1;");

        Scene scene1 = new Scene(hbox, 980, 720);
        stage.setScene(scene1);
        stage.show();
    }

}
