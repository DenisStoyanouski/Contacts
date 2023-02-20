package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Record implements Serializable {
    private String phoneNumber = "";
    private LocalDateTime timeCreated;
    private LocalDateTime timeEdited;

    public Record() {
        timeCreated = LocalDateTime.now();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
         this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "[no number]";
            setTimeEdited();
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\+?(\\(\\w+\\)|\\w+[\\s-]\\(\\w{2,}\\)|\\w+)([\\s-]\\w{2,})*");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    protected boolean hasNumber() {
        return !getPhoneNumber().isEmpty() || !"[no number]".equals(getPhoneNumber());
    }

    protected void setTimeEdited(){
        timeEdited = LocalDateTime.now();
    }

    protected String getTimeCreated() {
        return timeCreated.withSecond(0).withNano(0).toString();
    }

    protected String getTimeEdited() {
        return timeEdited.withSecond(0).withNano(0).toString();
    }

    abstract String printAllFields();

    abstract String toTitle();

    abstract String getFields();

    abstract void changeField(String fieldName, String value);

    abstract String returnFieldValue(String fieldName);
}
