package practice07.FileChooser;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FileChooserController {

	@FXML
	Button btn1;

	@FXML
	Button btn2;

	@FXML
	ListView<String> listview;

	@FXML
	ImageView img, img2;
	@FXML
	Spinner<Integer> spin;
	@FXML
	GridPane gridp;
	
	Spinner<Integer> testspin= new Spinner<Integer>(4,24,4,4);
	private int  setvalue() {
		int a = testspin.getValue();
		if (a==2) {
			return 4;
		}else
			return a+=a;
	}
	Button btn = new Button("Show spin Value");
	Button btn4= new Button("Show spin Value");
	public void initialize() {
		gridp.add(testspin, 0, 0);
		gridp.add(btn, 0, 1);
		gridp.add(btn2, 1, 2);
		gridp.add(btn4, 2, 1);
		btn.setOnAction(e->{
			System.out.println(testspin.getValue());
		});
	}
	
	
	
	public void setupspinner() {
		spin.setValueFactory(valueFactory);
		
	}
	
	
	public void show(ActionEvent e) {
		
		System.out.println(spin.getValue());
		
	}
//	
//	final Spinner<Integer> spinner = new Spinner<Integer>();
//	 
    final int initialValue = 3;
//
//    // Value factory.
    SpinnerValueFactory<Integer> valueFactory = //
            new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, initialValue);
//
  

	

	// it keeps showing this error search for it later
	// Qt: Untested Windows version 10.0 detected!

	public void btnClicked1(ActionEvent e) throws MalformedURLException {
		FileChooser fc = new FileChooser();
		//if you want to open a particular director
		fc.setInitialDirectory(new File ("C:\\Users\\Chinedu\\Documents\\Programming"));
		//to add a filter
		//fc.getExtensionFilters().addAll(new ExtensionFilter("Showing PDF Files "," *pdf" ));
		File seletedfile = fc.showOpenDialog(null);
		//for the image
		String localUrl = seletedfile.toURI().toURL().toString();
		Image localImage = new Image(localUrl, false);
		
		if (seletedfile != null) {
			listview.getItems().add(seletedfile.getName());
			img.setImage(localImage);
			//img.
			/*
			 * File file = new File("C:\\Users\\jdoe\\Pictures\\myphoto.jpg");
			 * String localUrl = file.toURI().toURL().toString();
			 * Image localImage = new Image(localUrl, false); // don't load in the background
			 * Image image = new Image(url, true);
			 * ImageView imageView = new ImageView(image);
			 */
		}else
			System.out.println("Nothing here");

	}

	public void btnClicked2(ActionEvent e) {
		FileChooser fc = new FileChooser();
		// if you want to open a particular director
		fc.setInitialDirectory(new File("C:\\Users\\Chinedu\\Documents\\Programming"));
		// to add a filter
		fc.getExtensionFilters().addAll(new ExtensionFilter("Showing PDF Files ", " *pdf"));
		List<File> seletedfiles = fc.showOpenMultipleDialog(null);

		if (seletedfiles != null) {
			for (int j = 0; j < seletedfiles.size(); j++)
				listview.getItems().add(seletedfiles.get(j).getName());
		} else
			System.out.println("Nothing here");

	}//end btnclick
	
	public void changeImage(MouseEvent e) throws MalformedURLException {
		FileChooser fc = new FileChooser();
		File seletedfile = fc.showOpenDialog(null);
		//for the image
		if (seletedfile != null) {
			String localUrl = seletedfile.toURI().toURL().toString();
			Image localImage = new Image(localUrl, false);
			img2.setImage(localImage);}
		
	}//end change image
	
	
}
