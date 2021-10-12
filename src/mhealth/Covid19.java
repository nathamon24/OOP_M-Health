package mhealth;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.util.Callback;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Phxi
 */
public class Covid19 extends Application {

    ;
       String STYLE_MINTGREEN = "-fx-border-color:#B2EEE6;-fx-border-width:2.5;-fx-border-style:dashed;-fx-background-color:#B2EEE6;-fx-opacity: 1.0";
    String STYLE_DARKGREEN = "-fx-border-color:#92C6BF;-fx-border-width:2.5;-fx-border-style:dashed;-fx-background-color:#92C6BF;-fx-opacity: 1.0";
    String STYLE_BORDER_DASHED = "-fx-border-color:#92C6BF;-fx-border-width:2.5;-fx-border-style:dashed;-fx-background-color:#B2EEE6;-fx-opacity: 1.0";

    public VBox showCovidPage() {
        VBox vbox = new VBox();
        HBox hboxMenu = new HBox();
        HBox hbox = new HBox();
        hbox.getChildren().add(showInfomationPage());
        Button btnInformation = new Button();
        Button btnInfographic = new Button();
        btnInformation.setPrefHeight(42);
        Image image1 = new Image(Covid19.class.getResource("/Image/btnMenu2.png").toExternalForm());
        ImageView imageButtonView1 = new ImageView(image1);
        btnInformation.setStyle(STYLE_DARKGREEN);
        imageButtonView1.setPreserveRatio(true);
        imageButtonView1.setSmooth(true);
        imageButtonView1.setCache(true);
        Image image2 = new Image(Covid19.class.getResource("/Image/btnMenu1.png").toExternalForm());
        ImageView imageButtonView2 = new ImageView(image2);
        btnInfographic.setPrefHeight(42);
        btnInfographic.setStyle(STYLE_MINTGREEN);
        btnInfographic.setGraphic(imageButtonView1);
        imageButtonView2.setPreserveRatio(true);
        imageButtonView2.setSmooth(true);
        imageButtonView2.setCache(true);
        hboxMenu.setPrefHeight(60);
        btnInformation.setGraphic(imageButtonView2);
        hboxMenu.setPadding(new Insets(5, 10, 5, 10));
        HBox hboxMenu1 = new HBox();
        HBox hboxMenu2 = new HBox();
        hboxMenu1.setAlignment(Pos.CENTER);
        hboxMenu2.setAlignment(Pos.CENTER_LEFT);
        hboxMenu1.setPrefHeight(50);
        hboxMenu2.setPrefHeight(50);

        hboxMenu1.getChildren().add(btnInformation);
        hboxMenu2.getChildren().add(btnInfographic);
        hboxMenu.setSpacing(10);
        hboxMenu.setAlignment(Pos.CENTER_LEFT);
        hboxMenu.setStyle("-fx-background-color:#B2EEE6");

        hboxMenu.getChildren().addAll(hboxMenu1, hboxMenu2);

        btnInformation.setDisable(false);
        btnInfographic.setDisable(false);

        btnInfographic.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            if (btnInformation.isDisabled() && !btnInfographic.isDisabled() || !btnInformation.isDisabled() && !btnInfographic.isDisabled()) {
                btnInfographic.setStyle(STYLE_MINTGREEN);
            }
        });
        btnInfographic.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            if (btnInformation.isDisabled() && !btnInfographic.isDisabled() || !btnInformation.isDisabled() && !btnInfographic.isDisabled()) {
                btnInfographic.setStyle(STYLE_BORDER_DASHED);
            }
        });

//              btnInformation.setDisable(false);
        btnInformation.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            if (!btnInformation.isDisabled() && btnInfographic.isDisabled()) {
                btnInformation.setStyle(STYLE_MINTGREEN);
            }
        });

        btnInformation.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            if (!btnInformation.isDisabled() && btnInfographic.isDisabled()) {
                btnInformation.setStyle(STYLE_BORDER_DASHED);
            }
        });

//         
        btnInformation.setOnAction((ActionEvent t) -> {
            hbox.getChildren().clear();
            btnInformation.setDisable(true);
            btnInfographic.setDisable(false);
            btnInformation.setStyle(STYLE_DARKGREEN);
            btnInfographic.setStyle(STYLE_MINTGREEN);
            hbox.getChildren().add(showInfomationPage());

        });
        btnInfographic.setOnAction((ActionEvent t) -> {
            hbox.getChildren().clear();
            btnInformation.setDisable(false);
            btnInfographic.setDisable(true);
            btnInfographic.setStyle(STYLE_DARKGREEN);
            btnInformation.setStyle(STYLE_MINTGREEN);
            hbox.getChildren().add(showInfographicPage());

        });

        vbox.getChildren().addAll(hboxMenu, hbox);
        return vbox;
    }

    public HBox showInfomationPage() {
        Main m = new Main();
        HBox hbox = new HBox();
        VBox vbox = new VBox();
        HBox hboxCovid1 = new HBox();
        HBox hboxCovid2 = new HBox();

        Image[] imageList = new Image[5];
        ImageView[] imageView = new ImageView[5];
        for (int i = 1; i < imageList.length; i++) {
            imageList[i] = new Image(Covid19.class.getResource("/image/" + i + ".jpg").toExternalForm());
            imageView[i] = new ImageView(imageList[i]);
            imageView[i].setFitHeight(450);
            imageView[i].setFitWidth(800);
        }

// btnInformation.setStyle("-fx-border-color:#92C6BF;-fx-border-width:2;-fx-border-style:dashed;-fx-background-color:#92C6BF;-fx-opacity: 1.0");
////            
        Button button1 = new Button();
        Image image1 = new Image(Covid19.class.getResource("/Image/button1.png").toExternalForm());
        ImageView imageButtonView1 = new ImageView(image1);
        imageButtonView1.setFitHeight(40);
        button1.setGraphic(imageButtonView1);

        Button button2 = new Button();
        Image image2 = new Image(Covid19.class.getResource("/Image/button2.png").toExternalForm());
        ImageView imageButtonView2 = new ImageView(image2);
        imageButtonView2.setFitHeight(40);
        button2.setGraphic(imageButtonView2);

        Button button3 = new Button();
        Image image3 = new Image(Covid19.class.getResource("/Image/button3.png").toExternalForm());
        ImageView imageButtonView3 = new ImageView(image3);
        imageButtonView3.setFitHeight(40);
        button3.setGraphic(imageButtonView3);

        Button button4 = new Button();
        Image image4 = new Image(Covid19.class.getResource("/Image/button4.png").toExternalForm());
        ImageView imageButtonView4 = new ImageView(image4);
        imageButtonView4.setFitHeight(40);
        button4.setGraphic(imageButtonView4);

        button1.setPrefSize(20, 20);
        button1.setStyle("-fx-background-color:#F6F4EA;-fx-opacity: 1.0");
        button2.setPrefSize(20, 20);
        button2.setStyle("-fx-background-color:#212121");
        button3.setPrefSize(20, 20);
        button3.setStyle("-fx-background-color:#212121");
        button4.setPrefSize(20, 20);
        button4.setStyle("-fx-background-color:#212121");
        button1.setDisable(true);
        button1.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {

            button1.setEffect(new DropShadow());

        });

        button1.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            button1.setEffect(null);
        });

        button2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {

            button2.setEffect(new DropShadow());

        });

        button2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            button2.setEffect(null);
        });

        button3.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {

            button3.setEffect(new DropShadow());

        });

        button3.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            button3.setEffect(null);
        });

        button4.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {

            button4.setEffect(new DropShadow());

        });

        button4.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            button4.setEffect(null);
        });

        button1.setOnAction((ActionEvent t) -> {

            hboxCovid1.getChildren().clear();
            button1.setDisable(true);
            button4.setDisable(false);
            button2.setDisable(false);
            button3.setDisable(false);
            button1.setStyle("-fx-background-color:#F6F4EA;-fx-opacity: 1.0");
            button2.setStyle("-fx-background-color:#212121");
            button3.setStyle("-fx-background-color:#212121");
            button4.setStyle("-fx-background-color:#212121");
            hboxCovid1.getChildren().add(imageView[1]);

        });
        button2.setOnAction((ActionEvent t) -> {

            button2.setDisable(true);
            button1.setDisable(false);
            button4.setDisable(false);
            button3.setDisable(false);
            hboxCovid1.getChildren().clear();
            button1.setStyle("-fx-background-color:#212121");
            button2.setStyle("-fx-background-color:#F6F4EA;-fx-opacity: 1.0");
            button3.setStyle("-fx-background-color:#212121");
            button4.setStyle("-fx-background-color:#212121");
            hboxCovid1.getChildren().add(imageView[2]);
        });
        button3.setOnAction((ActionEvent t) -> {

            hboxCovid1.getChildren().clear();
            button3.setDisable(true);
            button1.setDisable(false);
            button2.setDisable(false);
            button4.setDisable(false);
            button1.setStyle("-fx-background-color:#212121");
            button2.setStyle("-fx-background-color:#212121");
            button3.setStyle("-fx-background-color:#F6F4EA;-fx-opacity: 1.0");
            button4.setStyle("-fx-background-color:#212121");
            hboxCovid1.getChildren().add(imageView[3]);
        });
        button4.setOnAction((ActionEvent t) -> {

            button4.setDisable(true);
            button1.setDisable(false);
            button2.setDisable(false);
            button3.setDisable(false);
            hboxCovid1.getChildren().clear();
            button1.setStyle("-fx-background-color:#212121");
            button2.setStyle("-fx-background-color:#212121");
            button3.setStyle("-fx-background-color:#212121");
            button4.setStyle("-fx-background-color:#F6F4EA;-fx-opacity: 1.0");
            hboxCovid1.getChildren().add(imageView[4]);
        });

//        root.setTop(hbox1);
//        root.setBottom(hbox2);
        hboxCovid1.setAlignment(Pos.CENTER);
        hboxCovid2.setAlignment(Pos.TOP_CENTER);
        hboxCovid1.setPrefHeight(470);
        hboxCovid2.setPrefHeight(100);
//      hbox2.setPadding(new Insets(10,10,10,10));
        hboxCovid2.setSpacing(10);
        hboxCovid2.getChildren().addAll(button1, button2, button3, button4);
        hboxCovid1.getChildren().add(imageView[1]);
        vbox.setPrefWidth(954);
        vbox.getChildren().addAll(hboxCovid1, hboxCovid2);
        vbox.setStyle("-fx-background-color:#F6F4EA");
        hbox.getChildren().add(vbox);
        return hbox;
    }

    public HBox showInfographicPage() {
        HBox hbox = new HBox();
        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        HBox hbox3 = new HBox();
//         btnInformation.setDisable(false);  
//         btnInfographic.setDisable(true);
//         btnInfographic.setStyle("-fx-border-color:#92C6BF;-fx-opacity: 1.0");
////         btnInformation.setStyle("-fx-border-color:#B2EEE6;-fx-border-width:2;-fx-border-style:dashed;-fx-background-color:#B2EEE6;-fx-opacity: 1.0");
//        btnInformation.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
//
//            btnInformation.setStyle("-fx-border-color:#92C6BF;-fx-border-width:2;-fx-border-style:dashed;-fx-background-color:#B2EEE6;-fx-opacity: 1.0");
//           
//        });
//         if(!btnInformation.isDisable())   {
//         {      btnInfographic.setStyle("-fx-border-color:#92C6BF;-fx-border-width:2;-fx-border-style:dashed;-fx-background-color:#92C6BF;-fx-opacity: 1.0");
//        btnInformation.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
//          
//             btnInformation.setStyle("-fx-border-color:#B2EEE6;-fx-border-width:2;-fx-border-style:dashed;-fx-background-color:#B2EEE6;-fx-opacity: 1.0");
//        });

        Pagination pagination = new Pagination();
        pagination.setPageCount(12);
        pagination.setCurrentPageIndex(0);
        pagination.setMaxPageIndicatorCount(6);
//        pagination.setStyle("-fx-base:ivory;"+"-fx-border-radius:5px;"+"-fx-border-color:white;"+"-fx-border-width:3;"+"-fx-border-style:dashed;"
//                +"-fx-page-information-visible:false;"+
//                "-fx-text-base-color: black;"+
//                "-fx-font-size:12;");
        pagination.getStyleClass().addAll(Pagination.STYLE_CLASS_BULLET);
        pagination.setStyle("-fx-border-color:white;" + "-fx-border-width:3;" + "-fx-border-style:dashed;" + "-fx-page-information-visible:false;" + "-fx-font-size:16");
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {

                return createPage(pageIndex);
            }
        });

        AnchorPane pane = new AnchorPane();
        AnchorPane.setTopAnchor(pagination, 10.0);
        AnchorPane.setRightAnchor(pagination, 10.0);
        AnchorPane.setLeftAnchor(pagination, 10.0);
        AnchorPane.setBottomAnchor(pagination, 10.0);
        pane.getChildren().addAll(pagination);
        hbox1.setStyle("-fx-background-color:#F6F4EA");
        hbox2.setStyle("-fx-background-color:#FFE9B6");
        hbox3.setStyle("-fx-background-color:#F6F4EA");
        hbox1.setPrefSize(207, 570);
        hbox2.setPrefSize(560, 570);
        hbox3.setPrefSize(207, 570);
        hbox2.setAlignment(Pos.TOP_CENTER);
        hbox2.getChildren().add(pane);
        hbox.getChildren().addAll(hbox1, hbox2, hbox3);

        return hbox;
    }
//    public void menuDecorator(Button buttonMenu) {
//        buttonMenu.setOnMouseEntered((value) -> {
//            buttonMenu.setStyle("-fx-backgrouund-color:blue");
//
//        });
//        buttonMenu.setOnMouseExited((value) -> {
//            buttonMenu.setStyle("-fx-backgrouund-color:red");
//
//        });
//
//    }

    public HBox createPage(int pageIndex) {
        int i = pageIndex + 1;
        HBox hbox = new HBox();
//        BorderPane pane = new BorderPane();
        Image image = new Image(Covid19.class.getResource("/info/" + i + ".jpg").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(450);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        hbox.setPadding(new Insets(10, 0, 0, 0));
        //hbox.setPrefWidth(1240);
        // hbox.setStyle("-fx-background-color:#F6F4EA");
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().add(imageView);
        hbox.setPrefSize(540, 560);
        return hbox;
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
