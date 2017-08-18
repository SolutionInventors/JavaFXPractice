/**
 * 
 */
package practice13.TableView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author ChineduKnight
 */
public class TableViewCotroller implements Initializable{

	@FXML private TableView<Student>table;
	@FXML private TableColumn<Student, Integer>id;
	@FXML private TableColumn<Student, String>name;
	@FXML private TableColumn<Student, String>surname;
	@FXML private TableColumn<Student, Integer>age;
	
	public ObservableList<Student> list = FXCollections.observableArrayList(
			new Student(1,"Norbert", "Edomah", 27),
			new Student(2,"Kelvin", "Enumah", 23),
			new Student(3,"Michel", "John", 29),
			new Student(4,"Segun", "francis", 28),
			new Student(5,"chidi", "Ogu", 20)
			);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		id.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
		name.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
		surname.setCellValueFactory(new PropertyValueFactory<Student, String>("surname"));
		age.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));
		table.setItems(list);
	}
}//end class
