
/**
 * This class provides the methods for the validations of the contacts such as
 * names, ID numbers, phone number, addresses and email addresses.
 * <p>
 * Each validation method ensures that the user input meets the specific format
 * that's required for different informations. The methods uses reqular
 * expression to do this. If an input fails validation an
 * IllegalArgumentException is thrown with error message.
 * </p>
 */
public class Validation {
    /**
     * Validates an id-number input by the user.
     * <p>
     * This metod checks if the given id-number matches a specific regex
     * pattern.
     * The regex ensures that the id-number matches the pattern of the finnish
     * id-number requirements.
     * </p>
     *
     * @param id is the id-number entered by the user
     * @return is the trimmed id if it passes validation
     * @throws IllegalArgumentException if the id doesn't match the regex
     */
    public static String idValidation(final String id) {
        if (!id.matches("(0[1-9]|[1-2][0-9]|3[0-1])(0[1-9]|1[0-2])[0-9]{2}[A+-][0-9]{3}[A-Z0-9]$")) {
            //checks the date, month ja year then A, + or - and the 3 numbers
            //and a capital letter or a number between 0-9
            throw new IllegalArgumentException("Error. Invalid ID-Number.");
        } else {
            return id;
        }
    }

    /**
     * Validates a name input by the user.
     * <p>
     * This metod checks if the given name matches a specific regex pattern.
     * The regex ensures that the name consists of only letters, spaces,
     * periods, commas, apostrophes or hyphes and starts with a letter. The
     * maximum length of the name is 50 chaacters. This is used to validate the
     * first and the last names.
     * </p>
     *
     * @param name is the name entered by the user
     * @return is the trimmed name if it passes validation
     * @throws IllegalArgumentException if the name doesn't match the regex
     */
    public static String nameValidation(final String name) {
        if (!name.matches("(?i)(^[a-zåäö])((?![ .,'-]$)[a-zåäö .,'-]){0,40}$")) {
            throw new IllegalArgumentException("Error. Name must contain only letters, spaces, periods, commas, apostrophes or hyphens.");
        } else {
            return name;
        }
    }

    /**
     * Validates a phone number input by the user.
     * <p>
     * This metod checks if the given phone number matches a specific regex
     * pattern. The regex ensures that the phone number matches the requirements
     *  that phone numbers has. The phone number can be from any country.
     * </p>
     *
     * @param number is the phone number entered by the user
     * @return is the trimmed phone number if it passes validation
     * @throws IllegalArgumentException if the phone number doesn't match the
     * regex
     */
    public static String phoneNumberValidation(final String number) {
        if (!number.matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")) {
            throw new IllegalArgumentException("Error. Invalid phone number.");
        } else {
            return number;
        }
    }

    /**
     * Validates an address input by the user.
     * <p>
     * This metod checks if the given address matches a specific regex pattern.
     * The regex ensures that the address includes the address, the postal code
     * and the city.
     *
     * </p>
     *
     * @param address is the address entered by the user
     * @return is the trimmed address if it passes validation
     * @throws IllegalArgumentException if the addres doesn't match the regex
     */
    public static String addressValidation(final String address) {
        if (!(address == null || address.trim().isEmpty())) {
            if (!address.matches("[A-Za-zåäöÅÄÖ0-9.,' -]*[ ][0-9]{5}[ ][A-Za-zåäöÅÄÖ]*")) {
                //any letters or numbers, spacing, 5 numbers, spacing, any
                //letters
                throw new IllegalArgumentException("Error. Address needs to contain your address, postal code and city.");
            } else {
                return address;
            }
        } return address;
    }

    /**
     * Validates an e-mail input by the user.
     * <p>
     * This metod checks if the given e-mail matches a specific regex pattern.
     * The regex ensures that the e-mail is in this format: example@gmail.com.
     * </p>
     *
     * @param eMail is the e-mail entered by the user
     * @return is the trimmed e-mail if it passes validation
     * @throws IllegalArgumentException if the e-mail doesn't match the regex
     */
    public static String eMailValidation(final String eMail) {
        if (!eMail.matches("[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+")) {
            throw new IllegalArgumentException("Error. E-mail put in wrong format.");
        } else {
            return eMail;
        }
    }
}
