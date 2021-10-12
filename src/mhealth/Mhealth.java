/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhealth;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Pair;
import javax.swing.JOptionPane;

/**
 *
 * @author G-nap
 */
public class Mhealth extends Application {

    VBox vboxTest = new VBox();
    HBox hboxTest = new HBox();

    VBox vbox_i2_2 = new VBox();
    HBox hbox_i2_1 = new HBox();
    HBox hbox_i2_2 = new HBox();

    Scene scene1, scene2, scene3, sceneMain;
    String userName;
    String mail;
    String pass;
    TextField nameField;

    static int Check = 1;
    private List<Pair<String, String>> admin = new ArrayList<>();
    private List<Pair<String, String>> user = new ArrayList<>();

    public Mhealth() {
    }

    public String getUserName() {
        return nameField.getText().toString();
    }

    public Mhealth(String userName) {
        this.userName = userName;
    }
    public Stage stageMain = new Stage();
//  class WindowButtons extends HBox {
//
//        public WindowButtons(Stage stage) {
//            Button closeBtn = new Button("X");
//           Button  foldBtn = new Button("-");
//           closeBtn.setStyle("-fx-background-color:transparest;");
//           foldBtn.setStyle("-fx-background-color: transparest;");
//            closeBtn.setOnAction(new EventHandler<ActionEvent>() {
//
//                @Override
//                public void handle(ActionEvent actionEvent) {
//                    Platform.exit();
//                }
//            });
//foldBtn.setOnAction(new EventHandler<ActionEvent>() {
//
//                @Override
//                public void handle(ActionEvent actionEvent) {
//                    stage.setIconified(true);
//                }
//            });
//            this.getChildren().addAll(foldBtn,closeBtn);
//        }
//    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(Mhealth.class.getResource("/icon/DoctorIcon.png").toExternalForm()));
//        stageMain.setOnHidden((e)->{
//            primaryStage.show();
// primaryStage.initStyle(StageStyle.UNDECORATED);
//       BorderPane borderPane = new BorderPane();
//        borderPane.setStyle("-fx-background-color:transparest");
//         BorderPane mainPane = new BorderPane();
//        mainPane.setStyle("-fx-background-color:transparest");
//
//        ToolBar toolBar = new ToolBar();
//
//        int height = 25;
//        toolBar.setPrefHeight(height);
//        toolBar.setMinHeight(height);
//        toolBar.setMaxHeight(height);
//        toolBar.getItems().add(new WindowButtons(primaryStage));
//        
//        borderPane.setRight(toolBar);
//        mainPane.setTop(borderPane);  
////        quiz.Quiz().setOnHidden((e)->{
////            primaryStage.show();
//toolBox.setStyle("-fx-background-color: black;");
//        });
// toolBox.getChildren().addAll(toolBar);
// VBox box = new VBox();
        readTextFile();
        primaryStage.setTitle("M health");
        primaryStage.setResizable(false);
//        primaryStage.setScene(new Scene(borderPane, 300, 250));
//scene1 Login
        //admin.add(new Pair<>("eiei", "bibi"));
        //admin.add(new Pair<>("hello", "home"));
        //admin.add(new Pair<>("gnap", "123"));

        HBox hbox = new HBox();
        VBox vbox = new VBox();
        VBox box = new VBox();
        /*File file = new File("image.png");
        FileInputStream fileImage = new FileInputStream(file);
        Image image = new Image(fileImage);
        ImageView imageView = new ImageView(image);*/
        ImageView imageView2 = new ImageView(new Image(new FileInputStream(new File("test.png"))));

        // create a input stream 
        FileInputStream input = new FileInputStream("1.jpg");
        // create a image 
        Image image = new Image(input);

        // create a background image 
        BackgroundImage backgroundimage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        // create Background 
        Background background = new Background(backgroundimage);
        // set background 
        vbox.setBackground(background);

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
        username.setMaxSize(200, 30);
        username.setPrefSize(200, 30);
        username.setPromptText("Enter User Name Here");
        username.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            //
        });
        VBox.setMargin(username, new Insets(10, 10, 5, 10));
        PasswordField password = new PasswordField();
        password.setMaxSize(200, 30);
        password.setPrefSize(200, 30);
        password.setPromptText("Enter Password");
        VBox.setMargin(password, new Insets(10, 10, 10, 10));

        Button button = new Button("Login");
        VBox.setMargin(button, new Insets(20, 20, 10, 20));
        button.setMaxSize(200, 60);
        button.setStyle("-fx-background-color: #00FA9A ");

        button.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            button.setEffect(new DropShadow());
        });

        button.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            button.setEffect(null);
        });

        //button.setOnAction(e -> primaryStage.setScene(scene2));
        button.setOnAction((ActionEvent e) -> {
            //System.out.println("Hello world");
            boolean loginSucces = false;
            for (int i = 0; i < admin.size(); i++) {//[]
                if (username.getText().equals(admin.get(i).getKey()) && password.getText().equals(admin.get(i).getValue())) {
                    System.out.println(admin);
                    System.out.println("Login success! (admin)" + "[UserName : " + admin.get(i).getKey() + "]");
                    System.out.println("-------------------");
                    //primaryStage.setScene(sceneMain);
                    Admin main = new Admin();
                    main.showAdmin();
                    Check = 2;
                    primaryStage.hide();
                    username.setText("");
                    password.setText("");
                    loginSucces = true;
                    break;

//                } else if (userName.equals(user.get(i).getKey()) && pass.equals(user.get(i).getValue())) {
//                    System.out.println(user);
//                    System.out.println("Login success! (user)" + "[UserName : " + user.get(i).getKey() + "]");
//                    System.out.println("-------------------");
//                    primaryStage.setScene(sceneMain);
//                    username.setText("");
//                    password.setText("");
//                    break;
//
                }

            }

            for (int i = 0; i < user.size(); i++) {//[]
                if (username.getText().equals(user.get(i).getKey()) && password.getText().equals(user.get(i).getValue())) {
                    System.out.println(user);
                    System.out.println("Login success! (user)" + "[UserName : " + user.get(i).getKey() + "]");
                    System.out.println("-------------------");
                    //primaryStage.setScene(sceneMain);
                    Main main = new Main();
                    main.showMain();
                    Check = 1;
                    primaryStage.hide();
                    username.setText("");
                    password.setText("");
                    loginSucces = true;
                    break;

//                } else if (userName.equals(user.get(i).getKey()) && pass.equals(user.get(i).getValue())) {
//                    System.out.println(user);
//                    System.out.println("Login success! (user)" + "[UserName : " + user.get(i).getKey() + "]");
//                    System.out.println("-------------------");
//                    primaryStage.setScene(sceneMain);
//                    username.setText("");
//                    password.setText("");
//                    break;
//
                }

            }
            if (!loginSucces) {
                JOptionPane.showMessageDialog(null, "Username or Password Wrong");
                username.setText("");
                password.setText("");
            }

        });
        Hyperlink hyperLink = new Hyperlink("Register");
        hyperLink.setTextFill(Color.WHITE);
        hyperLink.setFont(Font.loadFont(new FileInputStream("Quicksand-VariableFont_wght.ttf"), 14));
//        hyperLink.setOnAction((ActionEvent e) -> {
//            System.out.println("Register");
//        });
        hyperLink.setOnAction(e -> primaryStage.setScene(scene3));

        //Label title3 = new Label("Copyright 2020 OOP CE KMITL TECH Ltd. All rights reserved.");
        //vbox.setStyle("-fx-background-image: url('1.jpg')");
        HBox hboxUserName = new HBox();
        //hboxUserName.setAlignment(Pos.CENTER);
        Label lbUserName = new Label("User Name");
        lbUserName.setTextFill(Color.WHITE);
        HBox.setMargin(lbUserName, new Insets(10, 10, 10, 120));
        hboxUserName.getChildren().addAll(lbUserName, username);

        HBox hboxPassword = new HBox();
        //hboxPassword.setAlignment(Pos.CENTER);
        Label lbPassword = new Label("Password");
        lbPassword.setTextFill(Color.WHITE);
        HBox.setMargin(lbPassword, new Insets(10, 10, 10, 130));

        hboxPassword.getChildren().addAll(lbPassword, password);

        vbox.getChildren().addAll(title1, title2, hboxUserName, hboxPassword, button, hyperLink);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefSize(880 - 300, 620);
        //vbox.setStyle("-fx-background-color: linear-gradient(#3d1fc2, #CC66FF);");
        //String image = Mhealth.class.getResource("1.jpg").toExternalForm();

        //vbox.setStyle("-fx-border-color: blue; -fx-border-width: 1 1 1 1;");
//        box.getChildren().addAll(borderPane,hbox);
        scene1 = new Scene(hbox, 880, 620);
        //primaryStage.setScene(scene1);
        //primaryStage.show();

//Scene 2 Home
//        Label label2 = new Label("Home");
//        Button button2 = new Button("Go to scene 1");
//        button2.setOnAction(e -> primaryStage.setScene(scene1));
//        VBox layout2 = new VBox(20);
//        layout2.getChildren().addAll(label2, button2);
//
//        scene2 = new Scene(layout2, 980, 720);
//        primaryStage.setScene(scene1);
//        primaryStage.show();
//        BorderPane root = new BorderPane();
////    root.getChildren().add(Rectangle1);
////    root.getChildren().add(Rectangle2);
//        Image imageHeader = new Image(Mhealth.class.getResource("/image/Header.png").toExternalForm());
//        ImageView imageViewHeader = new ImageView(imageHeader);
//        HBox Hbox1 = new HBox();
//        Hbox1.setPrefHeight(100);
//        Hbox1.setStyle("-fx-background-color:#385A7C");
//        Hbox1.getChildren().addAll(imageViewHeader);
//
//        HBox Hbox2 = new HBox();
//        Hbox2.setPrefHeight(620);
//        Hbox2.setStyle("-fx-background-color:#275E55");
//        vboxTest.setStyle("-fx-background-color:yellow");
//        vboxTest.setPrefHeight(620);
//        vboxTest.setPrefWidth(1240);
//        Hbox2.getChildren().addAll(Menu(), vboxTest);
//
////Button button = new Button();
////button.setText("tstaaaaaaaa");
////Button button2 = new Button();
////button.setText("tsaaat");
////Hbox2.getChildren().addAll(button,button2);
////    root.setLeft(Menu());
//        root.setTop(Hbox1);
//        root.setBottom(Hbox2);
//
//        sceneMain = new Scene(root, 1280, 720);
//        //primaryStage.setScene(scene1);
//        //primaryStage.show();
//        // Create a scene and place it in the stage
//
////    Scene scene = new Scene(pane, 1280, 720);
//        primaryStage.setTitle("Covid-19"); // Set the stage title
////    primaryStage.setScene(scene); // Place the scene in the stage
////    primaryStage.show(); // Display the stage
////    primaryStage.setResizable(false);
//Scene 3 register
        Label label3 = new Label("Register");

        HBox hbox3 = new HBox();
        VBox vbox3 = new VBox();

        ImageView imageView3 = new ImageView(new Image(new FileInputStream(new File("test.png"))));

        // create a input stream 
        FileInputStream input1 = new FileInputStream("1.jpg");
        // create a image 
        Image image1 = new Image(input1);

        // create a background image 
        BackgroundImage backgroundimage1 = new BackgroundImage(image1,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        // create Background 
        Background background1 = new Background(backgroundimage1);
        // set background 
        vbox3.setBackground(background1);

        hbox3.getChildren().addAll(imageView3, vbox3);

//        hbox3.setStyle("-fx-border-color: blue; -fx-border-width: 1 1 1 1;");
//        vbox3.setStyle("-fx-border-color: blue; -fx-border-width: 1 1 1 1;");
        Label title3 = new Label("REGISTER");
        VBox.setMargin(title3, new Insets(5));
        title3.setTextFill(Color.WHITE);
        title3.setFont(Font.loadFont(new FileInputStream("Quicksand-VariableFont_wght.ttf"), 35));

        Label title3_2 = new Label("TO ACCESS THE PORTAL");
        VBox.setMargin(title3_2, new Insets(5, 5, 25, 5));
        title3_2.setTextFill(Color.WHITE);
        title3_2.setFont(Font.loadFont(new FileInputStream("Quicksand-VariableFont_wght.ttf"), 18));

        HBox hboxNameField = new HBox();
        TextField nameField = new TextField();
        Label lbUameField = new Label("User Name");
        lbUameField.setTextFill(Color.WHITE);
        nameField.setMaxSize(200, 60);
        nameField.setPromptText("User Name");
        HBox.setMargin(lbUameField, new Insets(10, 10, 10, 120));
        //VBox.setMargin(nameField, new Insets(10, 10, 5, 10));

        HBox hboxEmailField = new HBox();
        TextField emailField = new TextField();
        Label lbEmailField = new Label("E-mail");
        lbEmailField.setTextFill(Color.WHITE);
        emailField.setMaxSize(200, 60);
        emailField.setPromptText("E-mail");
        HBox.setMargin(lbEmailField, new Insets(10, 10, 10, 145));
        //VBox.setMargin(emailField, new Insets(10, 10, 5, 10));

        HBox hboxPasswordField = new HBox();
        PasswordField passwordField = new PasswordField();
        Label lbPasswordField = new Label("Password");
        lbPasswordField.setTextFill(Color.WHITE);
        passwordField.setMaxSize(200, 60);
        passwordField.setPromptText("Password");
        HBox.setMargin(lbPasswordField, new Insets(10, 10, 10, 128));
        //VBox.setMargin(passwordField, new Insets(10, 10, 10, 10));

        nameField.setMaxSize(200, 30);
        nameField.setPrefSize(200, 30);
        emailField.setMaxSize(200, 30);
        emailField.setPrefSize(200, 30);
        passwordField.setMaxSize(200, 30);
        passwordField.setPrefSize(200, 30);

        hboxNameField.getChildren().addAll(lbUameField, nameField);
        hboxEmailField.getChildren().addAll(lbEmailField, emailField);
        hboxPasswordField.getChildren().addAll(lbPasswordField, passwordField);

        Button submitButton = new Button("Submit");
        VBox.setMargin(submitButton, new Insets(20, 20, 10, 20));
        submitButton.setMaxSize(200, 60);
        submitButton.setStyle("-fx-background-color: #00FA9A ");

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (nameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill your information completely");

                } else if (emailField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill your information completely");
                } else if (passwordField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill your information completely");
                } else {

                    userName = nameField.getText().toString();
                    pass = passwordField.getText().toString();

                    JOptionPane.showMessageDialog(null, "Registration Successful! Welcome, " + userName);
                    primaryStage.setScene(scene1);

                    System.out.println("REGISTER");
                    System.out.println("User : " + userName);
                    System.out.println("Password : " + pass);
                    System.out.println("-------------------");

                    appendTextFile(userName);
                    appendTextFile(pass);

                    user.add(new Pair<>(userName, pass));

                    nameField.setText("");
                    emailField.setText("");
                    passwordField.setText("");
                    username.setText("");
                    password.setText("");

                }
            }
        });

        Hyperlink hyperLink3 = new Hyperlink("Back");
        hyperLink3.setTextFill(Color.WHITE);
        hyperLink3.setFont(Font.loadFont(new FileInputStream("Quicksand-VariableFont_wght.ttf"), 14));
        //hyperLink3.setOnAction(e -> primaryStage.setScene(scene1));
        hyperLink3.setOnAction((ActionEvent e) -> {
            //System.out.println("Hello world");

            primaryStage.setScene(scene1);
            nameField.setText("");
            emailField.setText("");
            passwordField.setText("");
            username.setText("");
            password.setText("");

        });

        VBox.setMargin(hyperLink3, new Insets(10, 20, 10, 20));

        vbox3.getChildren().addAll(title3, title3_2, hboxNameField, hboxEmailField, hboxPasswordField, submitButton, hyperLink3);
        vbox3.setAlignment(Pos.CENTER);
        vbox3.setPrefSize(880 - 300, 620);
        //vbox3.setStyle("-fx-background-color: linear-gradient(#3d1fc2, #CC66FF);");

        scene3 = new Scene(hbox3, 880, 620);
        primaryStage.setScene(scene1);
        primaryStage.show();
//        this.stageMain.setScene(sceneMain); // init main stage
    }

//    public VBox Menu() {
//        VBox vbox = new VBox();
//        vbox.setPrefWidth(50);
//
//        /* 1 Account
//        2 Home
//        3 Assessment
//        4 Contact
//        5 Question & Answer
//        6 Log out
//         */
//        for (int i = 1; i < 6; i++) {
//            vbox.getChildren().add(Item(i));
//        }
//        vbox.setStyle("-fx-background-color:#2D4053");
//        return vbox;
//
//    }
    public void clearIcon2() {
        hboxTest.getChildren().clear();
        vbox_i2_2.getChildren().clear();
        hbox_i2_1.getChildren().clear();
        hbox_i2_2.getChildren().clear();
    }

//    public HBox Item(int icon) {
//
//        Image image = new Image(Mhealth.class.getResource("/icon/" + icon + ".png").toExternalForm());
//        ImageView imageView = new ImageView(image);
//        imageView.setFitHeight(50);
//        imageView.setPreserveRatio(true);
//        imageView.setSmooth(true);
//        imageView.setCache(true);
//        Button buttonMenu = new Button();
//        buttonMenu.setGraphic(imageView);
//        buttonMenu.setPrefSize(45, 50);
//        buttonMenu.setStyle("-fx-background-color:#2D4053");
//        Pane paneIndicator = new Pane();
////        paneIndicator.setPrefSize(10, 50);
////        paneIndicator.setStyle("-fx-background-color:#B2EEE6");
//        menuDecorator(buttonMenu, paneIndicator);
//        HBox hbox = new HBox(paneIndicator, buttonMenu);
//
//        VBox vbox_i2_1 = new VBox();
//        vbox_i2_1.setPrefSize(520, 620);
//        vbox_i2_1.setStyle("-fx-border-color: blue; -fx-border-width: 1 1 1 1;");
//
//        //VBox vbox_i2_2 = new VBox();
//        vbox_i2_2.setPrefSize(720, 620);
//        vbox_i2_2.setStyle("-fx-border-color: blue; -fx-border-width: 1 1 1 1;");
//
//        //HBox hbox_i2_1 = new HBox();
//        hbox_i2_1.setPrefSize(720, 434);
//        hbox_i2_1.setStyle("-fx-border-color: blue; -fx-border-width: 1 1 1 1;");
//
//        //HBox hbox_i2_2 = new HBox();
//        hbox_i2_2.setPrefSize(720, 186);
//        hbox_i2_2.setStyle("-fx-border-color: blue; -fx-border-width: 1 1 1 1;");
//        if (icon == 1) {
//            buttonMenu.setOnAction((ActionEvent t) -> {
//                vboxTest.getChildren().clear();
////                Stage stage = new Stage();
////                stage.setWidth(500);
////                stage.setHeight(500);
////                stage.show();
//                vboxTest.setStyle("-fx-background-color:red");
//                clearIcon2();
//                Contact contact = new Contact();
//                vboxTest.getChildren().addAll(contact.showContactPage());
//
//            });
//
//        }
//        if (icon == 2) {
//            buttonMenu.setOnAction((ActionEvent t) -> {
//                vboxTest.getChildren().clear();
//                vboxTest.setStyle("-fx-background-color:#C76345");
//
//                vboxTest.getChildren().addAll(hboxTest);
//                hboxTest.getChildren().addAll(vbox_i2_1, vbox_i2_2);
//                vbox_i2_2.getChildren().addAll(hbox_i2_1, hbox_i2_2);
//
//            });
//
//        }
//        if (icon == 3) {
//            buttonMenu.setOnAction((ActionEvent t) -> {
//                vboxTest.getChildren().clear();
//                vboxTest.setStyle("-fx-background-color:#F5DA9C");
//                clearIcon2();
//                Covid19 covid = new Covid19();
//                vboxTest.getChildren().addAll(covid.showCovidPage());
//
//            });
//
//        }
//        if (icon == 4) {
//            buttonMenu.setOnAction((ActionEvent t) -> {
//                vboxTest.getChildren().clear();
//                vboxTest.setStyle("-fx-background-color:#B2EEE6");
//                clearIcon2();
//                MainQuiz quiz = new MainQuiz();
//                quiz.Quiz();
//                stageMain.hide();
//            });
//
//        }
//        if (icon == 5) {
//            buttonMenu.setOnAction((ActionEvent t) -> {
//                vboxTest.getChildren().clear();
//                vboxTest.setStyle("-fx-background-color:green");
//                clearIcon2();
//            });
//
//        }
//        if (icon == 6) {
//            buttonMenu.setOnAction((ActionEvent t) -> {
//                vboxTest.getChildren().clear();
//                vboxTest.setStyle("-fx-background-color:blue");
//                Stage stage = (Stage) buttonMenu.getScene().getWindow();
//                stage.close();
//            });
//
//        }
//        return hbox;
//    }
//    public void menuDecorator(Button buttonMenu, Pane pane) {
//        buttonMenu.setOnMouseEntered((value) -> {
//            buttonMenu.setStyle("-fx-backgrouund-color:#275E55");
//            pane.setStyle("-fx-backgrouund-color:#C76345");
//        });
//        buttonMenu.setOnMouseExited((value) -> {
//            //buttonMenu.setStyle("-fx-backgrouund-color:#C76345");
//            buttonMenu.setStyle("-fx-background-color:#2D4053");
//            pane.setStyle("-fx-backgrouund-color:#2D4053");
//        });
//    }
    public void readTextFile() {

        String input = "";
        String input2 = "";
        int index = 0;
        try {
            BufferedReader buf = new BufferedReader(new FileReader(new File("User.txt")));
            while ((input = buf.readLine()) != null) {
                ///System.out.println(input);
                if (index == 0) {
                    input2 = input;
                    index++;
                } else {
                    this.user.add(new Pair<>(input2, input));
                    index = 0;
                    input2 = "";
                }
            }
            buf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-- show user all --");
        for (var x : this.user) {
            System.out.println(x.getKey() + " " + x.getValue());
        }

        //Read Admin
        input = "";
        input2 = "";
        index = 0;
        try {
            BufferedReader buf = new BufferedReader(new FileReader(new File("Admin.txt")));
            while ((input = buf.readLine()) != null) {
                ///System.out.println(input);
                if (index == 0) {
                    input2 = input;
                    index++;
                } else {
                    this.admin.add(new Pair<>(input2, input));
                    index = 0;
                    input2 = "";
                }
            }
            buf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-- show admin all --");
        for (var x : this.admin) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }

    public void appendTextFile(String text) {

        File file = new File("User.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            BufferedWriter buf = new BufferedWriter(new FileWriter(file, true));
            buf.append(text);
            buf.newLine();
            buf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createTextFile(String text) {

        File file = new File("text.txt");

        if (!file.exists()) {

            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            BufferedWriter buf = new BufferedWriter(new FileWriter(file, false));
            buf.append(text);
            buf.newLine();
            buf.close();
        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static void main(String[] args) throws IOException {
//        FileOutputStream out = new FileOutputStream("myfile.txt");
//        for (int i = 0; i < 10; i++) {
//            out.write(i);
//        }
//        out.close();
//        System.out.println("finite writing file");
//
//        System.out.println("start reading file");
//        FileInputStream in = new FileInputStream("myfile.txt");
//        while(in.available() != 0){
//            System.out.println(in.read());
//        }
//        System.out.println("finite reading file");
        launch(args);

//        FileOutputStream fos = new FileOutputStream("myfile.txt");
//        PrintWriter pw = new PrintWriter(fos);
//        File file = new File("data_user.txt");
//        //String file1 = "Data_user.txt";
//        FileWriter fw = new FileWriter(file, true);
//        PrintWriter pw = new PrintWriter(fw);
//
//        Mhealth m1 = new Mhealth();
//
//        pw.println(m1.getUserName());
//
//        pw.close();
//
//        System.out.println("written");
//        System.out.println(m1.getUserName());
//        ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream("myfile.txt"));
//        out.writeUTF("chotika");
//        out.close();
//        System.out.println("finite writing oject");
//        System.out.println("finite reading oject");
//        
//        ObjectInputStream in = new ObjectInputStream (new FileInputStream("myfile.txt"));
//        System.out.println(in.readUTF());
//        System.out.println("finite reading file");
    }

}
