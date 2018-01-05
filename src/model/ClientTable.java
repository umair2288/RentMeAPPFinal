package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ClientTable {
    private final SimpleStringProperty nic;
    private final SimpleStringProperty name;
    private final SimpleStringProperty address;
    private final SimpleStringProperty carID ;
    private final SimpleStringProperty contact;


    public ClientTable(String nic, String name, String address, String carID, String contact) {
        super();
        this.nic= new SimpleStringProperty(nic);
        this.name= new SimpleStringProperty(name);
        this.address= new SimpleStringProperty(address);
        this.carID= new SimpleStringProperty(carID);
        this.contact = new SimpleStringProperty(contact);
    }





    public String getNic() {
        return nic.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getCarID() {
        return carID.get();
    }

    public String getContact() {
        return contact.get();
    }

    public String getName() {
        return name.get();
    }




}
