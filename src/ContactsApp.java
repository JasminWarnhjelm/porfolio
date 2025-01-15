
import java.io.Console;

/**
 * The main class for the Contact App.
 * <p>
 * This class provides a command-line interface to manage a contact list.
 * Users can create, read, update and delete contacts stored in a CSV file.
 * The application runs in a loop until the user decides to quit the program by
 * pressing q and enter.
 * </p>
 *
 * <p><b>Features:</b></p>
 * <ul>
 *      <li>Create new contacts and save them to a CSV file.</li>
 *      <li>Read and display all contacts in the CSV file.</li>
 *      <li>Update existing contacts by specifying the contact line number.</li>
 *      <li>Delete contacts from the CSV file.</li>
 * </ul>
 *
 * @author Jasmin Susann Wärnhjelm
 */
public class ContactsApp {
    /**
     * Start of the Contact App
     * <p>
     * This method initializes the application, displays greetings to the user
     * and provides options for managing contacts. The program continues running
     * in a loop until the user chooses to quit the program.
     * </p>
     * @param args command-line arguments (not used in this application)
     */
    public static void main(final String[] args) {
        Console c = System.console();

        System.out.println("Hello, welcome to Contact App!");
        try {
        Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("");
        }
        System.out.println("Contact list: ");

        String file = "Information.csv";
        MyFile.writeHeaders(file);
        MyFile.fileReader(file);
        System.out.println();

        try {
            Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("");
            }

        System.out.println("Instructions: ");
        System.out.println("Type create, read, update or delete to make your choise.");
        System.out.println("Apply the information by separating them with commas.");
        System.out.println("For example: ID-Number, First Name, Last Name, Phone Number, Address Postal Code City, E-Mail)");
        System.out.println();

        while (true) {
            System.out.println("What would you like to do? Create, read, update or delete a contact? (To quit press q and enter)");
            String choice = c.readLine().toLowerCase();

            switch(choice) {
                case "create":
                    Choices.create(file);
                    break;
                case "read":
                    MyFile.fileReader(file);
                    break;
                case "update":
                    if (MyFile.rowNumber == 1) {
                        System.out.println("File is empty can not update any information.");
                    } else if (MyFile.rowNumber == 2) {
                        try {
                            System.out.println("Do you want to update contact 1? (yes/no)");
                            String confirmation = c.readLine();
                            if (confirmation.equalsIgnoreCase("yes")) {
                                Choices.update(file, 1);
                            } else {
                                System.out.println("Updating cancelled!");
                            }
                        } catch (Exception e) {
                            System.out.println("Error problem with updating line.");
                        }
                    } else {
                        System.out.println("Which contact do you want to update? 1-"
                        + (MyFile.rowNumber - 1));

                        try {
                            int update_line = Integer.parseInt(c.readLine());

                            if (update_line >= 1 && update_line <= (MyFile.rowNumber - 1)) {
                                Choices.update(file, update_line);
                            } else {
                                System.out.println("Error. Invalid line number.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error. Please enter a number between 1 and "
                            + (MyFile.rowNumber - 1));
                        }
                    }
                    break;
                case "delete":
                    if (MyFile.rowNumber == 1) {
                        System.out.println("File is empty can not delete any information.");
                    } else if (MyFile.rowNumber == 2) {
                        try {
                            System.out.println("Do you want to delete contact 1? (yes/no)");
                            String confirmation = c.readLine();
                            if (confirmation.equalsIgnoreCase("yes")) {
                                Choices.delete(file, 1);
                            } else {
                                System.out.println("Deleting cancelled!");
                            }
                        } catch (Exception e) {
                            System.out.println("Error problem with deleting line.");
                        }
                    } else {
                        System.out.println("Which contact do you want to remove? 1-"
                        + (MyFile.rowNumber - 1));

                        try {
                            int delete_line = Integer.parseInt(c.readLine());

                            if (delete_line >= 1 && delete_line <= (MyFile.rowNumber - 1)) {
                                Choices.delete(file, delete_line);
                            } else {
                                System.out.println("Error. Invalid line number.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Error. Please enter a number between 1 and "
                            + (MyFile.rowNumber - 1));
                        }
                    }
                    break;
                case "q":
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 'create', 'read', 'update', 'delete' or 'q'.");
            }
        }
    }
}
