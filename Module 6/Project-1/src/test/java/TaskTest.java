import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    // -------------------------------------------------------
    // Valid task tests
    // -------------------------------------------------------

    @Test
    void testTask() {
        Task task = new Task(
                "Task123",
                "Buy Groceries",
                "Buy groceries from the local store");

        assertEquals("Task123", task.getTaskID());
        assertEquals("Buy Groceries", task.getName());
        assertEquals("Buy groceries from the local store", task.getDescription());
    }

    // -------------------------------------------------------
    // Task ID tests
    // -------------------------------------------------------

    @Test
    void testTaskLongTaskID() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task(
                        "Task123456789",
                        "Buy Groceries",
                        "Buy groceries from the local store")
        );
    }

    @Test
    void testTaskNullTaskID() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task(
                        null,
                        "Buy Groceries",
                        "Buy groceries from the local store")
        );
    }

    // -------------------------------------------------------
    // Name tests
    // -------------------------------------------------------

    @Test
    void testTaskLongName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task(
                        "Task123",
                        "Buy Groceries From The Local Store Today",
                        "Buy groceries from the local store")
        );
    }

    @Test
    void testTaskNullName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task(
                        "Task123",
                        null,
                        "Buy groceries from the local store")
        );
    }

    @Test
    void testSetNameNull() {
        Task task = new Task(
                "Task123",
                "Buy Groceries",
                "Buy groceries from the local store");
        assertThrows(IllegalArgumentException.class, () ->
                task.setName(null)
        );
    }

    @Test
    void testSetNameTooLong() {
        Task task = new Task(
                "Task123",
                "Buy Groceries",
                "Buy groceries from the local store");
        assertThrows(IllegalArgumentException.class, () ->
                task.setName("Buy Groceries From The Local Store Today")
        );
    }

    @Test
    void testSetNameSuccess() {
        Task task = new Task(
                "Task123",
                "Buy Groceries",
                "Buy groceries from the local store");
        task.setName("Walk The Dog");
        assertEquals("Walk The Dog", task.getName());
    }

    // -------------------------------------------------------
    // Description tests
    // -------------------------------------------------------

    @Test
    void testTaskLongDescription() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task(
                        "Task123",
                        "Buy Groceries",
                        "Buy groceries from the local store and doing some more stuff to meet")
        );
    }

    @Test
    void testTaskNullDescription() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task(
                        "Task123",
                        "Buy Groceries",
                        null)
        );
    }

    @Test
    void testSetDescriptionNull() {
        Task task = new Task(
                "Task123",
                "Buy Groceries",
                "Buy groceries from the local store");
        assertThrows(IllegalArgumentException.class, () ->
                task.setDescription(null)
        );
    }

    @Test
    void testSetDescriptionTooLong() {
        Task task = new Task(
                "Task123",
                "Buy Groceries",
                "Buy groceries from the local store");
        assertThrows(IllegalArgumentException.class, () ->
                task.setDescription("Buy groceries from the local store down the street today after work")
        );
    }

    @Test
    void testSetDescriptionSuccess() {
        Task task = new Task(
                "Task123",
                "Buy Groceries",
                "Buy groceries from the local store");
        task.setDescription("Walk the dog around the block");
        assertEquals("Walk the dog around the block", task.getDescription());
    }
}