package model;

import databaseconnector.DBConnect;

import java.sql.SQLException;
import java.sql.Statement;

public class Driver extends Employee {
    private String contact;
    private String availabiliy;
    private String licenceNo;

    public Driver(String nic, String empNo, String fName, String lName, String address, String empType, String sex, String contact, String availabiliy, String licenceNo) {
        super(nic, empNo, fName, lName, address, empType, sex);
        this.contact = contact;
        this.availabiliy = availabiliy;
        this.licenceNo = licenceNo;
    }

    @Override
    public void addToDatabase()
    {
        super.addToDatabase();
        String query="INSERT INTO `driver` (`DriverID`, `LicenceNo`, `Contact`, `Availability`)\n" +
                " VALUES ('"+this.empNo+"', '"+this.licenceNo+"', '"+this.contact+"', 'Available');";
        System.out.println(query);
        DBConnect conn= new DBConnect();
        Statement stmt = conn.Connect2DB();

        try {
            stmt.executeUpdate(query);
            //   stmt.executeUpdate(query2);
        }catch (SQLException e)
        {
            System.out.println("Adding to database is unsuccessfull, reporting from add to database method in model.Employee Class");
            e.printStackTrace();
        }
    }

}
