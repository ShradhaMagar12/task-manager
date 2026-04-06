package com.uit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    @Test
    void testCreateTask() {
        TaskManager.createTask("Test Task", "Shradha", "HIGH");
        assertTrue(TaskManager.tasks.size() > 0);
    }

    @Test
    void testUpdateStatus() {
        TaskManager.createTask("Bug Fix", "Shradha", "HIGH");
        TaskManager.updateStatus("Bug Fix", "DONE");

        boolean updated = false;
        for (Task t : TaskManager.tasks) {
            if (t.title.equals("Bug Fix") && t.status.equals("DONE")) {
                updated = true;
            }
        }

        assertTrue(updated);
    }

    @Test
    void testEdgeCase() {
        TaskManager.createTask("", "Shradha", "LOW");
        assertNotNull(TaskManager.tasks);
    }

    @Test
    void testInvalidStatus() {
        TaskManager.createTask("Task1", "Shradha", "HIGH");
        TaskManager.updateStatus("Task1", "FINISHED"); // invalid

        boolean valid = false;
        for (Task t : TaskManager.tasks) {
            if (t.title.equals("Task1") && !t.status.equals("FINISHED")) {
                valid = true;
            }
        }

        assertTrue(valid);
    }

    @Test
    void testTaskNotFound() {
        int before = TaskManager.tasks.size();

        TaskManager.updateStatus("UnknownTask", "DONE");

        assertEquals(before, TaskManager.tasks.size());
    }

    @Test
    void testEmptyTitle() {
        int before = TaskManager.tasks.size();

        TaskManager.createTask("", "Shradha", "HIGH");

        assertEquals(before, TaskManager.tasks.size());
    }

    @Test
    void testCaseInsensitive() {
        TaskManager.createTask("Login API", "Shradha", "HIGH");
        TaskManager.updateStatus("login api", "DONE");

        boolean updated = false;
        for (Task t : TaskManager.tasks) {
            if (t.title.equals("Login API") && t.status.equals("DONE")) {
                updated = true;
            }
        }

        assertTrue(updated);
    }

}
