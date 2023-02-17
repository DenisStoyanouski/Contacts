package contacts;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Record {
    private String name;
    private String surname;

    private LocalDate birthDate;

    private String gender;
    private String phoneNumber = "";

    private String organizationName;

    private String address;


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumbers() {
        return phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
         this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "[no number]";
        }
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\+?(\\(\\w+\\)|\\w+[\\s-]\\(\\w{2,}\\)|\\w+)([\\s-]\\w{2,})*");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    private boolean hasNumber() {
        return !getPhoneNumbers().isEmpty() || !"[no number]".equals(getPhoneNumbers());
    }

    @Override
    public String toString() {
        return  name + " " + surname + ", " + phoneNumber;
    }
}
