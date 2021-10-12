/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author PamaiKS
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhealth;

import com.sun.javafx.charts.Legend;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.MotionBlur;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.SepiaTone;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author PamaiKS
 */
public class PieChartCovid extends Application {

    Stage stage = new Stage();
    private TextField textField;
// private TableView<PieChart.Data> tableView = new TableView<>();
    private ObservableList<PieChart.Data> dataList = FXCollections.observableArrayList(
            new PieChart.Data("Bangkok", 1489),
            new PieChart.Data("Phuket", 207),
            new PieChart.Data("Nonthaburi", 156),
            new PieChart.Data("Samut Prakan", 111),
            new PieChart.Data("Yala", 116),
            new PieChart.Data("Pattani", 91),
            new PieChart.Data("Chonburi", 91),
            new PieChart.Data("Songkhla", 105),
            new PieChart.Data("Chiang Mai", 40),
            new PieChart.Data("Pathum Thani", 43)
    );

    public VBox pieChart() {
//        BorderPane bp = new BorderPane();
        PieChart pc = new PieChart();
        //pc.setTitle("Top 10 provinces with highest number of COVID-19");
        Image title = new Image(PieChartCovid.class.getResource("/Image/title_black.png").toExternalForm());

        ImageView titleView = new ImageView(title);
        titleView.setFitWidth(470);

        titleView.setPreserveRatio(true);
        titleView.setSmooth(true);
        titleView.setCache(true);
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER);
        header.getChildren().add(titleView);
        pc.setStyle("-fx-font:10 Dekko");
//        ObservableList<PieChart.Data> dataList = FXCollections.observableArrayList(
//                new PieChart.Data("Bangkok", 1489),
//                new PieChart.Data("Phuket", 207),
//                new PieChart.Data("Nonthaburi", 156),
//                new PieChart.Data("Samut Prakan", 111),
//                new PieChart.Data("Yala", 116),
//                new PieChart.Data("Pattani", 91),
//                new PieChart.Data("Chonburi", 91),
//                new PieChart.Data("Songkhla", 105),
//                new PieChart.Data("Chiang Mai", 40),
//                new PieChart.Data("Pathum Thani", 43)
//                
//             
//        );

        pc.setData(dataList);
//        bp.setTop(pc);
        pc.setLegendSide(Side.RIGHT);
        pc.setLabelLineLength(3);
        pc.setLabelsVisible(false);
        pc.setLegendVisible(true);
        pc.setPrefHeight(300);
//        setupAnimation();

        //---
// setupAnimation();
        Group g = new Group();
        StackPane pane = new StackPane();
        g.getChildren().add(pane);

        Label caption = new Label();
        caption.setVisible(false);
        caption.setStyle("-fx-font:16 arial;-fx-background-color:rgba(0,0,0,0.7);"
                + "-fx-background-radius:5;-fx-background-insets: -4 -4 -4 -4"
        );
        caption.setTextFill(Color.WHITE);
        caption.setMinSize(Label.USE_PREF_SIZE, Label.USE_PREF_SIZE);

        pane.getChildren().add(pc);
        pane.getChildren().add(caption);

//        RotateTransition rotate = new RotateTransition();
//        rotate.setAxis(Rotate.Z_AXIS);
//         rotate.setByAngle(360);
//         rotate.setDuration(Duration.minutes(1));
//         rotate.setNode();
//         rotate.play();
        for (PieChart.Data data : pc.getData()) {
//            data.nameProperty().set(data.getName()+ " : "+(int)data.getPieValue()+ " cases");

            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {
//                    JOptionPane.showMessageDialog(null, "Province -- " + data.getName());

                }
            });
            data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
//                    data.getNode().setEffect(new Glow());
//                    data.getNode().setStyle("-fx-border-width:2;fx-border-color:#212121");
                    data.getNode().setEffect(new Glow());

                    caption.setMouseTransparent(true);
                    caption.setTranslateX(e.getX());
                    caption.setTranslateY(e.getY());
                    caption.setText(String.valueOf(/*"Province - "+ */data.getName() + " : " + (int) data.getPieValue() + " cases"));
                    caption.setVisible(true);
//                Tooltip tooltip = new Tooltip("Province --"+ data.getName());
//                tooltip.setStyle("-fx-font:14 arial");
//                //tooltip.setText(String.valueOf("Province -- "+ data.getName()));
//                Tooltip.install(data.getNode(), tooltip);
                }
            });

            data.getNode().addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                //pc.setAnimated(true);
                data.getNode().setEffect(null);
                data.getNode().setStyle("");
                caption.setVisible(false);

            });

        }
        pc.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            if (Mhealth.Check == 2) {
                showTable();

            }
        });

        HBox hboxChart = new HBox();
//        Scene sc = new Scene(bp,700,450);

        hboxChart.setAlignment(Pos.CENTER);
        hboxChart.getChildren().add(g);
        header.setPrefHeight(50);
        hboxChart.setPrefHeight(200);
        VBox vbox1 = new VBox();
        vbox1.getChildren().addAll(header, hboxChart);

//        primaryStage.setScene(sc);
//        primaryStage.setTitle("Please Be Careful");
//        primaryStage.show();
        return vbox1;
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        launch(args);
//    }
    public void showTable() {
        TableView<PieChart.Data> tableView = new TableView<>();
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
                new PropertyValueFactory<PieChart.Data, String>("name"));

        TableColumn columnValue = new TableColumn("Value");
        columnValue.setCellValueFactory(
                new PropertyValueFactory<PieChart.Data, Double>("pieValue"));

        //--- Add for Editable Cell of Value field, in Double
        columnValue.setCellFactory(cellFactory);
        columnValue.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<PieChart.Data, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<PieChart.Data, Double> t) {
                ((PieChart.Data) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setPieValue(t.getNewValue());
            }
        });
        //---
//tableView.setItems(dataList);
//       tableView.getColumns().addAll(columnMonth, columnValue);
        columnMonth.setMinWidth(200);
        columnValue.setMinWidth(100);

        tableView.getItems().clear();
        tableView.setItems(dataList);
        tableView.getColumns().addAll(columnMonth, columnValue);
        tableView.setPrefWidth(300);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(tableView);
        Scene sc = new Scene(hbox, 300, 300);
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

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class EditingCell extends TableCell<PieChart.Data, Double> {

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
        public void updateItem(Double item, boolean empty) {
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
