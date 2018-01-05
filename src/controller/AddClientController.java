package controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Car;
import model.Client;
import model.Licence;

public class AddClientController {
    @FXML
    Button btnAdd,btnCancel;
    @FXML
    JFXTextField txtNIC,txtFName,txtLName,txtLicenceNo,txtAddress,txtContactNo,txtLicencePath,txtNicPath;
    @FXML
    JFXDatePicker date_ExpireDate;

    @FXML
    public void onAddButtonClicked()
    {//  public Car(String car_ID,String model,Integer seats,Integer mileage,String color,String availability,Integer basicPrice,String plateNo)

        try {
           Client client = new Client(txtNIC.getText(),txtFName.getText(),txtLName.getText(),txtAddress.getText(), txtContactNo.getText());

           //Licence(String no, LocalDateTime ex_Date, String type, String owner)
          Licence licence = new Licence(txtLicenceNo.getText(),date_ExpireDate.getValue(),"Client",txtNIC.getText(),txtLicencePath.getText());
          client.addToDatabase();
         licence.addToDatabase();
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
        txtNIC.clear();
        txtFName.clear();
        txtLName.clear();
        txtLicenceNo.clear();
        txtContactNo.clear();
        txtAddress.clear();
        txtLicencePath.clear();
        txtNicPath.clear();
        date_ExpireDate.getEditor().clear();
    }
}
