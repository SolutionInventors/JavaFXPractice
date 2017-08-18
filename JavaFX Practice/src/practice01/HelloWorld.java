/**
 * @author ChineduKnight Oguejiofor
 *19 Jul. 2017
 * 10:49:35 pm
 */
package practice01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloWorld extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btn = new Button("Click me");
		Button exit = new Button("Exit Dont click");
		//lambds
		exit.setOnAction(e -> System.exit(0));
		//add action listener
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");//on action do this
			}
			
		});
		
		//StackPane root = new StackPane();//this is the layout
		VBox root = new VBox();//another layout
	//	root.getChildren().add(btn);//add the button to the layout
		root.getChildren().addAll(exit,btn);
		Scene scene = new Scene(root,500,500);//create a scene with size
		primaryStage.setTitle("this is my practice");
		primaryStage.setScene(scene);//add scene to stage
		primaryStage.show();//display scene
	}

}
