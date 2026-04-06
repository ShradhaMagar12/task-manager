# Task Manager - Maven Project

A simple task management application built with Maven, featuring JUnit 5 tests.

## Project Structure

```
Task/
├── pom.xml                                      # Maven configuration
├── src/
│   ├── main/java/com/uit/
│   │   └── TaskManager.java                    # Main application
│   └── test/java/com/uit/
│       └── TaskManagerTest.java                # Test suite
├── target/                                     # Build output (auto-generated)
├── .gitignore                                  # Git ignore patterns
└── README.md                                   # This file
```

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

## Maven Commands

### Build the project
```bash
mvn clean build
```

### Run tests
```bash
mvn test
```

### Run specific test class
```bash
mvn test -Dtest=TaskManagerTest
```

### Run application
```bash
mvn exec:java -Dexec.mainClass="com.uit.TaskManager"
```

### Create executable JAR
```bash
mvn clean package
```

This creates two JARs:
- `task-manager-1.0.0.jar` - Standard JAR
- `task-manager-1.0.0-shaded.jar` - Uber-JAR (all dependencies included)

### Run the JAR
```bash
java -jar target/task-manager-1.0.0-shaded.jar
```

### View dependency tree
```bash
mvn dependency:tree
```

### Clean build artifacts
```bash
mvn clean
```

## Features

- **Create Task**: Add new tasks with title, assignee, and priority
- **Update Status**: Change task status (TO_DO, IN_PROGRESS, DONE)
- **Display Tasks**: View all tasks in the system
- **Input Validation**: Validates task titles and statuses
- **Case-Insensitive Search**: Find tasks regardless of case

## Tests

The project includes 7 comprehensive test cases:

1. `testCreateTask` - Verify task creation
2. `testUpdateStatus` - Verify status updates
3. `testEdgeCase` - Handle edge cases
4. `testInvalidStatus` - Reject invalid statuses
5. `testTaskNotFound` - Handle non-existent tasks
6. `testEmptyTitle` - Reject empty task titles
7. `testCaseInsensitive` - Case-insensitive task lookup

Run all tests with:
```bash
mvn test
```

## Troubleshooting

### Maven not found
Install Maven from: https://maven.apache.org/install.html

### Tests fail to run
Ensure you're using Java 11+:
```bash
java -version
```

### Clean build if issues occur
```bash
mvn clean install
```

## Notes

- The `lib/` folder with JUnit JAR is no longer needed (Maven manages dependencies)
- Original `TaskManager.java` and `TaskManagerTest.java` files are preserved in the root for reference
