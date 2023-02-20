package contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ContactsDB implements Serializable {

    private List<Record> contacts = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    public int count() {
        return contacts.size();
    }

    public void addContact() {
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

    }

    public Record getContactByIndex(int index) {
        return contacts.get(index - 1);
    }

    public Record getContactByName(String name) {
        return search(name).get(0);

    }

    public void removeContactByIndex(int index) {
        contacts.remove(index - 1);
    }

    public void removeContact(Record record) {
        contacts.remove(record);
    }

    public List<Record> search(String query) {
        List<Record> result = new ArrayList<>();
        for(Record record : contacts) {
            if(record.returnFieldValue("name").matches(query)) {
                result.add(record);
            }
        }
       return result;
    }

    public void printContacts() {
        if (contacts.size() == 0) {
            System.out.println("No records to show!");
        } else {
            contacts.forEach(x -> System.out.printf("%d. %s %n", contacts.indexOf(x) + 1, x.toTitle()));
            System.out.println();
        }
    }

}
