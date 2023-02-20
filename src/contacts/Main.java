package contacts;


public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        String fileName = null;
        if (args.length != 0) {
            fileName = args[0];
        }
        new mainMenu(fileName).runMenu();
    }

}

