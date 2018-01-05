package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import controller.ReceptionistController;

import java.io.IOException;
import java.sql.SQLException;


public class LoginController {

    @FXML
    Button btnExit;
    @FXML
    Button btnLogin;
    @FXML
    TextField txtUsername;
    @FXML
    PasswordField pwPassword;


    public model.Login login;

    @FXML
    private void exitButtonClicked(){
        System.out.println("Exiting application");
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }



    @FXML
    private void loginButtonClicked(){
        String userName,password;

        userName=txtUsername.getText();
        password = pwPassword.getText();

        System.out.println("Username: "+ userName+"\nPassword: "+password);

        login = new model.Login();
        FXMLLoader Loader= new FXMLLoader();



        if(login.login(userName,password)){
            if(login.empType(userName).equalsIgnoreCase("ADMIN"))
            {
                Loader.setLocation(getClass().getResource("../view/admin/Admin.fxml"));
                try {
                    Loader.load();
                }catch (IOException e) {
                    e.printStackTrace();
                }
                //hide login window
                Stage stageLogin = (Stage) btnExit.getScene().getWindow();
                txtUsername.clear(); //clearing username
                pwPassword.clear(); //clearing password
                stageLogin.close();
                //
                AdminController admin= Loader.getController();
                Parent root= Loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.getIcons().add(new Image(this.getClass().getResource("../resources/img/login.png").toString()));
               // stage.initStyle(StageStyle.UNDECORATED);
                stage.showAndWait();
            }else{
                Loader.setLocation(getClass().getResource("../view/user/ReceptionistForm.fxml"));
                try {
                    Loader.load();
                }catch (IOException e) {
                    e.printStackTrace();
                }

                //hide login window
                Stage stageLogin = (Stage) btnExit.getScene().getWindow();
                txtUsername.clear(); //clearing username
                pwPassword.clear(); //clearing password
                stageLogin.close();
                //
                ReceptionistController receptionist= Loader.getController();
                receptionist.setHeader(login.getName(userName),"Receptionist");
                Parent root= Loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.getIcons().add(new Image(this.getClass().getResource("../resources/img/login.png").toString()));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.showAndWait();
            }


        }
        else{
            System.out.println("Login failed");
            txtUsername.clear(); //clearing username
            pwPassword.clear(); //clearing password
        }
    }


}
