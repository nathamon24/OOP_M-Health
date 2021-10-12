package mhealth;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Ram
 */
public class BarChartCovid extends Application {
    //private StackedBarChart chart;

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Covid-19");

        StackPane root = new StackPane();
        Scene scene = new Scene(root, 500, 350);

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        //ScatterChart chart = new ScatterChart(xAxis, yAxis, getChartData());
        //LineChart chart = new LineChart(xAxis, yAxis, getChartData());
        //AreaChart chart = new AreaChart(xAxis, yAxis, getChartData());
        //StackedAreaChart chart = new StackedAreaChart(xAxis, yAxis, getChartData());
        //BarChart chart = new BarChart(xAxis, yAxis, getChartData());
        StackedBarChart chart = new StackedBarChart(xAxis, yAxis, getChartData());
        chart.setTitle("Case in April");

        Timeline t1 = new Timeline();
        t1.getKeyFrames().add(new KeyFrame(Duration.millis(500),
                (ActionEvent e) -> {
                    chart.getData().stream().forEach((series) -> {

                    });
                }));
        root.getChildren().add(chart);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private ObservableList<Series<String, Double>> getChartData() {
        double maleValue = 850.56;
        double cValue = 850.54;
        double cppValue = 8.25;

        ObservableList<XYChart.Series<String, Double>> data = FXCollections.observableArrayList();

        Series<String, Double> male = new Series<>();
        Series<String, Double> female = new Series<>();
        //Series<String, Double> cpp = new Series<>();

        male.setName("Male");
        female.setName("Female");
        //cpp.setName("C++");

        for (int i = 1; i < 25; i++) {
            male.getData().add(new XYChart.Data(Integer.toString(i), maleValue));
            maleValue = maleValue + 50 * Math.random() - 2;

            female.getData().add(new XYChart.Data(Integer.toString(i), cValue));
            cValue = cValue + 50 * Math.random() - 1.96;

            //cpp.getData().add(new XYChart.Data(Integer.toString(i), cppValue));
            // cppValue = cppValue + 4 * Math.random() - 0.2;
        }

        data.addAll(male, female);

        return data;
    }
}
