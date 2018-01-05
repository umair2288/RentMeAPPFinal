package model;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import databaseconnector.DBConnect;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.sql.Statement;

public class User {
   private String username;
   private String password;
   private String empID;

    public User(String username, String password, String empID) {
        this.username = username;
        this.password = password;
        this.empID = empID;
    }
    public void addToDatabase()
    {

        String query="INSERT INTO `users`\n" +
                " VALUES ('"+this.empID+"', '"+this.username+"', '"+this.password+"');";
        System.out.println(query);
        DBConnect conn= new DBConnect();
        Statement stmt = conn.Connect2DB();

        try {
            stmt.executeUpdate(query);
        }
        catch(MySQLIntegrityConstraintViolationException e)
        {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error");
            error.setHeaderText(null);
            error.setHeaderText("Employee ID does not Exists");
            error.showAndWait();
        }
        catch (SQLException e)
        {
            System.out.println("Adding to database is unsuccessfull, reporting from add to database method in model.Employee Class");
            e.printStackTrace();
        }
    }
}
