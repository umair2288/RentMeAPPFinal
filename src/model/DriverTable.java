package model;

import javafx.beans.property.SimpleStringProperty;

public class DriverTable {
    private final SimpleStringProperty driverID;
    private final SimpleStringProperty name;
    private final SimpleStringProperty licenceNo;
    private final SimpleStringProperty availability;
    private final SimpleStringProperty contact;


    public DriverTable(String driverID, String name, String licenceNo , String availability, String contact) {
        super();
        this.driverID= new SimpleStringProperty(driverID);
        this.name= new SimpleStringProperty(name);
        this.licenceNo= new SimpleStringProperty(licenceNo);
        this.availability= new SimpleStringProperty(availability);
        this.contact = new SimpleStringProperty(contact);
    }

    public String getDriverID() {
        return driverID.get();
    }

    public String getLicenceNo() {
        return licenceNo.get();
    }

    public String getAvailability() {
        return availability.get();
    }

    public String getContact() {
        return contact.get();
    }

    public String getName() {
        return name.get();
    }
}

