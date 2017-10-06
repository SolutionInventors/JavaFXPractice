package practice22.MediaAudio.java.com.ita.ui;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;

import java.io.IOException;

/**
 * Created by itachi on 14/2/15.
 */
public class SliderBar extends StackPane {

    @FXML
    private Slider slider;

    @FXML
    private ProgressBar progressBar;


    public SliderBar() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/com/ita/fxml/sliderbar.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        getStylesheets().add(getClass().getResource("/com/ita/style/sliderbar.css").toExternalForm());
        bindValues();
    }

    private void bindValues(){
        progressBar.prefWidthProperty().bind(slider.widthProperty());
        progressBar.progressProperty().bind(slider.valueProperty().divide(100));
    }

    public DoubleProperty sliderValueProperty() {
        return slider.valueProperty();
    }

    public boolean isTheValueChanging() {
        return slider.isValueChanging();
    }
}
