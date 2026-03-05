import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class AppointmentServiceTest {

    AppointmentService service;
    Appointment appointment;
    Date futureDate;

    @BeforeEach
    void setUp() {
        service = new AppointmentService();
        futureDate = new Date(System.currentTimeMillis() + 86400000);
        appointment = new Appointment(
                "Appt123",
                futureDate,
                "Doctor appointment");
    }

    // -------------------------------------------------------
    // Add appointment tests
    // -------------------------------------------------------

    @Test
    void testAddAppointment() {
        service.addAppointment(appointment);
        assertEquals(appointment, service.getAppointmentByID("Appt123"));
    }

    @Test
    void testAddDuplicateAppointmentID() {
        service.addAppointment(appointment);
        Appointment duplicate = new Appointment(
                "Appt123",
                futureDate,
                "Dentist appointment");
        assertThrows(IllegalArgumentException.class, () ->
                service.addAppointment(duplicate)
        );
    }

    @Test
    void testAddNullAppointment() {
        assertThrows(IllegalArgumentException.class, () ->
                service.addAppointment(null)
        );
    }

    // -------------------------------------------------------
    // Delete appointment tests
    // -------------------------------------------------------

    @Test
    void testDeleteAppointment() {
        service.addAppointment(appointment);
        service.deleteAppointment("Appt123");
        assertThrows(IllegalArgumentException.class, () ->
                service.getAppointmentByID("Appt123")
        );
    }

    @Test
    void testDeleteAppointmentNotFound() {
        assertThrows(IllegalArgumentException.class, () ->
                service.deleteAppointment("NOTEXIST")
        );
    }

    @Test
    void testDeleteAppointmentNullID() {
        assertThrows(IllegalArgumentException.class, () ->
                service.deleteAppointment(null)
        );
    }

    // -------------------------------------------------------
    // Update appointment tests
    // -------------------------------------------------------

    @Test
    void testUpdateAppointmentDate() {
        Date newFutureDate = new Date(System.currentTimeMillis() + 172800000);
        service.addAppointment(appointment);
        service.updateAppointmentDate("Appt123", newFutureDate);
        assertEquals(newFutureDate, service.getAppointmentByID("Appt123").getAppointmentDate());
    }

    @Test
    void testUpdateAppointmentDateNotFound() {
        Date newFutureDate = new Date(System.currentTimeMillis() + 172800000);
        assertThrows(IllegalArgumentException.class, () ->
                service.updateAppointmentDate("NOTEXIST", newFutureDate)
        );
    }

    @Test
    void testUpdateDescription() {
        service.addAppointment(appointment);
        service.updateDescription("Appt123", "Dentist appointment");
        assertEquals("Dentist appointment", service.getAppointmentByID("Appt123").getDescription());
    }

    @Test
    void testUpdateDescriptionNotFound() {
        assertThrows(IllegalArgumentException.class, () ->
                service.updateDescription("NOTEXIST", "Dentist appointment")
        );
    }
}