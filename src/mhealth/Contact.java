package mhealth;

import java.io.File;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Phxi
 */
public class Contact extends Application {

    String STYLE_BLACK = "-fx-background-color:rgba(0,0,0,0.8)";

    public VBox showContactPage() {
        VBox vbox = new VBox();

        Button btnCentral = new Button();
        Button btnNortheast = new Button();
        Button btnNorth = new Button();
        Button btnSouthern = new Button();
        Button btnEast = new Button();
        Button btnBangkok = new Button();
        btnBangkok.setShape(new Circle(125));
        btnCentral.setShape(new Circle(125));
        btnNortheast.setShape(new Circle(125));
        btnNorth.setShape(new Circle(125));
        btnSouthern.setShape(new Circle(125));
        btnEast.setShape(new Circle(125));
        Image[] image = new Image[6];
        ImageView[] imageView = new ImageView[6];
        for (int i = 0; i < image.length; i++) {
            int k = i + 1;
            image[i] = new Image(Contact.class.getResource("/Image/btn" + k + ".png").toExternalForm());
            imageView[i] = new ImageView(image[i]);
            imageView[i].setFitWidth(125);
            imageView[i].setFitHeight(125);
        }
        Image[] image1 = new Image[6];
        ImageView[] imageView1 = new ImageView[6];
        for (int i = 0; i < image1.length; i++) {
            int k = i + 1;
            image1[i] = new Image(Contact.class.getResource("/Image/region" + k + ".png").toExternalForm());
            imageView1[i] = new ImageView(image1[i]);
            imageView1[i].setFitWidth(125);
            imageView1[i].setFitHeight(125);
        }

        btnCentral.setGraphic(imageView[0]);

        btnNortheast.setGraphic(imageView[1]);

        btnNorth.setGraphic(imageView[2]);

        btnSouthern.setGraphic(imageView[3]);

        btnEast.setGraphic(imageView[4]);

        btnBangkok.setGraphic(imageView[5]);
        GridPane pane = new GridPane();
//       pane.setPrefSize(1240, 620);
        pane.setAlignment(Pos.CENTER); // Set center alignment

//    pane.setHgap(5);
        pane.setVgap(8); // Set vGap to 5.5px
//    btnCentral.setStyle("-fx-background-color:#60504c");
//    btnNortheast.setStyle("-fx-background-color:#61598c");
//    btnNorth.setStyle("-fx-background-color:#6a9e96");
//    btnSouthern.setStyle("-fx-background-color:#e8b558");
//    btnEast.setStyle("-fx-background-color:#db7b8e");
//    btnBangkok.setStyle("-fx-background-color:#9a7770");
        btnCentral.setStyle(STYLE_BLACK);
        btnNortheast.setStyle(STYLE_BLACK);
        btnNorth.setStyle(STYLE_BLACK);
        btnSouthern.setStyle(STYLE_BLACK);
        btnEast.setStyle(STYLE_BLACK);
        btnBangkok.setStyle(STYLE_BLACK);

        btnCentral.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btnCentral.setEffect(new DropShadow());

            btnCentral.setGraphic(imageView1[0]);

        });
        btnCentral.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            btnCentral.setEffect(null);
            btnCentral.setGraphic(imageView[0]);

        });
        btnNortheast.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btnNortheast.setEffect(new DropShadow());
            btnNortheast.setGraphic(imageView1[1]);

        });
        btnNortheast.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            btnNortheast.setEffect(null);
            btnNortheast.setGraphic(imageView[1]);
        });
        btnNorth.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btnNorth.setEffect(new DropShadow());
            btnNorth.setGraphic(imageView1[2]);

        });
        btnNorth.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            btnNorth.setEffect(null);
            btnNorth.setGraphic(imageView[2]);
        });
        btnSouthern.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btnSouthern.setEffect(new DropShadow());
            btnSouthern.setGraphic(imageView1[3]);

        });
        btnSouthern.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            btnSouthern.setEffect(null);
            btnSouthern.setGraphic(imageView[3]);
        });
        btnEast.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btnEast.setEffect(new DropShadow());
            btnEast.setGraphic(imageView1[4]);

        });
        btnEast.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            btnEast.setEffect(null);
            btnEast.setGraphic(imageView[4]);

        });

        btnBangkok.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            btnBangkok.setEffect(new DropShadow());
            btnBangkok.setGraphic(imageView1[5]);

        });
        btnBangkok.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            btnBangkok.setEffect(null);
            btnBangkok.setGraphic(imageView[5]);

        });

        Image image2 = new Image(Contact.class.getResource("/Image/hospital.png").toExternalForm());
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(200);
        imageView2.setPreserveRatio(true);
        imageView2.setSmooth(true);
        imageView2.setCache(true);
        GridPane.setHalignment(btnCentral, HPos.CENTER);
        GridPane.setHalignment(btnNortheast, HPos.CENTER);
        GridPane.setHalignment(btnNorth, HPos.CENTER);
        GridPane.setHalignment(btnSouthern, HPos.CENTER);
        GridPane.setHalignment(btnEast, HPos.CENTER);
        GridPane.setHalignment(imageView2, HPos.CENTER);
//        pane.setPadding(new Insets(55,55,55,55));
        pane.add(btnBangkok, 7, 0);
        pane.add(btnCentral, 3, 0);
        pane.add(btnNortheast, 2, 4);
        pane.add(btnNorth, 3, 10);
        pane.add(btnSouthern, 7, 10);
        pane.add(btnEast, 8, 4);
        pane.add(imageView2, 5, 4);

//        pane.setStyle("-fx-background-color:#275E55");
        Image imageBg = new Image(Contact.class.getResource("/Image/bg.png").toExternalForm());

//         create a background image 
        BackgroundImage backgroundimage1 = new BackgroundImage(imageBg,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1.0, 1.15, true, true, false, false));
        // create Background 
        Background background1 = new Background(backgroundimage1);
        // set background 
        vbox.setBackground(background1);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefSize(1240, 620);
        vbox.getChildren().add(pane);

        btnBangkok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showBangkokPerimeter();
            }
        });
        btnCentral.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showCentral();
            }
        });

        btnNortheast.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showNortheast();
            }
        });

        btnNorth.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showNorth();
            }
        });

        btnSouthern.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showSouthern();
            }
        });

        btnEast.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showEast();
            }
        });
        return vbox;
    }

    public void showBangkokPerimeter() {
        File file = new File(Contact.class.getResource("/pdf/bangkok.pdf").getFile());
        HostServices host = getHostServices();
        host.showDocument(file.getAbsolutePath());
    }

    public void showCentral() {
        File file = new File(Contact.class.getResource("/pdf/central.pdf").getFile());
        HostServices host = getHostServices();
        host.showDocument(file.getAbsolutePath());
    }

    public void showNortheast() {
        File file = new File(Contact.class.getResource("/pdf/northeast.pdf").getFile());
        HostServices host = getHostServices();
        host.showDocument(file.getAbsolutePath());
    }

    public void showNorth() {
        File file = new File(Contact.class.getResource("/pdf/north.pdf").getFile());
        HostServices host = getHostServices();
        host.showDocument(file.getAbsolutePath());
    }

    public void showSouthern() {
        File file = new File(Contact.class.getResource("/pdf/southern.pdf").getFile());
        HostServices host = getHostServices();
        host.showDocument(file.getAbsolutePath());
    }

    public void showEast() {
        File file = new File(Contact.class.getResource("/pdf/east.pdf").getFile());
        HostServices host = getHostServices();
        host.showDocument(file.getAbsolutePath());
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
