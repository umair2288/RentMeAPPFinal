package controller;

import databaseconnector.DBConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.ClientTable;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ClientController implements Initializable{
    @FXML
    TableView<ClientTable> table;

    @FXML TableColumn<ClientTable,String> nic;
    @FXML  TableColumn<ClientTable,String> name;
    @FXML  TableColumn<ClientTable,String> address;
    @FXML  TableColumn<ClientTable,String> carID;
    @FXML  TableColumn<ClientTable,String> contact;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateTable();
    }

    public void populateTable()
    {
        ObservableList<ClientTable> list = FXCollections.observableArrayList();
        String query = "SELECT c.NIC,CONCAT(c.FName,' ',c.LName) AS Name,c.Address,r.CarID,c.Contact\n" +
                "FROM client c,rented_out r \n" +
                "WHERE c.NIC=r.ClientID";

        DBConnect conn= new DBConnect();
        Statement stmt = conn.Connect2DB();
        try {
            ResultSet result= stmt.executeQuery(query);

            while(result.next())
            {

                ClientTable myClient = new ClientTable(result.getString("NIC"),result.getString("Name"),result.getString("Address"),result.getString("CarID"),result.getString("Contact"));
                System.out.println(myClient.getCarID());

                list.add(myClient);

            }


            nic.setCellValueFactory(new PropertyValueFactory<ClientTable,String>("nic"));
            name.setCellValueFactory(new PropertyValueFactory<ClientTable,String>("name"));
            address.setCellValueFactory(new PropertyValueFactory<ClientTable,String>("address"));
            contact.setCellValueFactory(new PropertyValueFactory<ClientTable,String>("contact"));
            carID.setCellValueFactory(new PropertyValueFactory<ClientTable,String>("carID"));


            table.setItems(list);
            //System.out.println("it's hre");
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
