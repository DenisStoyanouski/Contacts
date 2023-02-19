package contacts;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContactsDB implements Serializable {

    private static List<Record> contacts;

    private static final long serialVersionUID = 1L;

    private static final String fileName = "db.contacts";

    private static final File file = new File(fileName);


    ContactsDB(String fileName) {
        if (!file.exists()) {
            contacts = new ArrayList<>();
        } else {
            try {
                Record[] records = (Record[]) SerializationUtils.deserialize(fileName);
                contacts = Arrays.stream(records).collect(Collectors.toCollection(ArrayList::new));
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static int count() {
        return contacts.size();
    }

    public static void addContact() {
        System.out.print("Enter the type (person, organization): ");
        Record record;
        String type = mainMenu.getInput();
        if ("person".equals(type)) {
            record = new PersonFactory().createRecord();
        } else if ("organization".equals(type)) {
            record = new OrganizationFactory().createRecord();
        } else {
            System.out.println("Unknown type");
            return;
        }
        contacts.add(record);
        System.out.println("The record added.\n");
        try {
            SerializationUtils.serialize(contacts.toArray(), fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Record getContactByIndex(int index) {
        return contacts.get(index - 1);
    }

    public static void removeContactByIndex(int index) {
        contacts.remove(index - 1);
    }

    static void printContacts() {
        if (ContactsDB.count() == 0) {
            System.out.println("No records to show!");
        } else {
            contacts.forEach(x -> System.out.printf("%d. %s %n", contacts.indexOf(x) + 1, x.toTitle()));
        }
    }

}
