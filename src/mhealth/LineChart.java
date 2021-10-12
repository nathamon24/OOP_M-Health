/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhealth;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Blend;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import javafx.util.Duration;
import static mhealth.QuizEnd.primaryStage;

public class LineChart extends Application {

    String font = " -fx-font:14 Dekko";
//    private TableView<XYChart.Data> tableView = new TableView<>();

    private ObservableList<XYChart.Data> dataList
            = FXCollections.observableArrayList(
                    new XYChart.Data("15 Jan", 0),
                    new XYChart.Data("31 Jan", 19),
                    new XYChart.Data("15 Feb", 34),
                    new XYChart.Data("29 Feb", 42),
                    new XYChart.Data("15 Mar", 114),
                    new XYChart.Data("31 Mar", 1651),
                    new XYChart.Data("15 Apr", 2643)
            );

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        launch(args);
    Stage stage = new Stage();

    public void showTable() {
        // Mhealth.Check=3;
        //Stage stage = new Stage();
        TableView<XYChart.Data> tableView = new TableView<>();
        tableView.setEditable(true);
        Callback<TableColumn, TableCell> cellFactory
                = new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn p) {
                return new EditingCell();
            }
        };

        TableColumn columnMonth = new TableColumn("Month");
        columnMonth.setCellValueFactory(
                new PropertyValueFactory<XYChart.Data, String>("XValue"));

//       columnMonth.setCellFactory(cellFactory);
//       
//       columnMonth.setOnEditCommit(
//               new EventHandler<TableColumn.CellEditEvent<XYChart.Data, String>>() {
//                   @Override public void handle(TableColumn.CellEditEvent<XYChart.Data, String> t) {
//                       ((XYChart.Data)t.getTableView().getItems().get(
//                               t.getTablePosition().getRow())).setXValue(t.getNewValue());
//                   }
//               });
        TableColumn columnValue = new TableColumn("Number");
        columnValue.setCellValueFactory(
                new PropertyValueFactory<XYChart.Data, Number>("YValue"));

        //--- Add for Editable Cell of Value field, in Number
        columnValue.setCellFactory(cellFactory);

        columnValue.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<XYChart.Data, Number>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<XYChart.Data, Number> t) {
                ((XYChart.Data) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setYValue(t.getNewValue());
            }
        });
        tableView.getItems().clear();
        tableView.setItems(dataList);
        tableView.getColumns().addAll(columnMonth, columnValue);
        tableView.setPrefWidth(110);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(tableView, showLineChart());
        Scene sc = new Scene(hbox, 650, 300);
        stage.setResizable(false);
        stage.getIcons().add(new Image(Mhealth.class.getResource("/icon/edit.png").toExternalForm()));
        stage.setScene(sc);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Mhealth.Check = 2;
                stage.close();
            }

        });
    }

    public VBox showLineChart() {
        VBox vbox = new VBox();
//    primaryStage.setTitle("java-buddy.blogspot.com");

//        Group root = new Group();
        //--- Prepare LineChart
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Month");
        yAxis.setLabel("Value");

        final javafx.scene.chart.LineChart<String, Number> lineChart = new javafx.scene.chart.LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Number of people infected per month");
        XYChart.Series series = new XYChart.Series(dataList);
        series.setName("Number of deaths");

        lineChart.getData().add(series);
        lineChart.setLegendVisible(false);
        lineChart.setStyle(font);
        Image image2 = new Image(Home.class.getResourceAsStream("/icon/edit.png"));
        ImageView imageView2 = new ImageView(image2);
        Tooltip tooltip = new Tooltip();
        lineChart.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            if (Mhealth.Check == 2) {
                showTable();
            }
        });

        lineChart.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {

            if (Mhealth.Check == 2) {
                tooltip.setGraphic(imageView2);
                tooltip.setText("Click to edit");
                Tooltip.install(imageView2, tooltip);

                lineChart.setEffect(new DropShadow());
            }

        });
        lineChart.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {

            lineChart.setEffect(null);

        });

//        --- Prepare TableView
//        ---
        HBox hBox = new HBox();
        hBox.setSpacing(10);
//        hBox.getChildren().addAll(tableView, lineChart);
//        hBox.getChildren().addAll(lineChart);

//        root.getChildren().add(hBox);
        vbox.setPrefHeight(500);
        vbox.getChildren().add(lineChart);

//        primaryStage.setScene(new Scene(root, 670, 400));
//        primaryStage.show();
        return vbox;
    }
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("java-buddy.blogspot.com");
//
//        Group root = new Group();
//
//        tableView.setEditable(true);
//        Callback<TableColumn, TableCell> cellFactory
//                = new Callback<TableColumn, TableCell>() {
//            @Override
//            public TableCell call(TableColumn p) {
//                return new EditingCell();
//            }
//        };
//
//        TableColumn columnMonth = new TableColumn("Month");
//        columnMonth.setCellValueFactory(
//                new PropertyValueFactory<XYChart.Data, String>("XValue"));
//
////       columnMonth.setCellFactory(cellFactory);
////       
////       columnMonth.setOnEditCommit(
////               new EventHandler<TableColumn.CellEditEvent<XYChart.Data, String>>() {
////                   @Override public void handle(TableColumn.CellEditEvent<XYChart.Data, String> t) {
////                       ((XYChart.Data)t.getTableView().getItems().get(
////                               t.getTablePosition().getRow())).setXValue(t.getNewValue());
////                   }
////               });
//        TableColumn columnValue = new TableColumn("Value");
//        columnValue.setCellValueFactory(
//                new PropertyValueFactory<XYChart.Data, Number>("YValue"));
//
//        //--- Add for Editable Cell of Value field, in Number
//        columnValue.setCellFactory(cellFactory);
//
//        columnValue.setOnEditCommit(
//                new EventHandler<TableColumn.CellEditEvent<XYChart.Data, Number>>() {
//            @Override
//            public void handle(TableColumn.CellEditEvent<XYChart.Data, Number> t) {
//                ((XYChart.Data) t.getTableView().getItems().get(
//                        t.getTablePosition().getRow())).setYValue(t.getNewValue());
//            }
//        });
//
//        //--- Prepare LineChart
//        final CategoryAxis xAxis = new CategoryAxis();
//        final NumberAxis yAxis = new NumberAxis();
//
//        xAxis.setLabel("Month");
//        yAxis.setLabel("Value");
//
//        final javafx.scene.chart.LineChart<String, Number> lineChart = new javafx.scene.chart.LineChart<>(xAxis, yAxis);
//
//        lineChart.setTitle("LineChart");
//        XYChart.Series series = new XYChart.Series(dataList);
//        series.setName("XYChart.Series");
//        lineChart.getData().add(series);
//
//        //--- Prepare TableView
//        tableView.setItems(dataList);
//        tableView.getColumns().addAll(columnMonth, columnValue);
//
//        //---
//        HBox hBox = new HBox();
//        hBox.setSpacing(10);
//        hBox.getChildren().addAll(tableView, lineChart);
//
//        root.getChildren().add(hBox);
//
//        primaryStage.setScene(new Scene(root, 670, 400));
//        primaryStage.show();
//    }
//
//    Node[] start() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class EditingCell extends TableCell<XYChart.Data, Number> {

        private TextField textField;

        public EditingCell() {
        }

        @Override
        public void startEdit() {
            super.startEdit();

            if (textField == null) {
                createTextField();
            }

            setGraphic(textField);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            textField.selectAll();
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();

            setText(String.valueOf(getItem()));
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }

        @Override
        public void updateItem(Number item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setGraphic(textField);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                } else {
                    setText(getString());
                    setContentDisplay(ContentDisplay.TEXT_ONLY);
                }
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
            textField.setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent t) {
                    if (t.getCode() == KeyCode.ENTER) {
                        commitEdit(Double.parseDouble(textField.getText()));
                    } else if (t.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    }
                }
            });
        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }

}
