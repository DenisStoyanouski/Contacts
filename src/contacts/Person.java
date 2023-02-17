package contacts;

import java.time.LocalDate;

public class Person extends Record{

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String gender;

    public String getName() {
        return getName();
    }

    public String getSurname() {
        return getSurname();
    }

    public LocalDate getBirthDate() {
        return getBirthDate();
    }

    public String getGender() {
        return getGender();
    }

    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    public void setName(String name) {
        setName(name);
    }

    public void setSurname(String surname) {
        setSurname(surname);
    }

    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    public void setBirthDate(LocalDate birthDate) {
        setBirthDate(birthDate);
    }


    public void setGender(String gender) {
        setGender(gender);
    }

    @Override
    public String toString() {
        return  name + " " + surname + ", " + super.getPhoneNumber();
    }
}
