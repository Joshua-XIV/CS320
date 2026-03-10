import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    TaskService service;
    Task task;

    @BeforeEach
    void setUp() {
        service = new TaskService();
        task = new Task(
                "Task123",
                "Buy Groceries",
                "Buy groceries from the local store");
    }

    // -------------------------------------------------------
    // Add task tests
    // -------------------------------------------------------

    @Test
    void testAddTask() {
        service.addTask(task);
        assertEquals(task, service.getTaskByID("Task123"));
    }

    @Test
    void testAddDuplicateTaskID() {
        service.addTask(task);
        Task duplicate = new Task(
                "Task123",
                "Walk Dog",
                "Walk the dog around the block");
        assertThrows(IllegalArgumentException.class, () ->
                service.addTask(duplicate)
        );
    }

    @Test
    void testAddNullTask() {
        assertThrows(IllegalArgumentException.class, () ->
                service.addTask(null)
        );
    }

    // -------------------------------------------------------
    // Delete task tests
    // -------------------------------------------------------

    @Test
    void testDeleteTask() {
        service.addTask(task);
        service.deleteTask("Task123");
        assertThrows(IllegalArgumentException.class, () ->
                service.getTaskByID("Task123")
        );
    }

    @Test
    void testDeleteTaskNullID() {
        assertThrows(IllegalArgumentException.class, () ->
                service.deleteTask(null)
        );
    }

    @Test
    void testDeleteTaskNotFound() {
        assertThrows(IllegalArgumentException.class, () ->
                service.deleteTask("NOTEXIST")
        );
    }

    // -------------------------------------------------------
    // Update task name tests
    // -------------------------------------------------------

    @Test
    void testUpdateTaskName() {
        service.addTask(task);
        service.updateTaskName("Task123", "Walk Dog");
        assertEquals("Walk Dog", service.getTaskByID("Task123").getName());
    }

    @Test
    void testUpdateTaskNameNotFound() {
        assertThrows(IllegalArgumentException.class, () ->
                service.updateTaskName("NOTEXIST", "Walk Dog")
        );
    }

    // -------------------------------------------------------
    // Update task description tests
    // -------------------------------------------------------

    @Test
    void testUpdateTaskDescription() {
        service.addTask(task);
        service.updateTaskDescription("Task123", "Walk the dog around the block");
        assertEquals("Walk the dog around the block", service.getTaskByID("Task123").getDescription());
    }

    @Test
    void testUpdateTaskDescriptionNotFound() {
        assertThrows(IllegalArgumentException.class, () ->
                service.updateTaskDescription("NOTEXIST", "Walk the dog around the block")
        );
    }

    // -------------------------------------------------------
    // Get tasks tests
    // -------------------------------------------------------

    @Test
    void testGetTaskByIDNull() {
        assertThrows(IllegalArgumentException.class, () -> service.getTaskByID(null));
    }

    @Test
    void testGetTaskByIDNotFound() {
        assertThrows(IllegalArgumentException.class, () -> service.getTaskByID("NOTEXIST"));
    }
}