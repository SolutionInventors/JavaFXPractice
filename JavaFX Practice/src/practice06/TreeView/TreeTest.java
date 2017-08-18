/**
 * @author ChineduKnight Oguejiofor
 *22 Jul. 2017
 * 9:26:47 am
 */
package practice06.TreeView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TreeTest extends Application{

	@Override
	public void start(Stage primaryStage) {
		try {
			//Parent root = FXMLLoader.load(getClass().getResource("Tree.fxml"));
			
			Parent root = FXMLLoader.load(getClass().getResource("\\deeper/Tree.fxml"));
																//practice06\TreeView\deeper\Tree.fxml
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setTitle("Tree View");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
