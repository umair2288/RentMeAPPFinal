package controller;

import databaseconnector.DBConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Car;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CarController implements Initializable{


    @FXML  TableView<Car> table;
    @FXML  TableColumn<Car,String> car_ID;
    @FXML  TableColumn<Car,String> model;
    @FXML  TableColumn<Car,String> color;
    @FXML  TableColumn<Car,String> availability;
    @FXML  TableColumn<Car,Integer> seats;
    @FXML  TableColumn<Car,Integer> mileage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateTable();
    }

    public void populateTable()
    {
        ObservableList<Car> list = FXCollections.observableArrayList();
        String query = "SELECT * FROM `cars` ";

        DBConnect conn= new DBConnect();
        Statement stmt = conn.Connect2DB();
        try {
            ResultSet result= stmt.executeQuery(query);
            while(result.next())
            {
                Car myCar = new Car(result.getString("CAR_ID"),result.getString("MODEL"),Integer.parseInt(result.getString("SEATS")),Integer.parseInt(result.getString("MILEAGE")),result.getString("COLOUR"),result.getString("AVAILABILITY"));
                //System.out.println(myCar.getSeat());

                list.add(myCar);
            }

            mileage.setCellValueFactory(new PropertyValueFactory<Car,Integer>("mileage"));
            car_ID.setCellValueFactory(new PropertyValueFactory<Car,String>("car_ID"));
            model.setCellValueFactory(new PropertyValueFactory<Car,String>("model"));
            color.setCellValueFactory(new PropertyValueFactory<Car,String>("Color"));
            seats.setCellValueFactory(new PropertyValueFactory<Car,Integer>("Seat"));
            availability.setCellValueFactory(new PropertyValueFactory<Car,String>("Availablity"));


            table.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onMakeAvailableClicked()
    {
        Car car=table.getSelectionModel().getSelectedItem();
        String query = "UPDATE `cars` SET `AVAILABILITY` = 'Available' WHERE `cars`.`CAR_ID` = '"+car.getCar_ID()+"'";
        System.out.println(query);
        DBConnect connect= new DBConnect();
        Statement stmt=connect.Connect2DB();
        try {
            stmt.executeUpdate(query);
            populateTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onMakeUnavailableClicked()
    {
        Car car=table.getSelectionModel().getSelectedItem();
        String query = "UPDATE `cars` SET `AVAILABILITY` = 'Not Available' WHERE `cars`.`CAR_ID` = '"+car.getCar_ID()+"'";
        System.out.println(query);
        DBConnect connect= new DBConnect();
        Statement stmt=connect.Connect2DB();
        try {
            stmt.executeUpdate(query);
            populateTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
