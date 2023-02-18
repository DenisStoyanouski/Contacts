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


    public void setName(String name) {
        this.name = name;
        super.setTimeEdited();

    }

    public void setSurname(String surname) {
        this.surname = surname;
        super.setTimeEdited();
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
        return  "Name: " + getName() + "\n" +
                "Surname: " + getSurname() + "\n" +
                "Birth date: " + getBirthDate() + "\n" +
                "Gender: " + getGender() + "\n" +
                "Number: " + getPhoneNumber() + "\n" +
                "Time created: " + getTimeCreated() + "\n" +
                "Time last edit: " + getTimeEdited() + "\n";
    }

    public String toTitle(){
        return getName() + " " + getSurname();
    }
}
