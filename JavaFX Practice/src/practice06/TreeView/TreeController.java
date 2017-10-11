/**
 * @author ChineduKnight Oguejiofor
 *22 Jul. 2017
 * 9:26:54 am
 */
package practice06.TreeView;

import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class TreeController  {
	//Image icon = new Image(getClass().getResourceAsStream("/img/icon.png"));
	Image icon = new Image(getClass().getResourceAsStream("/img/icon2.png"));
	@FXML TreeView<String> treeview;

	@SuppressWarnings("unchecked")
	public void initialize() {
		TreeItem<String> root = new TreeItem<>("This PC",new ImageView(icon));
		root.setExpanded(true);//to expande by default
		//Text t = new Text(10, 50, "This is a test");

		TreeItem<String> nodeA = new TreeItem<>("Desktop");
		//.location.TreeItem<Text> nodeB = new TreeItem<>(t);
		TreeItem<String> nodeB = new TreeItem<>("Documents",new ImageView(icon));
		TreeItem<String> nodeC = new TreeItem<>("Downloads",new ImageView(icon));
		
		//to be added to nodeA
		TreeItem<String> nodeA1 = new TreeItem<>("Work",new ImageView(icon));
		TreeItem<String> nodeB1 = new TreeItem<>("Recycle Bin ",new ImageView(icon));
		TreeItem<String> nodeC1 = new TreeItem<>("Code School",new ImageView(icon));
		
		//to be added to nodeC
		TreeItem<String> longText = new TreeItem<>("sdJavaFX provides capabilities to interoperate with HTML5 content. The underlying web page–\r\n" + 
				"rendering engine in JavaFX is the popular open-source API called WebKit. This API is used in Apple’s\r\n" + 
				"Safari browsers, Amazon’s Kindle devices, and was used in Google’s Chrome browser prior to\r\n" + 
				"version 27 (the WebKit fork called Blink). HTML5 is the newly accepted standard markup language\r\n" + 
				"for rendering content in web browsers. HTML5 content consists of JavaScript, CSS, Scalable Vector\r\n" + 
				"Graphics (SVG), Canvas API, Media, XML, and new HTML element tags.");
		
		nodeA.getChildren().addAll(nodeA1,nodeB1,nodeC1);
		nodeC.getChildren().add(longText);
		
		root.getChildren().add(nodeA);
		root.getChildren().add(nodeB);
		root.getChildren().add(nodeC);
		
		
		
		
		
		treeview.setRoot(root);

	}//end initialize method
	//note
	//you have to set this method in the fxml file
	//both in on context menu request and on mouse clicked
	
	public void mouseClicked(MouseEvent e) {
		TreeItem<String> item = treeview.getSelectionModel().getSelectedItem();
		System.out.println(item.getValue());
		//if (e.getClickCount() == 2) {
			
			if (item.getValue().equals("Desktop")) {
				System.out.println("I have caught you");
		//	}
			
		}
	}

}
