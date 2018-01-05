package model;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import databaseconnector.DBConnect;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

    Statement statement;
    ResultSet result;
    //login
    public boolean login(String username,String password){
        DBConnect connection = new DBConnect();
        statement = connection.Connect2DB();
        if(statement!=null) {
            String query1 = "SELECT * FROM users WHERE UserName=\'" + username + "\'";
            try {
                result = statement.executeQuery(query1);
                if (result.next()) {
                    if (username.equals(result.getString("UserName")) && password.equals(result.getString("password"))) {
                        System.out.println("Logged in...");
                        return true;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println(query1);

            System.out.println("Username or password is wrong");
            //Alert box
            Alert loginAlert = new Alert(Alert.AlertType.ERROR);
            loginAlert.setTitle("OOPS! Watch out");
            loginAlert.setHeaderText(null);
            loginAlert.setContentText("Don't worry human makes mistakes.\nContact your administrator if you're forgotten your password ");
            //loginAlert.setGraphic(new ImageView(this.getClass().getResource("../icons/png/users-1.png").toString()));
        //    Stage stage = (Stage) loginAlert.getDialogPane().getScene().getWindow();
         //   stage.getIcons().add(new Image(this.getClass().getResource("../icons/png/locked-6.png").toString()));
            loginAlert.showAndWait();
        }
        else{

            Alert dbNotConnectedAlert = new Alert(Alert.AlertType.ERROR);
            dbNotConnectedAlert.setTitle("Error");
            dbNotConnectedAlert.setHeaderText(null);
            dbNotConnectedAlert.setHeaderText("Unable to connect database.");
            Stage stage = (Stage) dbNotConnectedAlert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("../icons/png/database-3.png").toString()));
            dbNotConnectedAlert.showAndWait();
        }
        return false;
    }
    //end of login

    public String getName(String username){
        String query = "SELECT CONCAT(FNAME,\' \',LNAME) AS FULL_NAME FROM RENTEMP,USERS WHERE RENTEMP.EMP_NO=USERS.USER_NO AND USERNAME=\'"+username+"\'";
        try {
            ResultSet result = statement.executeQuery(query);
            try {
                result.next();
            } catch (SQLException e) {
                System.out.println("Reporting from getName method in Login class, error caused while executing result.next()");
                e.printStackTrace();
            }
            String name = result.getString("FULL_NAME");
            return name;
        }catch (SQLException e){
            System.out.println("Reporting from getName method in Login class, error caused while executing query");
            e.printStackTrace();
        }
        return "NULL";
    }



    public String empType(String username)
    {
        String query="SELECT EMP_TYPE FROM rentemp E,users U WHERE E.EMP_NO=U.USER_NO AND UserName=\'" + username + "\'";
        ResultSet result= null;
        try {
            result = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("1:From isAdmin Methon in Login.java");
        }
        String flag="";

        try {
            if(result.next())
                flag=result.getString("EMP_TYPE");
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("2:From isAdmin Method in Login.java");
        }
        return flag;

    }







    /*public void createReceptionist(String username)
    {

        String query = "SELECT CONCAT(FNAME,\' \',LNAME) AS FULL_NAME,ADDRESS,SEX,NIC,SALARY FROM RENTEMP,USERS WHERE RENTEMP.EMP_NO=USERS.USER_NO AND USERNAME=\'"+username+"\'";
        try
        {
            ResultSet result = statement.executeQuery(query);
            result.next();
            //creating receptionist object
            receptionist.setName(result.getString("FULL_NAME"));
          //  receptionist.setAddress(result.getString("ADDRESS"));
          //  receptionist.setNic(result.getString("NIC"));
           // receptionist.setSalary(Double.parseDouble(result.getString("SALARY")));

        }catch ( SQLException e){
            e.printStackTrace();
        }

    }*/





}

