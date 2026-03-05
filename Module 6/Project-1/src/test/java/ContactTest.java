import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {

    // -------------------------------------------------------
    // Valid contact tests
    // -------------------------------------------------------

    @Test
    void testContact() {
        Contact contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");

        assertEquals("Joshua123", contact.getContactID());
        assertEquals("Joshua", contact.getFirstName());
        assertEquals("Hernandez", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Random Road", contact.getAddress());
    }

    // -------------------------------------------------------
    // Contact ID tests
    // -------------------------------------------------------

    @Test
    void testContactLongContactID() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "Joshua123456789",
                        "Joshua",
                        "Hernandez",
                        "1234567890",
                        "123 Random Road")
        );
    }

    @Test
    void testContactNullContactID() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        null,
                        "Joshua",
                        "Hernandez",
                        "1234567890",
                        "123 Random Road")
        );
    }

    // -------------------------------------------------------
    // First name tests
    // -------------------------------------------------------

    @Test
    void testContactLongFirstName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "Joshua123",
                        "Joshuaaaaaaaaaaaaa",
                        "Hernandez",
                        "1234567890",
                        "123 Random Road")
        );
    }

    @Test
    void testContactNullFirstName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "Joshua123",
                        null,
                        "Hernandez",
                        "1234567890",
                        "123 Random Road")
        );
    }

    @Test
    void testSetFirstNameNull() {
        Contact contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");
        assertThrows(IllegalArgumentException.class, () ->
                contact.setFirstName(null)
        );
    }

    @Test
    void testSetFirstNameTooLong() {
        Contact contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");
        assertThrows(IllegalArgumentException.class, () ->
                contact.setFirstName("Joshuaaaaaaaaaaaaa")
        );
    }

    @Test
    void testSetFirstNameSuccess() {
        Contact contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    // -------------------------------------------------------
    // Last name tests
    // -------------------------------------------------------

    @Test
    void testContactLongLastName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "Joshua123",
                        "Joshua",
                        "Hernandezzzzzzzz",
                        "1234567890",
                        "123 Random Road")
        );
    }

    @Test
    void testContactNullLastName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "Joshua123",
                        "Joshua",
                        null,
                        "1234567890",
                        "123 Random Road")
        );
    }

    @Test
    void testSetLastNameNull() {
        Contact contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");
        assertThrows(IllegalArgumentException.class, () ->
                contact.setLastName(null)
        );
    }

    @Test
    void testSetLastNameTooLong() {
        Contact contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");
        assertThrows(IllegalArgumentException.class, () ->
                contact.setLastName("Hernandezzzzzzzz")
        );
    }

    @Test
    void testSetLastNameSuccess() {
        Contact contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    // -------------------------------------------------------
    // Phone number tests
    // -------------------------------------------------------

    @Test
    void testContactLongPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "Joshua123",
                        "Joshua",
                        "Hernandez",
                        "1234567890123456789",
                        "123 Random Road")
        );
    }

    @Test
    void testContactShortPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "Joshua123",
                        "Joshua",
                        "Hernandez",
                        "12345",
                        "123 Random Road")
        );
    }

    @Test
    void testContactLettersInPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "Joshua123",
                        "Joshua",
                        "Hernandez",
                        "12345ABCDE",
                        "123 Random Road")
        );
    }

    @Test
    void testContactNullPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "Joshua123",
                        "Joshua",
                        "Hernandez",
                        null,
                        "123 Random Road")
        );
    }

    @Test
    void testSetPhoneNull() {
        Contact contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");
        assertThrows(IllegalArgumentException.class, () ->
                contact.setPhone(null)
        );
    }

    @Test
    void testSetPhoneTooShort() {
        Contact contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");
        assertThrows(IllegalArgumentException.class, () ->
                contact.setPhone("12345")
        );
    }

    @Test
    void testSetPhoneLetters() {
        Contact contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");
        assertThrows(IllegalArgumentException.class, () ->
                contact.setPhone("12345ABCDE")
        );
    }

    @Test
    void testSetPhoneSuccess() {
        Contact contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
    }

    // -------------------------------------------------------
    // Address tests
    // -------------------------------------------------------

    @Test
    void testContactLongAddress() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "Joshua123",
                        "Joshua",
                        "Hernandez",
                        "1234567890",
                        "123 Random Road 123 Random Road 123 Random Road")
        );
    }

    @Test
    void testContactNullAddress() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(
                        "Joshua123",
                        "Joshua",
                        "Hernandez",
                        "1234567890",
                        null)
        );
    }

    @Test
    void testSetAddressNull() {
        Contact contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");
        assertThrows(IllegalArgumentException.class, () ->
                contact.setAddress(null)
        );
    }

    @Test
    void testSetAddressTooLong() {
        Contact contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");
        assertThrows(IllegalArgumentException.class, () ->
                contact.setAddress("123 Random Road 123 Random Road 123 Random Road")
        );
    }

    @Test
    void testSetAddressSuccess() {
        Contact contact = new Contact(
                "Joshua123",
                "Joshua",
                "Hernandez",
                "1234567890",
                "123 Random Road");
        contact.setAddress("456 Other Road");
        assertEquals("456 Other Road", contact.getAddress());
    }
}