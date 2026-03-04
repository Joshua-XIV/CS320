import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {
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
}
