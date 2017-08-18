package practice13.TableView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
//creating a table with code
    Stage window;
    @SuppressWarnings("unchecked")
	TableView<Product> table[] = new TableView[3];

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("unchecked")
	@Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("thenewboston - JavaFX");
       // table[0] = 
        //array test
        TableColumn<Product, String> name[] = new TableColumn[3];
        for (int i = 0; i < name.length; i++) {
        	 name[i] = new TableColumn<>("Competitor Name");
        	 name[i].setMinWidth(200);
             name[i].setCellValueFactory(new PropertyValueFactory<>("nameg"));
		}
        
        
        //test array for single table double for price and quantity
       
        
        String priqan[] = {"price","quantity"};
        TableColumn<Product, Double> pricedouble[][] = new TableColumn[2][2];
        for (int row = 0; row < pricedouble.length; row++) {
			for (int col = 0; col < pricedouble[row].length; col++) {
				pricedouble[row][col] = new TableColumn<>(priqan[col]);
		        pricedouble[row][col].setMinWidth(5);
		        pricedouble[row][col].setCellValueFactory(new PropertyValueFactory<>(priqan[col]));
		        
			}
		}
        
        table[0] = new TableView<>();
        table[0].setItems(getProduct());
        table[0].getColumns().addAll(name[0], pricedouble[0][0] , pricedouble[0][1]);

        table[1] = new TableView<>();
        table[1].setItems(getProduct());
        table[1].getColumns().addAll(name[1], pricedouble[0][0], pricedouble[0][1]);
        
        table[2] = new TableView<>();
        table[2].setItems(getProduct3());
        table[2].getColumns().addAll(name[2],  pricedouble[1][0],  pricedouble[1][1]);
        
      Button btn = new Button("Click Me");
        
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(new Label("Standing"),new Label("Group A"),table[0],new Label("Group B"),table[1],btn,table[2]);
        
        ScrollPane sp = new ScrollPane(vBox);
        sp.setPrefSize(table[1].getWidth(), 300);
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        
        Scene scene = new Scene(sp);
        window.setScene(scene);
        window.show();
    }

    String abc [] = {"first","second","third","fourth","fifth"};
    int num1[] = {12,21,12,12,12};
    double num2[] = {12,21,12,12,12};
    //Get all of the products
    
  //Get all of the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> items = FXCollections.observableArrayList();
        items.add(new Product("John", 859.00, 3434434));
        items.add(new Product("Mike Ball", 2.49, 343434));
        items.add(new Product("sdf", 99.00, 74));
        items.add(new Product("The Notebook DVD", 19.99, 6565));
        items.add(new Product("Corn", 1.49, 123));
        return items;
    }

    public ObservableList<Product> getProduct3(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(0,new Product("Just", 859.00, 111));
        products.add(new Product("To change", 2.49, 222));
        products.add(new Product("abit", 99.00, 777));
        products.add(new Product("The names", 19.99, 333));
        products.add(new Product("see", 1.49, 123));
        return products;
    }
    
    public ObservableList<Product> testProduct(){
    	  ObservableList<Product> items = FXCollections.observableArrayList();
    	  ObservableList<Product> products = FXCollections.observableArrayList();
    	  List< ObservableList<Product>> combine = FXCollections.observableArrayList();
    	combine.add(0, items );
    	combine.addAll(combine);
    	Map< String, Integer > map = new HashMap< String, Integer >();
    	map.put("ac", 23);
    	Map< Integer,  Product > map2 = new HashMap< Integer,  Product >();
    	map2.put(0, new Product("Just", 859.00, 111));
    	map2.put(1, new Product("Just", 859.00, 111));
    	
    	return null;
    	
    }

}