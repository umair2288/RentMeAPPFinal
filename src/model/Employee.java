package model;

import databaseconnector.DBConnect;

import java.sql.SQLException;
import java.sql.Statement;

public class Employee {
    String nic;
    String empNo;
    String fName;
    String lName;
    String address;
    String empType;
    String sex;

    public Employee(String nic, String empNo, String fName, String lName, String address, String empType, String sex) {
        this.nic = nic;
        this.empNo = empNo;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.empType = empType;
        this.sex = sex;
    }

    public void addToDatabase()
    {
        String query="\n" +
                "INSERT INTO `rentemp` (`EMP_NO`, `FNAME`, `LNAME`, `ADDRESS`, `SEX`, `EMP_TYPE`, `DNO`, `NIC`) \n" +
                "VALUES ('"+this.empNo+"', '"+this.fName+"', '"+this.lName+"', '"+this.address+"', '"+this.sex+"', '"+this.empType+"','"+0+"','"+this.nic+"');";
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
