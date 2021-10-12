package mhealth;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MapTable extends Application {

    Stage window = new Stage();
    TableView<Product> table;
    TextField provinceInput, infectedInput, deathInput;

//    public static void main(String[] args) {
//        launch(args);
//    }
    public void showTable() {
        window.close();
        window.setTitle("Detials");
        window.getIcons().add(new Image(Mhealth.class.getResource("/icon/read.png").toExternalForm()));
        //Name column
        TableColumn<Product, String> nameColumn = new TableColumn<>("Province");
        nameColumn.setMinWidth(180);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("province"));

        //Price column
        TableColumn<Product, Integer> priceColumn = new TableColumn<>("Infected");
        priceColumn.setMinWidth(120);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("infected"));

        //Quantity column
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Death");
        quantityColumn.setMinWidth(120);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("death"));

        //Name input
        provinceInput = new TextField();
        provinceInput.setPromptText("Province");
        provinceInput.setMaxWidth(100);

        //Price input
        infectedInput = new TextField();
        infectedInput.setPromptText("Infected");
        infectedInput.setMaxWidth(70);

        //Quantity input
        deathInput = new TextField();
        deathInput.setPromptText("Death");
        deathInput.setMaxWidth(70);

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());
        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);
        HBox hBox = new HBox();
        VBox vBox = new VBox();
        if (Mhealth.Check == 2) {
            hBox.setPadding(new Insets(10, 10, 10, 10));
            hBox.setSpacing(10);
            hBox.getChildren().addAll(provinceInput, infectedInput, deathInput, addButton, deleteButton);
            vBox.getChildren().addAll(table, hBox);
        } else {
            vBox.getChildren().addAll(table);
        }

        window.setResizable(false);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //Add button clicked
    public void addButtonClicked() {
        Product product = new Product();
        product.setProvince(provinceInput.getText());
        product.setInfected(Integer.parseInt(infectedInput.getText()));
        product.setDeath(Integer.parseInt(deathInput.getText()));
        table.getItems().add(product);
        provinceInput.clear();
        infectedInput.clear();
        deathInput.clear();
    }

    //Delete button clicked
    public void deleteButtonClicked() {
        ObservableList<Product> productSelected, allProducts;
        allProducts = table.getItems();
        productSelected = table.getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }

    //Get all of the products
    public ObservableList<Product> getProduct() {
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Bangkok", 1489, 23));
        products.add(new Product("Phuket", 207, 1));
        products.add(new Product("Nonthaburi", 156, 2));
        products.add(new Product("Samut Prakan", 111, 5));
        products.add(new Product("Yala", 116, 2));
        products.add(new Product("Pattani", 91, 1));
        products.add(new Product("Chonburi", 91, 2));

        products.add(new Product("Songkhla", 105, 0));
        products.add(new Product("Chiang Mai", 40, 1));
        products.add(new Product("Pathum Thani", 43, 2));
        products.add(new Product("Nakhon Ratchasima", 18, 0));
        products.add(new Product("Prachuap Khiri Khan", 17, 2));
        products.add(new Product("Chumphon", 21, 2));
        products.add(new Product("Narathiwat", 33, 1));
        return products;
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
