package ws1c.gui.controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Auth implements Initializable {

    private boolean isTerminated;

    @FXML
    private Button getDataButton;

    @FXML
    private Button closeAuthButton;

    @FXML
    private DatePicker dateField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginField;

    public boolean isTerminated(){
        return isTerminated;
    }

    public LocalDate getDate(){
        return dateField.getValue();
    }

    public String getLogin(){
        return loginField.getText();
    }

    public void setDefaultLogin(){
        loginField.setText("GetDataForDashBoard");
    }

    public String getPassword(){
        return passwordField.getText();
    }

    @FXML
    void getDataButtonOnAction(ActionEvent event) {

        Button button = (Button) event.getTarget();
        Stage stage = (Stage) button.getScene().getWindow();

        isTerminated = false;

        stage.close();
    }

    @FXML
    void closeAuthButtonOnAction(ActionEvent event) {

        Button button = (Button) event.getTarget();
        Stage stage = (Stage) button.getScene().getWindow();

        isTerminated = true;

        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dateField.setValue(LocalDate.now());
    }
}

