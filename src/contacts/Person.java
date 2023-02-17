package contacts;

import java.time.LocalDate;

public class Person extends Record{

    private String name;
    private String surname;
    private LocalDate birthDate;
    private String gender;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return super.getPhoneNumber();
    }

    public void setName(String name) {
        this.name = name;
        super.setTimeEdited();

    }

    public void setSurname(String surname) {
        this.surname = surname;
        super.setTimeEdited();
    }

    public void setPhoneNumber(String phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = this.birthDate;
        super.setTimeEdited();
    }


    public void setGender(String gender) {
        this.gender = gender;
        super.setTimeEdited();
    }

    @Override
    public String toString() {
        return  name + " " + surname + ", " + super.getPhoneNumber();
    }
}
