/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhealth;

import java.io.FileInputStream;
import javafx.application.Application;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static mhealth.QuizEnd.primaryStage;
//import javafx.stage.WindowEvent;

/**
 *
 * @author Chin
 */
public class MainQuiz extends Application {

    public static int num = 0;
    String font = "-fx-font:24 Dekko";
    String pagefont = "-fx-font:18 Dekko";
    String enter = "-fx-border-color:white;-fx-border-width:2;-fx-border-radius:29;-fx-background-radius:29;-fx-background-color:transparent";
    String exited = "-fx-border-color:transparent;-fx-border-width:2;-fx-border-radius:29;-fx-background-radius:29;-fx-background-color:transparent";
    static Button yes = new Button();
    static Button no = new Button();
    static int page = 1;
    static HBox bottomBox = new HBox();
    String font1 = "-fx-font:16 Dekko";

    public void hoverButtton() {
        yes.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            yes.setEffect(new DropShadow());
            yes.setStyle(enter);

        });
        yes.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            yes.setEffect(null);
            yes.setStyle(exited);

        });
        no.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            no.setEffect(new DropShadow());
            no.setStyle(enter);

        });
        no.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            no.setEffect(null);
            no.setStyle(exited);

        });
    }

    public VBox Quiz() {
        num = 0;
        page = 1;
        bottomBox.getChildren().clear();
        QuizEnd q = new QuizEnd();

        Label label = new Label();
        label.setStyle(font);
        label.setTextFill(Color.WHITE);
        label.setAlignment(Pos.CENTER);

        label.setText("Is your Temperature being over or equal to 37.5 Degrees Celsius?");
        VBox vbox = new VBox();
        vbox.setPrefSize(1240, 620);
        Image Yes = new Image(MainQuiz.class.getResource("/Image/yes.png").toExternalForm());
        ImageView yesview = new ImageView(Yes);
        Image No = new Image(MainQuiz.class.getResource("/Image/no.png").toExternalForm());
        ImageView noview = new ImageView(No);
        yesview.setFitHeight(45);
        noview.setFitHeight(45);
        yesview.setPreserveRatio(true);
//        yesview.setSmooth(true);
//        yesview.setCache(true);
        noview.setPreserveRatio(true);
//        noview.setSmooth(true);
//        noview.setCache(true);
        yes.setGraphic(yesview);
        no.setGraphic(noview);
        yes.setStyle(exited);
        no.setStyle(exited);
        hoverButtton();
        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();
                num++;

                vbox.getChildren().addAll(Question2());
            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();

                vbox.getChildren().addAll(Question2());

            }
        });

//        text.setFont(Font.loadFont(new FileInputStream("Quicksand-VariableFont_wght.ttf"), 18));
        Image imageBg = new Image(Contact.class.getResource("/Image/bg1.png").toExternalForm());
        BackgroundImage backgroundimage1 = new BackgroundImage(imageBg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1, 1, true, true, false, false));
        // create Background 
        Background background1 = new Background(backgroundimage1);
        // set background 
        vbox.setBackground(background1);

        HBox topBox = new HBox();

        Label Page = new Label();
        Page.setText(page + "/10");
        Page.setStyle(pagefont);
        Page.setTextFill(Color.WHITE);
        Page.setAlignment(Pos.CENTER);
        HBox textBox = new HBox();
        HBox buttonBox = new HBox();
        textBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        textBox.setPadding(new Insets(15, 12, 15, 12));
//        buttonBox.setPadding(new Insets(15, 12, 15, 12));
        textBox.setSpacing(10);
        buttonBox.setSpacing(120);
        textBox.getChildren().addAll(label);
        buttonBox.getChildren().addAll(yes, no);
//        Scene scene = new Scene(root, 1200, 250);
        topBox.setPrefHeight(150);
        bottomBox.setPrefHeight(150);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().add(Page);
        buttonBox.setPrefHeight(70);
        textBox.setPrefHeight(150);
        vbox.getChildren().addAll(topBox, textBox, buttonBox, bottomBox);
        if (q.primaryStage.isShowing()) {
//            yes.setDisable(true);
//            no.setDisable(true);

            Label text = new Label();
            text.setText("Please check your results");
            text.setStyle(font);
            text.setTextFill(Color.RED);
            bottomBox.getChildren().clear();
            bottomBox.getChildren().add(text);
        } else {
            yes.setDisable(false);
            no.setDisable(false);
            q.primaryStage.close();

        }
//        if (!yes.isDisabled() && !no.isDisabled()) {
//            bottomBox.getChildren().clear();
//
//            bottomBox.getChildren().add(Page);
//        }
        return vbox;
    }

    public VBox Question2() {
        page++;
        Label label = new Label();
        Label label1 = new Label();
        VBox vbox = new VBox();
        Label Page = new Label();
        Page.setText(page + "/10");
        Page.setStyle(pagefont);
        Page.setTextFill(Color.WHITE);
        Page.setAlignment(Pos.CENTER);
//        Text text = new Text();
//        text.setText("Do you have any of these symptoms?(cough, sore throat, shortness on breathing or difficulty on breathing)");
        label.setText("Do you have any of these symptoms?");
        label1.setText("(cough, sore throat, shortness on breathing or difficulty on breathing)");
        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();

                num++;

                vbox.getChildren().addAll(Question3());
            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();

                vbox.getChildren().addAll(Question3());
//                primaryStage.close();

            }
        });
        HBox topBox = new HBox();
        HBox bottomBox = new HBox();

        label.setStyle(font);
        label.setTextFill(Color.WHITE);
        label1.setStyle(font);
        label1.setTextFill(Color.WHITE);

//        label.setStyle("-fx-font-color:#F2F2F2");
        label.setAlignment(Pos.CENTER);
        label1.setAlignment(Pos.CENTER);

        VBox textvbox = new VBox();
        textvbox.setAlignment(Pos.CENTER);
        textvbox.getChildren().addAll(label, label1);

        HBox textBox = new HBox();
        HBox buttonBox = new HBox();
        textBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        textBox.setPadding(new Insets(15, 12, 15, 12));
//        buttonBox.setPadding(new Insets(15, 12, 15, 12));
        textBox.setSpacing(10);
        buttonBox.setSpacing(120);

        textBox.getChildren().addAll(textvbox);
        buttonBox.getChildren().addAll(yes, no);
//        Scene scene = new Scene(root, 1200, 250);
        topBox.setPrefHeight(150);
        bottomBox.setPrefHeight(150);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().add(Page);
        buttonBox.setPrefHeight(70);
        textBox.setPrefHeight(150);
        vbox.getChildren().addAll(topBox, textBox, buttonBox, bottomBox);

        return vbox;
    }

    public VBox Question3() {
        VBox vbox = new VBox();
        page++;
//        Stage primaryStage = new Stage();
        Label label = new Label();
        Label Page = new Label();
        Page.setText(page + "/10");
        Page.setStyle(pagefont);
        Page.setTextFill(Color.WHITE);
        Page.setAlignment(Pos.CENTER);
//        text.setText("Do you have any of these symptoms?(cough, sore throat, shortness on breathing or difficulty on breathing)");
        label.setText("You have stayed or came from other countries.");

        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();

                num++;

                vbox.getChildren().addAll(Question4());
//                primaryStage.close();
            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();
                vbox.getChildren().addAll(Question4());
//                primaryStage.close();

            }
        });

        label.setStyle(font);
        label.setTextFill(Color.WHITE);

//        label.setStyle("-fx-font-color:#F2F2F2");
        label.setAlignment(Pos.CENTER);

        HBox topBox = new HBox();
        HBox bottomBox = new HBox();

//        text.setFont(font);
        // text.setFill(Color.WHITE);
        HBox textBox = new HBox();
        HBox buttonBox = new HBox();
        textBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        textBox.setPadding(new Insets(15, 12, 15, 12));
//        buttonBox.setPadding(new Insets(15, 12, 15, 12));
        textBox.setSpacing(10);
        buttonBox.setSpacing(120);
        textBox.getChildren().addAll(label);
        buttonBox.getChildren().addAll(yes, no);
//        Scene scene = new Scene(root, 1200, 250);
        topBox.setPrefHeight(150);
        bottomBox.setPrefHeight(150);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().add(Page);
        buttonBox.setPrefHeight(70);
        textBox.setPrefHeight(150);
        vbox.getChildren().addAll(topBox, textBox, buttonBox, bottomBox);
        return vbox;
    }

    public VBox Question4() {
        page++;
        VBox vbox = new VBox();
        Label label = new Label();
        Label label1 = new Label();
        Label Page = new Label();
        Page.setText(page + "/10");
        Page.setStyle(pagefont);
        Page.setTextFill(Color.WHITE);
        Page.setAlignment(Pos.CENTER);
//        Text text = new Text();
//        text.setText("Do you have any of these symptoms?(cough, sore throat, shortness on breathing or difficulty on breathing)");
        label.setText("You have contacted/stay closed to COVID-19 risky patient.");
        label1.setText("(Keep distance from patients less than 1 meter for 5 minutes.)");
        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();

                num++;

                vbox.getChildren().addAll(Question5());
//                primaryStage.close();
            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();
                vbox.getChildren().addAll(Question5());
//                primaryStage.close();

            }
        });

        HBox topBox = new HBox();
        HBox bottomBox = new HBox();

        label.setStyle(font);
        label.setTextFill(Color.WHITE);
        label1.setStyle(font);
        label1.setTextFill(Color.WHITE);

//        label.setStyle("-fx-font-color:#F2F2F2");
        label.setAlignment(Pos.CENTER);
        label1.setAlignment(Pos.CENTER);

        VBox textvbox = new VBox();
        textvbox.setAlignment(Pos.CENTER);
        textvbox.getChildren().addAll(label, label1);
        HBox textBox = new HBox();
        HBox buttonBox = new HBox();
        textBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        textBox.setPadding(new Insets(15, 12, 15, 12));
//        buttonBox.setPadding(new Insets(15, 12, 15, 12));
        textBox.setSpacing(10);
        buttonBox.setSpacing(120);
        textBox.getChildren().addAll(textvbox);
        buttonBox.getChildren().addAll(yes, no);
//        Scene scene = new Scene(root, 1200, 250);
        topBox.setPrefHeight(150);
        bottomBox.setPrefHeight(150);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().add(Page);
        buttonBox.setPrefHeight(70);
        textBox.setPrefHeight(150);
        vbox.getChildren().addAll(topBox, textBox, buttonBox, bottomBox);
        return vbox;
    }

    public VBox Question5() {
        VBox vbox = new VBox();
        page++;
        Label label = new Label();
        Label label1 = new Label();
        Label Page = new Label();
        Page.setText(page + "/10");
        Page.setStyle(pagefont);
        Page.setTextFill(Color.WHITE);
        Page.setAlignment(Pos.CENTER);
//        Text text = new Text();
//        text.setText("Do you have any of these symptoms?(cough, sore throat, shortness on breathing or difficulty on breathing)");
        label.setText("Have been travelled to community area or crowded places");
        label1.setText("such as local market,shopping mall, hospital, or republic transport.");

        label.setStyle(font);
        label.setTextFill(Color.WHITE);
        label1.setStyle(font);
        label1.setTextFill(Color.WHITE);

//        label.setStyle("-fx-font-color:#F2F2F2");
        label.setAlignment(Pos.CENTER);
        label1.setAlignment(Pos.CENTER);

        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();
                num++;
                vbox.getChildren().addAll(Question6());

            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();
                vbox.getChildren().addAll(Question6());

            }
        });

        HBox topBox = new HBox();
        HBox bottomBox = new HBox();

//        text.setFont(font);
//        text.setFill(Color.WHITE);
        HBox textBox = new HBox();
        VBox textvbox = new VBox();
        textvbox.setAlignment(Pos.CENTER);
        textvbox.getChildren().addAll(label, label1);
        HBox buttonBox = new HBox();
        textBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        textBox.setPadding(new Insets(15, 12, 15, 12));
//        buttonBox.setPadding(new Insets(15, 12, 15, 12));
        textBox.setSpacing(10);
        buttonBox.setSpacing(120);
        textBox.getChildren().addAll(textvbox);
        buttonBox.getChildren().addAll(yes, no);
//        Scene scene = new Scene(root, 1200, 250);
        topBox.setPrefHeight(150);
        bottomBox.setPrefHeight(150);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().add(Page);
        buttonBox.setPrefHeight(70);
        textBox.setPrefHeight(150);
        vbox.getChildren().addAll(topBox, textBox, buttonBox, bottomBox);
//        primaryStage.show();
        return vbox;
//        Scene scene = new Scene(root, 1200, 250);
// 
//        primaryStage.setTitle("Quiz");
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }

    public VBox Question6() {
        VBox vbox = new VBox();
        page++;
        Label label = new Label();
        Label label1 = new Label();
        Label Page = new Label();
        Page.setText(page + "/10");
        Page.setStyle(pagefont);
        Page.setTextFill(Color.WHITE);
        Page.setAlignment(Pos.CENTER);
//        Text text = new Text();
//        text.setText("Do you have any of these symptoms?(cough, sore throat, shortness on breathing or difficulty on breathing)");
        label.setText("You are up to 50 years old.");
//        label1.setText("or under investigation for COVID-19");

        label.setStyle(font);
        label.setTextFill(Color.WHITE);
//        label1.setStyle(font);
//        label1.setTextFill(Color.WHITE);

//        label.setStyle("-fx-font-color:#F2F2F2");
        label.setAlignment(Pos.CENTER);
//        label1.setAlignment(Pos.CENTER);
        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();
                vbox.getChildren().addAll(Question7());
                num++;

//                primaryStage.close();
            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();
                vbox.getChildren().addAll(Question7());

            }
        });

        HBox topBox = new HBox();
        HBox bottomBox = new HBox();

        VBox textvbox = new VBox();
        textvbox.setAlignment(Pos.CENTER);
        textvbox.getChildren().addAll(label);
        HBox textBox = new HBox();
        HBox buttonBox = new HBox();
        textBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        textBox.setPadding(new Insets(15, 12, 15, 12));
//        buttonBox.setPadding(new Insets(15, 12, 15, 12));
        textBox.setSpacing(10);
        buttonBox.setSpacing(120);
        textBox.getChildren().addAll(textvbox);
        buttonBox.getChildren().addAll(yes, no);
//        Scene scene = new Scene(root, 1200, 250);
        topBox.setPrefHeight(150);
        bottomBox.setPrefHeight(150);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().add(Page);
        buttonBox.setPrefHeight(70);
        textBox.setPrefHeight(150);
        vbox.getChildren().addAll(topBox, textBox, buttonBox, bottomBox);

        return vbox;

    }

    public VBox Question7() {
        page++;
        VBox vbox = new VBox();
        Label label = new Label();
        Label label1 = new Label();
        Label Page = new Label();
        Page.setText(page + "/10");
        Page.setStyle(pagefont);
        Page.setTextFill(Color.WHITE);
        Page.setAlignment(Pos.CENTER);
        label.setText("Are you a medical staff?");
//        label1.setText("who came from other countries.");

        label.setStyle(font);
        label.setTextFill(Color.WHITE);
//        label1.setStyle(font);
//        label1.setTextFill(Color.WHITE);

        label.setAlignment(Pos.CENTER);
//        label1.setAlignment(Pos.CENTER);

        VBox textvbox = new VBox();
        textvbox.setAlignment(Pos.CENTER);
        textvbox.getChildren().addAll(label);

        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();
                num++;
                vbox.getChildren().addAll(Question8());

            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();
                vbox.getChildren().addAll(Question8());

            }
        });
        HBox topBox = new HBox();
        HBox bottomBox = new HBox();

        HBox textBox = new HBox();
        HBox buttonBox = new HBox();
        textBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        textBox.setPadding(new Insets(15, 12, 15, 12));
//        buttonBox.setPadding(new Insets(15, 12, 15, 12));
        textBox.setSpacing(10);
        buttonBox.setSpacing(120);
        textBox.getChildren().addAll(textvbox);
        buttonBox.getChildren().addAll(yes, no);

        topBox.setPrefHeight(150);
        bottomBox.setPrefHeight(150);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().add(Page);
        buttonBox.setPrefHeight(70);
        textBox.setPrefHeight(150);
        vbox.getChildren().addAll(topBox, textBox, buttonBox, bottomBox);

        return vbox;

    }

    public VBox Question8() {
        VBox vbox = new VBox();
        page++;
        Label label = new Label();
        Label label1 = new Label();

        Label Page = new Label();
        Page.setText(page + "/10");
        Page.setStyle(pagefont);
        Page.setTextFill(Color.WHITE);
        Page.setAlignment(Pos.CENTER);
        label.setText("Have been in close contact with 5 or more people");
        label1.setText("who have had flu at the same time in the last 14 days.");

        label.setStyle(font);
        label.setTextFill(Color.WHITE);
        label1.setStyle(font);
        label1.setTextFill(Color.WHITE);

//        label.setStyle("-fx-font-color:#F2F2F2");
        label.setAlignment(Pos.CENTER);
        label1.setAlignment(Pos.CENTER);

        VBox textvbox = new VBox();
        textvbox.setAlignment(Pos.CENTER);
        textvbox.getChildren().addAll(label, label1);
        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();
                vbox.getChildren().addAll(Question9());
                num++;

            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();
                vbox.getChildren().addAll(Question9());
                ;
            }
        });

        HBox topBox = new HBox();
        HBox bottomBox = new HBox();

        HBox textBox = new HBox();
        HBox buttonBox = new HBox();
        textBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        textBox.setPadding(new Insets(15, 12, 15, 12));
//        buttonBox.setPadding(new Insets(15, 12, 15, 12));
        textBox.setSpacing(10);
        buttonBox.setSpacing(120);
        textBox.getChildren().addAll(textvbox);
        buttonBox.getChildren().addAll(yes, no);
//        Scene scene = new Scene(root, 1200, 250);
        topBox.setPrefHeight(150);
        bottomBox.setPrefHeight(150);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().add(Page);
        buttonBox.setPrefHeight(70);
        textBox.setPrefHeight(150);
        vbox.getChildren().addAll(topBox, textBox, buttonBox, bottomBox);
//        primaryStage.show();
        return vbox;
    }

    public VBox Question9() {
        VBox vbox = new VBox();
        page++;
        Label label = new Label();
        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label Page = new Label();
        Page.setText(page + "/10");
        Page.setStyle(pagefont);
        Page.setTextFill(Color.WHITE);
        Page.setAlignment(Pos.CENTER);
//        Text text = new Text();
//        text.setText("Do you have any of these symptoms?(cough, sore throat, shortness on breathing or difficulty on breathing)");
        label.setText("Have closely exposed in the same room/home");
        label1.setText("with someone who came from these countries.");
        label2.setText("China, Hongkong, Macao, Japan, South Korea, Italy, Iran, France, Germany,");
        label3.setText("United States of America, Switzerland, Norway, Denmark, Netherland, Sweden, England");

        label.setStyle(font);
        label.setTextFill(Color.WHITE);
        label1.setStyle(font);
        label1.setTextFill(Color.WHITE);
        label2.setStyle(font1);
        label2.setTextFill(Color.WHITE);
        label3.setStyle(font1);
        label3.setTextFill(Color.WHITE);

//        label.setStyle("-fx-font-color:#F2F2F2");
        label.setAlignment(Pos.CENTER);
        label1.setAlignment(Pos.CENTER);
        label2.setAlignment(Pos.CENTER);
        label3.setAlignment(Pos.CENTER);
        VBox textvbox = new VBox();
        textvbox.setAlignment(Pos.CENTER);
        textvbox.getChildren().addAll(label, label1, label2, label3);
        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();
                vbox.getChildren().addAll(Question10());
                num++;

            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vbox.getChildren().clear();
                vbox.getChildren().addAll(Question10());

            }
        });

        HBox topBox = new HBox();
        HBox bottomBox = new HBox();

        HBox textBox = new HBox();
        HBox buttonBox = new HBox();
        textBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        textBox.setPadding(new Insets(15, 12, 15, 12));
//        buttonBox.setPadding(new Insets(15, 12, 15, 12));
        textBox.setSpacing(10);
        buttonBox.setSpacing(120);
        textBox.getChildren().addAll(textvbox);
        buttonBox.getChildren().addAll(yes, no);
//        Scene scene = new Scene(root, 1200, 250);
        topBox.setPrefHeight(150);
        bottomBox.setPrefHeight(150);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().add(Page);
        buttonBox.setPrefHeight(70);
        textBox.setPrefHeight(150);
        vbox.getChildren().addAll(topBox, textBox, buttonBox, bottomBox);
//        primaryStage.show();
        return vbox;
    }

    public VBox Question10() {
        VBox vbox = new VBox();
        page++;
        Label label = new Label();

        label.setText("Do any of your relatives are risk to got COVID-19 affected?");
        Label Page = new Label();
        Page.setText(page + "/10");
        Page.setStyle(pagefont);
        Page.setTextFill(Color.WHITE);
        Page.setAlignment(Pos.CENTER);
        label.setStyle(font);
        label.setTextFill(Color.WHITE);

        label.setAlignment(Pos.CENTER);
        QuizEnd q = new QuizEnd();

        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                yes.setDisable(true);
                no.setDisable(true);
                num++;

                q.End();
// Main.vboxMain.getChildren().clear();
                vbox.getChildren().clear();
                vbox.getChildren().add(Quiz());

            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                yes.setDisable(true);
                no.setDisable(true);

                q.End();
//                Main.vboxMain.getChildren().clear();
                vbox.getChildren().clear();
                vbox.getChildren().add(Quiz());

            }
        });

        HBox topBox = new HBox();
        HBox bottomBox = new HBox();
        HBox textBox = new HBox();
        HBox buttonBox = new HBox();
        textBox.setAlignment(Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        vbox.setAlignment(Pos.CENTER);
        textBox.setPadding(new Insets(15, 12, 15, 12));
//        buttonBox.setPadding(new Insets(15, 12, 15, 12));
        textBox.setSpacing(10);
        buttonBox.setSpacing(120);
        textBox.getChildren().addAll(label);
        buttonBox.getChildren().addAll(yes, no);
//        Scene scene = new Scene(root, 1200, 250);
        topBox.setPrefHeight(150);
        bottomBox.setPrefHeight(150);
        bottomBox.setAlignment(Pos.CENTER);
        bottomBox.getChildren().add(Page);
        buttonBox.setPrefHeight(70);
        textBox.setPrefHeight(150);
        vbox.getChildren().addAll(topBox, textBox, buttonBox, bottomBox);
//        primaryStage.setScene(scene);
//        primaryStage.show();
        return vbox;
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
