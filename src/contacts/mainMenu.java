package contacts;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class mainMenu {


        final static Scanner scanner = new Scanner(System.in);

        static ContactsDB contacts = new ContactsDB();

        private String fileName;

        mainMenu(String fileName) {
            this.fileName = fileName;
        }

        public void runMenu(){
            createDB();
            String input;
            while(true) {
                System.out.print("Enter action (add, remove, edit, count, info, exit): ");
                input = getInput();
                switch (input) {
                    case "add" : contacts.addContact();
                                try {
                                    SerializationUtils.serialize(contacts, fileName);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                        break;
                    case "list" : contacts.printContacts();
                        break;
                    case "search" : editRecord();
                        break;
                    case "count" : printCount();
                        break;
                    case "exit" : return;
                    default:
                        System.out.println("Unknown command. Try again");
                        break;
                }
            }
        }

    private void createDB() {
        try {
            File file = new File("./" + fileName);
            if (!file.exists()) {throw new NullPointerException();}
            contacts = (ContactsDB) SerializationUtils.deserialize(fileName);
            System.out.println("open " + fileName + "\n");
        } catch (IOException | ClassNotFoundException | NullPointerException e) {
            contacts = new ContactsDB();
            fileName = "db.contacts";
            File file = new File ("./" + fileName);
            System.out.println("created " + fileName + "\n");
        }
    }

    static String getInput() {
        return scanner.nextLine().trim();
    }

    private static void removeRecord() {
        if (contacts.count() == 0) {
            System.out.println("No records to remove!");
        } else {
            contacts.printContacts();
            System.out.print("Select a record: ");
            contacts.removeContactByIndex(Integer.parseInt(getInput()));
            System.out.println("The record removed!\n");
        }
    }

    private static void editRecord() {
        if (contacts.count() == 0) {
            System.out.println("No records to edit!");
        } else {
            contacts.printContacts();
            System.out.print("Select a record: ");
            int index = Integer.parseInt(getInput()) - 1;
            if ("Person".equals(contacts.getContactByIndex(index).getClass().getSimpleName())) {
                Person person = (Person) contacts.getContactByIndex(index);
                System.out.printf("Select a field %s: ", person.getFields());
                String field = getInput();
                System.out.printf("Enter %s: ", field);
                String value = getInput();
                person.changeField(field, value);
                System.out.println("The record updated!\n");
            }
            if ("Organization".equals(contacts.getContactByIndex(index).getClass().getSimpleName())) {
                Organization organization = (Organization) contacts.getContactByIndex(index);
                System.out.printf("Select a field %s: ", organization.getFields());
                String field1 = getInput();
                System.out.printf("Enter %s: ", field1);
                String value1 = getInput();
                organization.changeField(field1, value1);
                System.out.println("The record updated!\n");
            }
        }
    }

    private static void printCount() {
        System.out.printf("The Phone Book has %d records.%n", contacts.count());
    }

    private static void getInfo() {
        if (contacts.count() == 0) {
            System.out.println("No records to show!");
        } else {
            contacts.printContacts();
            System.out.print("Enter index to show info: ");
            try {
                int index = Integer.parseInt(getInput());
                System.out.println((contacts.getContactByIndex(index)).toString());
            } catch (NumberFormatException e) {
                System.out.println("Unknown index");
            }
        }

    }

}
