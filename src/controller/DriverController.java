package controller;

import databaseconnector.DBConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DriverTable;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class DriverController implements Initializable{
    @FXML
    TableView<DriverTable> table;


    @FXML  TableColumn<DriverTable,String> name;
    @FXML  TableColumn<DriverTable,String> driverID;
    @FXML  TableColumn<DriverTable,String> licenceNo;
    @FXML  TableColumn<DriverTable,String> availability;
    @FXML  TableColumn<DriverTable,String> contact;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateTable();
    }

    public void populateTable()
    {
        ObservableList<DriverTable> list = FXCollections.observableArrayList();
        String query = "SELECT D.DriverID,CONCAT(E.FNAME,' ',E.LNAME) AS Name,D.LicenceNo,D.Contact,D.Availability\n" +
                "FROM Driver D, rentemp E\n" +
                "WHERE D.DriverID=E.EMP_NO;";


        DBConnect conn= new DBConnect();

        Statement stmt = conn.Connect2DB();
        try {
            ResultSet result= stmt.executeQuery(query);

            while(result.next())
            {

                DriverTable myDriver = new DriverTable(result.getString("DriverID"),result.getString("Name"),result.getString("LicenceNo"),result.getString("Availability"),result.getString("Contact"));
                System.out.println(myDriver.getDriverID());
                list.add(myDriver);

            }


            driverID.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("driverID"));
            name.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("name"));
            licenceNo.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("licenceNo"));
            contact.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("contact"));
            availability.setCellValueFactory(new PropertyValueFactory<DriverTable,String>("availability"));


            table.setItems(list);
            //System.out.println("it's hre");
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
