import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentTest {

    // -------------------------------------------------------
    // Valid appointment tests
    // -------------------------------------------------------

    @Test
    void testAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment(
                "Appt123",
                futureDate,
                "Doctor appointment");

        assertEquals("Appt123", appointment.getAppointmentID());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Doctor appointment", appointment.getDescription());
    }

    // -------------------------------------------------------
    // Appointment ID tests
    // -------------------------------------------------------

    @Test
    void testAppointmentLongID() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment(
                        "Appt12345678910",
                        futureDate,
                        "Doctor appointment")
        );
    }

    @Test
    void testAppointmentNullID() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment(
                        null,
                        futureDate,
                        "Doctor appointment")
        );
    }

    // -------------------------------------------------------
    // Appointment date tests
    // -------------------------------------------------------

    @Test
    void testAppointmentPastDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 86400000);
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment(
                        "Appt123",
                        pastDate,
                        "Doctor appointment")
        );
    }

    @Test
    void testAppointmentNullDate() {
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment(
                        "Appt123",
                        null,
                        "Doctor appointment")
        );
    }

    @Test
    void testSetAppointmentDateNull() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment(
                "Appt123",
                futureDate,
                "Doctor appointment");
        assertThrows(IllegalArgumentException.class, () ->
                appointment.setAppointmentDate(null)
        );
    }

    @Test
    void testSetAppointmentDateInPast() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Date pastDate = new Date(System.currentTimeMillis() - 86400000);
        Appointment appointment = new Appointment(
                "Appt123",
                futureDate,
                "Doctor appointment");
        assertThrows(IllegalArgumentException.class, () ->
                appointment.setAppointmentDate(pastDate)
        );
    }

    @Test
    void testSetAppointmentDateSuccess() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Date newFutureDate = new Date(System.currentTimeMillis() + 172800000);
        Appointment appointment = new Appointment(
                "Appt123",
                futureDate,
                "Doctor appointment");
        appointment.setAppointmentDate(newFutureDate);
        assertEquals(newFutureDate, appointment.getAppointmentDate());
    }

    // -------------------------------------------------------
    // Description tests
    // -------------------------------------------------------

    @Test
    void testAppointmentLongDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment(
                        "Appt123",
                        futureDate,
                        "Doctor appointment at the local clinic down the street today")
        );
    }

    @Test
    void testAppointmentNullDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        assertThrows(IllegalArgumentException.class, () ->
                new Appointment(
                        "Appt123",
                        futureDate,
                        null)
        );
    }

    @Test
    void testSetDescriptionNull() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment(
                "Appt123",
                futureDate,
                "Doctor appointment");
        assertThrows(IllegalArgumentException.class, () ->
                appointment.setDescription(null)
        );
    }

    @Test
    void testSetDescriptionTooLong() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment(
                "Appt123",
                futureDate,
                "Doctor appointment");
        assertThrows(IllegalArgumentException.class, () ->
                appointment.setDescription("Doctor appointment at the local clinic down the street today")
        );
    }

    @Test
    void testSetDescriptionSuccess() {
        Date futureDate = new Date(System.currentTimeMillis() + 86400000);
        Appointment appointment = new Appointment(
                "Appt123",
                futureDate,
                "Doctor appointment");
        appointment.setDescription("Dentist appointment");
        assertEquals("Dentist appointment", appointment.getDescription());
    }
}