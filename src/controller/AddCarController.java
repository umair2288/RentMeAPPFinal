package controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Car;
import model.Licence;

public class AddCarController {
    @FXML
    Button btnAdd,btnCancel;
    @FXML
    JFXTextField txtCarId,txtCarModel,txtColor,txtPlateNo,txtLicenceNo,txtBasicPrice,txtNoOfSeats,txtMileage;
    @FXML
    JFXDatePicker dateExpireDate;

    @FXML
    public void onAddButtonClicked()
    {//  public Car(String car_ID,String model,Integer seats,Integer mileage,String color,String availability,Integer basicPrice,String plateNo)

        try {
            Car car = new Car(txtCarId.getText(), txtCarModel.getText(), Integer.parseInt(txtNoOfSeats.getText()), Integer.parseInt(txtMileage.getText()), txtColor.getText(), "Available", Integer.parseInt(txtBasicPrice.getText()), txtPlateNo.getText());
           //Licence(String no, LocalDateTime ex_Date, String type, String owner)
            Licence licence = new Licence(txtLicenceNo.getText(),dateExpireDate.getValue(),"Vehicle",txtCarId.getText());
            car.addToDatabase();
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

}
