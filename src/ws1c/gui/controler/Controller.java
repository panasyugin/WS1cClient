package ws1c.gui.controler;
import ws1c.client.*;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceException;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private AuthResult authResult;

    private AuthController authController;
    private AverageRatesController averageRateController;

    @FXML
    public MenuItem buttonClose;

    @FXML
    public MenuItem buttonGetDataForDashBoard;

    @FXML
    public MenuItem buttonGetMaxDebt;

    @FXML
    public MenuItem buttonGetAverageWeightedRates;

    @FXML
    private TableView<DataCreditsLoans> tableView;

    @FXML
    private TableColumn<DataCreditsLoans, String> companyID;
    @FXML
    private TableColumn<DataCreditsLoans, String> companyName;
    @FXML
    private TableColumn<DataCreditsLoans, String> companyType;
    @FXML
    private TableColumn<DataCreditsLoans, String> segment;
    @FXML
    private TableColumn<DataCreditsLoans, String> territoriality;
    @FXML
    private TableColumn<DataCreditsLoans, String> creditorID;
    @FXML
    private TableColumn<DataCreditsLoans, String> creditorName;
    @FXML
    private TableColumn<DataCreditsLoans, String> creditSecurity;
    @FXML
    private TableColumn<DataCreditsLoans, XMLGregorianCalendar> loanPeriod;
    @FXML
    private TableColumn<DataCreditsLoans, String> loanForm;
    @FXML
    private TableColumn<DataCreditsLoans, String> currency;
    @FXML
    private TableColumn<DataCreditsLoans, Double> limit;
    @FXML
    private TableColumn<DataCreditsLoans, Double> limitInCurrency;
    @FXML
    private TableColumn<DataCreditsLoans, XMLGregorianCalendar> balanceDate;
    @FXML
    private TableColumn<DataCreditsLoans, Double> remainingDebt;
    @FXML
    private TableColumn<DataCreditsLoans, Double> remainingDebtInCurrency;

    @FXML
    void buttonCloseOnAction(ActionEvent event) {

        //MenuItem menuItem = (MenuItem) event.getTarget();
        //ContextMenu cm = menuItem.getParentPopup();
        //Stage stage = (Stage) cm.getOwnerWindow();

        //stage.close();

        //System.exit(0);

        Platform.exit();
    }

    @FXML
    void buttonGetDataForDashBoardOnAction(ActionEvent event) throws IOException, DatatypeConfigurationException {

        AuthResult authRes = authAndGetProxy();

        GetDataForDashBoardPortType portType = authRes.portType;
        LocalDate date = authRes.date;

        if (portType == null)
            return;

        // Выполняем вызов web-сервиса
        GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
        XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);

        TableCreditsLoans loanData = portType.getLoanData(xmlDate);

        ObservableList observableList = FXCollections.observableList(loanData.getDataCreditsLoans());

        tableView.setItems(observableList);
    }

    @FXML
    void buttonGetMaxDebtOnAction(ActionEvent event) throws IOException, DatatypeConfigurationException {

        AuthResult authRes = authAndGetProxy();

        GetDataForDashBoardPortType portType = authRes.portType;
        LocalDate date = authRes.date;

        if (portType == null)
            return;

        // Выполняем вызов web-сервиса
        GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
        XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);

        TableCreditsLoans loanData = portType.getMaxDebt(xmlDate);

        ObservableList observableList = FXCollections.observableList(loanData.getDataCreditsLoans());

        tableView.setItems(observableList);
    }

    void setAuthControler(AuthController c){
        authController = c;
    }

    void setAverageRateController(AverageRatesController c){
        averageRateController = c;
    }

    @FXML
    void buttonGetAverageWeightedRatesOnAction(ActionEvent event) throws IOException, DatatypeConfigurationException {

        AuthResult authRes = authAndGetProxy();

        GetDataForDashBoardPortType portType = authRes.portType;
        LocalDate date = authRes.date;

        if (portType == null)
            return;

        // Выполняем вызов web-сервиса
        GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
        XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);

        TableAverageWeightedRates ratesData = portType.getAverageWeightedRates(xmlDate);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ws1c/gui/views/averageRates.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Средневзвешенные ставки");
        stage.setScene(scene);

        AverageRatesController controller = loader.getController();
        setAverageRateController(controller);

        controller.setTableViewData(ratesData);

        stage.showAndWait();
    }

    AuthResult authAndGetProxy() throws IOException {

        if (authResult != null)
            return authResult;

        GetDataForDashBoardPortType portType = null;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ws1c/gui/views/auth.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.setTitle("Укажите дату запроса и праметры авторизации");

        stage.setScene(scene);

        AuthController authC = loader.getController();

        setAuthControler(authC);

        authC.setDefaultLogin();

        stage.showAndWait();

        String login = authC.getLogin();
        String pass = authC.getPassword();
        LocalDate date = authC.getDate();

        if (authC.isTerminated())
            return new AuthResult(portType, date);

        // Получаем порт для вызова операции web-сервиса
        Authenticator myAuth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(login, pass.toCharArray());
            }
        };

        Authenticator.setDefault(myAuth);

        GetDataForDashBoard proxy;

        try {
            proxy = new GetDataForDashBoard();
        }
        catch (WebServiceException e){
            System.out.println(e.getMessage());
            return new AuthResult(portType, date);
        }

        portType = proxy.getGetDataForDashBoardSoap();

        authResult = new AuthResult(portType, date);

        return authResult;
    }

    AuthController getAuthController(){
        return authController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        companyID.setCellValueFactory(new PropertyValueFactory<>("companyID"));
        companyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        companyType.setCellValueFactory(new PropertyValueFactory<>("companyType"));
        segment.setCellValueFactory(new PropertyValueFactory<>("segment"));
        territoriality.setCellValueFactory(new PropertyValueFactory<>("territoriality"));
        creditorID.setCellValueFactory(new PropertyValueFactory<>("creditorID"));
        creditorName.setCellValueFactory(new PropertyValueFactory<>("creditorName"));
        creditSecurity.setCellValueFactory(new PropertyValueFactory<>("creditSecurity"));
        loanPeriod.setCellValueFactory(new PropertyValueFactory<>("loanPeriod"));
        loanForm.setCellValueFactory(new PropertyValueFactory<>("loanForm"));
        currency.setCellValueFactory(new PropertyValueFactory<>("currency"));
        balanceDate.setCellValueFactory(new PropertyValueFactory<>("balanceDate"));

        NumberFormat currencyFormat = NumberFormat.getInstance();

        limitInCurrency.setCellValueFactory(new PropertyValueFactory<>("limitInCurrency"));
        limitInCurrency.setCellFactory(tc -> new TableCell<DataCreditsLoans, Double>() {

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

        limit.setCellValueFactory(new PropertyValueFactory<>("limit"));
        limit.setCellFactory(tc -> new TableCell<DataCreditsLoans, Double>() {

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

        remainingDebt.setCellValueFactory(new PropertyValueFactory<>("remainingDebt"));
        remainingDebt.setCellFactory(tc -> new TableCell<DataCreditsLoans, Double>() {

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

        remainingDebtInCurrency.setCellValueFactory(new PropertyValueFactory<>("remainingDebtInCurrency"));
        remainingDebtInCurrency.setCellFactory(tc -> new TableCell<DataCreditsLoans, Double>() {

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

    private class AuthResult {

        private LocalDate date;

        private GetDataForDashBoardPortType portType;

        public AuthResult(GetDataForDashBoardPortType portType, LocalDate date) {
            this.portType = portType;
            this.date = date;
        }
    }
}
