# Task Manager Spring Boot

A simple REST API for managing tasks with priority and status tracking.

## Features

- Create, read, update, and delete tasks
- Filter tasks by status
- Filter tasks by priority
- PostgreSQL-backed persistence with Spring Data JPA
- CORS enabled for `http://localhost:5173` on `/api/**`

## Tech Stack

- Java 21
- Spring Boot 4.0.3
- Spring Web MVC
- Spring Data JPA
- PostgreSQL (runtime driver configured)
- Lombok
- Maven Wrapper (`mvnw`, `mvnw.cmd`)

## Project Structure

```text
src/main/java/com/ayush/task_manager_spring_boot
├── config/WebConfig.java
├── controller/TaskController.java
├── enums/{Priority,TaskStatus}.java
├── model/Task.java
├── repository/TaskRepository.java
├── service/TaskService.java
└── TaskManagerSpringBootApplication.java
```

## Prerequisites

- JDK 21+
- PostgreSQL running locally
- Maven (optional; wrapper included)

## Configuration

Current datasource config in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/task-manager
spring.datasource.username=postgres
spring.datasource.password=temp
spring.jpa.hibernate.ddl-auto=update
```

Update these values to match your local PostgreSQL setup before running.

## Run the Application

### Windows (PowerShell/CMD)

```bash
.\mvnw.cmd spring-boot:run
```

### macOS/Linux

```bash
./mvnw spring-boot:run
```

Server starts on:

```text
http://localhost:8080
```

## API Endpoints

Base path: `/api/tasks`

- `POST /api/tasks` - Create task
- `GET /api/tasks` - Get all tasks
- `GET /api/tasks/{id}` - Get task by ID
- `GET /api/tasks/status/{status}` - Get tasks by status
- `GET /api/tasks/priority/{priority}` - Get tasks by priority
- `PUT /api/tasks/{id}` - Update task
- `DELETE /api/tasks/{id}` - Delete task

### Enum Values

- `status`: `TODO`, `IN_PROGRESS`, `DONE`
- `priority`: `LOW`, `MEDIUM`, `HIGH`

## Example Request Payload

```json
{
  "title": "Finish backend docs",
  "description": "Write README and endpoint examples",
  "priority": "HIGH",
  "status": "IN_PROGRESS"
}
```

Notes:

- `id` is auto-generated.
- `createdAt` and `updatedAt` are managed by the service layer.

## Quick cURL Examples

Create:

```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d "{\"title\":\"Sample Task\",\"description\":\"Demo\",\"priority\":\"MEDIUM\",\"status\":\"TODO\"}"
```

Get all:

```bash
curl http://localhost:8080/api/tasks
```

Filter by status:

```bash
curl http://localhost:8080/api/tasks/status/TODO
```

Update:

```bash
curl -X PUT http://localhost:8080/api/tasks/1 \
  -H "Content-Type: application/json" \
  -d "{\"title\":\"Updated Task\",\"description\":\"Updated description\",\"priority\":\"HIGH\",\"status\":\"DONE\"}"
```

Delete:

```bash
curl -X DELETE http://localhost:8080/api/tasks/1
```

## Testing

Run tests with:

```bash
.\mvnw.cmd test
```

Currently the project includes a basic Spring context load test.
