
/**
 * The class represents a contact with properties ID number, first name, last
 * name, phone number, address and email.
 * <p>
 * This class provides getters and setters for each propertry and ensures
 * that the data is validated before being set using the validation class.
 * If a value doesn't pass validation an IllegalArgumentException is thrown.
 * </p>
 * <p>
 * This class also includes methods to represent the contact as a string format
 * for storage or console display.
 * </p>
 */
public class Info {
    private String IDNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String eMail;

    /**
     * Default constructor that generates empty strings to all properties.
     * <p>
     * This constructor creates an object with default values. Each property is
     * set to an empty string.
     */
    public Info() {
        this.IDNumber = "";
        this.firstName = "";
        this.lastName = "";
        this.phoneNumber = "";
        this.address = "";
        this.eMail = "";
    }

    /**
     * Constructs for the objects.
     * <p>
     * This constructor initializes the contact information with the provided
     * values for ID number, first name, last name, phone number, address and
     * email. The address and email are optional fiels and can be set to  null
     * if not provided.
     * </p>
     *
     * @param IDNumber the ID-number of the contact
     * @param firstName the first name of the contact
     * @param lastName the last name of the contact
     * @param phoneNumber the phone number of the contact
     * @param address the address of the contact (opional)
     * @param eMail the email address of the contact (optional)
     */
    public Info(final String IDNumber, final String firstName,
            final String lastName, final String phoneNumber,
            final String address, final String eMail) {
        this.IDNumber = IDNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.eMail = eMail;
    }

    // ID-number
    /**
     * Sets the ID-number of the contact after validating the input.
     *
     * @param IDNumber the ID-number to set
     *
     */
    public void setIDNumber(final String IDNumber) {
        this.IDNumber = Validation.idValidation(IDNumber);
    }

    /**
     * Returns the ID-number of the contact.
     *
     * @return the ID-number of the contact
     */
    public String getIDNumber() {
        return IDNumber;
    }

    // First Name
    /**
     * Sets the first name of the contact after validating the input.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(final String firstName) {
        this.firstName = Validation.nameValidation(firstName);
    }

    /**
     * Returns the first name of the contact.
     *
     * @return the first name of the contact
     */
    public String getFirstName() {
        return firstName;
    }

    // Last Name
    /**
     * Sets the last name of the contact after validating the input.
     *
     * @param lastName the last name to set
     */
    public void setLastName(final String lastName) {
        this.lastName = Validation.nameValidation(lastName);
    }

    /**
     * Returns the last name of the contact.
     *
     * @return the last name of the contact
     */
    public String getLastName() {
        return lastName;
    }

    // Phone Number
    /**
     * Sets the phone number of the contact after validating the input.
     *
     * @param phoneNumber the phone number to set
     *
     */
    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = Validation.phoneNumberValidation(phoneNumber);
    }

    /**
     * Returns the phone number of the contact.
     *
     * @return the phone number of the contact
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Address
    /**
     * Sets the address of the contact after validating the input.
     *
     * @param address the address to set
     *
     */
    public void setAddress(final String address) {
        this.address = Validation.addressValidation(address);
    }

    /**
     * Returns the address of the contact.
     *
     * @return the address of the contact
     */
    public String getAddress() {
        return address;
    }

    // EMail
    /**
     * Sets the e-mail of the contact after validating the input.
     *
     * @param eMail the e-mail to set
     *
     */
    public void setEMail(final String eMail) {
        this.eMail = Validation.eMailValidation(eMail);
    }
    /**
     * Returns the e-mail of the contact.
     *
     * @return the e-mail of the contact
     */
    public String getEMail() {
        return eMail;
    }

    /**
     * Converts the contact information into a CSV-formatted string.
     * <p>
     * The string includes all non-empty fields separated by commnas, with
     * optional properities (address and email) are left out if empty.
     * </p>
     *
     * @return a CSV-formatted string representing the contact
     */
    @Override
    public String toString() {
        return IDNumber + "," + firstName + "," + lastName + "," + phoneNumber
                + (address.isEmpty() ? "" : "," + address)
               + (eMail.isEmpty() ? "" : "," + eMail);
    }

    /**
     * Converts the contact information into readable string for console output.
     * <p>
     * The string includes all non-empty fields separated by commnas, with
     * optional properities (address and email) are left out if empty.
     * </p>
     *
     * @return a formatted string suitable for console output
     */
    public String toConsoleString() {
        return IDNumber + ", " + firstName + ", " + lastName + ", "
                + phoneNumber
                + (address.isEmpty() ? "" : ", " + address)
                + (eMail.isEmpty() ? "" : ", " + eMail);
    }
}
