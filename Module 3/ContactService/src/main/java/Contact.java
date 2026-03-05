public class Contact {
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private final int CONTACT_ID_LIMIT = 10;
    private final int FIRST_NAME_LIMIT = 10;
    private final int LAST_NAME_LIMIT = 10;
    private final int PHONE_NUMBER_LENGTH = 10;
    private final int ADDRESS_LIMIT = 30;


    /**
     * Constructs a new Contact with the specified ID, name, phone, and address.
     * All fields must meet their validation rules, otherwise an IllegalArgumentException
     * will be thrown.
     *
     * @param contactID the unique identifier for the contact (max 10 characters, not null)
     * @param firstName the first name of the contact (max 10 characters, not null)
     * @param lastName  the last name of the contact (max 10 characters, not null)
     * @param phone     the phone number of the contact (exactly 10 digits, not null)
     * @param address   the address of the contact (max 30 characters, not null)
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        if (contactID == null) {
            throw new IllegalArgumentException("Contact ID must not be null");
        }
        if (contactID.length() > CONTACT_ID_LIMIT) {
            throw new IllegalArgumentException("Contact ID must be at most " + CONTACT_ID_LIMIT + " characters");
        }

        if (firstName == null) {
            throw new IllegalArgumentException("First name must not be null");
        }
        if (firstName.length() > FIRST_NAME_LIMIT) {
            throw new IllegalArgumentException("First name must be at most " + FIRST_NAME_LIMIT + " characters");
        }

        if (lastName == null) {
            throw new IllegalArgumentException("Last name must not be null");
        }
        if (lastName.length() > LAST_NAME_LIMIT) {
            throw new IllegalArgumentException("Last name must be at most " + LAST_NAME_LIMIT + " characters");
        }

        if (phone == null) {
            throw new IllegalArgumentException("Phone must not be null");
        }
        if (phone.length() != PHONE_NUMBER_LENGTH) {
            throw new IllegalArgumentException("Phone must be exactly " + PHONE_NUMBER_LENGTH + " digits");
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                throw new IllegalArgumentException("Phone must contain only digits");
            }
        }

        if (address == null) {
            throw new IllegalArgumentException("Address must not be null");
        }
        if (address.length() > ADDRESS_LIMIT) {
            throw new IllegalArgumentException("Address must be at most " + ADDRESS_LIMIT + " characters");
        }

        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Some simple getters for our class attributes
    public String getContactID() {return contactID;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getPhone() {return phone;}
    public String getAddress() {return address;}

    // Setters for all attributes except contactID
    public void setFirstName(String firstName) {
        if (firstName == null)
            throw new IllegalArgumentException("First name must not be null");
        if (firstName.length() > FIRST_NAME_LIMIT)
            throw new IllegalArgumentException("First name must be at most " + FIRST_NAME_LIMIT  + " characters");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null)
            throw new IllegalArgumentException("Last name must not be null");
        if (lastName.length() > LAST_NAME_LIMIT)
            throw new IllegalArgumentException("Last name must be at most " + LAST_NAME_LIMIT + " characters");
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null)
            throw new IllegalArgumentException("Phone must not be null");
        if (phone.length() != PHONE_NUMBER_LENGTH)
            throw new IllegalArgumentException("Phone must be exactly " + PHONE_NUMBER_LENGTH + " digits");
        for (int i = 0; i < phone.length(); i++)
            if (!Character.isDigit(phone.charAt(i)))
                throw new IllegalArgumentException("Phone must contain only digits");
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null)
            throw new IllegalArgumentException("Address must not be null");
        if (address.length() > ADDRESS_LIMIT)
            throw new IllegalArgumentException("Address must be at most " + ADDRESS_LIMIT + " characters");
        this.address = address;
    }
}
