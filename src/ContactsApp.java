package src;

import src.ContactsManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class ContactsApp {




        public static void main(String[] args) throws IOException {
                Scanner scanner = new Scanner(System.in);


                String directory = "data";
                String filename = "contacts.txt";

                Path path = Paths.get(directory);
                Path dataFile = Paths.get(directory, filename);

                System.out.println(dataFile);

                try {
                        Files.write(
                                Paths.get("data", "contacts.txt"),
                                Arrays.asList("eggs"), // list with one item
                                StandardOpenOption.APPEND
                        );
                } catch (IOException e) {
                        System.err.println("Name not found");
                }

        }
          public static void menu() {
        Input userSelection = new Input();
                        System.out.println("1. View contacts.");
                        System.out.println("2. Add a new contact.");
                        System.out.println("3. Search a contact by name.");
                        System.out.println("4. Delete an existing contact.");
                        System.out.println("5. Exit.");
                        System.out.println("Enter an option (1, 2, 3, 4 or 5):");


              int userInput = userSelection.getInt();

                        if (userInput == 1) {
                                System.out.println("User selected 1");
                        }
                        if (userInput == 2) {
                                System.out.println("User selected 2");
                        }
                        if (userInput == 3) {

                                System.out.println("User selected 3");
                        }
                        if (userInput == 4) {
                                System.out.println("User selected 4");
                        }
                        if (userInput == 5) {
                                System.out.println("User selected 5");
                        }
                }


}
