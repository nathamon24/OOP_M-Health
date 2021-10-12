/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhealth;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static mhealth.QuizEnd.primaryStage;

/**
 *
 * @author Phxi
 */
public class Main extends Application {

    static VBox vboxMain = new VBox();
    private Stage stage = new Stage();

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void showMain() {
        Home home = new Home();
        vboxMain.getChildren().addAll(home.showHome());

        BorderPane root = new BorderPane();
//    root.getChildren().add(Rectangle1);
//    root.getChildren().add(Rectangle2);
        Image imageHeader = new Image(Mhealth.class.getResource("/image/Header.png").toExternalForm());
        ImageView imageViewHeader = new ImageView(imageHeader);
        imageViewHeader.setFitHeight(80);
        imageViewHeader.setPreserveRatio(true);
        imageViewHeader.setSmooth(true);
        imageViewHeader.setCache(true);

        Image image1 = new Image(Mhealth.class.getResource("/image/Doctor.png").toExternalForm());
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(80);
        imageView1.setPreserveRatio(true);
        //set icon
        stage.getIcons().add(new Image(Mhealth.class.getResource("/icon/DoctorIcon.png").toExternalForm()));
//        imageView1.setSmooth(true);
//        imageView1.setCache(true);
        HBox Hbox1 = new HBox();
        Hbox1.setPrefHeight(100);
        Hbox1.setPadding(new Insets(10, 10, 10, 15));
        Hbox1.setSpacing(10);
        Hbox1.setStyle("-fx-background-color:#385A7C");
        Hbox1.setAlignment(Pos.CENTER_LEFT);
        if (Mhealth.Check == 1) {
            Hbox1.getChildren().addAll(imageView1, imageViewHeader);
        } else if (Mhealth.Check == 2) {
            Hbox1.getChildren().addAll(imageView1, imageViewHeader);
        }

        HBox Hbox2 = new HBox();
        Hbox2.setPrefHeight(620);
        //Hbox2.setStyle("-fx-background-color:#275E55");
//        vboxMain.setStyle("-fx-background-color:yellow");
        vboxMain.setPrefHeight(620);
        vboxMain.setPrefWidth(954);
        Hbox2.getChildren().addAll(Menu(), vboxMain);

//Button button = new Button();
//button.setText("tstaaaaaaaa");
//Button button2 = new Button();
//button.setText("tsaaat");
//Hbox2.getChildren().addAll(button,button2);
//    root.setLeft(Menu());
        root.setTop(Hbox1);
        root.setBottom(Hbox2);

        Scene scene = new Scene(root, 1024, 720);
        stage.setScene(scene);
        stage.show();
        // Create a scene and place it in the stage

//    Scene scene = new Scene(pane, 1280, 720);
        stage.setTitle("Covid-19"); // Set the stage title
//    primaryStage.setScene(scene); // Place the scene in the stage
//    primaryStage.show(); // Display the stage
        stage.setResizable(false);
    }

    public VBox Menu() {
        VBox vbox = new VBox();
        vbox.setPrefWidth(70);

        /* 1 Account
        2 Home
        3 Assessment
        4 Contact
        5 Question & Answer
        6 Log out
         */
        for (int i = 1; i < 6; i++) {
            vbox.getChildren().add(Item(i));
        }
        vbox.setStyle("-fx-background-color:#2D4053");

        return vbox;

    }

    public HBox Item(int icon) {

        Image image = new Image(Mhealth.class.getResource("/icon/" + icon + ".png").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(45);
        imageView.setPreserveRatio(true);
//        imageView.setSmooth(true);
        imageView.setCache(true);
        Button buttonMenu = new Button();
        buttonMenu.setGraphic(imageView);
        buttonMenu.setPrefSize(45, 50);
        buttonMenu.setStyle("-fx-background-color:#2D4053");

        HBox hbox = new HBox(buttonMenu);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(5, 0, 0, 0));
        buttonMenu.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {

            buttonMenu.setStyle("-fx-background-color:#233140");

        });

        buttonMenu.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            buttonMenu.setStyle("-fx-background-color:#2D4053");
        });

        if (icon == 1) {
            buttonMenu.setOnAction((ActionEvent t) -> {
                vboxMain.getChildren().clear();
                Home home = new Home();
                vboxMain.getChildren().addAll(home.showHome());

            });

        }
        if (icon == 2) {

            buttonMenu.setOnAction((ActionEvent t) -> {
                vboxMain.getChildren().clear();
                //vboxMain.setStyle("-fx-background-color:#C76345");
                Covid19 covid = new Covid19();
                vboxMain.getChildren().addAll(covid.showCovidPage());

            });

        }
        if (icon == 3) {
            buttonMenu.setOnAction((ActionEvent t) -> {
                vboxMain.getChildren().clear();
                //vboxMain.setStyle("-fx-background-color:#F5DA9C");
                MainQuiz quiz = new MainQuiz();

                vboxMain.setAlignment(Pos.CENTER);
                vboxMain.getChildren().addAll(quiz.Quiz());

//                stage.hide();
            });

        }
        if (icon == 4) {
            buttonMenu.setOnAction((ActionEvent t) -> {
                vboxMain.getChildren().clear();
//                vboxMain.setStyle("-fx-background-color:#B2EEE6");
                Contact contact = new Contact();
                vboxMain.getChildren().addAll(contact.showContactPage());

            });

        }
        if (icon == 5) {
            buttonMenu.setOnAction((ActionEvent t) -> {
                vboxMain.getChildren().clear();
                //vboxMain.setStyle("-fx-background-color:blue");
                Mhealth m = new Mhealth();
                m.Check = 1;
                stage.close();
                Stage s = new Stage();
                try {
                    m.start(s);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

//                Stage stage = (Stage) buttonMenu.getScene().getWindow();
//                stage.close();
            });

        }
//        if (icon == 6) {
//            buttonMenu.setOnAction((ActionEvent t) -> {
//                vboxMain.getChildren().clear();
//                vboxMain.setStyle("-fx-background-color:blue");
//                Stage stage = (Stage) buttonMenu.getScene().getWindow();
//                stage.close();
//            });
//
//        }
////Back to LoginStage
////        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
////            @Override
////            public void handle(WindowEvent t) {
////                Mhealth m = new Mhealth();
////                Stage s = new Stage();
////                try {
////                    m.start(s);
////                } catch (FileNotFoundException ex) {
////                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
////                }
////            }
////
////        });
        return hbox;
    }

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
}
