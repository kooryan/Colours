package sample;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.HashMap;
import java.util.Map;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class Controller {

    //TODO: implement Color library Maps<String, Integer>
    /**
     * perhaps do a Set if no duplicates are wanted.
     */

    @FXML
    ColorPicker colorPicker;

    @FXML
    AnchorPane pane;

    @FXML
    AnchorPane child_pane;

    @FXML
    TextField hexField;

    @FXML
    Button generateCode;

    private static final int LIMIT = 6;

    @FXML
    Slider R;
    @FXML
    Slider G;
    @FXML
    Slider B;

    Map<String, Integer> colorLibrary = new HashMap<>();

    @FXML
    public void changeColor() {

        Color color = colorPicker.getValue();
        pane.setBackground(new Background(new BackgroundFill(Paint.valueOf(color.toString()), CornerRadii.EMPTY, Insets.EMPTY)));

    }

    @FXML
    public void limitText() {

        //TODO: CLEAN UP
        Pattern pattern = Pattern.compile(".{0,6}");
        TextFormatter formatter = new TextFormatter((UnaryOperator<TextFormatter.Change>)(change) -> {
            return pattern.matcher(change.getControlNewText()).matches() ? change : null;
        });
        TextFormatter formatter1 = new TextFormatter<Object>((change) -> {
            change.setText(change.getText().toUpperCase());
            return change;
        });


        hexField.setTextFormatter(formatter);
        hexField.setTextFormatter(formatter1);


        hexField.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    if (!newValue.matches("[A-F]*") || !newValue.matches("\\d*")) {
                        hexField.setText(newValue.replaceAll("[G-Z]*", ""));
                    }
                });

    }

    @FXML
    public void enterHexCode() {
        Color color = Color.web("#" + hexField.getText());
        pane.setBackground(new Background(new BackgroundFill(Paint.valueOf(color.toString()), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void addNewColor() {

    }

    public void menuBar() {

    }

    public void findHtmlCode() { // probably won't be used
        // binary search ?
    }

    public void setRGBSliders() {
        pane.setBackground(new Background(new BackgroundFill(Color.rgb((int) R.getValue(), (int) G.getValue(), (int) B.getValue()),
                CornerRadii.EMPTY, Insets.EMPTY)));
        hexField.setText(String.format("%2X%02X%02X", (int) R.getValue(), (int) G.getValue(), (int) B.getValue()));
    }

    public void setHSVSliders() {

    }

    @FXML
    public void generateHexCode() {
        String code = genCode();
        Color color = Color.web("#" + code);
        hexField.setText("");
        hexField.setText(code);
        pane.setBackground(new Background(new BackgroundFill(Paint.valueOf(color.toString()), CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public static String genCode() {
        String[] letters;
        letters = "0123456789ABCDEF".split("");
        String code = "";
        for (int i = 0; i < 6; i++) {
            double ind = Math.random() * 15;
            int index = (int) Math.round(ind);
            code += letters[index];
        }
        return code;
    }


//TODO everything needs css in this neighborhood

    // implement add [+] new color option

    // implement menu bar

    // implement html color code searcher

//TODO: CSS for sliders

    //implement rgb slider

    // implement hsv slider

    // implement . . .

}
