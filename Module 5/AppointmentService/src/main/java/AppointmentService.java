import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment object can not be null");
        }

        if (appointments.containsKey(appointment.getAppointmentID())) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }

        appointments.put(appointment.getAppointmentID(), appointment);
    }

    public void deleteAppointment(String appointmentID) {
        if (appointmentID == null) {
            throw new IllegalArgumentException("Appointment ID can not be null");
        }

        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID does not exist");
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
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID does not exist");
        }

        return appointments.get(appointmentID);
    }
}
