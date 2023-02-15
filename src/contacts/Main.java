package contacts;


import java.util.Scanner;

public class Main {

    private static String name;

    private static String surname;

    private static String phoneNumber;

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        createContact();
    }

    private static void createContact(){
        System.out.println("Enter the name of the person:");
        name = sc.nextLine();
        System.out.println("Enter the surname of the person:");
        surname = sc.nextLine();
        System.out.println("Enter the number:");
        phoneNumber = sc.nextLine();
        System.out.println("A record created!");
        System.out.println("A Phone Book with a single record created!");

    }


}

