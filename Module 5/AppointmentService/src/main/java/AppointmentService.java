import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment object can not be null.");
        }

        if (appointments.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment ID already exists.");
        }

        appointments.put(appointment.getAppointmentID(), appointment);
    }

    public void deleteAppointment(String appointmentID) {
        if (appointmentID == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null.");
        }

        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("No appointment found with the given ID.");
        }

        appointments.remove(appointmentID);
    }

    public void updateAppointmentDate(String appointmentID, Date appointmentDate) {
        getAppointmentByID(appointmentID).setAppointmentDate(appointmentDate);
    }

    public void updateDescription(String appointmentID, String description) {
        getAppointmentByID(appointmentID).setDescription(description);
    }

    public Appointment getAppointmentByID(String appointmentID) {
        if (appointmentID == null) {
            throw new IllegalArgumentException("The appointment ID can not be null");
        }

        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("There is no appointment by that given ID");
        }

        return appointments.get(appointmentID);
    }
}
