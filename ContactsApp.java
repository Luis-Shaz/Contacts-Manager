import src.ContactsManager;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ContactsApp {
        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                //        public static ContactsManager contacts = new ContactsManager();
                //        public static File contactsFile = new Files();
                //      public static boolean exitApp
                //      private static input

                String filePath = "data";
                Path path = Paths.get("data");

                System.out.println("1. View contacts.");
                System.out.println("2. Add a new contact.");
                System.out.println("3. Search a contact by name.");
                System.out.println("4. Delete an existing contact.");
                System.out.println("5. Exit.");
                System.out.println("Enter an option (1, 2, 3, 4 or 5):");

                int userInput = scanner.nextInt();

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
