import java.util.Date;

public class Appointment {
    private final String appointmentID;
    private Date appointmentDate;
    private String description;
    private final int DESCRIPTION_LIMIT = 50;


    public Appointment(String appointmentID, Date appointmentDate, String description) {
        if (appointmentID == null) {
            throw new IllegalArgumentException("The appointment ID can not be null");
        }

        if (appointmentID.length() > 10) {
            throw new IllegalArgumentException("This appointment ID can not be more than 10 characters");
        }

        if (appointmentDate == null) {
            throw new IllegalArgumentException("The appointment date can not be null");
        }

        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("The appointment date can not be in the past");
        }

        if (description == null) {
            throw new IllegalArgumentException("The description can not be null");
        }

        if (description.length() > DESCRIPTION_LIMIT) {
            throw new IllegalArgumentException("The description can not be more than " + DESCRIPTION_LIMIT + " characters");
        }
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("The appointment date can not be null");
        }

        if (appointmentDate.before(this.appointmentDate)) {
            throw new IllegalArgumentException("The appointment date can not be in the past");
        }

        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("The description can not be null");
        }

        if (description.length() > DESCRIPTION_LIMIT) {
            throw new IllegalArgumentException("The description can not be more than " + DESCRIPTION_LIMIT + " characters");
        }

        this.description = description;
    }
}
