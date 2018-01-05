package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.RemoveData;

import java.lang.invoke.SwitchPoint;
import java.net.URL;
import java.util.ResourceBundle;


public class RemoveDataController implements Initializable {

    @FXML
    Button btnCancel,btnRemove;
    @FXML
    JFXTextField    txtID;
    @FXML
    JFXComboBox<String> comboType;

    @FXML
    public void onCancelButtonClicked() {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onRemoveButtonClicked()
    {
        String table,key;
        switch (comboType.getValue())
        {
            case "Car":
                table="cars";
                key="CAR_ID";
                break;
            case "Client":
                table="client";
                key="NIC";
                break;
            case "Driver":
                table="driver";
                key="DriverID";
                break;
            case "Employee":
                table="rentemp";
                key="EMP_NO";
                break;
                default: return;

        }
        RemoveData removeData=new RemoveData();
        removeData.remove(table,key,txtID.getText());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> list= FXCollections.observableArrayList("Car","Client","Driver","Employee");
        comboType.setItems(list);
    }
}
