package model;

import databaseconnector.DBConnect;

import java.sql.SQLException;
import java.sql.Statement;

public class RemoveData {

    public void remove(String table,String key,String id)
    {

        String query = "DELETE FROM "+table+" WHERE "+ key+"='"+id+"'";
        System.out.println(query);

        System.out.println(query);
        DBConnect connect= new DBConnect();
        Statement stmt=connect.Connect2DB();
        try {
            stmt.executeUpdate(query);
           // populateTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
