public class Task {
    private final String taskID;
    private String name;
    private String description;
    private final int TASK_ID_LIMIT = 10;
    private final int NAME_LIMIT = 20;
    private final int DESCRIPTION_LIMIT = 50;


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
    public Task(String taskID, String name, String description) {
        if (taskID == null) {
            throw new IllegalArgumentException(("Task ID must not be null"));
        }

        if (taskID.length() > TASK_ID_LIMIT) {
            throw new IllegalArgumentException("Task ID must not be longer than " + TASK_ID_LIMIT + " characters");
        }

        if (name == null) {
            throw new IllegalArgumentException("Name must not be null");
        }

        if (name.length() > NAME_LIMIT) {
            throw  new IllegalArgumentException("Name must not be longer than " + NAME_LIMIT + " characters");
        }

        if (description == null) {
            throw new IllegalArgumentException("Description must not be null");
        }

        if (description.length() > DESCRIPTION_LIMIT) {
            throw new IllegalArgumentException("Description must not be longer than " + DESCRIPTION_LIMIT + " characters");
        }

        this.taskID = taskID;
        this.name = name;
        this.description = description;
    }

    // Getters for class attributes
    public String getTaskID() {return taskID;}
    public String getName() {return name;}
    public String getDescription() {return description;}

    // Setters for class attributes except taskID
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name must not be null");
        }

        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("Name must not be longer than " + NAME_LIMIT + " characters");
        }

        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Description must not be null");
        }

        if (description.length() > DESCRIPTION_LIMIT) {
            throw new IllegalArgumentException("Description must not be longer than " + DESCRIPTION_LIMIT + " characters");
        }

        this.description = description;
    }
}
