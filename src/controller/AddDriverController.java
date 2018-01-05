package controller;


import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Driver;
import model.Licence;

import java.net.URL;
import java.util.ResourceBundle;

public class AddDriverController implements Initializable {
    @FXML
    Button btnAdd,btnCancel;
    @FXML
    JFXTextField txtEmpId,txtNic,txtFName,txtLName,txtLicenceNo,txtAddress,txtContact,txtPathLicence,txtPathNic;
    @FXML
    JFXDatePicker dateExpire;
    @FXML
    JFXComboBox<String> comboGender;

    @FXML
    public void onAddButtonClicked()
    {//  public Car(String car_ID,String model,Integer seats,Integer mileage,String color,String availability,Integer basicPrice,String plateNo)

        try {
          //  Driver(String nic, String empNo, String fName, String lName, String address, String empType, String sex, String contact, String availabiliy, String licenceNo) {

                Driver driver = new Driver(txtNic.getText(), txtEmpId.getText(), txtFName.getText(),txtLName.getText(),txtAddress.getText(),"Driver",comboGender.getValue(),txtContact.getText(),"Available",txtLicenceNo.getText());
            //Licence(String no, LocalDateTime ex_Date, String type, String owner)
            Licence licence = new Licence(txtLicenceNo.getText(),dateExpire.getValue(),"Driver",txtEmpId.getText());
            driver.addToDatabase();
            licence.addToDatabase();
        }catch(Exception e) {
            System.out.println("Error: Class:AddCarController Method:onAddButtonClicked");
            e.printStackTrace();
        }

    }
    @FXML
    public void onCancelButtonClicked()
    {
        Stage stage= (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> genderList= FXCollections.observableArrayList("Male","Female");
        comboGender.setItems(genderList);
    }
}

