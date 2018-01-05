package controller;

import com.jfoenix.controls.*;
import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;
import com.sun.org.apache.xpath.internal.SourceTree;
import databaseconnector.DBConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Receptionist;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class ReceptionistController implements Initializable {

    @FXML
    JFXTextField txtClientName,txtContactNo,txtDriverID,txtRent_ClientID;
    @FXML
    JFXDatePicker dateHireDate,dateReturnDate,dateRent_RentDate,dateRent_ReturnDate;

    @FXML
    JFXComboBox comboCarModel,comboCarID,comboRent_CarID,comboRent_CarModel;

    @FXML
    JFXButton btnHire,btnExit,btnCancel,btnLogout,btnCars,btnClients,btnDrivers,btnRent_Cancel,btnRent_Rentout;

    @FXML
    Label lblName,lblPosition;

    model.Receptionist receptionist;


    @FXML
    private void onCarsButtonClicked()
    {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("../view/car/Car.fxml"));
        try {
            Loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root= Loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }
    @FXML
    private void onClientsButtonClicked()
    {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("../view/client/Client.fxml"));
        try {
            Loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root= Loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.DECORATED);
        stage.show();

    }
    @FXML
    private void onDriversButtonClicked()
    {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("../view/driver/Driver.fxml"));
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

        //System.out.println("Exiting application");
       // Stage stageMain = (Stage) btnExit.getScene().getWindow();

    }

    @FXML
    private void onHireButtonClicked() {
        receptionist = new Receptionist();
        if (receptionist.bookHire(txtClientName.getText(), txtContactNo.getText(), dateHireDate.getValue().toString(), dateReturnDate.getValue().toString(), txtDriverID.getText(),comboCarID.getValue().toString()))
            System.out.println("hire booked successfully");
        else {
            System.out.println("Hire not booked");
        }

    }

    @FXML
    private void logoutButtonClicked() {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("../view/LoginForm.fxml"));
        try {
            Loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }



        Parent root= Loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        System.out.println("Login out application");
        Stage Rstage = (Stage) btnLogout.getScene().getWindow();
        Rstage.close();


    }
    @FXML
    private void exitButtonClicked() {
        //put an alert box before close
        System.out.println("Exiting application");
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //TODO
        fillComboBoxCarModel();
    }

    public void setHeader(String name, String position)
    {
        this.lblName.setText(name);
        this.lblPosition.setText(position);
    }

    public void fillComboBoxCarModel()
    {
        ObservableList<String> carmodel = FXCollections.observableArrayList();
        String query = "SELECT DISTINCT MODEL  FROM `cars` WHERE AVAILABILITY=\'AVAILABLE\' ORDER BY MODEL ";

        DBConnect conn= new DBConnect();
        Statement stmt = conn.Connect2DB();
        try {
            ResultSet result= stmt.executeQuery(query);
            for(int i=0;i<=10&&result.next();i++)
            {
                carmodel.add(result.getString("MODEL"));
            }
            comboCarModel.setItems(carmodel);
            comboRent_CarModel.setItems(carmodel);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void fillComboBoxCarID()
    {
        String carModel;
        ObservableList<String> carId = FXCollections.observableArrayList();
        if(comboCarModel.getSelectionModel().isEmpty())
            carModel=comboRent_CarModel.getValue().toString();
        else
            carModel=comboCarModel.getValue().toString();
        String query = "SELECT CAR_ID  FROM `cars` WHERE MODEL=\'"+carModel+"\' AND  AVAILABILITY=\'AVAILABLE\'";

        DBConnect conn= new DBConnect();
        Statement stmt = conn.Connect2DB();
        try {
            ResultSet result= stmt.executeQuery(query);
            for(int i=0;i<=10&&result.next();i++)
            {
                carId.add(result.getString("CAR_ID"));
            }
            comboCarID.setItems(carId);
            comboRent_CarID.setItems(carId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void onRentoutButtonClicked()
    {
        boolean flag=false;
        receptionist = new Receptionist();
        try {
            flag = receptionist.rentOut(txtRent_ClientID.getText(), dateRent_RentDate.getValue().toString(), dateRent_ReturnDate.getValue().toString(), comboRent_CarID.getValue().toString());
        }catch(NullPointerException e)
        {
            System.out.println("Error");
            e.printStackTrace();
        }

        if (flag)
            System.out.println("rent added");
        else {
            System.out.println("rent not booked");
        }
    }

    @FXML
    public void onCancelButtonClicked()
    {
        txtClientName.clear();
        txtContactNo.clear();
        txtDriverID.clear();
        dateHireDate.getEditor().clear();
        dateReturnDate.getEditor().clear();
        txtRent_ClientID.clear();
        dateRent_RentDate.getEditor().clear();
        dateRent_ReturnDate.getEditor().clear();
    }




}