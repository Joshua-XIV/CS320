import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact must not be null.");
        }
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("A contact with this ID already exists.");
        }
        contacts.put(contact.getContactID(), contact);
    }

    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("No contact found with the given ID.");
        }
        contacts.remove(contactID);
    }

    public void updateFirstName(String contactID, String firstName) {
        getContactById(contactID).setFirstName(firstName);
    }

    public void updateLastName(String contactID, String lastName) {
        getContactById(contactID).setLastName(lastName);
    }

    public void updatePhone(String contactID, String phone) {
        getContactById(contactID).setPhone(phone);
    }

    public void updateAddress(String contactID, String address) {
        getContactById(contactID).setAddress(address);
    }

    public Contact getContactById(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("There is no contact by that given ID");
        }
        return contacts.get(contactID);
    }
}