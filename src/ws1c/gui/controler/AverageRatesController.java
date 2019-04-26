package ws1c.gui.controler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ws1c.client.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;

public class AverageRatesController implements Initializable {

    @FXML
    public MenuItem buttonClose;

    @FXML
    private TableView<DataCreditsLoans> tableView;

    @FXML
    private TableColumn<DataCreditsLoans, String> companyID;
    @FXML
    private TableColumn<DataCreditsLoans, String> companyName;
    @FXML
    private TableColumn<DataCreditsLoans, String> currency;
    @FXML
    private TableColumn<DataCreditsLoans, Double> averageWeightedRate;

    @FXML
    void buttonCloseOnAction(ActionEvent event) {

        MenuItem menuItem = (MenuItem) event.getTarget();
        ContextMenu cm = menuItem.getParentPopup();
        Stage stage = (Stage) cm.getOwnerWindow();

        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        companyID.setCellValueFactory(new PropertyValueFactory<>("companyID"));
        companyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        currency.setCellValueFactory(new PropertyValueFactory<>("currency"));

        NumberFormat currencyFormat = NumberFormat.getInstance();

        averageWeightedRate.setCellValueFactory(new PropertyValueFactory<>("averageWeightedRate"));
        averageWeightedRate.setCellFactory(tc -> new TableCell<DataCreditsLoans, Double>() {
            @Override
            protected void updateItem(Double price, boolean empty) {
                super.updateItem(price, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(currencyFormat.format(price));
                }
            }
        });
    }

    public void setTableViewData(TableAverageWeightedRates tableAverageWeightedRates) {

        ObservableList observableList = FXCollections.observableList(tableAverageWeightedRates.getDataAverageWeightedRates());

        tableView.setItems(observableList);
    }
}
