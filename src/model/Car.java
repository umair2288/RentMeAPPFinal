package model;

import databaseconnector.DBConnect;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.SQLException;
import java.sql.Statement;

public class Car {
    private final SimpleStringProperty car_ID;
    private final SimpleStringProperty model;
    private final SimpleIntegerProperty seats ;
    private final SimpleIntegerProperty mileage ;
    private final SimpleStringProperty color;
    private final SimpleStringProperty availability;
    private final SimpleIntegerProperty basicPrice;
    private final SimpleStringProperty plateNo;


    public Car(String car_ID,String model,Integer seats,Integer mileage,String color,String availability,Integer basicPrice,String plateNo) {
        super();
        this.car_ID= new SimpleStringProperty(car_ID);
        this.model= new SimpleStringProperty(model);
        this.seats= new SimpleIntegerProperty(seats);
        this.color= new SimpleStringProperty(color);
        this.availability= new SimpleStringProperty(availability);
        this.mileage = new SimpleIntegerProperty(mileage);
        this.basicPrice=new SimpleIntegerProperty(basicPrice);
        this.plateNo=new SimpleStringProperty(plateNo);
    }


    public Car(String car_ID,String model,Integer seats,Integer mileage,String color,String availability) {
        super();
        this.car_ID= new SimpleStringProperty(car_ID);
        this.model= new SimpleStringProperty(model);
        this.seats= new SimpleIntegerProperty(seats);
        this.color= new SimpleStringProperty(color);
        this.availability= new SimpleStringProperty(availability);
        this.mileage = new SimpleIntegerProperty(mileage);
        this.basicPrice=new SimpleIntegerProperty(0);
        this.plateNo = new SimpleStringProperty("");
    }

    public Integer getSeat() {
        return seats.get();
    }

    public String getCar_ID() {
        return car_ID.get();
    }

    public String getAvailablity() {
        return availability.get();
    }

    public String getColor() {
        return color.get();
    }

    public String getModel() {
        return model.get();
    }

    public Integer getMileage() {
        return mileage.get();
    }

    public void addToDatabase()
    {
        String query ="INSERT INTO `cars` (`CAR_ID`, `MODEL`, `COLOUR`, `SEATS`, `AVAILABILITY`, `MILEAGE`, `BasicPrice`, `PlateNo`) \n" +
                "VALUES ('"+this.car_ID.getValue()+"','"+this.model.getValue()+"', '"+this.color.getValue()+"', '"+this.seats.getValue()+"','"+this.availability.getValue()+"', '"+this.mileage.getValue()+"', '"+this.basicPrice.getValue()+"','"+this.plateNo.getValue()+"');";
      //  String query2 = "INSERT INTO `licence` (`No`, `Expire`, `Type`, `Owner`, `CopyFilePath`) VALUES ('"122222336"', '2018-01-10', 'Vechile', '0100', 'path');"

        System.out.println(query);
        DBConnect conn= new DBConnect();
        Statement stmt = conn.Connect2DB();
        try {
            stmt.executeUpdate(query);
         //   stmt.executeUpdate(query2);
        }catch (SQLException e)
        {
            System.out.println("Adding to database is unsuccessfull, reporting from add to database method in model.Car Class");
        }


    }
}
