public class Task {
    private final String taskID;
    private String name;
    private String description;


    /**
     * Constructs a new Task with the specified ID, name, and description.
     * All fields must meet their validation rules, otherwise an IllegalArgumentException
     * will be thrown.
     *
     * @param taskID the unique identifier for the task (max 10 characters, not null)
     * @param name the name of the task (max 20 characters, not null)
     * @param description  the description of the task (max 50 characters, not null)
     * @throws IllegalArgumentException if any parameter is invalid
     */
    Task(String taskID, String name, String description) {
        if (taskID == null) {
            throw  new IllegalArgumentException(("Task ID must not be null"));
        }

        if (taskID.length() > 10) {
            throw new IllegalArgumentException("Task ID must not be longer than 10 characters");
        }

        if (name == null) {
            throw new IllegalArgumentException("Name must not be null");
        }

        if (name.length() > 20) {
            throw  new IllegalArgumentException("Name must not be longer than 20 characters");
        }

        if (description == null) {
            throw new IllegalArgumentException("Description must not be null");
        }

        if (description.length() > 50) {
            throw  new IllegalArgumentException("Description must not be longer than 50 characters");
        }

        this.taskID = taskID;
        this.name = name;
        this.description = description;
    }

    // Getters for class attributes
    String getTaskID() {return  taskID;}
    String getName() {return name;}
    String getDescription() {return description;}

    // Setters for class attributes except taskID
    void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name must not be null");
        }

        if (name.length() > 20) {
            throw  new IllegalArgumentException("Name must not be longer than 20 characters");
        }

        this.name = name;
    }

    void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description must not be null");
        }

        if (description.length() > 50) {
            throw  new IllegalArgumentException("Description must not be longer than 50 characters");
        }

        this.description = description;
    }
}
