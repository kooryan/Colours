package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Controller {
    @FXML
    Slider colorRed;
    @FXML
    ColorPicker colorPicker;
    @FXML
    AnchorPane pane;

    @FXML
    public void changeColor(ActionEvent actionEvent){

        // get rid of color picker and use custom one
        Color color = colorPicker.getValue();
        pane.setBackground(new Background(new BackgroundFill(Paint.valueOf(color.toString()), CornerRadii.EMPTY, Insets.EMPTY)));


    }

    public void addNewColor() {

    }

    public void menuBar() {

    }

    public void findHtmlCode() {

    }


// everything needs css in this neighborhood...

    // implement add [+] new color option

    // implement menu bar

    // implement html color code searcher

// CSS for sliders

    //implement rgb slider

    // implement hsv slider

    // implement . . .



}
