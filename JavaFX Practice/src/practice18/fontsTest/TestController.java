package practice18.fontsTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class TestController {
	
	@FXML private List<Label> SNArray;

	public void initialize() throws FileNotFoundException, URISyntaxException {
		URL url = getClass().getResource("/resources/fonts/TRON.TTF"); 
		URL url2 = getClass().getResource("/practice18/fontsTest/Pristina.ttf");
		final Font f = Font.loadFont(new FileInputStream(new File(url.toURI())), 19);
		final Font f2 = Font.loadFont(new FileInputStream(new File(url2.toURI())), 99);
		for (int i = 0; i < SNArray.size(); i++) {
			SNArray.get(i).setFont(f2);
		}
	}
}
