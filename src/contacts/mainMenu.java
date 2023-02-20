package contacts;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class mainMenu {


        final static Scanner scanner = new Scanner(System.in);

        static ContactsDB contacts = new ContactsDB();

        private static String fileName;

        mainMenu(String fileName) {
            this.fileName = fileName;
        }

        public void runMenu(){
            createDB();
            String input;
            while(true) {
                System.out.print("Enter action (add, list, search, count, exit): ");
                input = getInput();
                switch (input) {
                    case "add" : contacts.addContact();
                                try {
                                    SerializationUtils.serialize(contacts, fileName);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                        break;
                    case "search" : search();
                        break;
                    case "list" : getList();
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

    private void getList() {
        contacts.printContacts();
        System.out.print("Enter action ([number], back): ");
        String input = getInput();
        if (input.matches("\\d*?")) {
            Record record = contacts.getContactByIndex(Integer.parseInt(input));
            System.out.println(record.printAllFields());
            recordMenu(record);
        }
    }

    private void search() {
        System.out.print("Enter search query: ");
        List<Record> result = contacts.search(getInput());
        System.out.printf("Found %d results:%n", result.size());
        result.forEach(x -> System.out.println((result.indexOf(x) + 1) + ". " + x.toTitle()));
        System.out.println();
        while(true) {
            System.out.print("Enter action ([number], back, again): ");
            String command = getInput();
            if(command.matches("\\d+")) {
                Record record = contacts.getContactByName(result.get(Integer.parseInt(command) - 1).returnFieldValue("name"));
                System.out.println(record.printAllFields());
                recordMenu(record);
                break;
            }
            if("again".equals(command)) {
                search();
            }
            if ("back".equals(command)) {
                break;
            }
        }
    }


    private static void recordMenu(Record record) {
        System.out.print("Enter action (edit, delete, menu): ");
        switch(getInput()) {
            case "edit" : editRecord(record);
            break;
            case "delete" : removeRecord(record);
            break;
            case "menu" : break;
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
            System.out.println("created " + fileName + "\n");
        }
    }

    static String getInput() {
        return scanner.nextLine().trim();
    }

    private static void removeRecord(Record record) {
        contacts.removeContact(record);
        try {
            SerializationUtils.serialize(contacts, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void editRecord(Record record) {
        if (contacts.count() == 0) {
            System.out.println("No records to edit!");
        } else {
            System.out.printf("Select a field %s: ", record.getFields());
            String field = getInput();
            System.out.printf("Enter %s: ", field);
            String value = getInput();
            record.changeField(field, value);
            System.out.println("Saved");
            System.out.println(record.printAllFields());
        }
        try {
            SerializationUtils.serialize(contacts, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        recordMenu(record);
    }

    private static void printCount() {
        System.out.printf("The Phone Book has %d records.%n", contacts.count());
    }
}
