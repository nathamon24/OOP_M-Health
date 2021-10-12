/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhealth;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Phxi
 */
public class Home extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public HBox showHome() {
        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color:#D8E7F1");
        VBox vboxLeft = new VBox();
        VBox vboxRight = new VBox();
        HBox hboxTop = new HBox();
        HBox hboxBottom = new HBox();
        Image image = new Image(Home.class.getResource("/Image/MapCovid.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(550);
        imageView.setPreserveRatio(true);
//        imageView.setSmooth(true);
//        imageView.setCache(true);
        FadeTransition f = new FadeTransition(Duration.seconds(0.3), imageView);
        f.setFromValue(0);
        f.setToValue(1);
        f.play();
        Image image1 = new Image(Home.class.getResourceAsStream("/icon/find_icon.png"));
        ImageView imageView1 = new ImageView(image1);
        Image image2 = new Image(Home.class.getResourceAsStream("/icon/edit_icon.png"));
        ImageView imageView2 = new ImageView(image2);
        Tooltip tooltip = new Tooltip();

        //tooltip.setGraphic(imageView1);
        LineChart l = new LineChart();
        imageView.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {

            if (Mhealth.Check == 1) {

                tooltip.setGraphic(imageView1);
                tooltip.setText("Click to see detials");
            } else if (2 == Mhealth.Check) {
                System.out.println(Mhealth.Check);
                tooltip.setGraphic(imageView2);
                tooltip.setText("Click to edit");
            }
            tooltip.setStyle("-fx-font:15 Dekko");
            Tooltip.install(imageView, tooltip);
            imageView.setEffect(new DropShadow(20, Color.DARKTURQUOISE));

        });
        imageView.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            imageView.setEffect(null);

        });
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {

            //tooltip.setText(String.valueOf("Province -- "+ data.getName()));
            MapTable lc = new MapTable();

            lc.showTable();

        });

        vboxLeft.setAlignment(Pos.CENTER_RIGHT);
        vboxLeft.setPrefWidth(400);
        vboxLeft.getChildren().add(imageView);
        hboxTop.setPrefSize(400, 180);
        hboxBottom.setPrefHeight(500);
        vboxRight.setPrefHeight(620);
        hboxTop.setAlignment(Pos.TOP_CENTER);
        hboxBottom.setAlignment(Pos.CENTER);
        hbox.setPrefHeight(620);
        PieChartCovid pieChart = new PieChartCovid();
        hboxTop.getChildren().addAll(pieChart.pieChart());

        hboxBottom.getChildren().addAll(l.showLineChart());
        vboxRight.getChildren().addAll(hboxTop, hboxBottom);
        hbox.getChildren().addAll(vboxLeft, vboxRight);

        return hbox;
    }

}
