package controller;

import databaseconnector.DBConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.RentEntry;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdminController implements Initializable{


    @FXML  TableView<RentEntry> table;
    @FXML  TableColumn<RentEntry,String> carID,model,clientID,clientName;
    @FXML   Button btnAddCar,btnAddClient,btnAddDriver,btnAddEmployee,btnAddUser,btnDecline;
   /* @FXML  TableColumn<RentEntry,String> model;
    @FXML  TableColumn<RentEntry,String> clientID;
    @FXML  TableColumn<RentEntry,String> clientName;*/
 //   @FXML  TableColumn<RentEntry,String> approval;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateTable();
    }

    public void populateTable()
    {
        ObservableList<RentEntry> list = FXCollections.observableArrayList();
        String query = "SELECT r.CarID AS CarID,c.MODEL AS Model,r.ClientID AS ClientID,CONCAT(cl.FName,' ',cl.LName) AS Name\n" +
                "FROM cars c,rented_out r,client cl\n" +
                "WHERE c.CAR_ID=r.CarID AND r.ClientID=cl.NIC;";

        DBConnect conn= new DBConnect();
        Statement stmt = conn.Connect2DB();
        try {
            ResultSet result= stmt.executeQuery(query);
            while(result.next())
            {
                RentEntry myEntry = new RentEntry(result.getString("CarID"),result.getString("Model"),result.getString("ClientID"),result.getString("Name"));
                list.add(myEntry);
               // System.out.println(list.isEmpty());
            }

            carID.setCellValueFactory(new PropertyValueFactory<RentEntry,String>("carID"));
            model.setCellValueFactory(new PropertyValueFactory<RentEntry,String>("model"));
            clientID.setCellValueFactory(new PropertyValueFactory<RentEntry,String>("clientID"));
            clientName.setCellValueFactory(new PropertyValueFactory<RentEntry,String>("clientName"));
       //     approval.setCellValueFactory(new PropertyValueFactory<RentEntry,String>("approval"));

            try {
                table.setItems(list);
            }
            catch (NullPointerException e)
            {
                System.out.println("expetion from here");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onRemoveButtonClicked()
    {

        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("../view/admin/RemoveData.fxml"));
        try {
            System.out.println("Try is working");
            Loader.load();

        } catch (IOException e) {
            System.out.println("Unable to load");
            e.printStackTrace();

        }

        Parent root= Loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }
    @FXML
    public void onDeclineButtonClicked()
    {
        Stage stage =(Stage) btnDecline.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void onAddCarButtonClicked()
    {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("../view/admin/AddCar.fxml"));
        try {
            System.out.println("Try is working");
            Loader.load();

        } catch (IOException e) {
            System.out.println("Unable to load");
            e.printStackTrace();

        }

        Parent root= Loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }
    @FXML
    public void onAddClientButtonClicked()
    {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("../view/admin/AddClient.fxml"));
        try {
            System.out.println("Try is working");
            Loader.load();

        } catch (IOException e) {
            System.out.println("From onAddClient button Clicked method at AdminControllerClass Unable to load");
            e.printStackTrace();

        }

        Parent root= Loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.DECORATED);
        stage.show();

    }
    @FXML
    public void onAddEmployeeButtonClicked()
    {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("../view/admin/AddEmployee.fxml"));
        try {
            System.out.println("Try is working");
            Loader.load();

        } catch (IOException e) {
            System.out.println("Unable to load");
            e.printStackTrace();

        }

        Parent root= Loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }
    @FXML
    public void onAddUserButtonClicked(){
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("../view/admin/AddUser.fxml"));
        try {
            System.out.println("Try is working");
            Loader.load();

        } catch (IOException e) {
            System.out.println("Unable to load");
            e.printStackTrace();

        }

        Parent root= Loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.DECORATED);
        stage.show();

    }
    @FXML
    public void onAddDriverButtonClicked()
    {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("../view/admin/AddDriver.fxml"));
        try {
            System.out.println("Try is working");
            Loader.load();

        } catch (IOException e) {
            System.out.println("Unable to load");
            e.printStackTrace();

        }

        Parent root= Loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }



}
