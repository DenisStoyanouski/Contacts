package contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
        final static List<Record> contacts = new ArrayList<>();

        final static Scanner scanner = new Scanner(System.in);

        public static void runMenu() {
            String input = null;
            while(true) {
                System.out.print("Enter action (add, remove, edit, count, info, exit): ");
                input = getInput();
                switch (input) {
                    case "add" : addRecord();
                        break;
                    case "remove" : removeRecord();
                        break;
                    case "edit" : editRecord();
                        break;
                    case "count" : printCount();
                        break;
                    case "info" : getInfo();
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

    private static void addRecord() {
        System.out.print("Enter the type (person, organization): ");
        Record record = null;
        String type = getInput();
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

    private static void removeRecord() {
        if (contacts.size() == 0) {
            System.out.println("No records to remove!");
        } else {
            printContacts();
            System.out.print("Select a record: ");
            contacts.remove(Integer.parseInt(getInput()) - 1);
            System.out.println("The record removed!\n");
        }
    }

    private static void editRecord() {
        if (contacts.size() == 0) {
            System.out.println("No records to edit!");
        } else {
            printContacts();
            System.out.print("Select a record: ");
            int index = Integer.parseInt(getInput()) - 1;
            if ("Person".equals(contacts.get(index).getClass().getSimpleName())) {
                Person person = (Person) contacts.get(index);
                System.out.print("Select a field (name, surname, birth, gender, number): ");
                String field = getInput();
                switch (field) {
                    case "name" :
                        System.out.print("Enter name: ");
                        person.setName(getInput());
                        System.out.println("The record updated!\n");
                        break;
                    case "surname" :
                        System.out.print("Enter surname: ");
                        person.setSurname(getInput());
                        System.out.println("The record updated!\n");
                        break;
                    case "birth" :
                        System.out.print("Enter birth: ");
                        person.setBirthDate(getInput());
                        System.out.println("The record updated!\n");
                        break;
                    case "gender" :
                        System.out.print("Enter gender: ");
                        person.setGender(getInput());
                        System.out.println("The record updated!\n");
                        break;
                    case "number" :
                        System.out.print("Enter number: ");
                        person.setPhoneNumber(getInput());
                        System.out.println("The record updated!\n");
                        break;
                    default :
                        System.out.println("Unknown field. Try again");
                }
            }
            if ("Organization".equals(contacts.get(index).getClass().getSimpleName())) {
                Organization organization = (Organization) contacts.get(index);
                System.out.print("Select a field (address, number): ");
                String field1 = getInput();
                switch (field1) {
                    case "address":
                        System.out.print("Enter address: ");
                        organization.setAddress(getInput());
                        System.out.println("The record updated!\n");
                        break;
                    case "number":
                        System.out.print("Enter number: ");
                        organization.setPhoneNumber(getInput());
                        System.out.println("The record updated!\n");
                        break;
                    default:
                        System.out.println("Unknown field. Try again");
                }
            }
        }
    }

    private static void printCount() {
        System.out.printf("The Phone Book has %d records.%n", contacts.size());
    }

    private static void printContacts() {
        if (contacts.size() == 0) {
            System.out.println("No records to show!");
        } else {
            contacts.forEach(x -> System.out.printf("%d. %s %n", contacts.indexOf(x) + 1, x.toTitle()));
        }
    }

    private static void getInfo() {
        if (contacts.size() == 0) {
            System.out.println("No records to show!");
        } else {
            printContacts();
            System.out.print("Enter index to show info: ");
            try {
                System.out.println(contacts.get(Integer.parseInt(getInput()) - 1).toString());
            } catch (NumberFormatException e) {
                System.out.println("Unknown index");
            }
        }

    }

}
