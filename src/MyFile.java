
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

/**
 * This class contains methods that the application uses to write to the
 * CSV file or reads information from the file.
 * <p>
 * This class is used in the creation, modification and reading of the CSV file
 * that is used to store contact information. It includes:
 * <ul>
 *      <li>Write headers to a new CSV file</li>
 *      <li>Write contact information to an existing CSV file</li>
 *      <li>Read and dispay contact from a CSV file</li>
 * </ul>
 * </p>
 */
public class MyFile {
    public static int rowNumber;
    /**
     * Writes the header row of a CSV file
     * <p>
     * If the file doesn't exist, this metod creates the file and
     * writes the header row with the titles:
     * "ID-Number", "First Name", "Last Name", "Phone Number", "Address",
     * "E-Mail".
     * </p>
     * <p>
     * If the file already exists, this method doesn't do anything because it
     * would overwrite the existing file.
     * </p>
     *
     * @param file is a path to a csv file that the contact information and the
     * headers are stored
     * @throws FileNotFoundExeption if the file cannot be created or written to
     */
    public static void writeHeaders(final String file) {
        File csvFile = new File(file);
        if (!csvFile.exists()) {
            try (PrintWriter pw = new PrintWriter(file)) {
                pw.write("ID-Number,First Name,Last Name,Phone Number,"
                + "Address,E-Mail\n");
            } catch (FileNotFoundException e) {
                System.out.println("Error with handling the file: "
                + e.getMessage());
            }
        }
    }

    /**
     * Writes the information to CSV file.
     * <p>
     * This method writes the information provided to a CSV file. It uses
     * FileWriter and PrintWriter to do this. Each field is comma-separated and
     * a newline is added to the end of the line. This method doesn't overwrite
     * the existing content. After this the program closes the writer.
     * </p>
     *
     * @param file is a path to a csv file that the contact information and the
     * headers are stored
     * @param Person an object for the contact details to write
     * @throws IOException if an error occurs while writing to the file
     */
    public static void writeToFile(final String file, final Info Person) {

        try (FileWriter fw = new FileWriter(file, true);
                PrintWriter pw = new PrintWriter(fw)) {
            pw.write(Person.getIDNumber() + ","
                    + Person.getFirstName() + ","
                    + Person.getLastName() + ","
                    + Person.getPhoneNumber() + ","
                    + Person.getAddress() + ","
                    + Person.getEMail() + "\n");

            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("An error occured while writing to the file: "
            + e.getMessage());
        }
    }

    /**
     * Reads the information from the csv file.
     * <p>
     * This method uses bufferedReader to read the information from the file.
     * If first reads and displays the headers and then reads the file row by
     * row. It also adds a rownumber infront of the contact rows so that it
     * easier for the user to make changes to a specific contact row. The
     * method ensures proper formatting and spacing for better readability.
     * After this the program closes the reader.
     * </p>
     *
     * @param file is a path to a csv file that the contact information and the
     * headers are stored
     * @throws IOException if an error occurs while reading the file
     */
    public static void fileReader(final String file) {
        try
        (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            String line = reader.readLine();

            if (line != null) {
                System.out.print("     ");
                String[] columns = line.split(",");
                for (int i = 0; i < columns.length; i++) {
                    String myStr = "%-30s";
                    //% = start,- = line left, 30 = size, s = display
                    System.out.print(String.format(myStr, (columns[i])));
                }
                System.out.println();

                line = reader.readLine();
            }

            rowNumber = 1;
            while (line != null) {
                String[] columns = line.split(",");
                System.out.print(String.format("%-5s", (rowNumber + ".")));
                for (int i = 0; i < columns.length; i++) {
                    String myStr = "%-30s";
                    //% = start,- = line left, 20 = size, s = display
                    System.out.print(String.format(myStr, (columns[i])));
                }
                System.out.println();

                line = reader.readLine();

                rowNumber++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: "
            + e.getMessage());
        }
    }
}
