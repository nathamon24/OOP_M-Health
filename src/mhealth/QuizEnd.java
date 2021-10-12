/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhealth;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.rgb;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import static mhealth.MainQuiz.bottomBox;
import static mhealth.MainQuiz.no;
import static mhealth.MainQuiz.page;
import static mhealth.MainQuiz.yes;

/**
 *
 * @author Chin
 */
public class QuizEnd {

    static Stage primaryStage = new Stage();
    //String pagefont = "-fx-font:18 Dekko";
    String font = "-fx-font:18 Dekko";
    String font1 = "-fx-font:16 Dekko";
    String font2 = "-fx-font:20 Dekko";
    String font3 = "-fx-font:22 Dekko";

    public void End() {

        MainQuiz.page = 1;

        Button back = new Button();
        Image Back = new Image(MainQuiz.class.getResource("/Image/back.png").toExternalForm());
        ImageView backview = new ImageView(Back);
        Image Back1 = new Image(MainQuiz.class.getResource("/Image/back2.png").toExternalForm());
        ImageView backview1 = new ImageView(Back1);

        backview.setFitHeight(30);

        backview.setPreserveRatio(true);
        backview.setSmooth(true);
        backview.setCache(true);

        backview1.setFitHeight(30);

        backview1.setPreserveRatio(true);
        backview1.setSmooth(true);
        backview1.setCache(true);

        back.setGraphic(backview1);

        back.setStyle("-fx-background-radius:30;-fx-background-color:transparent");

        back.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {

            back.setGraphic(backview);

        });
        back.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            back.setGraphic(backview1);

        });

        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
//        Label label5 = new Label();
        MainQuiz m = new MainQuiz();
        System.out.println(m.num);
        if (m.num >= 0 && m.num <= 4) {
            label1.setText("You've got " + m.num + " / 10");
            label2.setText("**You are not at risk for COVID-19 infection.**");
            label3.setText("In each question, weight in calculating score by percentage is equal.");
            label4.setText("\tCAUTION! With Care\n"
                    + "    - Regularly wash hands with soap or alcohol based hand rub.\n"
                    + "    - Avoid touching the flu-like patients or avoiding the crowd.\n"
                    + "    - Throughly cooking your meals with heat.\n"
                    + "    - Wear mask to cover the mouth and nose to prevent getting infection.");
            label2.setTextFill(Color.GREEN);
        } else {
            label1.setText("You've got " + m.num + " / 10");
            label2.setText("**You are at risk for COVID-19 infection.**");
            label3.setText("In each question, weight in calculating score by percentage is equal.");
            label4.setText("\tCAUTION! With Care\n"
                    + "    - Regularly wash hands with soap or alcohol based hand rub.\n"
                    + "    - Avoid touching the flu-like patients or avoiding the crowd.\n"
                    + "    - Throughly cooking your meals with heat.\n"
                    + "    - Wear mask to cover the mouth and nose to prevent getting infection.");
            label2.setTextFill(Color.RED);
        }

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                m.yes.setDisable(false);
                m.no.setDisable(false);

                Main m1 = new Main();
                MainQuiz q = new MainQuiz();
//        m1.vboxMain.getChildren().clear();
//        m1.vboxMain.getChildren().add(q.Quiz());
                m.bottomBox.getChildren().clear();
                Label Page = new Label();
                Page.setText(m.page + "/10");
                Page.setStyle(font);
                Page.setTextFill(Color.WHITE);
                Page.setAlignment(Pos.CENTER);
                m.bottomBox.getChildren().add(Page);
                primaryStage.close();

            }
        });
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                m.yes.setDisable(false);
                m.no.setDisable(false);
                Main m1 = new Main();
                MainQuiz q = new MainQuiz();
//        m1.vboxMain.getChildren().clear();
//        m1.vboxMain.getChildren().add(q.Quiz());
                m.bottomBox.getChildren().clear();

                Label Page = new Label();
                Page.setText(m.page + "/10");
                Page.setStyle(font);
                Page.setTextFill(Color.WHITE);
                Page.setAlignment(Pos.CENTER);
                m.bottomBox.getChildren().add(Page);
                primaryStage.close();
            }

        });

//        if (!yes.isDisabled() && !no.isDisabled()) {
//            bottomBox.getChildren().clear();
//Label Page = new Label();
//                Page.setText(m.page + "/10");
//                Page.setStyle(font);
//                Page.setTextFill(Color.WHITE);
//                Page.setAlignment(Pos.CENTER);
//                m.bottomBox.getChildren().add(Page);
//            bottomBox.getChildren().add(Page);
//        }
        VBox vbox = new VBox();
        VBox vboxT = new VBox();
        VBox vboxB = new VBox();

        label1.setStyle(font2);
        label1.setAlignment(Pos.CENTER);
        label1.setTextFill(Color.BLACK);
        label1.setPrefHeight(50);

        label2.setStyle(font3);
        label2.setAlignment(Pos.CENTER);

        label2.setPrefHeight(70);

        label3.setStyle(font1);
        label3.setAlignment(Pos.CENTER);
        label3.setTextFill(Color.BLACK);
        label3.setPrefHeight(50);

        label4.setStyle(font1 + ";-fx-background-color:#faf0e6;-fx-background-radius:15");
        label4.setAlignment(Pos.CENTER_LEFT);
        label4.setTextFill(Color.BLACK);
        label4.setPrefSize(530, 130);

//        label4.setStyle("-fx-background-color:#faf0e6;-fx-background-radius:15");
//        label5.setStyle(font1);
//        label5.setAlignment(Pos.TOP_LEFT);
//        label5.setTextFill(Color.BLACK);
//        label5.setPrefSize(530,100);
        vbox.setAlignment(Pos.CENTER);
        vboxT.setAlignment(Pos.CENTER);
        vboxB.setAlignment(Pos.CENTER);
        vboxB.setPadding(new Insets(0, 0, 0, 20));

//        vboxB.setStyle("-fx-background-color:#faf0e6;-fx-background-radius:15");
        vbox.setStyle("-fx-background-color:white");

        vboxT.getChildren().addAll(label1, label2, label3);
        vboxB.getChildren().addAll(label4);

        vboxB.setPadding(new Insets(10, 10, 10, 10));
        vbox.setPadding(new Insets(10, 10, 10, 10));

        vbox.getChildren().addAll(vboxT, vboxB, back);

        Scene scene = new Scene(vbox, 600, 400);

//  scene.setFill(Color.MINTCREAM);
        primaryStage.getIcons().add(new Image(Mhealth.class.getResource("/icon/noti.png").toExternalForm()));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Assessment results");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
