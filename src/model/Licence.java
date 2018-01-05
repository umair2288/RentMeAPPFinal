package model;

import databaseconnector.DBConnect;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Licence {
    String no;
    LocalDate ex_Date;
    String type;
    String owner; //vehicle ID or driverID or ClientTable ID
    String copyPath;

    public Licence(String no, LocalDate ex_Date, String type, String owner, String copyPath) {
        this.no = no;
        this.ex_Date = ex_Date;
        this.type = type;
        this.owner = owner;
        this.copyPath = copyPath;
    }

    public Licence(String no, LocalDate ex_Date, String type, String owner) {
        this.no = no;
        this.ex_Date = ex_Date;
        this.type = type;
        this.owner = owner;
    }

    public void addToDatabase()
    {
        String query ="INSERT INTO `licence` (`No`, `Expire`, `Type`, `Owner`, `CopyFilePath`) VALUES ('"+this.no+"', '"+this.ex_Date+"','"+this.type+"', '"+this.owner+"','"+this.copyPath+"');";
        //  String query2 = "INSERT INTO `licence` (`No`, `Expire`, `Type`, `Owner`, `CopyFilePath`) VALUES ('"122222336"', '2018-01-10', 'Vechile', '0100', 'path');"

        System.out.println(query);
        DBConnect conn= new DBConnect();
        Statement stmt = conn.Connect2DB();
        try {
            stmt.executeUpdate(query);
            //   stmt.executeUpdate(query2);
        }catch (SQLException e)
        {
            System.out.println("Adding to database is unsuccessfull, reporting from add to database method in model.Licence Class");
            e.printStackTrace();
        }
    }
}
