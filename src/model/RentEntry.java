package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class RentEntry {
    private final SimpleStringProperty carID;
    private final SimpleStringProperty model;
    private final SimpleStringProperty clientID ;
    private final SimpleStringProperty clientName ;
  //  private final SimpleStringProperty approval;



    public RentEntry(String carID, String model,String clientID, String clientName) {


        this.carID= new SimpleStringProperty(carID);
        this.model= new SimpleStringProperty(model);
        this.clientID= new SimpleStringProperty(clientID);
        this.clientName= new SimpleStringProperty(clientName);
     //   this.approval= new SimpleStringProperty(approval);

    }

    public String getCarID() {
        return carID.get();
    }

    public String getModel() {
        return model.get();
    }

 /*  // public String getApproval() {
        return approval.get();
    }*/

    public String getClientName() {
        return clientName.get();
    }

    public String getClientID()
    {
        return clientID.get();
    }
}
