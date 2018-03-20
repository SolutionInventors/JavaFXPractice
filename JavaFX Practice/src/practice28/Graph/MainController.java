package practice28.Graph;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

public class MainController {
	@FXML PieChart piechart;
	
	public void btn(ActionEvent event) {
		//import piechart data
		ObservableList<Data> list = FXCollections.observableArrayList(
				new PieChart.Data("Java", 52),
				new PieChart.Data("c++", 42),
				new PieChart.Data("phython", 34),
				new PieChart.Data("JS", 92),
				new PieChart.Data("others", 22)
				
				);
		piechart.setData(list);
	}
}
