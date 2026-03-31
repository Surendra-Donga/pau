# PAU Banking - Payment Management System

A robust Spring Boot application demonstrating advanced Dependency Injection patterns, DTO implementation, and clean architectural practices.

---

## 🚀 Key Features

- **Multi-Method Payment Support**: Integrated implementations for Cards, UPI, and Net Banking.
- **Dynamic Routing**: Runtime switching between payment strategies using Spring's Qualifier system.
- **User Management**: Complete user registration and retrieval with proper data abstraction.
- **Data Validation**: Server-side validation for all incoming requests using Jakarta Validation API.
- **Global Error Handling**: Centralized exception handling for consistent API responses.
- **Persistent Storage**: MongoDB integration for storing payment records and user data.
- **Web Dashboard**: A Thymeleaf-based UI for processing payments.

---

## 🏗 Architecture & Design Patterns

The project follows a layered architecture to ensure separation of concerns:
- **Controller Layer**: Handles HTTP requests and maps them to service calls.
- **Service Layer**: Contains business logic and orchestrates data flow.
- **Repository Layer**: Manages data persistence using Spring Data MongoDB.
- **DTO Layer**: Decouples internal entities from API responses/requests.

### Design Patterns Used:
- **Strategy Pattern**: Different payment methods (Card, UPI, Net Banking) implement the `PaymentMethod` interface.
- **Dependency Injection**: Constructor and field-based injection for loose coupling.
- **Primary/Qualifier**: Managing multiple beans of the same type.

---

## 📦 Data Transfer Object (DTO) Implementation

This project utilizes DTOs to provide a secure and efficient way to transfer data between the client and server.

### Why DTOs?
1. **Security**: Sensitive fields like `password` are never exposed in the response.
2. **Performance**: Only necessary data is transferred over the network.
3. **Abstraction**: Internal database structures can change without affecting the API contract.

### DTO Components:

#### 1. `UserRequest` (Input DTO)
Used during user registration. It includes strict validation rules:
- `name`: Mandatory (`@NotBlank`).
- `email`: Valid format and mandatory (`@Email`, `@NotBlank`).
- `password`: Minimum 6 characters (`@Size`).

#### 2. `UserDTO` (Output DTO)
The response object returned to the client. It contains only public information:
- `id`: The generated database ID.
- `name`: User's full name.
- `email`: User's email address.
*(Note: Password is omitted for security)*

#### 3. Mapping Logic
Manual mapping is implemented in `UserServiceImpl` using a private `mapToDTO` method to maintain full control over the transformation process without external dependencies like ModelMapper or MapStruct.

---

## 🛠 Tech Stack

- **Java 23+**: Utilizing modern Java features.
- **Spring Boot 3.x**: Core framework.
- **Spring Data MongoDB**: NoSQL database abstraction.
- **Thymeleaf**: Server-side template engine for the UI.
- **Lombok**: Reducing boilerplate code (Getters, Setters, Constructors).
- **Jakarta Validation**: Ensuring data integrity.

---

## 🚦 Spring Annotations Used

| Annotation | Purpose in this Project |
|------------|-------------------------|
| `@Primary` | Makes `CardPayment` the default implementation. |
| `@Qualifier` | Injects specific payment implementations in `PaymentService`. |
| `@RestControllerAdvice` | Centralizes exception handling across all controllers. |
| `@Valid` | Triggers bean validation for `@RequestBody` objects. |
| `@Document` | Maps Java objects to MongoDB collections. |
| `@Value` | Injects externalized configuration from `application.properties`. |

---

## 📂 Project Structure

```text
src/main/java/com/Banking/pau/
├── controller/       # REST and Web Controllers
├── service/          # Business logic and Interfaces
├── repository/       # MongoDB Repositories
├── entity/           # Database Models (User)
├── model/            # Internal Models (PaymentRecord)
├── dto/              # Data Transfer Objects (UserRequest, UserDTO)
├── payment/          # Payment Strategy implementations
└── exception/        # Global Exception Handler
```

---

## 🔌 API Endpoints

### Users
- `POST /api/users`: Create a new user (Validates `UserRequest`).
- `GET /api/users/{id}`: Retrieve a specific user by ID.
- `GET /api/users`: List all registered users.

### Payments
- `GET /`: Home page (Web UI).
- `POST /pay`: Process a payment via the Web UI.

---

## 🏃 How to Run

1. **Prerequisites**: Ensure you have Java 23+ and a running MongoDB instance.
2. **Configuration**: Update `src/main/resources/application.properties` with your MongoDB URI if necessary.
3. **Build & Run**:
   ```bash
   ./mvnw spring-boot:run
   ```
4. **Access**:
   - Web UI: [http://localhost:8080](http://localhost:8080)
   - API: [http://localhost:8080/api/users](http://localhost:8080/api/users)

---

## ⚙️ Configuration
The system is highly configurable via `application.properties`:
- `payment.api.endpoint`: External API endpoint for payment simulation.
- `spring.data.mongodb.uri`: Database connection string.
