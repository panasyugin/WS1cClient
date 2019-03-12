package ws1c.gui.controler;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import ws1c.client.DataCreditsLoans;
import ws1c.client.GetDataForDashBoard;
import ws1c.client.GetDataForDashBoardPortType;
import ws1c.client.TableCreditsLoans;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceException;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.List;

public class Controler {

    private Auth authControler;

    @FXML
    public MenuItem buttonClose;

    @FXML
    public MenuItem buttonGetDataForDashBoard;

    @FXML
    private TableView<DataCreditsLoans> tableView;

    @FXML
    private TableColumn<DataCreditsLoans, String> companyID;

    @FXML
    private TableColumn<DataCreditsLoans, String> companyName;

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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ws1c/gui/views/auth.fxml"));

        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.setTitle("Укажите дату запроса и праметры авторизации");

        stage.setScene(scene);

        Auth authC = loader.getController();

        setAuthControler(authC);

        authC.setDefaultLogin();

        stage.showAndWait();

        String login = authC.getLogin();
        String pass = authC.getPassword();
        LocalDate date = authC.getDate();

        if (authC.isTerminated())
            return;

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
            return;
        }

        GetDataForDashBoardPortType portType = proxy.getGetDataForDashBoardSoap();

        // Выполняем вызов web-сервиса
        GregorianCalendar gcal = GregorianCalendar.from(date.atStartOfDay(ZoneId.systemDefault()));
        XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);

        TableCreditsLoans loanData = portType.getLoanData(xmlDate);

        ObservableList observableList = FXCollections.observableList(loanData.getDataCreditsLoans());

        TableColumn<DataCreditsLoans, String> companyTypeCol = new TableColumn<DataCreditsLoans, String>("Company type");

        companyTypeCol.setCellValueFactory(new PropertyValueFactory<>("companyType"));
        tableView.getColumns().add(companyTypeCol);

        tableView.setItems(observableList);
    }

    void setAuthControler(Auth c){
        authControler = c;
    }

    Auth getAuthControler(){
        return authControler;
    }

}
