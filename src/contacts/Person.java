package contacts;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person extends Record {

    private String name;
    private String surname;
    private String birthDate;
    private String gender;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
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


    public void setBirthDate(String birthDate) {
        Pattern pattern = Pattern.compile("(\\d\\d\\d\\d[-/.]\\d\\d[-/.]\\d\\d)|(\\d\\d[-/.]\\d\\d[-/.]\\d\\d\\d\\d)");
        Matcher matcher = pattern.matcher(birthDate);
        if (matcher.matches()) {
            this.birthDate = birthDate;
        } else {
            System.out.println("Bad birth date!");
            this.birthDate = "[no data]";
        }

        super.setTimeEdited();
    }


    public void setGender(String gender) {
        Pattern pattern = Pattern.compile("[M|F]");
        Matcher matcher = pattern.matcher(gender);
        if (matcher.matches()) {
            this.gender = gender;
        } else {
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        }
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

    @Override
    String getFields() {
       return "(name, surname, birth, gender, number)";
    }

    @Override
    public void changeField(String fieldName, String value) {
        switch (fieldName) {
            case "name" : setName(value);
            break;
            case "surname" : setSurname(value);
            break;
            case "birth" : setBirthDate(value);
            break;
            case "gender" : setGender(value);
            break;
            case "number" : setPhoneNumber(value);
            break;
            default: break;
        }
    }

    @Override
    public String returnFieldValue(String fieldName) {
        switch (fieldName) {
            case "name" : return getName();
            case "surname" : return getSurname();
            case "birth" : return getBirthDate();
            case "gender" : return getGender();
            case "number" : return getPhoneNumber();
            default : break;
        }
        return "Unknown field Name";
    }
}
