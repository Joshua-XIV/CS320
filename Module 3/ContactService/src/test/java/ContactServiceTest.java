import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    ContactService service;
    Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");
    }

    // -------------------------------------------------------
    // Add contact tests
    // -------------------------------------------------------

    @Test
    void testAddContact() {
        service.addContact(contact);
        assertEquals(contact, service.getContactByID("Joshua123"));
    }

    @Test
    void testAddDuplicateContactID() {
        service.addContact(contact);
        Contact duplicate = new Contact(
                "Joshua123",
                "Josh",
                "Hdz",
                "0987654321",
                "456 Other Road");
        assertThrows(IllegalArgumentException.class, () ->
                service.addContact(duplicate)
        );
    }

    @Test
    void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () ->
                service.addContact(null)
        );
    }

    // -------------------------------------------------------
    // Delete contact tests
    // -------------------------------------------------------

    @Test
    void testDeleteContact() {
        service.addContact(contact);
        service.deleteContact("Joshua123");
        assertThrows(IllegalArgumentException.class, () ->
                service.getContactByID("Joshua123")
        );
    }

    @Test
    void testDeleteContactNullID() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () ->
                service.deleteContact(null)
        );
    }

    @Test
    void testDeleteContactNotFound() {
        assertThrows(IllegalArgumentException.class, () ->
                service.deleteContact("NOTEXIST")
        );
    }

    // -------------------------------------------------------
    // First name contact tests
    // -------------------------------------------------------

    @Test
    void testUpdateFirstName() {
        service.addContact(contact);
        service.updateFirstName("Joshua123", "NotJoshua");
        assertEquals("NotJoshua", service.getContactByID("Joshua123").getFirstName());
    }

    @Test
    void testUpdateFirstNameNullID() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () ->
                service.updateFirstName(null, "Jane")
        );
    }

    @Test
    void testUpdateFirstNameNotFound() {
        assertThrows(IllegalArgumentException.class, () ->
                service.updateFirstName("NOTEXIST", "Jane")
        );
    }

    // -------------------------------------------------------
    // Last name contact tests
    // -------------------------------------------------------

    @Test
    void testUpdateLastName() {
        service.addContact(contact);
        service.updateLastName("Joshua123", "Hdz");
        assertEquals("Hdz", service.getContactByID("Joshua123").getLastName());
    }

    @Test
    void testUpdateLastNameNullID() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () ->
                service.updateLastName(null, "Smith")
        );
    }

    @Test
    void testUpdateLastNameNotFound() {
        assertThrows(IllegalArgumentException.class, () ->
                service.updateLastName("NOTEXIST", "Smith")
        );
    }

    // -------------------------------------------------------
    // Phone number contact tests
    // -------------------------------------------------------

    @Test
    void testUpdatePhone() {
        service.addContact(contact);
        service.updatePhone("Joshua123", "0987654321");
        assertEquals("0987654321", service.getContactByID("Joshua123").getPhone());
    }

    @Test
    void testUpdatePhoneNullID() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () ->
                service.updatePhone(null, "1234567890")
        );
    }

    @Test
    void testUpdatePhoneNotFound() {
        assertThrows(IllegalArgumentException.class, () ->
                service.updatePhone("NOTEXIST", "0987654321")
        );
    }

    // -------------------------------------------------------
    // Address contact tests
    // -------------------------------------------------------

    @Test
    void testUpdateAddress() {
        service.addContact(contact);
        service.updateAddress("Joshua123", "456 Other Road");
        assertEquals("456 Other Road", service.getContactByID("Joshua123").getAddress());
    }

    @Test
    void testUpdateAddressNullID() {
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () ->
                service.updateAddress(null, "456 Road St")
        );
    }

    @Test
    void testUpdateAddressNotFound() {
        assertThrows(IllegalArgumentException.class, () ->
                service.updateAddress("NOTEXIST", "456 Other Road")
        );
    }
}