package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Record {
    private String name;
    private String surname;
    private String phoneNumber = "[no number]";

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumbers() {
        return phoneNumber;
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
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("\\+?(\\([\\da-zA-Z]\\))?(\\s|-)");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    @Override
    public String toString() {
        return  name + " " + surname + ", " + phoneNumber;
    }
}