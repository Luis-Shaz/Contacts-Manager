package src;

import src.ContactsManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readAllLines;

public class ContactsApp {

        public static void main(String[] args) throws IOException {

                menu();

        }

        public static void showContacts(){

            String directory = "data";
            String filename = "contacts.txt";
            Path dataFile = Paths.get(directory, filename);

            try {

                List<String> contactsFile = Files.readAllLines(dataFile);

                System.out.println("Name         |        Phone Number");
                System.out.println("__________________________________");

                for (int i = 0; i < contactsFile.size(); i += 1) {
                    System.out.println((i + 1) + ": " + contactsFile.get(i));
                }

                System.out.println("__________________________________");

            } catch (IOException error) {

                System.err.println("Name not found");

            }

        }

        public static void addNewContact(String name, String phoneNum) {

            String directory = "data";
            String filename = "contacts.txt";
            Path dataFile = Paths.get(directory, filename);

            try {
                Files.write(
                        dataFile,
                        Arrays.asList(name + " | " +  phoneNum), // list with one item
                        StandardOpenOption.APPEND
                );
            } catch (IOException e) {
                System.err.println("Name not found");
            }

        }

        public static void searchContacts(String name){

            String directory = "data";
            String filename = "contacts.txt";
            Path dataFile = Paths.get(directory, filename);

            try {

                List<String> contactsFile = Files.readAllLines(dataFile);

                for (int i = 0; i < contactsFile.size(); i += 1) {

                    if (contactsFile.get(i).contains(name)){
                       System.out.println("Contact found!");
                       System.out.println(contactsFile.get(i));
                   }

                    if (i == contactsFile.size()-1 && !contactsFile.get(i).contains(name)) {
                        System.out.println("Name not found.");
                    }

                }

            } catch (IOException error) {

                System.err.println("Name not found");

            }
        }

        public static String deleteContact(String name){

            String directory = "data";
            String filename = "contacts.txt";
            Path dataFile = Paths.get(directory, filename);

            try {

                List<String> contactsFile = Files.readAllLines(dataFile);

                List<String> newList = new ArrayList<>();

                for (int i = 0; i < contactsFile.size(); i += 1) {


                    if (contactsFile.get(i).contains(name)){
                       continue;
                    }

                    if (i == contactsFile.size()-1 && !contactsFile.get(i).contains(name)) {
                        System.out.println("Name not found.");
                        return "";
                    }

                    newList.add(contactsFile.get(i));

                }

                Files.write(dataFile, newList);
                System.out.println("Name has been deleted");

            } catch (IOException error) {

                System.out.println("Name not found");

            }
            return "";
        }

        public static void menu() {

            while (true) {


                Input userSelection = new Input();

                System.out.println("1. View contacts.");
                System.out.println("2. Add a new contact.");
                System.out.println("3. Search a contact by name.");
                System.out.println("4. Delete an existing contact.");
                System.out.println("5. Exit.");
                System.out.println("Enter an option (1, 2, 3, 4 or 5):");


                int userInput = userSelection.getInt();

                if (userInput == 1) {
                    showContacts();
                }
                if (userInput == 2) {
                    System.out.println("Input name");
                    String name = userSelection.getString();
                    System.out.println("Input 10 digit phone number");
                    String phoneNum = userSelection.getString();
                    addNewContact(name, phoneNum);
                    System.out.println("Contact successfully added");
                }
                if (userInput == 3) {
                    System.out.println("Please input the name to be searched");
                    String name = userSelection.getString();
                    searchContacts(name);
                }
                if (userInput == 4) {
                    System.out.println("Which contact do you want to delete?");
                    String name = userSelection.getString();
                    deleteContact(name);
                }
                if (userInput == 5) {
                    System.out.println("Now exiting contact list");
                    break;

                }
            }
        }


}
