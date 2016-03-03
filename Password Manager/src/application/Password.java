package application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Password {

    private StringProperty password = new SimpleStringProperty(this, "password", "");

    //Returns the StringProperty object
    public StringProperty firstNameProperty() {
        return password;
    }

    //Return the firstName value (ie. "Bucky")
    public String getFirstName() {
        return password.get();
    }

    //Set the firstName value
    public void setFirstName(String password) {
        this.password.set(password);
    }


}