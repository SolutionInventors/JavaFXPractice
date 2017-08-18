/**
 * @author ChineduKnight Oguejiofor
 *21 Jul. 2017
 * 12:28:02 pm
 */
package practice05.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class ComboController implements Initializable {
	@FXML
	public Label mylabel;

	@FXML
	public ComboBox<String> combobox;
	
	@FXML
	public ListView<String> listview;

	ObservableList<String> list = FXCollections.observableArrayList("Java",
			"Phython", "VBA", "Projects");

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		combobox.setItems(list);
		listview.setItems(list);
		listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
	}

	public void comboChanged(ActionEvent e) {
		mylabel.setText(combobox.getValue());
	}

	public void addItems(ActionEvent e) {
		combobox.getItems().addAll("C++", "C#", "Android", "Future");
		listview.getItems().addAll("C++", "C#", "Android", "Future");
		//to show the items  selected in the console
		
		ObservableList<String> selected;
		selected = listview.getSelectionModel().getSelectedItems();
		for (String string : selected) {
			System.out.println(string);
		}
		
	}
}
