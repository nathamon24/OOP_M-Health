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
public class Mhealth_Register extends Application {

    private List<Pair<String, String>> user = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
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

        Label title3 = new Label("REGISTER");
        VBox.setMargin(title3, new Insets(5));
        title3.setTextFill(Color.WHITE);
        title3.setFont(Font.loadFont(new FileInputStream("Quicksand-VariableFont_wght.ttf"), 35));

        Label title3_2 = new Label("TO ACCESS THE PORTAL");
        VBox.setMargin(title3_2, new Insets(5, 5, 25, 5));
        title3_2.setTextFill(Color.WHITE);
        title3_2.setFont(Font.loadFont(new FileInputStream("Quicksand-VariableFont_wght.ttf"), 18));

        TextField username3 = new TextField();
        username3.setMaxSize(200, 60);
        username3.setPromptText("User Name");
        VBox.setMargin(username3, new Insets(10, 10, 5, 10));
        username3.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {

        });

        TextField mail3 = new TextField();
        mail3.setMaxSize(200, 60);
        mail3.setPromptText("E-mail");
        VBox.setMargin(mail3, new Insets(10, 10, 5, 10));

        PasswordField password3 = new PasswordField();
        password3.setMaxSize(200, 60);
        password3.setPromptText("Password");
        VBox.setMargin(password3, new Insets(10, 10, 10, 10));

        PasswordField confirmpassword3 = new PasswordField();
        confirmpassword3.setMaxSize(200, 60);
        confirmpassword3.setPromptText("ConFirm Password");
        VBox.setMargin(confirmpassword3, new Insets(10, 10, 10, 10));

        Button button3 = new Button("Register");
        VBox.setMargin(button3, new Insets(20, 20, 10, 20));
        button3.setMaxSize(200, 60);
        button3.setStyle("-fx-background-color: #00FA9A ");
        button3.setOnAction((ActionEvent e) -> {
            //System.out.println("Hello world");
            for (int i = 0; i < user.size(); i++) {//[]
                if (username3.getText().equals(user.get(i).getKey()) && password3.getText().equals(user.get(i).getValue())) {
                    System.out.println("Register success! " + user.get(i).getKey());
                }
            }

        });

        //Label title3 = new Label("Copyright 2020 OOP CE KMITL TECH Ltd. All rights reserved.");
        vbox.getChildren().addAll(title3, title3_2, mail3, username3, password3, confirmpassword3, button3);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefSize(980 - 300, 720);
        vbox.setStyle("-fx-background-color: linear-gradient(#3d1fc2, #CC66FF);");
        //vbox.setStyle("-fx-border-color: blue; -fx-border-width: 1 1 1 1;");

        Scene scene2 = new Scene(hbox, 980, 720);
        stage.setScene(scene2);
        stage.show();
    }

}
