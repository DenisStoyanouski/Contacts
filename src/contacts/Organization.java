package contacts;

public class Organization extends Record{

    private String organizationName;
    private String address;

    @Override
    public String getPhoneNumber() {
        return getPhoneNumber();
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        super.setTimeEdited();
    }

    public void setAddress(String address) {
        this.address = address;
        super.setTimeEdited();
    }

}
