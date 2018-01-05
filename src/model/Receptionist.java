package model;

import databaseconnector.DBConnect;
import java.sql.SQLException;
import java.sql.Statement;

public class Receptionist {


    public boolean bookHire(String name, String contactNo, String hireDate, String returnDate, String driverID, String carID)
    {
        String query="INSERT Hired VALUES(\'"+name+"\',\'"+contactNo+"\',\'"+hireDate+"\',\'"+returnDate+"\',\'"+driverID+"\',\'"+carID+"\',\'NotApproved\');";
        System.out.println(query);
        DBConnect conn= new DBConnect();
        Statement stmt = conn.Connect2DB();
        try{
            stmt.executeUpdate(query);
            conn.close();
            return true;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }

    }

    public boolean rentOut(String nic, String rentDate, String returnDate,String carID)
    {
        String query="INSERT rented_out VALUES(\'"+nic+"\',\'"+rentDate+"\',\'"+returnDate+"\',\'"+carID+"\',\'NotApproved\')";
        System.out.println(query);
        DBConnect conn= new DBConnect();
        Statement stmt = conn.Connect2DB();
        try{
            stmt.executeUpdate(query);
            conn.close();
            return true;
        }catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }

    }


}
