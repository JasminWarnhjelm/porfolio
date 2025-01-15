
import java.io.*;
/**
 * Provides methods that are used to manage the contacts stored in a CSV file.
 * <p>
 * This class allowes user to create, update and delete contact information
 * within a CSV file.
 * </p>
 */
public class Choices {
    /**
     * Method for creating a contact and writing the contact into a file.
     * <p>
     * This method asks the user for their contact informations, validates the
     * input and creates a new object. The contact information is then written
     * to the specified CSV file.
     * </p>
     * @param file is a csv file that the contact information and the headings
     * are stored
     */
    public static void create(final String file) {
        Console c = System.console();
        try {
            System.out.println(
                        "Enter ID-Number, First Name, Last Name, "
                        + "Phone Number, (optional: Address and E-Mail): ");
            String contact = c.readLine();

            String[] contactFields = contact.split(",");

            Info newContact = null;

            if (contactFields.length >= 4) {
                newContact = new Info(
                        Validation.idValidation(contactFields[0].trim()),
                        Validation.nameValidation(contactFields[1].trim()),
                        Validation.nameValidation(contactFields[2].trim()),
                        Validation.phoneNumberValidation(contactFields[3].trim()),
                        contactFields.length > 4 ? Validation.addressValidation
                        (contactFields[4].trim()) : "",
                        contactFields.length > 5 ?
                        Validation.eMailValidation(contactFields[5].trim()) : "");
                System.out.println("Contact saved!");
            } else {
                System.out.println("Not enough data provided. Fill in ID-number, First Name, Last Name and Phone Number.");
                return;
            }
            MyFile.writeToFile(file, newContact);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input for the contact information: " + e.getMessage());
        }
    }

    /**
     * Method for updating a contact.
     * <p>
     * This method asks the user for the updated contact informations, validates
     *  the input and creates a new object. The method confirms the changes
     * from the user. Then it writes the other contacts and the uppdated
     * contact to a new file which is replaced with the old one.
     * </p>
     * @param file is a csv file that the contact information and the headings
     * are stored
     * @param line is a line in Information.csv file that the user wants to
     * update
     * @throws IllegalArgumentException if the input validation fails
     * @throws IOException if an error occurs while reading or writing to the
     * file
     */
    public static void update(final String file, final int line) {
        Console c = System.console();
        String tempFile = "temp.csv";
        File oldFile = new File(file);
        File newFile = new File(tempFile);

        String currentLine;
        int currentLineNumber = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(oldFile));
            PrintWriter pw = new PrintWriter(newFile);

            System.out.println(
                    "Apply changes you wanna make for ID-Number, First Name, "
                    + "Last Name, Phone Number, "
                    + "(optional: Address and E-Mail): ");
            String contact = c.readLine();

            String[] contactFields = contact.split(",");

            Info updatedContact = null;

            if (contactFields.length >= 4) {
                updatedContact = new Info(
                        Validation.idValidation(contactFields[0].trim()),
                        Validation.nameValidation(contactFields[1].trim()),
                        Validation.nameValidation(contactFields[2].trim()),
                        Validation.phoneNumberValidation(contactFields[3].trim()),
                        contactFields.length > 4 ?
                        Validation.addressValidation(contactFields[4].trim()) : "",
                        contactFields.length > 5 ?
                        Validation.eMailValidation(contactFields[5].trim()) : "");
            } else {
                System.out.println(
                        "Not enough data provided. Fill in ID-number, "
                        + "First Name, Last Name and Phone Number.");
                System.out.println("Try again!");
                pw.close();
                br.close();
                return;
            }

            System.out.println("Contact updating: "
            + updatedContact.toConsoleString());
            System.out.println("Confirm updated (yes/no): ");
            String confirmation = c.readLine();

            if (!confirmation.equalsIgnoreCase("yes")) {
                System.out.println("Updated cancelled!");
                pw.close();
                br.close();
                return;
            }

            while ((currentLine = br.readLine()) != null) {
                if (currentLineNumber != line) {
                    pw.println(currentLine);
                } else {
                    pw.println(updatedContact.toString());
                }
                currentLineNumber++;
            }
            pw.flush();
            pw.close();
            br.close();

            oldFile.delete();
            newFile.renameTo(oldFile);

        } catch (Exception e) {
            System.out.println("An error occurred while updating the contact: "
            + e.getMessage());
        }
        System.out.println("Contact updated!");
    }

    /**
     * Method for deleting a contact.
     * <p>
     * This method is provided with the line that the user wants to delete.
     * File is rewritten without the deleted contact into a new file that is
     * placed with the old one.
     * </p>
     * @param file is a csv file that the contact information and the headerss
     * are stored
     * @param line is a line in Information.csv file that the user wants to
     * delete
     * @throws IOException if an error occurs while reading or writing to the
     * file
     */
    public static void delete(final String file, final int line) {
        String tempFile = "temp.csv";
        File oldFile = new File(file);
        File newFile = new File(tempFile);

        String currentLine;
        int currentLineNumber = 0;

        try {
            BufferedReader br = new BufferedReader (new FileReader(oldFile));
            PrintWriter pw = new PrintWriter(newFile);

            while ((currentLine = br.readLine()) != null) {
                if (currentLineNumber != line) {
                    pw.println(currentLine);
                }
                currentLineNumber++;
            }
            pw.flush();
            pw.close();
            br.close();

            oldFile.delete();
            newFile.renameTo(oldFile);

        } catch (Exception e) {
            System.out.println("An error occurred while deleting the contact: "
            + e.getMessage());
        }
        System.out.println("Contact deleted!");
    }
}
