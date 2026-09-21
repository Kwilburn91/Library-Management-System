/*
Name: Kelly Wilburn
Course: Software Development I
Date: 9/21/26
Class Function: This class stores a patron’s information and checks that the information entered is valid.
Program Objective: The program stores and manages patron information while making sure the information is entered correctly.
*/

// Represents one patron in the LMS
public class Patron {

    private String patronId;
    private String firstName;
    private String lastName;

    private String streetNumber;
    private String streetName;
    private String city;
    private String stateInitials;
    private String zipCode;

    private double overdueFine;

    // Patron constructor
    public Patron(
            String patronId,
            String firstName,
            String lastName,
            String streetNumber,
            String streetName,
            String city,
            String stateInitials,
            String zipCode,
            double overdueFine) {

        setPatronId(patronId);
        setFirstName(firstName);
        setLastName(lastName);
        setStreetNumber(streetNumber);
        setStreetName(streetName);
        setCity(city);
        setStateInitials(stateInitials);
        setZipCode(zipCode);
        setOverdueFine(overdueFine);
    }

    public String getPatronId() {
        return patronId;
    }

    public void setPatronId(String patronId) {

        validatePatronId(patronId);

        this.patronId = patronId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        validateFirstName(firstName);

        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        validateLastName(lastName);

        this.lastName = lastName;
    }

    public String getPatronName() {

        return firstName + " " + lastName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {

        validateStreetNumber(streetNumber);

        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {

        validateStreetName(streetName);

        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {

        validateCity(city);

        this.city = city;
    }

    public String getStateInitials() {
        return stateInitials;
    }

    public void setStateInitials(String stateInitials) {

        validateStateInitials(stateInitials);

        this.stateInitials =
                stateInitials.toUpperCase();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {

        validateZipCode(zipCode);

        this.zipCode = zipCode;
    }

    public double getOverdueFine() {
        return overdueFine;
    }

    public void setOverdueFine(double overdueFine) {

        validateOverdueFine(overdueFine);

        this.overdueFine = overdueFine;
    }

    // Patron ID must contain exactly 7 digits.
    public static void validatePatronId(
            String patronId) {

        if (patronId == null
                || !patronId.matches("\\d{7}")) {

            throw new IllegalArgumentException(
                    "Patron ID must contain exactly 7 digits."
            );
        }
    }

    public static void validateFirstName(
            String firstName) {

        validateName(
                firstName,
                "First name"
        );
    }

    public static void validateLastName(
            String lastName) {

        validateName(
                lastName,
                "Last name"
        );
    }

    private static void validateName(
            String name,
            String fieldName) {

        if (name == null
                || name.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    fieldName + " cannot be empty."
            );
        }

        if (!name.matches(
                "[A-Za-z][A-Za-z' -]*")) {

            throw new IllegalArgumentException(
                    fieldName
                            + " may only contain letters, "
                            + "spaces, apostrophes, or hyphens."
            );
        }
    }

    public static void validateStreetNumber(
            String streetNumber) {

        if (streetNumber == null
                || streetNumber.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Street number cannot be empty."
            );
        }

        if (!streetNumber.matches(
                "\\d+[A-Za-z]?")) {

            throw new IllegalArgumentException(
                    "Street number must contain a valid number."
            );
        }
    }

    public static void validateStreetName(
            String streetName) {

        if (streetName == null
                || streetName.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Street name cannot be empty."
            );
        }

        if (!streetName.matches(
                "[A-Za-z0-9][A-Za-z0-9 .'-]*")) {

            throw new IllegalArgumentException(
                    "Street name contains invalid characters."
            );
        }
    }

    public static void validateCity(
            String city) {

        if (city == null
                || city.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "City cannot be empty."
            );
        }

        if (!city.matches(
                "[A-Za-z][A-Za-z .'-]*")) {

            throw new IllegalArgumentException(
                    "City may only contain letters, "
                            + "spaces, apostrophes, periods, "
                            + "or hyphens."
            );
        }
    }

    public static void validateStateInitials(
            String stateInitials) {

        if (stateInitials == null
                || !stateInitials.matches(
                "[A-Za-z]{2}")) {

            throw new IllegalArgumentException(
                    "State initials must contain exactly 2 letters."
            );
        }
    }

    public static void validateZipCode(
            String zipCode) {

        if (zipCode == null
                || !zipCode.matches("\\d{5}")) {

            throw new IllegalArgumentException(
                    "ZIP code must contain exactly 5 digits."
            );
        }
    }

    public static void validateOverdueFine(
            double overdueFine) {

        if (Double.isNaN(overdueFine)
                || Double.isInfinite(overdueFine)) {

            throw new IllegalArgumentException(
                    "Overdue fine must be a valid number."
            );
        }

        if (overdueFine < 0) {

            throw new IllegalArgumentException(
                    "Overdue fine cannot be negative."
            );
        }

        if (overdueFine > 250) {

            throw new IllegalArgumentException(
                    "Overdue fine cannot be greater than $250.00."
            );
        }
    }

    @Override
    public String toString() {

        return "Patron ID: " + patronId
                + "\n"
                + firstName + " " + lastName
                + "\n"
                + streetNumber + " "
                + streetName + " "
                + city + ", "
                + stateInitials + " "
                + zipCode
                + String.format(
                "\nOverdue Fine: $%.2f",
                overdueFine
        )
                + "\n";
    }
}
