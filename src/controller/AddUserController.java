package controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Car;
import model.Licence;
import model.User;

public class AddUserController {

        @FXML
        Button btnAdd,btnCancel;
        @FXML
        JFXTextField txtEmpID,txtUsername;
        @FXML
        JFXPasswordField pwPassword;

        @FXML
        public void onAddButtonClicked()
        {
            try {
                User user = new User(txtEmpID.getText(),pwPassword.getText(),txtUsername.getText());
                user.addToDatabase();

            }catch(Exception e) {
                System.out.println("Error: Class:AddUserController Method:onAddButtonClicked");
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
