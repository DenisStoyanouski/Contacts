package contacts;

public class Organization extends Record{

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
        return  "Address: " + address + "\n" +
                "Number: "+ getPhoneNumber() + "\n" +
                "Time created: " + getTimeEdited() + "\n" +
                "Time last edit: " + getTimeEdited() + "\n";
    }
}
