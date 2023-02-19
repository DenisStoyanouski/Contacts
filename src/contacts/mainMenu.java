package contacts;
import java.util.Scanner;

public class mainMenu {


        final static Scanner scanner = new Scanner(System.in);

        final static ContactsDB contactsDB = new ContactsDB("db.contacts");

        public static void runMenu(){
            String input;
            while(true) {
                System.out.print("Enter action (add, remove, edit, count, info, exit): ");
                input = getInput();
                switch (input) {
                    case "add" : ContactsDB.addContact();
                        break;
                    case "list" : ContactsDB.printContacts();
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

    static String getInput() {
        return scanner.nextLine().trim();
    }

    private static void removeRecord() {
        if (ContactsDB.count() == 0) {
            System.out.println("No records to remove!");
        } else {
            ContactsDB.printContacts();
            System.out.print("Select a record: ");
            ContactsDB.removeContactByIndex(Integer.parseInt(getInput()));
            System.out.println("The record removed!\n");
        }
    }

    private static void editRecord() {
        if (ContactsDB.count() == 0) {
            System.out.println("No records to edit!");
        } else {
            ContactsDB.printContacts();
            System.out.print("Select a record: ");
            int index = Integer.parseInt(getInput()) - 1;
            if ("Person".equals(ContactsDB.getContactByIndex(index).getClass().getSimpleName())) {
                Person person = (Person) ContactsDB.getContactByIndex(index);
                System.out.printf("Select a field %s: ", person.getFields());
                String field = getInput();
                System.out.printf("Enter %s: ", field);
                String value = getInput();
                person.changeField(field, value);
                System.out.println("The record updated!\n");
            }
            if ("Organization".equals(ContactsDB.getContactByIndex(index).getClass().getSimpleName())) {
                Organization organization = (Organization) ContactsDB.getContactByIndex(index);
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
        System.out.printf("The Phone Book has %d records.%n", ContactsDB.count());
    }

    private static void getInfo() {
        if (ContactsDB.count() == 0) {
            System.out.println("No records to show!");
        } else {
            ContactsDB.printContacts();
            System.out.print("Enter index to show info: ");
            try {
                int index = Integer.parseInt(getInput());
                System.out.println((ContactsDB.getContactByIndex(index)).toString());
            } catch (NumberFormatException e) {
                System.out.println("Unknown index");
            }
        }

    }

}
