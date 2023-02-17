package contacts;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Record {
    private String phoneNumber = "";


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isValidPhoneNumber(phoneNumber)) {
         this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "[no number]";
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^\\+?(\\(\\w+\\)|\\w+[\\s-]\\(\\w{2,}\\)|\\w+)([\\s-]\\w{2,})*");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    private boolean hasNumber() {
        return !getPhoneNumber().isEmpty() || !"[no number]".equals(getPhoneNumber());
    }
}
