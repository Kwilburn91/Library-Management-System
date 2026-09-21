# Library-Management-System

 **Name:** Kelly Wilburn  
 **Course:** Software Development I CEN-3024C 

 ## Project Description

 This project is a Java console-based Library Management System (LMS). The application allows users to manage a collection of library patrons through a simple menu-driven interface.

 ### Users can:

 - Add a new patron manually
- Add multiple patrons from a text file
- Remove an existing patron by ID
- Search for a patron by ID
- Display all stored patrons
- View the total number of patrons in the system
- Exit the application
- The application uses an `ArrayList<Patron>` to store `Patron` objects.

 Each patron contains a unique 7-digit patron ID, name, address information, and an overdue fine amount.

 ## 2\. Important Programming Concepts and Tools

 The project demonstrates several important Java programming concepts:

 - **Object-Oriented Programming (OOP):** The application is organized into multiple classes, including `Main`, `LMS`, and `Patron`.
- **Encapsulation:** Class fields in the `Patron` class are declared `private` and are accessed or modified through getter and setter methods.
- **Classes and Objects:** `Patron` objects are created to represent individual library patrons.
- **Collections and ArrayLists:** An `ArrayList<Patron>` is used to store and manage the patrons in the system.
- **Methods:** Separate methods handle tasks such as adding, removing, searching, displaying, validating, and loading patrons.
- **Control Flow:** `if/else`, `while`, `for`, and `try/catch` statements control the application's behavior.
- **Input/Output:** Java's `Scanner` class is used to collect keyboard and file input, while `System.out.println()` and `System.out.print()` display information.
- **File Input:** The application uses `File` and `Scanner` to read patron information from a text file.
- **Exception Handling:** `try/catch` blocks handle invalid numeric input, file errors, and validation errors without terminating the program.
- **Input Validation:** Patron information is validated before it is added to the system.
- **Regular Expressions:** Regular expressions are used to validate patron IDs, names, street numbers, street names, state initials, and ZIP codes.
- **String Manipulation:** Methods such as `trim()`, `split()`, `substring()`, `toUpperCase()`, and `matches()` are used to process and validate input.
- **Duplicate Detection:** The system searches the `ArrayList` for an existing patron ID before adding a new patron.
- **Data Formatting:** The `toString()` method formats patron information, including the overdue fine as a dollar amount.

 ## 3\. Expected Inputs and Outputs

 ### Inputs

 The application accepts the following user inputs:

 **Menu selection:**

 - Add Patron Manually
- Add Patrons From Text File
- Remove Patron
- Search By ID
- Display All Patrons
- Exit

 When manually adding a patron, the user is prompted to enter:

 - 7-digit patron ID
- First name
- Last name
- Street number
- Street name
- City
- Two-letter state initials
- 5-digit ZIP code
- Overdue fine between `$0.00` and `$250.00`

 When removing or searching for a patron, the user is prompted to enter:

 - 7-digit patron ID

 When loading patrons from a text file, the user is prompted to enter:

 - File name or file path

 The expected text file format is:

```
ID-FirstName LastName-Street Number Street Name City, ST ZIP-FineAmount
```

 Example:

```
1245789-Sarah Jones-1136 Gorden Ave. Orlando, FL 32822-40.54
```

 The fine amount in the text file should not contain a dollar sign.

 ### Outputs

 The application displays different messages depending on the selected operation:

 - **Add Patron Manually:** Confirms that the patron was successfully added and displays the current patrons.
- **Add Patrons From Text File:** Reads the file, adds valid patrons, and reports how many patrons were added and how many lines were skipped.
- **Remove Patron:** Confirms that the patron was removed if the specified ID exists.
- **Search By ID:** Displays the patron's ID, name, address, and overdue fine if the patron is found.
- **Display All Patrons:** Displays the number of patrons and the information for each patron.
- **Empty LMS:** Informs the user that there are currently no patrons in the system.
- **Duplicate Patron ID:** Displays an error message if a patron with the same ID already exists.
- **Invalid Input:** Displays an appropriate error message when information does not meet the required format.
- **Invalid Menu Selection:** Displays an error message when the user enters a menu option outside of 1–6.
- **Invalid File:** Displays an error when the specified file does not exist or is not a valid file.
- **File Processing:** Reports the number of patrons successfully added and the number of lines skipped.
- **Exit:** Displays a thank-you message and terminates the application.

 ## 4\. Data Validation Rules

 The application applies validation rules to ensure that patron information is entered correctly.

 - **Patron ID:** Must contain exactly 7 digits.
- **First Name:** Cannot be empty and may contain letters, spaces, apostrophes, and hyphens.
- **Last Name:** Cannot be empty and may contain letters, spaces, apostrophes, and hyphens.
- **Street Number:** Must contain a valid number and may include one letter after the number.
- **Street Name:** Cannot be empty and may contain letters, numbers, spaces, periods, apostrophes, and hyphens.
- **City:** Cannot be empty and may contain letters, spaces, periods, apostrophes, and hyphens.
- **State:** Must contain exactly two letters.
- **ZIP Code:** Must contain exactly 5 digits.
- **Overdue Fine:** Must be a valid number between `$0.00` and `$250.00`.
- **Duplicate IDs:** A patron cannot be added if another patron already has the same ID.

 The system repeatedly prompts the user for corrected information when invalid input is entered.
