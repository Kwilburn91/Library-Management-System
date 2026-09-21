/*
Name: Kelly Wilburn
Course: Software Development I
Date: 9/21/26
Class Function: This class manages the list of library patrons by: adding, removing, searching, loading, and displaying patron information.
Program Objective: The program keeps track of library patrons and allows users to: add, remove, search, and view their information.
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LMS {

    private ArrayList<Patron> patrons;

    // LMS constructor
    public LMS() {

        patrons = new ArrayList<>();
    }

    // Allows the user to manually add a patron
    public void addPatronManually(
            Scanner keyboard) {

        System.out.println();
        System.out.println("--- Add Patron Manually ---");

        String patronId =
                getPatronId(keyboard);

        Patron existingPatron =
                findPatron(patronId);

        if (existingPatron != null) {

            System.out.println(
                    "ERROR: A patron with ID "
                            + patronId
                            + " already exists."
            );

            return;
        }

        String firstName =
                getFirstName(keyboard);

        String lastName =
                getLastName(keyboard);

        String streetNumber =
                getStreetNumber(keyboard);

        String streetName =
                getStreetName(keyboard);

        String city =
                getCity(keyboard);

        String stateInitials =
                getStateInitials(keyboard);

        String zipCode =
                getZipCode(keyboard);

        double overdueFine =
                getOverdueFine(keyboard);

        Patron newPatron =
                new Patron(
                        patronId,
                        firstName,
                        lastName,
                        streetNumber,
                        streetName,
                        city,
                        stateInitials,
                        zipCode,
                        overdueFine
                );

        patrons.add(newPatron);

        System.out.println();
        System.out.println(
                "Patron successfully added."
        );

        displayAllPatrons();
    }

    // Gets a valid patron ID
    private String getPatronId(
            Scanner keyboard) {

        while (true) {

            System.out.print(
                    "Enter 7-digit patron ID: "
            );

            String userInput =
                    keyboard.nextLine().trim();

            try {

                Patron.validatePatronId(
                        userInput
                );

                return userInput;

            } catch (IllegalArgumentException exception) {

                System.out.println(
                        "ERROR: "
                                + exception.getMessage()
                );
            }
        }
    }

    // Gets a valid first name
    private String getFirstName(
            Scanner keyboard) {

        while (true) {

            System.out.print(
                    "Enter first name: "
            );

            String userInput =
                    keyboard.nextLine().trim();

            try {

                Patron.validateFirstName(
                        userInput
                );

                return userInput;

            } catch (IllegalArgumentException exception) {

                System.out.println(
                        "ERROR: "
                                + exception.getMessage()
                );
            }
        }
    }

    // Gets a valid last name
    private String getLastName(
            Scanner keyboard) {

        while (true) {

            System.out.print(
                    "Enter last name: "
            );

            String userInput =
                    keyboard.nextLine().trim();

            try {

                Patron.validateLastName(
                        userInput
                );

                return userInput;

            } catch (IllegalArgumentException exception) {

                System.out.println(
                        "ERROR: "
                                + exception.getMessage()
                );
            }
        }
    }

    // Gets a valid street number
    private String getStreetNumber(
            Scanner keyboard) {

        while (true) {

            System.out.print(
                    "Enter street number: "
            );

            String userInput =
                    keyboard.nextLine().trim();

            try {

                Patron.validateStreetNumber(
                        userInput
                );

                return userInput;

            } catch (IllegalArgumentException exception) {

                System.out.println(
                        "ERROR: "
                                + exception.getMessage()
                );
            }
        }
    }

    // Gets a valid street name
    private String getStreetName(
            Scanner keyboard) {

        while (true) {

            System.out.print(
                    "Enter street name: "
            );

            String userInput =
                    keyboard.nextLine().trim();

            try {

                Patron.validateStreetName(
                        userInput
                );

                return userInput;

            } catch (IllegalArgumentException exception) {

                System.out.println(
                        "ERROR: "
                                + exception.getMessage()
                );
            }
        }
    }

    // Gets a valid city
    private String getCity(
            Scanner keyboard) {

        while (true) {

            System.out.print(
                    "Enter city: "
            );

            String userInput =
                    keyboard.nextLine().trim();

            try {

                Patron.validateCity(
                        userInput
                );

                return userInput;

            } catch (IllegalArgumentException exception) {

                System.out.println(
                        "ERROR: "
                                + exception.getMessage()
                );
            }
        }
    }

    // Gets valid state initials
    private String getStateInitials(
            Scanner keyboard) {

        while (true) {

            System.out.print(
                    "Enter state initials (example: FL): "
            );

            String userInput =
                    keyboard.nextLine().trim();

            try {

                Patron.validateStateInitials(
                        userInput
                );

                return userInput.toUpperCase();

            } catch (IllegalArgumentException exception) {

                System.out.println(
                        "ERROR: "
                                + exception.getMessage()
                );
            }
        }
    }

    // Gets a valid ZIP code
    private String getZipCode(
            Scanner keyboard) {

        while (true) {

            System.out.print(
                    "Enter 5-digit ZIP code: "
            );

            String userInput =
                    keyboard.nextLine().trim();

            try {

                Patron.validateZipCode(
                        userInput
                );

                return userInput;

            } catch (IllegalArgumentException exception) {

                System.out.println(
                        "ERROR: "
                                + exception.getMessage()
                );
            }
        }
    }

    // Gets a valid overdue fine
    private double getOverdueFine(
            Scanner keyboard) {

        while (true) {

            System.out.print(
                    "Enter overdue fine ($0.00-$250.00): "
            );

            String userInput =
                    keyboard.nextLine().trim();

            try {

                double enteredFine =
                        Double.parseDouble(userInput);

                Patron.validateOverdueFine(
                        enteredFine
                );

                return enteredFine;

            } catch (NumberFormatException exception) {

                System.out.println(
                        "ERROR: Please enter a valid number."
                );

            } catch (IllegalArgumentException exception) {

                System.out.println(
                        "ERROR: "
                                + exception.getMessage()
                );
            }
        }
    }

    /*
      Loads patrons from a text file.
      Required file format:
      ID-Name-Address-FineAmount
      Example: 1245789-Sarah Jones-1136 Gorden Ave. Orlando, FL 32822-40.54
      The line is split on the first 3 dashes only.
      This will allow the address to contain additional dashes.
     */
    public void loadPatronsFromFile(
            Scanner keyboard) {

        System.out.println();
        System.out.println(
                "--- Add Patrons From Text File ---"
        );

        System.out.print(
                "Enter the file name/path: "
        );

        String fileName =
                keyboard.nextLine().trim();

        // Remove quotation marks if supplied
        if (fileName.startsWith("\"")
                && fileName.endsWith("\"")) {

            fileName =
                    fileName.substring(
                            1,
                            fileName.length() - 1
                    );
        }

        if (fileName.isEmpty()) {

            System.out.println(
                    "ERROR: File name cannot be empty."
            );

        } else {

            File patronFile =
                    new File(fileName);

            if (!patronFile.exists()) {

                System.out.println(
                        "ERROR: File does not exist."
                );

            } else if (!patronFile.isFile()) {

                System.out.println(
                        "ERROR: The specified path is not a file."
                );

            } else {

                readPatronFile(patronFile);

                displayAllPatrons();
            }
        }
    }

    /*
      Reads patron information from a file.
      Required format: ID-Name-Address-FineAmount
      The line is split into exactly four fields using only the first three dashes.
     */
    private void readPatronFile(
            File patronFile) {

        int patronsAdded = 0;
        int linesSkipped = 0;
        int lineNumber = 0;

        try (Scanner fileScanner =
                     new Scanner(patronFile)) {

            while (fileScanner.hasNextLine()) {

                lineNumber++;

                String fileLine =
                        fileScanner.nextLine().trim();

                if (fileLine.isEmpty()) {
                    continue;
                }

            	/*
              	The 4 means split with a maximum of three sections.
              	Example:
              	1245789-Sarah Jones-1136 Gorden Ave. Orlando, FL 32822-40.54
              	becomes:
              	[0] 1245789
              	[1] Sarah Jones
              	[2] 1136 Gorden Ave. Orlando, FL 32822
              	[3] 40.54
             	*/
                String[] patronData =
                        fileLine.split("-", 4);

                if (patronData.length != 4) {

                    System.out.println(
                            "ERROR on line "
                                    + lineNumber
                                    + ": Incorrect format. "
                                    + "Expected "
                                    + "ID-Name-Address-FineAmount. "
                                    + "Line skipped."
                    );

                    linesSkipped++;

                } else {

                    boolean patronWasAdded =
                            processFilePatron(
                                    patronData,
                                    lineNumber
                            );

                    if (patronWasAdded) {
                        patronsAdded++;
                    } else {
                        linesSkipped++;
                    }
                }
            }

            System.out.println();
            System.out.println(
                    "File processing complete."
            );

            System.out.println(
                    "Patrons added: "
                            + patronsAdded
            );

            System.out.println(
                    "Lines skipped: "
                            + linesSkipped
            );

        } catch (FileNotFoundException exception) {

            System.out.println(
                    "ERROR: Unable to open the file."
            );
        }
    }

    /*
      Processes one patron from the input file. patronData contains exactly:
      [0] ID
      [1] Name
      [2] Address
      [3] FineAmount
     */
    private boolean processFilePatron(
            String[] patronData,
            int lineNumber) {

        String patronId =
                patronData[0].trim();

        String fullName =
                patronData[1].trim();

        String fullAddress =
                patronData[2].trim();

        String fineText =
                patronData[3].trim();

        try {

            // Validate ID. Requires exactly 7 digits.
            Patron.validatePatronId(
                    patronId
            );

            // The Name field is expected to contain a first name and last name.
            String[] nameParts =
                    fullName.split("\\s+", 2);

            if (nameParts.length != 2) {

                throw new IllegalArgumentException(
                        "Name must contain a first name and last name."
                );
            }

            String firstName =
                    nameParts[0].trim();

            String lastName =
                    nameParts[1].trim();

            Patron.validateFirstName(
                    firstName
            );

            Patron.validateLastName(
                    lastName
            );

        	/*
          	Breaks down the address.
          	Expected example:
          	1136 Gorden Ave. Orlando, FL 32822
          	The final comma separates the city from the state and ZIP code.
         	*/
            int commaIndex =
                    fullAddress.lastIndexOf(",");

            if (commaIndex == -1) {

                throw new IllegalArgumentException(
                        "Address must contain a comma "
                                + "before the state."
                );
            }

            String streetAndCity =
                    fullAddress
                            .substring(
                                    0,
                                    commaIndex
                            )
                            .trim();

            String stateAndZip =
                    fullAddress
                            .substring(
                                    commaIndex + 1
                            )
                            .trim();

            // Breaks down state and ZIP.
            String[] stateZipParts =
                    stateAndZip.split("\\s+");

            if (stateZipParts.length != 2) {

                throw new IllegalArgumentException(
                        "Address must end with state initials "
                                + "and a 5-digit ZIP code."
                );
            }

            String stateInitials =
                    stateZipParts[0].trim();

            String zipCode =
                    stateZipParts[1].trim();

            Patron.validateStateInitials(
                    stateInitials
            );

            Patron.validateZipCode(
                    zipCode
            );

            // Breaks down street number.
            String[] addressWords =
                    streetAndCity.split("\\s+");

            if (addressWords.length < 3) {

                throw new IllegalArgumentException(
                        "Address must contain a street number, "
                                + "street name, and city."
                );
            }

            String streetNumber =
                    addressWords[0];

            Patron.validateStreetNumber(
                    streetNumber
            );

        	/*
          	Finds where the city begins.
          	For the supplied format:
          	1136 Gorden Ave. Orlando
          	the street name is everything between the street number and the city.
         	*/

            String city =
                    addressWords[
                            addressWords.length - 1
                            ];

            StringBuilder streetNameBuilder =
                    new StringBuilder();

            for (int i = 1;
                 i < addressWords.length - 1;
                 i++) {

                if (streetNameBuilder.length() > 0) {
                    streetNameBuilder.append(" ");
                }

                streetNameBuilder.append(
                        addressWords[i]
                );
            }

            String streetName =
                    streetNameBuilder.toString();

            Patron.validateStreetName(
                    streetName
            );

            Patron.validateCity(
                    city
            );

        	/*
          	Breaks down the fine amount.
          	The file can NOT contain a dollar sign.
          	Example: 40.54, NOT: $40.54
         	*/
            if (fineText.startsWith("$")) {

                throw new IllegalArgumentException(
                        "Fine amount must not contain a dollar sign."
                );
            }

            double overdueFine =
                    Double.parseDouble(fineText);

            Patron.validateOverdueFine(
                    overdueFine
            );


            // Check for any duplicate patron ID.
            Patron existingPatron =
                    findPatron(patronId);

            if (existingPatron != null) {

                System.out.println(
                        "ERROR on line "
                                + lineNumber
                                + ": Patron ID "
                                + patronId
                                + " already exists. "
                                + "Line skipped."
                );

                return false;
            }


            // Creates the patron

            Patron newPatron =
                    new Patron(
                            patronId,
                            firstName,
                            lastName,
                            streetNumber,
                            streetName,
                            city,
                            stateInitials,
                            zipCode,
                            overdueFine
                    );

            patrons.add(newPatron);

            return true;

        } catch (NumberFormatException exception) {

            System.out.println(
                    "ERROR on line "
                            + lineNumber
                            + ": Fine amount must be a valid number. "
                            + "Line skipped."
            );

        } catch (IllegalArgumentException exception) {

            System.out.println(
                    "ERROR on line "
                            + lineNumber
                            + ": "
                            + exception.getMessage()
                            + " Line skipped."
            );
        }

        return false;
    }

    // Removes a patron using their ID
    public void removePatron(
            Scanner keyboard) {

        System.out.println();
        System.out.println("--- Remove Patron ---");

        String patronId =
                getPatronId(keyboard);

        Patron patronToRemove =
                findPatron(patronId);

        if (patronToRemove == null) {

            System.out.println(
                    "ERROR: No patron was found with ID "
                            + patronId
                            + "."
            );

        } else {

            patrons.remove(patronToRemove);

            System.out.println(
                    "Patron "
                            + patronToRemove.getPatronName()
                            + " has been successfully removed."
            );

            displayAllPatrons();
        }
    }

    // Searches for a patron by ID
    public void searchById(
            Scanner keyboard) {

        System.out.println();
        System.out.println("--- Search By ID ---");

        String patronId =
                getPatronId(keyboard);

        Patron foundPatron =
                findPatron(patronId);

        if (foundPatron == null) {

            System.out.println();
            System.out.println(
                    "No patron was found with ID "
                            + patronId
                            + "."
            );

        } else {

            System.out.println();
            System.out.println(
                    "Patron found:"
            );

            System.out.println(
                    "--------------------------------------"
            );

            System.out.println(foundPatron);

            System.out.println(
                    "--------------------------------------"
            );
        }
    }

    // Displays all patrons
    public void displayAllPatrons() {

        System.out.println();
        System.out.println(
                "--- Current LMS Patrons ---"
        );

        if (patrons.isEmpty()) {

            System.out.println(
                    "There are currently no patrons "
                            + "in the system."
            );

        } else {

            System.out.println(
                    "Number of patrons: "
                            + patrons.size()
            );

            System.out.println();

            for (Patron currentPatron :
                    patrons) {

                System.out.println(currentPatron);

                System.out.println(
                        "--------------------------------------"
                );
            }
        }
    }

    // Searches the ArrayList for a patron ID
    private Patron findPatron(
            String patronId) {

        for (Patron currentPatron :
                patrons) {

            if (currentPatron
                    .getPatronId()
                    .equals(patronId)) {

                return currentPatron;
            }
        }

        return null;
    }
}
