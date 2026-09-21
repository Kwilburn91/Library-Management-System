/*
Name: Kelly Wilburn
Course: Software Development I
Date: 9/21/26
Class Function: This class runs the library management system (LMS) program, and lets the user: add, remove, search, and view patrons.
Program Objective: The program manages library patrons by letting users add, remove, search, and view patron information.
*/
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LMS lms = new LMS();
        Scanner keyboard = new Scanner(System.in);

        boolean isRunning = true;

        System.out.println("======================================");
        System.out.println("   LMS - Library Management System");
        System.out.println("======================================");

        while (isRunning) {

            displayMenu();

            int menuChoice = getIntInput(
                    keyboard,
                    "Enter your choice: "
            );

            if (menuChoice == 1) {

                lms.addPatronManually(keyboard);

            } else if (menuChoice == 2) {

                lms.loadPatronsFromFile(keyboard);

            } else if (menuChoice == 3) {

                lms.removePatron(keyboard);

            } else if (menuChoice == 4) {

                lms.searchById(keyboard);

            } else if (menuChoice == 5) {

                lms.displayAllPatrons();

            } else if (menuChoice == 6) {

                System.out.println();
                System.out.println(
                        "Thank you for using the LMS."
                );

                isRunning = false;

            } else {

                System.out.println();
                System.out.println(
                        "ERROR: Please select an option from 1-6."
                );
            }
        }

        keyboard.close();
    }

    // Displays the main menu
    private static void displayMenu() {

        System.out.println();
        System.out.println("--------------------------------------");
        System.out.println("       	LMS MAIN MENU");
        System.out.println("--------------------------------------");
        System.out.println("1. Add Patron Manually");
        System.out.println("2. Add Patrons From Text File");
        System.out.println("3. Remove Patron");
        System.out.println("4. Search By ID");
        System.out.println("5. Display All Patrons");
        System.out.println("6. Exit");
        System.out.println("--------------------------------------");
    }

    // Gets an integer from the user
    private static int getIntInput(
            Scanner keyboard,
            String prompt) {

        while (true) {

            System.out.print(prompt);

            String userInput =
                    keyboard.nextLine().trim();

            try {

                return Integer.parseInt(userInput);

            } catch (NumberFormatException exception) {

                System.out.println(
                        "ERROR: Please enter a valid number."
                );
            }
        }
    }
}
