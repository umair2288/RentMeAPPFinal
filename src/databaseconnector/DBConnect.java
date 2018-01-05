package databaseconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnect {
    public String url = "localhost";
    public String port = "3306";
    public String database = "rentme";
    public String Student = "root";
    public String password = "";
   // public String JDBC_DRIVER = "com.mysql.jdbc.DriverTable";
    Connection conn = null;

    //Function to Connect to DB
    public Statement Connect2DB()
    {
        String DB_URL = "jdbc:mysql://"+url+":"+port+"/"+database;
        Statement dbstmt=null;
        try {
            conn = DriverManager.getConnection(DB_URL,Student,password);//Connect
            dbstmt = conn.createStatement();
            System.out.println("Connected to database");
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        return dbstmt;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

