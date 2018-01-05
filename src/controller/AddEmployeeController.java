package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Employee;

import java.net.URL;
import java.util.*;

public class AddEmployeeController implements Initializable{
    @FXML
    Button btnAdd,btnCancel;
    @FXML
    JFXTextField txtEmpId,txtNic,txtFName,txtLName,txtAddress,txtSalary;
    @FXML
    JFXComboBox<String> comboGender,comboEmpType;

    @FXML
    public void onAddButtonClicked()
    {//  public Car(String car_ID,String model,Integer seats,Integer mileage,String color,String availability,Integer basicPrice,String plateNo)

        try {
           // Employee(String nic, String empNo, String fName, String lName, String address, String empType, char sex)
            Employee employee = new Employee(txtNic.getText(),txtEmpId.getText(),txtFName.getText(),txtLName.getText(),txtAddress.getText(),comboEmpType.getValue(),comboGender.getValue());
            employee.addToDatabase();
            clearField();
        }catch(Exception e) {
            System.out.println("Error: Class:AddClientController Method:onAddButtonClicked");
            e.printStackTrace();
        }
    }
    @FXML
    public void onCancelButtonClicked()
    {
        Stage stage= (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void clearField()
    {
        txtNic.clear();
        txtFName.clear();
        txtLName.clear();
        txtAddress.clear();
        txtEmpId.clear();
        txtSalary.clear();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> listGender= FXCollections.observableArrayList("Male","Female");
        comboGender.setItems(listGender);
        ObservableList<String> listEmpType= FXCollections.observableArrayList("Receptionist","Admin");
        comboEmpType.setItems(listEmpType);

            }
        }
