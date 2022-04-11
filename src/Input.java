package src;

import java.util.Scanner;

public class Input {
    private Scanner input; //lets us take in the user input


    public Input() {
        input = new Scanner(System.in);
    }

    public String getString() {
        return input.nextLine();
    }

    public boolean yesNo() {
        String userInput = getString();
        return (userInput.equalsIgnoreCase("y") ||
                userInput.equalsIgnoreCase("yes"));
    }

    public int getInt() {
        String inputInt = this.getString();
        try {

            return Integer.parseInt(inputInt);
        } catch (Exception e) {
            System.out.println("Must enter a valid integer");
            return getInt();
        }

    }

    public int getInt(int min, int max) {
        System.out.println("Please input a number between " + min + " and "
                + max + ": ");

        int userInt = getInt();

        if(userInt > max || userInt < min) {
            return getInt(min, max);
        }

        return userInt;
    }

    public double getDouble() {

        try {
            String userInput = this.getString();

            return Double.parseDouble(userInput);
        } catch (Exception e) {
            System.out.println("Must enter a valid double:");
            return getDouble();
        }
    }

    public double getDouble(double min, double max) {
        System.out.println("Please input a number between " + min + " and " + max);

        double userInput = getDouble();

        if (userInput > max || userInput < min ) {
            return getDouble(min, max);
        }

        return userInput;
    }
}
