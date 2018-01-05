package model;

import databaseconnector.DBConnect;

import java.sql.SQLException;
import java.sql.Statement;

public class Client {
    private String nic;
    private String fName;
    private String lName;
    private String address;
    private String contact;

    public Client(String nic, String fName, String lName, String address, String contact) {
        this.nic = nic;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.contact = contact;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void addToDatabase()
    {
        String query ="INSERT INTO `client` (`NIC`, `FName`, `LName`, `Address`, `Contact`)\n" +
                " VALUES ('"+this.nic+"', '"+this.fName+"', '"+this.lName+"','"+this.address+"', '"+this.contact+"');";
        System.out.println(query);
        DBConnect conn= new DBConnect();
        Statement stmt = conn.Connect2DB();
        try {
            stmt.executeUpdate(query);
        }catch (SQLException e)
        {
            System.out.println("Adding to database is unsuccessfull, reporting from add to database method in model.Client Class");
        }


    }
}
