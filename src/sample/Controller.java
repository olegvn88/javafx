package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class Controller implements Initializable {

    @FXML
    private Label faceslabel;
    @FXML
    private Label diceslabel;
    @FXML
    private Label rollslabel;

    @FXML
    private TextField facesInput;
    @FXML
    private TextField dicesInput;
    @FXML
    private TextField rollsInput;

    @FXML
    private Label resultValue;
    @FXML
    private Label resultLabel;

    public void clickOnButton() {
        Integer value = Integer.valueOf(facesInput.getText()) +
                Integer.valueOf(dicesInput.getText()) + Integer.valueOf(rollsInput.getText());
        resultValue.setText(value.toString());
        System.out.println("Button is clicked");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<TextField> list = new ArrayList<>();
        list.add(facesInput);
        list.add(dicesInput);
        list.add(rollsInput);
        setNumericValue(list);
    }

    private void setNumericValue(List<TextField> list) {
        IntStream.range(0, list.size()).forEach(x -> {
            int index = x;
            list.get(x).textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue,
                                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        list.get(x).setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });
        });
    }
}
