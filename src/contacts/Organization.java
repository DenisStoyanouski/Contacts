package contacts;

import java.io.Serializable;
import java.util.Arrays;

public class Organization extends Record {

    private String organizationName;
    private String address;


    public String getOrganizationName() {
        return organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        super.setTimeEdited();
    }

    public void setAddress(String address) {
        this.address = address;
        super.setTimeEdited();
    }

    @Override
    public String toString() {
        return  "Organization name: " + getOrganizationName() + "\n" +
                "Address: " + getAddress() + "\n" +
                "Number: "+ getPhoneNumber() + "\n" +
                "Time created: " + getTimeEdited() + "\n" +
                "Time last edit: " + getTimeEdited() + "\n";
    }

    public String toTitle() {
        return getOrganizationName();
    }

    @Override
    String getFields() {
        return "name, address, number";
    }

    @Override
    public void changeField(String fieldName, String value) {
        switch(fieldName) {
            case "name" : setOrganizationName(value);
            break;
            case "address" : setAddress(value);
            break;
            case "number" : setPhoneNumber(value);
            break;
            default: break;
        }
    }

    @Override
    public String returnFieldValue(String fieldName) {
        switch(fieldName) {
            case "name" : return getOrganizationName();
            case "address" : return getAddress();
            case "number" : return getPhoneNumber();
            default : break;
        }
        return "Unknown field";
    }
}
